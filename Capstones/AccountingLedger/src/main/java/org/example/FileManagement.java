package org.example;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class FileManagement {

    //decimal format for file writing
    private static final DecimalFormat df = new DecimalFormat("0.00");
    //filepath for reader and writer since doing both from same file
    private static String filePath = "src/main/resources/transactions.csv";

    //file reader
    public static List<Transaction> readTransactionsFromFile() {
        //array list
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //skips the header
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                //deserialization
                String[] data = line.split("\\|");
                String date = data[0];
                String time = data[1];
                String description = data[2];
                String vendor = data[3];
                double amount = Double.parseDouble(data[4]);

                //create new transaction to put into array
                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);
            }

        } catch (IOException ex) {
            System.out.println("File unable to be read.");
        }
        return transactions;
    }

    //file writer
    public static void writeTransactionToFile(Transaction transaction) {
        transaction.updateDate();
        transaction.updateTime();
        //must append to not overwrite file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + df.format(transaction.getAmount()));
            System.out.println("Transaction added.");
        } catch (IOException ex) {
            System.out.println("File could not be written to.");
        }
    }

    //filtered display and display all methods

    //all transactions sorted newest to oldest
    public static void getAllTransactions(List<Transaction> transactions) {
        int transactioncount = 0;
        //sort transactions by newest first
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                int dateComparison = t2.getDate().compareTo(t1.getDate());
                if (dateComparison != 0) {
                    return dateComparison;
                }

                //if the dates are equal, compare the time values
                return t2.getTime().compareTo(t1.getTime());
            }
        });

        //print sorted transactions
        for (Transaction transaction : transactions) {
            System.out.printf("%s %s %s %s %s\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            transactioncount++;
        }
        System.out.printf("All %d transactions displayed\n", transactioncount);
    }

    //only display deposits sorted newest to oldest
    public static void getAllDeposits(List<Transaction> transactions) {
        int transactioncount = 0;
        //sort transactions by newest first
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                int dateComparison = t2.getDate().compareTo(t1.getDate());
                if (dateComparison != 0) {
                    return dateComparison;
                }

                //if the dates are equal, compare the time values
                return t2.getTime().compareTo(t1.getTime());
            }
        });
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.printf("%s %s %s %s %s\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
                transactioncount++;
            }
        }
        System.out.printf("All %d deposits displayed\n", transactioncount);
    }

    //only display payments sorted newest to oldest
    public static void getAllPayments(List<Transaction> transactions) {
        int transactioncount = 0;
        //sort transactions by newest first
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                int dateComparison = t2.getDate().compareTo(t1.getDate());
                if (dateComparison != 0) {
                    return dateComparison;
                }

                //if the dates are equal, compare the time values
                return t2.getTime().compareTo(t1.getTime());
            }
        });
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.printf("%s %s %s %s %s\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
                transactioncount++;
            }
        }
        System.out.printf("All %d payments displayed\n", transactioncount);
    }


    public static List<Transaction> getTransactionsByPeriod(List<Transaction> transactions, String period) {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        LocalDate firstDayOfPreviousMonth = firstDayOfMonth.minusMonths(1);
        LocalDate lastDayOfPreviousMonth = firstDayOfMonth.minusDays(1);
        LocalDate firstDayOfYear = currentDate.withDayOfYear(1);
        LocalDate firstDayOfPreviousYear = firstDayOfYear.minusYears(1);
        LocalDate lastDayOfPreviousYear = firstDayOfYear.minusDays(1);

        switch (period) {
            case "MonthToDate":
                return filterTransactions(transactions, firstDayOfMonth, currentDate);
            case "PreviousMonth":
                return filterTransactions(transactions, firstDayOfPreviousMonth, lastDayOfPreviousMonth);
            case "YearToDate":
                return filterTransactions(transactions, firstDayOfYear, currentDate);
            case "PreviousYear":
                return filterTransactions(transactions, firstDayOfPreviousYear, lastDayOfPreviousYear);
            default:
                throw new IllegalArgumentException("Invalid period: " + period);
        }
    }

    // Method to filter transactions within a specific period
    private static List<Transaction> filterTransactions(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            if (!transactionDate.isBefore(startDate) && !transactionDate.isAfter(endDate)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static void printTransactions(List<Transaction> transactions) {
        int transactioncount = 0;
        for (Transaction transaction : transactions) {
            System.out.printf("%s %s %s %s %s\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            transactioncount++;
        }
        System.out.printf("All %d transactions displayed\n", transactioncount);
    }

    //method to search by vendor
    public static void searchByVendor(List<Transaction> transactions) {
        int transactioncount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the vendor name: ");
        String vendorName = scanner.nextLine();
        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.printf("%s %s %s %s %s\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
                transactioncount++;
            }
        }
        if (transactioncount == 0) {
            System.out.println("Vendor not found");
        } else {
            System.out.printf("All %d transactions displayed\n", transactioncount);
        }
    }
}





