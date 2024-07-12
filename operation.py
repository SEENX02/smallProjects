import jsonConfig

def displayBalance(filepath: str, accountNumber: int):
    data: dict = jsonConfig.loadBankDetails(filepath)
    balance: int = data["Details"][accountNumber]["Balance"]
    name: str = data["Details"][accountNumber]["Name"]
    print(f"Name: {name}")
    print(f"Your current balance is: {balance}")
    jsonConfig.saveBankDetails(data, filepath)
    return balance


def deposition(filepath: str, accountNumber: int):
    data: dict = jsonConfig.loadBankDetails(filepath)
    amount: int = int(input("Enter amount to Deposit: "))
    newAmount = data["Details"][accountNumber]["Balance"] + amount
    data["Details"][accountNumber]["Balance"] = newAmount
    print(f"Now, Your Balance is {newAmount}")
    jsonConfig.saveBankDetails(data, filepath)

def withDrawal(filepath: str, accountNumber: int):
    data: dict = jsonConfig.loadBankDetails(filepath)
    
    amount: int = int(input("Enter amount to withDraw: "))
    if data["Details"][accountNumber]["Balance"] - amount < 0:
        print("You dont have enough balance to withDraw!")
        displayBalance(filepath, accountNumber)

    else:
        newAmount: int = data["Details"][accountNumber]["Balance"] - amount
        data["Details"][accountNumber]["Balance"] = newAmount
        print(f"Now, Your Balance is {newAmount}")
        jsonConfig.saveBankDetails(data, filepath)

def transactionTermine():
    print("Your transaction has been terminated!")

def error1():
    print("Account not found")

def error2():
    print("Note: Please go according to the instruction")