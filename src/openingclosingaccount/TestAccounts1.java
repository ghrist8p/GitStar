package openingclosingaccount;

//************************************************************
//TestAccounts1
//A simple program to test the numAccts method of the
//Account class.
//************************************************************
import java.util.Scanner;

public class TestAccounts1 {
    public static void main(String[] args) {
        Account acct1;
        Account acct2;
        Account acct3;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter three names on three lines: ");
        acct1 = new Account(100, scan.nextLine());
        acct2 = new Account(100, scan.nextLine());
        acct3 = new Account(100, scan.nextLine());

        System.out.println("\n\n" + acct1 + "\n\n" + acct2 + "\n\n" + acct3);
        
        acct1.close();
        
        Account acct4 = Account.consolidate(acct2, acct3);

        System.out.println("\n\n" + acct1 + "\n\n" + acct2 + "\n\n" + acct3 + "\n\n" + acct4);
        
        
        /*System.out.println("How many accounts would you like to create?");
        int num = scan.nextInt();
        
        for (int i = 1; i <= num; i++) {
            testAcct = new Account(100, "Name" + i);
            System.out.println("\nCreated account " + testAcct);
            System.out.println("Now there are " + Account.getNumAccounts()
                    + " accounts");
        }*/
        scan.close();
    }
}