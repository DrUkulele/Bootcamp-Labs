package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    //properties
    private static BigDecimal totalPrice = BigDecimal.valueOf(0);
    private static List<Sandwich> sandwiches = new ArrayList<>();
    private static List<Drink> drinks = new ArrayList<>();
    private static List<Chip> chips = new ArrayList<>();


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
            totalPrice = totalPrice.add(chip.getPrice());
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


}
