package sg.edu.nus.iss;

import java.util.Random;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );

        BankAccount darrylAccount = new BankAccount("Darryl", "001-000-1111", (float) 100000.00);
        System.out.println(darrylAccount.toString());

        darrylAccount.deposit(100000.00f);
        System.out.println(darrylAccount.toString());

        darrylAccount.withdraw(50.00f);
        System.out.println(darrylAccount.toString());

        darrylAccount.setClosed(true);

        // darrylAccount.withdraw(50.00f);
        // System.out.println(darrylAccount.toString());

        for(String transDetails: darrylAccount.getTransactions()) {
            System.out.println(transDetails);
        }

        int n = 5;
        BankAccount [] bankAcct = new BankAccount[n];

        for (int i = 0 ; i < bankAcct.length; i++) {
            String uuid = UUID.randomUUID().toString();

            float min = 1000.00f;
            float max = 100000.00f;

            Random randomNum = new Random();
            float initialBalance = min + randomNum.nextFloat();

            bankAcct[i] = new BankAccount("Employee " + String.valueOf(i), uuid, initialBalance);
        }

        bankAcct[0].showAccount();
        bankAcct[0].withdraw(100.00f);
        bankAcct[0].showAccount();


        FixedDepositAccount fredFixedD = new FixedDepositAccount("Fred", "002-0001-FD", 30000.00f, 10.0f, 1);

        fredFixedD.deposit(20000.00f);
        fredFixedD.withdraw(20000.00f);
        float computedBalance = fredFixedD.getBalance();
        System.out.println("\n" + fredFixedD.getAccountNumber() + "- " + fredFixedD.getFullName() + "--> Balance: " + computedBalance);
        
    }
}
