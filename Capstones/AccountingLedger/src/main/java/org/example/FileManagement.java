package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {
    //filepath for reader and writer since doing both from same file
    private static String filePath = "src/main/resources/transactions.csv";
    //file reader
    public static List<Transaction> getTransactions(){
        //array list
        List<Transaction> transactions = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            //skips the header
            reader.readLine();
            while((line = reader.readLine()) != null){
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

        }
        catch(IOException ex){
            System.out.println("File unable to be read.");
        }
        return transactions;
    }

    //file writer
    public static void writeTransactionToFile(Transaction transaction){
        transaction.updateDate();
        transaction.updateTime();
        //must append to not overwrite file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.newLine();
            writer.write(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount());
            System.out.println("Transaction added.");
        }
        catch (IOException ex){
            System.out.println("File could not be written to.");
        }
    }

}
