import registration
import verification
import operation
import dbConfig

# Initialize DB
dbConfig.Database_Creation()

while True:
    try:
        Pin = int(input("Enter your 4 digit PIN: "))
    except:
        print("Note- (Pin should be number): ")
        continue
    else:
        account = verification.accountDetailsChecker(Pin)

        if not account:
            operation.error1()
            registration.register()
            break
        else:
            while True:
                try:
                    choice = int(input("Enter 1 for Cash Deposition, 2 for Cash Withdrawal, 3 for Balance , 4 for deregistration: "))
                except:
                    print("Please read the instructions carefully!")
                    continue

                if choice == 3:
                    operation.displayBalance(account)
                    operation.transactionTermine()
                    break
                elif choice == 1:
                    operation.deposition(account)
                    operation.transactionTermine()
                    break
                elif choice == 2:
                    operation.withDrawal(account)
                    operation.transactionTermine()
                    break
                elif choice == 4:
                    operation.deregistratoin(Pin)
                    operation.transactionTermine()
                    break
                else:
                    operation.error2()
            break
