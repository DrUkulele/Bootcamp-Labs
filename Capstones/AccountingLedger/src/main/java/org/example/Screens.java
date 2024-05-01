package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screens {
    //screens
    public static void homeScreen() {
        while (true) {
            System.out.println("""
                    ---Home Screen---
                    1) Add Deposit
                    2) Make Payment(Debit)
                    3) View Ledger
                    4) Exit""");
            switch (optionPicker()) {
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
            } catch (NumberFormatException ex) {
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
            } catch (NumberFormatException ex) {
                System.out.println("Please enter the payment amount in number format.");
            }
            addMorePayments();
        }
    }

    private static void ledgerScreen() {
        while (true) {
            System.out.println("""
                    ---Ledger---
                    1) Display all Transactions
                    2) Display all Deposits
                    3) Display all Payments
                    4) Display filtered Reports
                    5) Return to Home screen""");
            switch (optionPicker()) {
                case "1":
                    List<Transaction> allTransactions = TransactionSort.getAllTransactions(FileManagement.readTransactionsFromFile());
                    printTransactions(allTransactions);
                    break;
                case "2":
                    List<Transaction> deposits = TransactionSort.getAllDeposits(FileManagement.readTransactionsFromFile());
                    printTransactions(deposits);
                    break;
                case "3":
                    List<Transaction> withdraw = TransactionSort.getAllPayments(FileManagement.readTransactionsFromFile());
                    printTransactions(withdraw);
                    break;
                case "4":
                    customReportsScreen();
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
    public static void customReportsScreen() {
        while (true) {
            System.out.println("""
                    ---Reports---
                    1) Month To Date
                    2) Previous Month
                    3) Year To Date
                    4) Previous Year
                    5) Search by vendor
                    6) Custom search
                    7) Return to Ledger
                    8) Return to Home screen""");
            switch (optionPicker()) {
                case "1":
                    List<Transaction> monthToDate = TransactionSort.getTransactionsByPeriod(FileManagement.readTransactionsFromFile(), "MonthToDate");
                    printTransactions(monthToDate);
                    break;
                case "2":
                    List<Transaction> previousMonth = TransactionSort.getTransactionsByPeriod(FileManagement.readTransactionsFromFile(), "PreviousMonth");
                    printTransactions(previousMonth);
                    break;
                case "3":
                    List<Transaction> yearToDate = TransactionSort.getTransactionsByPeriod(FileManagement.readTransactionsFromFile(), "YearToDate");
                    printTransactions(yearToDate);
                    break;
                case "4":
                    List<Transaction> previousYear = TransactionSort.getTransactionsByPeriod(FileManagement.readTransactionsFromFile(), "PreviousYear");
                    printTransactions(previousYear);
                    break;
                case "5":
                    List<Transaction> vendorSort = TransactionSort.searchByVendor(FileManagement.readTransactionsFromFile());
                    printTransactions(vendorSort);
                    break;
                case "6":
                    customReports();
                    break;
                case "7":
                    ledgerScreen();
                    break;
                case "8":
                    homeScreen();
                    break;
                default:
                    System.out.println("Please choose from one of the options above");
                    break;
            }
        }
    }

    //custom reports screen
    public static void customReports() {
        List<Transaction> customSearch = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the following information: (Press enter to leave blank)");
        System.out.print("Start Date(yyyy-mm-dd): ");
        String startDate = scanner.nextLine();
        if(startDate.equals("")){
            startDate = null;
        }
        System.out.print("End Date(yyyy-mm-dd): ");
        String endDate = scanner.nextLine();
        if(endDate.equals("")){
            endDate = null;
        }
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Amount range");
        System.out.print("Maximum amount: ");
        String maxAmountInput = scanner.nextLine();
        System.out.print("Minimum amount: ");
        String minAmountInput = scanner.nextLine();
        Double minAmount = null;
        Double maxAmount = null;
        try {

            if (!minAmountInput.isEmpty() && !maxAmountInput.isEmpty()) {
                minAmount = Double.parseDouble(minAmountInput);
                maxAmount = Double.parseDouble(maxAmountInput);
            }
        }
        catch (NumberFormatException ex){
            System.out.println("Please enter amounts in number format.");
        }
        printTransactions(TransactionSort.customSearch(FileManagement.readTransactionsFromFile(), startDate, endDate, description, vendor, minAmount, maxAmount));
    }

    //helper methods for screens

    //option picking method returns string for scanner.nextLine()
    public static String optionPicker() {
        Scanner scanner = new Scanner(System.in);
        String optionChoice = scanner.nextLine();
        return optionChoice;
    }

    //allow user to stay on deposit screen
    public static void addMoreDeposits() {
        while (true) {
            System.out.println("1) Add another deposit 2) Home screen");
            switch (optionPicker()) {
                case "1":
                    addDeposit();
                    break;
                case "2":
                    homeScreen();
                    break;
                default:
                    System.out.println("Please choose from one of the above options.");
            }
        }
    }

    //allow user to stay on payments screen
    public static void addMorePayments() {
        while (true) {
            System.out.println("1) Add another payment 2) Home screen");
            switch (optionPicker()) {
                case "1":
                    makePayment();
                    break;
                case "2":
                    homeScreen();
                    break;
                default:
                    System.out.println("Please choose from one of the above options.");
            }
        }
    }

    //print the transaction arrays
    public static void printTransactions(List<Transaction> transactions) {
        int transactioncount = 0;
        for (Transaction transaction : transactions) {
            System.out.printf("%s %s %s %s %s\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            transactioncount++;
        }
        if (transactioncount == 0) {
            System.out.println("No transactions found.");
        } else {
            System.out.printf("All %d transactions displayed\n", transactioncount);
        }
    }
}

