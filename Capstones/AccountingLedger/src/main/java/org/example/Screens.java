package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Screens {
    //screens
    public static void homeScreen(){
        while(true) {
            System.out.println("""
                    ---Home Screen---
                    1) Add Deposit
                    2) Make Payment(Debit)
                    3) View Ledger
                    4) Exit""");
            switch (optionPicker()){
                case "1":
                    addDeposit();
                    break;
                case "2":
                    makePayment();
                    break;
                case "3":
                    ledgerScreen();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please chose one of the options above.");
            }
        }
    }

    private static void addDeposit() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("---Add Deposit---");
                Transaction deposit = new Transaction();
                System.out.println("Please enter the following information.");
                System.out.print("Deposit Description: ");
                String description = scanner.nextLine();
                System.out.print("Vendor: ");
                String vendor = scanner.nextLine();
                System.out.print("Amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                deposit.setDescription(description);
                deposit.setVendor(vendor);
                deposit.setAmount(amount);
                FileManagement.writeTransactionToFile(deposit);
            }
            catch(NumberFormatException ex){
                System.out.println("Please enter the deposit amount in number format.");
            }
            addMoreDeposits();
        }

    }

    private static void makePayment() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("---Make Payment---");
                Transaction payment = new Transaction();
                System.out.println("Please enter the following information.");
                System.out.print("Payment Description: ");
                String description = scanner.nextLine();
                System.out.print("Vendor: ");
                String vendor = scanner.nextLine();
                System.out.print("Amount: ");
                double amount = Math.abs(Double.parseDouble(scanner.nextLine())) * -1;
                payment.setDescription(description);
                payment.setVendor(vendor);
                payment.setAmount(amount);
                FileManagement.writeTransactionToFile(payment);
            }
            catch(NumberFormatException ex){
                System.out.println("Please enter the payment amount in number format.");
            }
            addMorePayments();
        }
    }

    private static void ledgerScreen() {
        while(true){
            System.out.println("""
                    ---Ledger---
                    1) Display all Transactions
                    2) Display all Deposits
                    3) Display all Payments
                    4) Display filtered Reports
                    5) Return to Home screen""");
            switch (optionPicker()){
                case "1":
                    FileManagement.getAllTransactions(FileManagement.readTransactionsFromFile());
                    break;
                case "2":
                    FileManagement.getAllDeposits(FileManagement.readTransactionsFromFile());
                    break;
                case "3":
                    FileManagement.getAllPayments(FileManagement.readTransactionsFromFile());
                    break;
                case "4":
                    break;
                case "5":
                    homeScreen();
                    break;
                default:
                    System.out.println("Please choose form one of the options above.");
                    break;

            }
        }

    }

    //sort by desired reports screen
    public static void customReportsScreen(){
        System.out.println("""
                ---Reports---
                1)
                2)
                3)
                4)
                5)
                6) 
                7) Return to Home screen""");
    }

    //helper methods for screens

    //option picking method returns string for scanner.nextLine()
    public static String optionPicker() {
        Scanner scanner = new Scanner(System.in);
        String optionChoice = scanner.nextLine();
        return optionChoice;
    }

    //allow user to stay on deposit screen
    public static void addMoreDeposits(){
        System.out.println("1) Add another deposit 2) Home screen");
        switch (optionPicker()){
            case "1":
                break;
            case "2":
                homeScreen();
                break;
            default:
                System.out.println("Please choose from one of the above options.");
        }
    }

    //allow user to stay on payments screen
    public static void addMorePayments(){
        System.out.println("1) Add another payment 2) Home screen");
        switch (optionPicker()){
            case "1":
                break;
            case "2":
                homeScreen();
                break;
            default:
                System.out.println("Please choose from one of the above options.");
        }
    }
}

