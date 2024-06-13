import java.io.*;
import java.util.Scanner;

public class Main {

    public static void display () {
        int i, n;
        BankManagementSystem bank = new BankManagementSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Describe Yourself:");
        System.out.println("1: Manager");
        System.out.println("2: Customer");
        System.out.println("3: Exit");
        n = scanner.nextInt();

        switch (n) {
            case 1:
                System.out.println("Manager\n");
                while (true) {
                    System.out.println("1: Search Account For Balance Checking");
                    System.out.println("2: Display Operations History");
                    System.out.println("3: Delete any account");
                    System.out.println("4: Previous Manu");
                    System.out.print("\t\t\t\t\tEnter Choice:");
                    i = scanner.nextInt();
                    switch (i) {
                        case 1:
                            bank.checkBala();
                            break;
                        case 2:
                            bank.displayOperationsHistory();
                            break;
                        case 3:
                            bank.deleteAccount();
                        case 4:
                            display();
                    }
                }
            case 2:
                System.out.println("Customer\n");
                while (true) {
                    System.out.println("1: Create Account");
                    System.out.println("2: Search Account For Balance Checking");
                    System.out.println("3: Update any information/Data");
                    System.out.println("4: Previous Menu");
                    System.out.print("\t\t\t\t\tEnter Choice:");
                    i = scanner.nextInt();
                    switch (i) {
                        case 1:
                            bank.createAcc();
                            break;
                        case 2:
                            bank.checkBala();
                            break;
                        case 3:
                            bank.updateAccount();
                        case 4:
                            display();
                    }

                }
            case 3:
                System.exit(0);
        }

    }

    public static void main(String[] args) {
        display();
       }
}
