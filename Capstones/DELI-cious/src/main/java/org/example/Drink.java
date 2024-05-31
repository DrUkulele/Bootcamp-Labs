package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Drink {
    //properties
    private String size;
    private String flavor;
    private BigDecimal price;
    private int quantity;
    int maxDescriptionLength = 20;
    private static Menu menu = new Menu();
    private static Scanner scanner = new Scanner(System.in);
    private static Cart cart = new Cart();

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

    public BigDecimal getDrinkPrice() {
        switch (size) {
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
        if (quantity > 1) {
            description = size + " " + flavor + " * " + quantity;
        } else {
            description = size + " " + flavor;
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

    public static void editDrink(Drink drink, int optionToEdit) {
        if (drink.getQuantity() > 1) {
            System.out.println("Enter the quantity to edit:");
            int quantityToEdit = Integer.parseInt(scanner.nextLine());
            if (quantityToEdit < drink.getQuantity() && quantityToEdit > 0) {
                // Decrease the quantity of the existing drink object
                drink.setQuantity(drink.getQuantity() - quantityToEdit);
                cart.addDrink(new Drink(drink.getSize(), drink.getFlavor(), quantityToEdit));
            } else {
                System.out.println("Invalid quantity. Please enter a value between 1 and " + drink.getQuantity() + ".");
            }
        }
        switch (optionToEdit) {
            case 1:
                while (true) {
                    try {
                        System.out.println("-----Edit Size-----");
                        System.out.println("Current size: " + drink.getSize());
                        System.out.println("-------------------");
                        UserInterface.displayWithNumbers(menu.getDrinkSizes());
                        int newSize = Integer.parseInt(scanner.nextLine());
                        drink.setSize(menu.getDrinkSizes().get(newSize - 1));
                        System.out.println("New Size: " + drink.getSize());
                        break;
                    } catch (Exception ex) {
                        System.out.println("PLease choose a size from the list.");
                    }
                }
                break;
            case 2:
                System.out.println("-----Edit Flavor-----");
                while (true) {
                    try {
                        System.out.println("-----Edit Flavor-----");
                        System.out.println("Current Flavor: " + drink.getFlavor());
                        System.out.println("-------------------");
                        UserInterface.displayWithNumbers(menu.getDrinkFlavors());
                        int newFlavor = Integer.parseInt(scanner.nextLine());
                        drink.setFlavor(menu.getDrinkFlavors().get(newFlavor - 1));
                        System.out.println("New Flavor: " + drink.getFlavor());
                        break;
                    } catch (Exception ex) {
                        System.out.println("PLease choose a flavor from the list.");
                    }
                }
                break;
        }
    }
}


