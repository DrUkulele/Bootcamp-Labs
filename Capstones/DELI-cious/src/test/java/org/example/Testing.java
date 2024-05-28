package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Testing {

    @Test
    public void giveList_displayList() {
        List<String> otherToppingsList = new ArrayList<>(Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"));
        UserInterface.displayWithNumbers(otherToppingsList);
    }

    @ParameterizedTest
    //sandwich size, num of meat, num of cheese, expected
    @CsvSource({"8 in, 3, 1 , 12.50", "4 in, 5, 3, 9.85", "12 in, 10, 22, 46.15", "12 in, 101, 101, 253.75"})
    public void giveSandwich_ReturnPrice(String sandwichSize, int numOfMeat, int numOfCheese, BigDecimal expected) {
        // Create HashMaps for toppings
        HashMap<String, Integer> meatMap = new HashMap<>();
        meatMap.put("Ham", numOfMeat);


        HashMap<String, Integer> cheeseMap = new HashMap<>();
        cheeseMap.put("Cheddar", numOfCheese);

        HashMap<String, Integer> otherToppingsMap = new HashMap<>();
        otherToppingsMap.put("Lettuce", 2);
        otherToppingsMap.put("Tomato", 1);

        HashMap<String, Integer> saucesMap = new HashMap<>();
        saucesMap.put("Mayo", 1);
        saucesMap.put("Mustard", 1);

        HashMap<String, Integer> sidesMap = new HashMap<>();
        sidesMap.put("Chips", 1);

        // Create a sandwich object
        Sandwich mySandwich = new Sandwich(sandwichSize, "Wheat", meatMap, cheeseMap, otherToppingsMap, saucesMap, sidesMap, true);

        assertEquals(expected, mySandwich.getTotalSandwichPrice(mySandwich));

    }

    @Test
    public void addSandwich_SandwichAddsToArray() {
        Cart cart = new Cart();

        // Create HashMaps for toppings
        HashMap<String, Integer> meatMap = new HashMap<>();
        meatMap.put("Ham", 1);


        HashMap<String, Integer> cheeseMap = new HashMap<>();
        cheeseMap.put("Cheddar", 1);

        HashMap<String, Integer> otherToppingsMap = new HashMap<>();
        otherToppingsMap.put("Lettuce", 2);
        otherToppingsMap.put("Tomato", 1);

        HashMap<String, Integer> saucesMap = new HashMap<>();
        saucesMap.put("Mayo", 1);
        saucesMap.put("Mustard", 1);

        HashMap<String, Integer> sidesMap = new HashMap<>();
        sidesMap.put("Chips", 1);

        // Create a sandwich object
        Sandwich mySandwich = new Sandwich("4 in", "Wheat", meatMap, cheeseMap, otherToppingsMap, saucesMap, sidesMap, true);
        Sandwich mySandwich2 = new Sandwich("8 in", "Ry3", meatMap, cheeseMap, otherToppingsMap, saucesMap, sidesMap, true);

        List<Sandwich> expected = new ArrayList<>(Arrays.asList(mySandwich, mySandwich2));

        cart.addSandwich(mySandwich);
        cart.addSandwich(mySandwich2);

        assertEquals(expected, cart.getSandwiches());
    }

    @ParameterizedTest
    //sandwich size, num of meat, num of cheese, expected
    @CsvSource({"8 in, 3, 1 , 12.50", "4 in, 5, 3, 9.85", "12 in, 10, 22, 46.15", "12 in, 101, 101, 253.75"})
    public void addSandwiches_getTotalPrice(String sandwichSize, int numOfMeat, int numOfCheese, BigDecimal priceOfSandwich) {
        Cart cart = new Cart();

        // Create HashMaps for toppings
        HashMap<String, Integer> meatMap = new HashMap<>();
        meatMap.put("Ham", numOfMeat);


        HashMap<String, Integer> cheeseMap = new HashMap<>();
        cheeseMap.put("Cheddar", numOfCheese);

        HashMap<String, Integer> otherToppingsMap = new HashMap<>();
        otherToppingsMap.put("Lettuce", 2);
        otherToppingsMap.put("Tomato", 1);

        HashMap<String, Integer> saucesMap = new HashMap<>();
        saucesMap.put("Mayo", 1);
        saucesMap.put("Mustard", 1);

        HashMap<String, Integer> sidesMap = new HashMap<>();
        sidesMap.put("Chips", 1);

        // Create a sandwich object
        Sandwich mySandwich = new Sandwich(sandwichSize, "Wheat", meatMap, cheeseMap, otherToppingsMap, saucesMap, sidesMap, true);
        Sandwich mySandwich2 = new Sandwich("8 in", "Rye", meatMap, cheeseMap, otherToppingsMap, saucesMap, sidesMap, true); // price of sandwich 12.50

        cart.addSandwich(mySandwich);
        cart.addSandwich(mySandwich2);

        BigDecimal expected = mySandwich2.getTotalSandwichPrice(mySandwich2).add(mySandwich.getTotalSandwichPrice(mySandwich));

        BigDecimal price = cart.getTotalPrice();

        assertEquals(price, expected);

    }

    @Test
    public void giveSandwich_DisplaySandwich() {

        // Create HashMaps for toppings
        HashMap<String, Integer> meatMap = new HashMap<>();
        meatMap.put("Ham", 1);


        HashMap<String, Integer> cheeseMap = new HashMap<>();
        cheeseMap.put("Cheddar", 1);

        HashMap<String, Integer> otherToppingsMap = new HashMap<>();
        otherToppingsMap.put("Lettuce", 2);
        otherToppingsMap.put("Tomato", 1);

        HashMap<String, Integer> saucesMap = new HashMap<>();
        saucesMap.put("Mayo", 1);
        saucesMap.put("Mustard", 1);

        HashMap<String, Integer> sidesMap = new HashMap<>();
        sidesMap.put("Chips", 1);



        // Create a sandwich object
        Sandwich mySandwich = new Sandwich("4 in", "Wheat", meatMap, cheeseMap, otherToppingsMap, saucesMap, sidesMap, true);
        Sandwich mySandwich2 = new Sandwich("12 in", "Rye", meatMap, cheeseMap, otherToppingsMap, saucesMap, sidesMap, false);
        Drink drink = new Drink("Small", "Cola");
        Chip chip = new Chip("Salt and Vinegar");

        List<Sandwich> sandwiches = new ArrayList<>(){{add(mySandwich); add(mySandwich2);}};
        List<Drink> drinks = new ArrayList<>(){{add(drink);}};
        List<Chip> chips = new ArrayList<>(){{add(chip);}};

        UserInterface.displayList(sandwiches);
        UserInterface.displayList(drinks);
        UserInterface.displayList(chips);
    }
}
