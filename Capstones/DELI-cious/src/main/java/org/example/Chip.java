package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Chip {
    //properties
    private String type;
    private BigDecimal price = BigDecimal.valueOf(1.50);
    private int quantity;
    int maxDescriptionLength = 20;
    private static Menu menu = new Menu();
    private static Scanner scanner = new Scanner(System.in);
    private static Cart cart = new Cart();

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

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(quantity));
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String description;
        if (quantity > 1) {
            description = type + " " + " * " + quantity;
        } else {
            description = type;
        }
        sb.append(formatDescription(description, getTotalPrice(), maxDescriptionLength)).append("\n");
        return sb.toString();
    }

    private String formatDescription(String description, BigDecimal price, int maxDescriptionLength) {

        // Calculate the adjusted width by adding additional spaces to maxDescriptionLength
        int adjustedWidth = 50 - maxDescriptionLength;

        // Format the description and price with the adjusted width
        return String.format("%-" + adjustedWidth + "s $%.2f", description, price.setScale(2, RoundingMode.HALF_UP));
    }

    public static void editChips(Chip chips) {
        if (chips.getQuantity() > 1) {
            System.out.println("Enter the quantity to edit:");
            int quantityToEdit = Integer.parseInt(scanner.nextLine());
            if (quantityToEdit < chips.getQuantity() && quantityToEdit > 0) {
                // Decrease the quantity of the existing chip object
                chips.setQuantity(chips.getQuantity() - quantityToEdit);
                cart.addChip(new Chip(chips.getType(), quantityToEdit));
            } else {
                System.out.println("Invalid quantity. Please enter a value between 1 and " + chips.getQuantity() + ".");
            }
        }

        while (true) {
            try {
                System.out.println("-----Edit type-----");
                System.out.println("Current type: " + chips.getType());
                System.out.println("-------------------");
                UserInterface.displayWithNumbers(menu.getChipTypes());
                int newType = Integer.parseInt(scanner.nextLine());
                chips.setType(menu.getChipTypes().get(newType - 1));
                System.out.println("New Type: " + chips.getType());
                break;
            } catch (Exception ex) {
                System.out.println("PLease choose a size from the list.");
            }
        }


    }
}


