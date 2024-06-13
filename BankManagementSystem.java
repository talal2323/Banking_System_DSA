import java.io.*;
import java.util.Scanner;

public class BankManagementSystem {

    static LinkedList accountsList = new LinkedList(); // Linked list to store bank accounts
    static Stack operationStack = new Stack(); // Stack to keep track of operations

    // Function for creating account
     void createAcc() {
        double j;
        Scanner scanner = new Scanner(System.in);
            Bank b = new Bank(); // Variable of structure
            System.out.println("Enter Name:");
            b.name = scanner.nextLine();
            System.out.println("Enter Account Number");
            j = scanner.nextInt(); // Taking account number
            check(j);
            b.account_num = j;
            System.out.println("Enter The NIC");
            b.nic = scanner.nextDouble();
            System.out.println("Enter Phone");
            b.phone = scanner.nextDouble();
            System.out.println("\nFOR LOAN DETAILS\n");
            System.out.println("Enter required amount of loan :");
            b.balance = scanner.nextInt();
            System.out.println("Enter Date:(dd mm yy)");
            b.d = scanner.nextInt();
            b.m = scanner.nextInt();
            b.y = scanner.nextInt();
            System.out.println("Enter Installment time period in months");
            b.d1 = scanner.nextInt();
            b.pm = (float) b.balance / b.d1; // Per month amount which will be


            accountsList.add(b); // Add the new account to the linked list

            for (int i = 0; i < 70; i++) {
                System.out.print("*");
            }

            System.out.println("\nThanks Account Successfully Created");
           // Push the operation onto the stack
            operationStack.push("Account Created: " + b.name);

        System.out.println("\t\t\t\tEnter Any Key TO Continue");
        scanner.nextLine(); // Wait for user input
    }

    // Function to check if an account number already exists
   void check(double a) {
        Bank existingAccount = accountsList.find(a);
        if (existingAccount != null) {
            System.out.println("This Number Account Exists. Please Re-enter The Account Number");
            // ... (you may want to handle re-entering account number here)
        }
    }

    // Function to display account balance
     void checkBala() {
        int j, k = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The ACCOUNT Number");
        j = scanner.nextInt();

        Bank account = accountsList.find(j);
        if (account != null) {
            System.out.println("Name: " + account.name + "\nAccount Number: " + account.account_num
                    + "\nAccount Balance: " + account.balance + "\nNIC number: " + account.nic
                    + "\nPhone Number: " + account.phone + "\nToday date: " + account.d + " " + account.m + " " + account.y
                    + "\nInstallment time period : " + account.d1 + " months\n You have to pay per month "
                    + account.pm);
            k = 1;

            // Push the operation onto the stack
            operationStack.push("Balance Checked: " + account.name);
        }

        if (k == 0)
            System.out.println("This Account Does Not Found");

        System.out.println("\t\t\t\tEnter Any Key TO Continue");
        scanner.nextLine(); // Consume newline left by previous scanner
        scanner.nextLine(); // Wait for user input
    }

    // Function to display operations history using stack
    void displayOperationsHistory() {
        System.out.println("Operations History:");
        while (!operationStack.isEmpty()) {
            System.out.println(operationStack.pop());
        }
    }
    void updateAccount() {
        double j;
        int a;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account Number to Update:");
        j = scanner.nextDouble();

        Bank account = accountsList.find(j);
        if (account != null) {
            System.out.println("1:Name\n");
            System.out.println("2:Phone number\n");
            System.out.println("3:NIC\n");
            System.out.println("What do you want to update\n");
            a = scanner.nextInt();
            switch(a){
                case 1:
                    System.out.println("Enter Updated Name:");
                    account.name = scanner.nextLine();
                    // Update other account details as needed
                    System.out.println("Account Updated Successfully");

                    // Push the operation onto the stack
                    operationStack.push("Account Updated: " + j);
                    break;
                case 2:
                    System.out.println("Enter Updated phone number:");
                    account.phone = scanner.nextDouble();
                    // Update other account details as needed
                    System.out.println("Account Updated Successfully");

                    // Push the operation onto the stack
                    operationStack.push("Account Updated: " + j);
                    break;
                case 3:
                    System.out.println("Enter Updated NIC:");
                    account.nic = scanner.nextDouble();
                    // Update other account details as needed
                    System.out.println("Account Updated Successfully");

                    // Push the operation onto the stack
                    operationStack.push("Account Updated: " + j);
                    break;
                default:
                    System.out.println("Please input valid option");
            }

        } else {
            System.out.println("Account Not Found");
        }

        System.out.println("\t\t\t\tEnter Any Key TO Continue");
        scanner.nextLine(); // Wait for user input
    }

    // delete a customer account
   void deleteAccount() {
        int j;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account Number to Delete:");
        j = scanner.nextInt();

        Bank account = accountsList.find(j);
        if (account != null) {
            accountsList.delete(j); // You need to implement a delete method in LinkedList
            System.out.println("Account Deleted Successfully");

            // Push the operation onto the stack
            operationStack.push("Account Deleted: " + j);
        } else {
            System.out.println("Account Not Found");
        }

        System.out.println("\t\t\t\tEnter Any Key TO Continue");
        scanner.nextLine(); // Wait for user input
    }
}
