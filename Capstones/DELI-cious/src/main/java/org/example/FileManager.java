package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileManager {
    public static void writeReceipt(List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips){
        String fileName = createReceiptName();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
        if (sandwiches != null){

        }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createReceiptName(){
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        DateTimeFormatter rFMT = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String receiptFileName = currentDateAndTime.format(rFMT);
        return receiptFileName + ".txt";
    }
}
