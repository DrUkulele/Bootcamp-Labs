package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    //properties
    private List<String> sizeList = new ArrayList<>(Arrays.asList("4 in", "8 in", "12 in"));
    private List<String> breadList = new ArrayList<>(Arrays.asList("White", "Wheat", "Rye", "Wrap"));
    private List<String> meatList = new ArrayList<>(Arrays.asList("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"));
    private List<String> cheeseList = new ArrayList<>(Arrays.asList("American", "Provolone", "Cheddar", "Swiss"));
    private List<String> otherToppingsList = new ArrayList<>(Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"));
    private List<String> saucesList = new ArrayList<>(Arrays.asList("Mayo","Mustard","Ketchup","Ranch","Thousand Island","Vinaigrette"));
    private List<String> sidesList = new ArrayList<>(Arrays.asList("Au Jus", "Sauce"));

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
}
