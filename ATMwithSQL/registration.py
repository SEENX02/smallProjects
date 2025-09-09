import dbConfig
import operation

def register():
    choice = input("Register Account? write y for yes: ")

    if choice.lower() != 'y':
        operation.transactionTermine()
    else:
        name = input("Enter your name: ")
        newpin = 0
        while newpin <= 1000 or newpin >= 9999:
            newpin = int(input("Enter your PIN (Note: It should be 4 digits): "))
            if dbConfig.fetch_account_by_pin(newpin):
                print("This PIN is already taken, try another.")
                newpin = 0
                continue

        dbConfig.insert_account(name, newpin)
        print("Account saved successfully!")
