import json

def loadBankDetails(filepath: str)-> dict:
    with open(filepath,'r') as file:
        data = json.load(file)
    return data

def saveBankDetails(newData: dict, filepath : str):

    with open(filepath, 'w') as file:
        json.dump(newData, file)
