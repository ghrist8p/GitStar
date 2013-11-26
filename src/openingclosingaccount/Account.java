package openingclosingaccount;

import java.util.Random;

//************************************************************
//Account.java
//
//A bank account class with methods to deposit to, withdraw from,
//change the name on, and get a String representation
//of the account.
//************************************************************
public class Account {
    private static final Random RAND_GEN = new Random();
    
    private static int numAccounts = 0;
    
    private double balance;
    private String name;
    private long acctNum;

    
    // -------------------------------------------------
    // Constructor -- initializes balance, owner, and account number to random long
    // -------------------------------------------------
    public Account(double initBal, String owner) {
        balance = initBal;
        name = owner;
        acctNum = Math.abs(RAND_GEN.nextLong()+1);
        ++numAccounts;
    }
    
    // -------------------------------------------------
    // Constructor -- initializes balance to 0, owner, and account number to random long
    // -------------------------------------------------
    public Account(String owner) {
        balance = 0;
        name = owner;
        acctNum = Math.abs(RAND_GEN.nextLong()+1);
        ++numAccounts;
    }

    // -------------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    // -------------------------------------------------
    public void withdraw(double amount) {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");
    }
    
    public void withdraw(double amount, double fee)
    {
        withdraw(amount+fee);
    }

    // -------------------------------------------------
    // Adds deposit amount to balance.
    // -------------------------------------------------
    public void deposit(double amount) {
        balance += amount;
    }

    // -------------------------------------------------
    // Returns balance.
    // -------------------------------------------------
    public double getBalance() {
        return balance;
    }
    
    public void close()
    {
        name += "CLOSED";
        withdraw(balance);
        --numAccounts;
    }
    
    public static Account consolidate( Account acct1, Account acct2 )
    {
        if( !acct1.name.equals(acct2.name) )
        {
            System.out.println("Consolidation failed: name mismatch!");
            return null;
        }
        if( acct1.acctNum == acct2.acctNum )
        {
            System.out.println("Consolidation failed: same account");
            return null;
        }
        Account newAcct = new Account(acct1.balance+acct2.balance, acct1.name);
        acct1.close();
        acct2.close();
        return newAcct;
    }
    
    public static int getNumAccounts()
    {
        return numAccounts;
    }

    // -------------------------------------------------
    // Returns a string containing the name, account number, and balance.
    // -------------------------------------------------
    public String toString() {
        return "Name:" + name + "\nAccount Number: " + acctNum + "\nBalance: "
                + balance;
    }
}