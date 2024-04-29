package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeDataTemp {




        public static void main(String[] args) {
            List<String> transactions = generateFakeTransactions(20);
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }

        public static List<String> generateFakeTransactions(int numTransactions) {
            List<String> transactions = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < numTransactions; i++) {
                // Generate a random date
                LocalDate date = LocalDate.of(2023, random.nextInt(12) + 1, random.nextInt(28) + 1);

                // Generate a random time
                LocalTime time = LocalTime.of(random.nextInt(24), random.nextInt(60), random.nextInt(60));

                // Generate a random description
                String[] descriptions = {"Deposit", "Payment", "Purchase", "Withdrawal", "Transfer"};
                String description = descriptions[random.nextInt(descriptions.length)];

                // Generate a random vendor
                String[] vendors = {"Amazon", "Walmart", "Starbucks", "Target", "Apple", "Google"};
                String vendor = vendors[random.nextInt(vendors.length)];

                // Generate a random amount
                double amount = random.nextDouble() * 1000;

                // Determine if it's a deposit or payment
                String type = random.nextBoolean() ? "Deposit" : "Payment";
                if (type.equals("Payment")) {
                    amount *= -1; // Make it negative for payments
                }

                // Format the transaction and add it to the list
                String transaction = String.format("%s|%s|%s|%s|%.2f", date, time, description, vendor, amount);
                transactions.add(transaction);
            }
            return transactions;
        }
    }
