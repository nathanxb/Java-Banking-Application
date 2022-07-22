package Primary;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

abstract class BankAccount {

    String SSN;
    String accountOwner;
    double initialDeposit;
    int unique5Digit = 99999;

    public BankAccount(String accountOwner, String SSN, double initialDeposit) {
        this.accountOwner = accountOwner;
        this.SSN = SSN;
        this.initialDeposit = initialDeposit;
        long accountNumber;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    //need to finish creating this function
    public long generateAccNum(String ACCOUNT_NUMBER) {
        long LONG_ACCOUNT_NUMBER = Long.parseLong(ACCOUNT_NUMBER);
        return LONG_ACCOUNT_NUMBER;
    }

    public long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }
    abstract void Deposit(double amountDeposited);

    abstract void Withdraw(double amountWithdrawn);

    abstract void Transfer(double amountTransferred);
    void ShowInfo(){
        System.out.println("Account Name = " + this.accountOwner);
        System.out.println("SSN = " + this.SSN);
    }

}

