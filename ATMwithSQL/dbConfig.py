import sqlite3

DB_NAME = 'bank.db'

def Database_Creation():
    conn = sqlite3.connect(DB_NAME)
    cursor = conn.cursor()
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS accounts (
            AccountNo INTEGER PRIMARY KEY AUTOINCREMENT,
            Name TEXT NOT NULL,
            Balance INTEGER NOT NULL DEFAULT 0,
            Pin INTEGER UNIQUE NOT NULL
        )
    ''')
    conn.commit()
    conn.close()

def deregistration(pin: int):
    account = fetch_account_by_pin(pin)
    if account:
        conn = sqlite3.connect(DB_NAME)
        cursor = conn.cursor()
        cursor.execute("DELETE FROM accounts WHERE Pin = ?", (pin,))
        conn.commit()
        conn.close()
        return "Account deleted successfully."
    else:
        return "No account found with the provided PIN."

def fetch_account_by_pin(pin: int):
    conn = sqlite3.connect(DB_NAME)
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM accounts WHERE Pin = ?", (pin,))
    row = cursor.fetchone()
    conn.close()
    return row

def insert_account(name: str, pin: int):
    conn = sqlite3.connect(DB_NAME)
    cursor = conn.cursor()
    cursor.execute("INSERT INTO accounts (Name, Pin, Balance) VALUES (?, ?, ?)", (name, pin, 0))
    conn.commit()
    conn.close()

def update_balance(account_no: int, new_balance: int):
    conn = sqlite3.connect(DB_NAME)
    cursor = conn.cursor()
    cursor.execute("UPDATE accounts SET Balance = ? WHERE AccountNo = ?", (new_balance, account_no))
    conn.commit()
    conn.close()