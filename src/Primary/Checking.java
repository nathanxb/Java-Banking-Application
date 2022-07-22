package Primary;


import java.util.Random;

public class Checking extends BankAccount implements BaseInterestRate{

    private String accountOwner, SSN, accType;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    public Checking(String accountName, String socialSecurity, double initialDeposit) {
        super(accountName,socialSecurity, initialDeposit);
        this.accountOwner = accountName;
        this.SSN = socialSecurity;
        this.checkingBalance = initialDeposit;
        this.accType = "Checking";

    }

    private long generateDebitNum() {
            return generateRandom(12);
    }

    @Override
    public void Deposit(double amountDeposited) {
            checkingBalance = checkingBalance += amountDeposited;
    }

    @Override
    public void Withdraw(double amountWithdrawn) {
            checkingBalance = checkingBalance -= amountWithdrawn;
    }

    @Override
    public void Transfer(double amountTransferred) {
        checkingBalance = checkingBalance -= amountTransferred;
        savingBalance = savingBalance += amountTransferred;

    }

    @Override
    public void ShowInfo() {
        System.out.println("Account Type = Checking");
        System.out.println(accountOwner);
        System.out.println(SSN);
        System.out.println(checkingBalance);
    }

    @Override
    public void baseRate() {
        float checkingRate = BIR*.15f;
        System.out.println("Your Savings Account Rate is : " + checkingRate);
    }
}
