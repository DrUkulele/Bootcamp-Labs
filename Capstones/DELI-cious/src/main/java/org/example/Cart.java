package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    //properties
    private static BigDecimal totalPrice = BigDecimal.valueOf(0);
    private static List<Sandwich> sandwiches = new ArrayList<>();
    private static List<Drink> drinks = new ArrayList<>();
    private static List<Chip> chips = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public static BigDecimal getTotalPrice() {
        if (totalPrice.compareTo(BigDecimal.valueOf(0)) == 0){
            totalPrice = getNewTotalPrice();
        }
        return totalPrice;
    }

    //methods
    public static BigDecimal getNewTotalPrice(){
        totalPrice = BigDecimal.valueOf(0);
        for (Sandwich sandwich : sandwiches){
            totalPrice = totalPrice.add(sandwich.getTotalSandwichPrice());
        }
        for (Drink drink : drinks){
            totalPrice = totalPrice.add(drink.getDrinkPrice());
        }
        for (Chip chip : chips)
            totalPrice = totalPrice.add(chip.getTotalPrice());
        return totalPrice;
    }

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void addChip(Chip chip){
        chips.add(chip);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }
    public List<Chip> getChips() {
        return chips;
    }

    public void clearCart(){
        sandwiches.clear();
        drinks.clear();
        chips.clear();
    }

    public void writeReceiptFromCart(){
        FileManager.writeReceipt(sandwiches, drinks, chips);
    }

    public <T> void removeItemFromCart(List<T> list, int index){
        if (list.equals(drinks)) {
            for (Drink drink : drinks) {
                int quantity = drink.getQuantity();
                if (quantity > 1)
                    System.out.print("Enter the quantity you wish to remove: ");
                int quantityToRemove = Integer.parseInt(scanner.nextLine());
                if (quantityToRemove >= drink.getQuantity()) {
                    list.remove(index - 1);
                } else {
                    drink.setQuantity(quantity - quantityToRemove);
                }
            }
        }
       else if (list.equals(chips)) {
            for (Chip chip : chips) {
                int quantity = chip.getQuantity();
                if (quantity > 1)
                    System.out.print("Enter the quantity you wish to remove: ");
                int quantityToRemove = Integer.parseInt(scanner.nextLine());
                if (quantityToRemove >= chip.getQuantity()) {
                    list.remove(index - 1);
                } else {
                    chip.setQuantity(quantity - quantityToRemove);
                }
            }
        }
        else {
            list.remove(index - 1);
        }
    }

}
