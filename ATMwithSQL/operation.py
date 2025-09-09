import dbConfig

def deregistratoin(pin: int):
    account = dbConfig.fetch_account_by_pin(pin)
    if account:
        message = dbConfig.deregistration(pin)
        print(message)
    else:
        print("No account found with the provided PIN.")

def displayBalance(account):
    print(f"Name: {account[1]}")
    print(f"Your current balance is: {account[2]}")
    return account[2]

def deposition(account):
    amount = int(input("Enter amount to Deposit: "))
    newAmount = account[2] + amount
    dbConfig.update_balance(account[0], newAmount)
    print(f"Now, Your Balance is {newAmount}")

def withDrawal(account):
    amount = int(input("Enter amount to Withdraw: "))
    if account[2] - amount < 0:
        print("You don't have enough balance to Withdraw!")
        displayBalance(account)
    else:
        newAmount = account[2] - amount
        dbConfig.update_balance(account[0], newAmount)
        print(f"Now, Your Balance is {newAmount}")

def error1():
    print("Account with this PIN doesn't exist!")

def transactionTermine():
    print("Transaction Terminated!")