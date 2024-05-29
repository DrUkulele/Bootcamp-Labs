package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Drink {
    //properties
    private String size;
    private String flavor;
    private BigDecimal price;
    private int quantity;
    int maxDescriptionLength = 20;

    //constructor
    public Drink(String size, String flavor, int quantity) {
        this.size = size;
        this.flavor = flavor;
        this.quantity = quantity;
    }

    //getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDrinkPrice(){
        switch (size){
            case "Small":
               price = BigDecimal.valueOf(2.00);
               break;
            case "Medium":
                price = BigDecimal.valueOf(2.50);
                break;
            case "Large":
                price = BigDecimal.valueOf(3.00);
                break;
            default:
                break;
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String description;
        if (quantity > 1){
          description = size + " " + flavor + " * " + quantity;
        }
        else {
         description = size + " " +flavor;
        }
        sb.append(formatDescription(description, getDrinkPrice().multiply(BigDecimal.valueOf(quantity)), maxDescriptionLength)).append("\n");
        return sb.toString();
    }
    private String formatDescription(String description, BigDecimal price, int maxDescriptionLength) {

        // Calculate the adjusted width by adding additional spaces to maxDescriptionLength
        int adjustedWidth = 50 - maxDescriptionLength;

        // Format the description and price with the adjusted width
        return String.format("%-" + adjustedWidth + "s $%.2f", description, price.setScale(2, RoundingMode.HALF_UP));
    }
}
