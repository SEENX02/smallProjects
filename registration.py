import jsonConfig
import verification
import operation


def register(filepath: str):

    choice: str = input("Register Account? write y for yes: ")

    if choice.lower() != 'y':
        operation.transactionTermine()

    else:

        data: dict = jsonConfig.loadBankDetails(filepath)
        name = input("Enter your name: ")
        lastElement = data["Details"][-1]
        lstPin = lastElement["AccountNo"]
        accountNumber = lstPin
        newAccountNumber = accountNumber + 1
        newpin = 0
        while newpin <= 1000 or newpin >= 9999:
            newpin = int(input("Enter your PIN (Note: It should be in 4 digit): "))

            if verification.checker(filepath, newpin) == True:
                continue

        newData = {"Name": name, "AccountNo":newAccountNumber, "Balance": 0, "Pin": newpin}
        data["Details"].append(newData)
        jsonConfig.saveBankDetails(data,filepath)
        print("Account saved successfully!")