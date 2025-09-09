import dbConfig

def checker(pin: int):
    account = dbConfig.fetch_account_by_pin(pin)
    return account is not None

def accountDetailsChecker(pin: int):
    return dbConfig.fetch_account_by_pin(pin)
