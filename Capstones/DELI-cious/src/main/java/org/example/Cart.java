package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    //properties
    private BigDecimal totalPrice = BigDecimal.valueOf(0);
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chip> chips = new ArrayList<>();


    //methods
    public BigDecimal getTotalPrice(){
        for (Sandwich sandwich : sandwiches){
            totalPrice = totalPrice.add(sandwich.getTotalSandwichPrice(sandwich));
        }
        for (Drink drink : drinks){
            totalPrice = totalPrice.add(drink.getDrinkPrice(drink));
        }
        for (Chip chip : chips)
            totalPrice = totalPrice.add(chip.getChipPrice(chip));
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
