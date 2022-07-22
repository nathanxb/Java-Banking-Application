package Primary;

public class Saving extends BankAccount implements BaseInterestRate{

    private double savingBalance = 0;
    private double checkingBalance = 0;

    String accType;
    public Saving(String accountName, String socialSecurity, Double initialDeposit) {
        super(accountName,socialSecurity, initialDeposit);
        this.accountOwner = accountName;
        this.SSN = socialSecurity;
        this.savingBalance = savingBalance += initialDeposit;
        this.accType = "Saving";

    }

    void createSafetyDepositBox() {
        // Identifies by 3-digit number
        generateRandom(3);

        // Accessed with a 4-digit code

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

    }

    @Override
    public void ShowInfo() {
        System.out.println("Account Type = Checking");
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
