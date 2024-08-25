def suryaTereLiye(companyName):
    startDate = datetime.datetime.date(2024, 7, 19) - datetime.timedelta(days=365)
    endDate = datetime.datetime.date(24, 7, 19)

    companyData = yf.download(companyName, start=startDate, end=endDate)
    dataframe = pd.DataFrame(companyData)

    # Prepare the features (X) and target (y)
    x = pd.DataFrame(dataframe, columns=["Open", "High", "Low", "Volume"])
    y = pd.DataFrame(dataframe, columns=["Close"])

    # Train the Linear Regression model on the entire data
    model = LinearRegression()
    model.fit(x, y)

    # Predict the prices for the next month (from endDate to 19-08-2024)
    future_dates = pd.date_range(start=endDate, end="2024-09-19")
    future_x = pd.DataFrame(index=future_dates, columns=["Open", "High", "Low", "Volume"])

    # Adding a time-based feature (e.g., day number)
    dataframe['Day'] = range(len(dataframe))
    x['Day'] = dataframe['Day']

    # Train the Linear Regression model on the entire data
    model = LinearRegression()
    model.fit(x, y)

    # Predict the prices for the next month (from endDate to 19-09-2024)
    future_dates = pd.date_range(start=endDate + datetime.timedelta(days=1), end="2024-09-19")
    future_df = pd.DataFrame(index=future_dates, columns=["Open", "High", "Low", "Volume", "Day"])

    # Initialize the first prediction input with the last known values
    last_row = dataframe.iloc[-1]
    future_df.iloc[0] = [last_row["Open"], last_row["High"], last_row["Low"], last_row["Volume"], last_row["Day"] + 1]

    # Iteratively predict the future prices day by day
    predictions = []
    for i in range(len(future_df)):
        future_x = future_df.iloc[i].values.reshape(1, -1)
        prediction = model.predict(future_x)[0]
        predictions.append(prediction)

        if i < len(future_df) - 1:
            # Use the predicted value for the next day's "Open" price (or other features)
            future_df.iloc[i + 1, 0] = prediction  # Set the next day's "Open" as today's "Predicted Close"
            future_df.iloc[i + 1, 1] = prediction  # Set the next day's "High"
            future_df.iloc[i + 1, 2] = prediction  # Set the next day's "Low"
            future_df.iloc[i + 1, 3] = last_row["Volume"]  # Keep the volume constant or set it differently
            future_df.iloc[i + 1, 4] = last_row["Day"] + i + 2  # Increment the Day

    # Create a DataFrame for the predicted values, aligning them with the future dates
    future_predictions = pd.DataFrame(data=predictions, index=future_dates, columns=["Predicted Close"])

    # Add the predicted close prices to the original DataFrame
    dataframe = dataframe._append(future_predictions)

    # Plot the candlestick chart along with the predicted close prices
    add_plot = [mplfinance.make_addplot(dataframe['Predicted Close'], color='red')]
    mplfinance.plot(dataframe, type='candle', style='charles', addplot=add_plot,
             title=f"{companyName} Candlestick with Predicted Close Prices", ylabel='Price')

if __name__ == '__main__':
    suryaTereLiye("INFY.NSE")
