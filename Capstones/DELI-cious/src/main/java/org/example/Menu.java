package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    //properties for the sandwich
    private List<String> sizeList = new ArrayList<>(Arrays.asList("4 in", "8 in", "12 in"));
    private List<String> breadList = new ArrayList<>(Arrays.asList("White", "Wheat", "Rye", "Wrap"));
    private List<String> meatList = new ArrayList<>(Arrays.asList("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"));
    private List<String> cheeseList = new ArrayList<>(Arrays.asList("American", "Provolone", "Cheddar", "Swiss"));
    private List<String> otherToppingsList = new ArrayList<>(Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"));
    private List<String> saucesList = new ArrayList<>(Arrays.asList("Mayo","Mustard","Ketchup","Ranch","Thousand Island","Vinaigrette"));
    private List<String> sidesList = new ArrayList<>(Arrays.asList("Au Jus", "Sauce"));

    //properties for the drinks
    private List<String> drinkSizes = new ArrayList<>(Arrays.asList("Small", "Medium", "Large"));
    private List<String> drinkFlavors = new ArrayList<>(Arrays.asList( "Cola", "Root Beer", "Orange Soda", "Lemon-Lime soda", "Ginger Ale", "Cream Soda", "Grape Soda", "Cherry Soda", "Vanilla Soda", "Strawberry Soda", "Blueberry Soda", "Peach Soda", "Raspberry Soda", "Passion fruit Soda", "Coconut Soda", "Mango Soda", "Lemonade" ));

    //properties for the chips
    private List<String> chipTypes = new ArrayList<>(Arrays.asList("Salt and Vinegar", "Barbecue", "Sour Cream and Onion", "Cheese", "Ranch", "Jalapeno", "Chili Lime", "Dill Pickle", "Honey Mustard", "Buffalo Wing"));

    public List<String> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<String> sizeList) {
        this.sizeList = sizeList;
    }

    public List<String> getBreadList() {
        return breadList;
    }

    public void setBreadList(List<String> breadList) {
        this.breadList = breadList;
    }

    public List<String> getMeatList() {
        return meatList;
    }

    public void setMeatList(List<String> meatList) {
        this.meatList = meatList;
    }

    public List<String> getCheeseList() {
        return cheeseList;
    }

    public void setCheeseList(List<String> cheeseList) {
        this.cheeseList = cheeseList;
    }

    public List<String> getOtherToppingsList() {
        return otherToppingsList;
    }

    public void setOtherToppingsList(List<String> otherToppingsList) {
        this.otherToppingsList = otherToppingsList;
    }

    public List<String> getSaucesList() {
        return saucesList;
    }

    public void setSaucesList(List<String> saucesList) {
        this.saucesList = saucesList;
    }

    public List<String> getSidesList() {
        return sidesList;
    }

    public void setSidesList(List<String> sidesList) {
        this.sidesList = sidesList;
    }

    public List<String> getDrinkSizes() {
        return drinkSizes;
    }

    public void setDrinkSize(List<String> drinkSize) {
        this.drinkSizes = drinkSize;
    }

    public List<String> getDrinkFlavors() {
        return drinkFlavors;
    }

    public void setDrinkFlavors(List<String> drinkFlavors) {
        this.drinkFlavors = drinkFlavors;
    }

    public List<String> getChipTypes() {
        return chipTypes;
    }

    public void setChipTypes(List<String> chipTypes) {
        this.chipTypes = chipTypes;
    }

    public static <T> T pickItemFromArray(List<T> list) {

        int selectedIndex;
        while (true) {
            try {
                System.out.print("Enter the index of the item you want to select (1-" + list.size() + "): ");
                selectedIndex = Integer.parseInt(scanner.nextLine());
                if (selectedIndex < 1 || selectedIndex > list.size()) {
                    System.out.println("Invalid index. Please enter a number within the range.");
                } else {
                    break; // Exit the loop if the index is valid
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return list.get(selectedIndex - 1); // Adjust index by -1 because index starts from 1
    }
}
