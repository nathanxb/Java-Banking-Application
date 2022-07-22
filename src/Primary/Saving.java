package Primary;

import java.util.Scanner;

public class Saving extends BankAccount implements BaseInterestRate{

    private double savingBalance = 0;
    private double checkingBalance = 0;

    String accType;
    public Saving(String accountName, String socialSecurity, Double initialDeposit) {
        super(accountName,socialSecurity, initialDeposit);
        this.accountOwner = accountName;
        this.SSN = socialSecurity;
        this.savingBalance = initialDeposit;
        this.accType = "Saving";

    }

    void createSafetyDepositBox() {
        // Identifies by 3-digit number
        generateRandom(3);

        // Accessed with a 4-digit code
            // Use Scanner for user PIN input
        Scanner enterPIN = new Scanner(System.in);

    }
    @Override
    public void Deposit(double amountDeposited) {
        savingBalance = savingBalance += amountDeposited;

    }

    @Override
    public void Withdraw(double amountWithdrawn) {
        savingBalance = savingBalance += amountWithdrawn;

    }

    @Override
    public void Transfer(double amountTransferred) {
        savingBalance = savingBalance -= amountTransferred;
        checkingBalance = checkingBalance += amountTransferred;
    }

    @Override
    public void ShowInfo() {
        System.out.println("Account Type = Saving");
        System.out.println(accountOwner);
        System.out.println(SSN);
        System.out.println(savingBalance);
    }

    @Override
    public void baseRate() {
        float savingsRate = BIR - .25f;
        System.out.println("Your Savings Account Rate is : " + savingsRate);
    }
}
