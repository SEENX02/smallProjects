import jsonConfig


def checker(filepath: str, inputPin: int) -> bool | None:
    data: dict = jsonConfig.loadBankDetails(filepath)
    for password in data["Details"]:
        pin: int = password["Pin"]
        if pin == inputPin:
            return True

def accountDetailsChecker(filepath: str, inputPin: int) -> int | str:

    data: dict = jsonConfig.loadBankDetails(filepath)
    accountNumber = 0
    for password in data["Details"]:
        pin: int = password["Pin"]
        if pin == inputPin:
            return accountNumber

        else:
            accountNumber = accountNumber + 1

    return "Something went wrong!"