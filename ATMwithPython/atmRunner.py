import registration
import userInput
import verification
import operation

detailsFile: str = "bankDetails.json"
while True:

    try:
        Pin = userInput.inputPin()

    except:
        print("Note- (Pin should be number): ")
        continue

    else:
        verified: bool = verification.checker(detailsFile, Pin)
        accountNumber: int = verification.accountDetailsChecker(detailsFile, Pin)

        if verified != True:

            operation.error1()
            registration.register(detailsFile)
            break

        else:
            while True:

                try:
                    choice: int = int(input("Enter 1 for Cash Deposition, 2 for Cash WithDrawal, 3 for Balance : "))

                except:
                    print("Please read the instructions carefully!")

                if choice == 3:

                    operation.displayBalance(detailsFile, accountNumber)
                    operation.transactionTermine()
                    break

                elif choice == 1:

                    operation.deposition(detailsFile, accountNumber)
                    operation.transactionTermine()
                    break

                elif choice == 2:

                    operation.withDrawal(detailsFile, accountNumber)
                    operation.transactionTermine()
                    break


                else:
                    operation.error2()
        break
