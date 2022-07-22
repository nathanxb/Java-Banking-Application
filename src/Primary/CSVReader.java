package Primary;


import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class CSVReader {
    private ArrayList<BankAccount> bankAccounts  = new ArrayList<BankAccount>();

    public static void main(String[] args) {

        String file = "/Users/nburchiel/IdeaProjects/BankApplication/src/NewBankAccounts.csv";
        BufferedReader reader = null;
        String line = "";
        int unique5Digit = 99999;

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {



                String[] row = line.split(",");
                    String accountName = row[0];
                    String socialSecurity = row[1];
                    String accountType = row[2];
                    Double initialDeposit = Double.parseDouble(row[3]);
                    String Deposit = NumberFormat.getCurrencyInstance().format(initialDeposit);



                //Account Divider
                System.out.println("-----------------------------------------------------------");

                //Account Info
                System.out.println("Account Name = " + accountName);
                System.out.println("SSN = " + socialSecurity);
                System.out.println("Account Type = " + accountType);
                System.out.println("Deposit = " + Deposit);

                //Generating an 11-digit Account Number
                ArrayList<Integer> accountNumber = new ArrayList<Integer>();

                //Starting account number with 1 or 2 depending on Account Type
                if (accountType.equals("Checking")){
                    accountNumber.add(1);
                    long debitCardNumber = generateRandom(12);
                    System.out.println("Debit Card: " + debitCardNumber);
                } else if (accountType.equals("Savings")){
                    accountNumber.add(2);
                    long safetyDepositBoxNum = generateRandom(3);
                    System.out.println("Safety Deposit Box: " + safetyDepositBoxNum);
                    Scanner setPIN = new Scanner(System.in);
                    String safetyPIN = "";
                    while (safetyPIN.length() != 4
                            //|| !safetyPIN.matches("[0-9]")
                            ) {
                        System.out.println("Please Enter Your Safety Deposit Box 4-Digit PIN:");
                        safetyPIN = setPIN.nextLine();
                        System.out.println("***INCORRECT INPUT*** Please enter 4 digits (0-9)");
                    }
                    System.out.println("Your Safety PIN is: " + safetyPIN);

                }

                // Last two digits of SSN
                String lastTwoSSN = socialSecurity.substring(Math.max(socialSecurity.length() - 2, 0));
                int twoSSN = Integer.valueOf(lastTwoSSN);
                accountNumber.add(twoSSN);

                // Unique 5-digit Number
                accountNumber.add(unique5Digit);
                unique5Digit = unique5Digit - 1;

                // Random 3-digit Number
                Random random = new Random();
                int rand3Digit = random.nextInt(900) + 100;
                accountNumber.add(rand3Digit);

                // Combining Account Number ArrayList
                String stringAccNum = accountNumber.toString();
                String substringAccNum = stringAccNum.substring(1, stringAccNum.length()-1);
                String ACCOUNT_NUMBER = substringAccNum.replaceAll(", ", "");
                System.out.println("Account Number: " + ACCOUNT_NUMBER);

                //push information to generateAccNum()
                generateAccNum(ACCOUNT_NUMBER);



                // Formatted account summary
                for(String index : row) {

                    System.out.printf("%-20s", index);
                }
                System.out.println();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private static long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
        }

    public static long generateAccNum(String ACCOUNT_NUMBER) {
        long LONG_ACCOUNT_NUMBER = Long.parseLong(ACCOUNT_NUMBER);
        return LONG_ACCOUNT_NUMBER;
    }
}

