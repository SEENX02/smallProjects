import json
jsondata ='''{
  "Details": 
    [
    {
    "Name": "Maaz Qureshi",
    "Balance": 2000,
    "Pin": 3786
    },
    {
    "Name":"Qais Qureshi",
    "Balance":4000,
    "Pin":4786
    }
    ]
}'''

data: dict = json.loads(jsondata)

# for password in data["Details"]:
#     pin: int = password["Pin"]
#     print(pin)

# for password in data["Details"]:
#     newpin == password["Pin"]
#     print("This Pin has already taken!")
#     error = True
#     break

