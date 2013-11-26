package flexibleaccount;

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
    
    private double balance;
    private String name;
    private long acctNum;

 // -------------------------------------------------
    // Constructor -- initializes balance, owner, and account number
    // -------------------------------------------------
    public Account(double initBal, String owner, long number) {
        balance = initBal;
        name = owner;
        acctNum = number;
    }
    
    // -------------------------------------------------
    // Constructor -- initializes balance, owner, and account number to random long
    // -------------------------------------------------
    public Account(double initBal, String owner) {
        balance = initBal;
        name = owner;
        acctNum = RAND_GEN.nextLong();
    }
    
    // -------------------------------------------------
    // Constructor -- initializes balance to 0, owner, and account number to random long
    // -------------------------------------------------
    public Account(String owner) {
        balance = 0;
        name = owner;
        acctNum = RAND_GEN.nextLong();
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

    // -------------------------------------------------
    // Returns a string containing the name, account number, and balance.
    // -------------------------------------------------
    public String toString() {
        return "Name:" + name + "\nAccount Number: " + acctNum + "\nBalance: "
                + balance;
    }
}