package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileManager {
    private static int maxDescriptionLength = 20;

    public static void writeReceipt(List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips) {
        String fileName = createReceiptName();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            if (sandwiches != null) {
                for (Sandwich sandwich : sandwiches) {
                    writer.write(sandwich.toString());
                }
            }
            if(drinks != null){
                for (Drink drink : drinks){
                    writer.write(drink.toString());
                }
            }
            if(chips != null){
                for(Chip chip : chips){
                    writer.write(chip.toString());
                }
            }
            writer.write(formatDescription("Total: ", Cart.getTotalPrice(), maxDescriptionLength));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createReceiptName() {
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        DateTimeFormatter rFMT = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String receiptFileName = currentDateAndTime.format(rFMT);
        return receiptFileName + ".txt";
    }
    private static String formatDescription(String description, BigDecimal price, int maxDescriptionLength) {

        // Calculate the adjusted width by adding additional spaces to maxDescriptionLength
        int adjustedWidth = 50 - maxDescriptionLength;

        // Format the description and price with the adjusted width
        return String.format("%-" + adjustedWidth + "s $%.2f", description, price.setScale(2, RoundingMode.HALF_UP));
    }
}
