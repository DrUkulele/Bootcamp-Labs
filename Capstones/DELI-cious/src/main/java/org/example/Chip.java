package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Chip {
    //properties
    private String type;
    private BigDecimal price = BigDecimal.valueOf(1.50);
    private int quantity;
    int maxDescriptionLength = 20;

    //constructor
    public Chip(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    //getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(formatDescription(type, price, maxDescriptionLength)).append("\n");
        return sb.toString();
    }
    private String formatDescription(String description, BigDecimal price, int maxDescriptionLength) {

        // Calculate the adjusted width by adding additional spaces to maxDescriptionLength
        int adjustedWidth = 50 - maxDescriptionLength;

        // Format the description and price with the adjusted width
        return String.format("%-" + adjustedWidth + "s $%.2f", description, price.setScale(2, RoundingMode.HALF_UP));
    }

}
