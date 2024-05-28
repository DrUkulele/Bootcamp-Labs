package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Sandwich {
    //properties
    private static final Scanner scanner = new Scanner(System.in);
    private String size;
    private String bread;
    private HashMap<String, Integer> meat;
    private HashMap<String, Integer> cheese;
    private HashMap<String, Integer> otherToppings;
    private HashMap<String, Integer> sauces;
    private HashMap<String, Integer> sides;
    private boolean isToasted;
    private BigDecimal breadPrice;
    private BigDecimal meatPrice;
    private BigDecimal cheesePrice;
    private BigDecimal extraMeatPrice;
    private BigDecimal extraCheesePrice;


    //constructor
    public Sandwich(String size, String bread, HashMap<String, Integer> meat, HashMap<String, Integer> cheese, HashMap<String, Integer> otherToppings, HashMap<String, Integer> sauces, HashMap<String, Integer> sides, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.otherToppings = otherToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted;
    }

    //overloaded constructor for has a relationship in User Interface
    public Sandwich() {
    }

    //overloaded constructor for getting the price
    public Sandwich(String size, String bread, HashMap<String, Integer> meat, HashMap<String, Integer> cheese, HashMap<String, Integer> otherToppings, HashMap<String, Integer> sauces, HashMap<String, Integer> sides, boolean isToasted, BigDecimal price) {
        this.size = size;
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.otherToppings = otherToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted;
    }

    //getters and setters for constructor items
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public HashMap<String, Integer> getMeat() {
        return meat;
    }

    public void setMeat(HashMap<String, Integer> meat) {
        if (meat != null) {
            this.meat = meat;
        }
    }

    public HashMap<String, Integer> getCheese() {

        return cheese;
    }

    public void setCheese(HashMap<String, Integer> cheese) {
        if (cheese != null) {
            this.cheese = cheese;
        }
    }

    public HashMap<String, Integer> getOtherToppings() {
        return otherToppings;
    }

    public void setOtherToppings(HashMap<String, Integer> otherToppings) {
        if (otherToppings != null) {
            this.otherToppings = otherToppings;
        }
    }

    public HashMap<String, Integer> getSauces() {
        return sauces;
    }

    public void setSauces(HashMap<String, Integer> sauces) {
        if (sauces != null) {
            this.sauces = sauces;
        }
    }

    public HashMap<String, Integer> getSides() {
        return sides;
    }

    public void setSides(HashMap<String, Integer> sides) {
        if (sides != null) {
            this.sides = sides;
        }
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public BigDecimal getBreadPrice() {
        switch (size) {
            case "4 in":
                breadPrice = BigDecimal.valueOf(5.50);
                break;
            case "8 in":
                breadPrice = BigDecimal.valueOf(7.00);

                break;
            case "12 in":
                breadPrice = BigDecimal.valueOf(8.50);
                break;
        }

        return breadPrice;
    }

    public void setBreadPrice(BigDecimal breadPrice) {
        this.breadPrice = breadPrice;
    }

    public BigDecimal getMeatPrice() {
        switch (size) {
            case "4 in":
                meatPrice = BigDecimal.valueOf(1.00);
                break;
            case "8 in":
                meatPrice = BigDecimal.valueOf(2.00);

                break;
            case "12 in":
                meatPrice = BigDecimal.valueOf(3.00);
                break;
        }
        return meatPrice;
    }

    public void setMeatPrice(BigDecimal meatPrice) {
        this.meatPrice = meatPrice;
    }

    public BigDecimal getCheesePrice() {
        switch (size) {
            case "4 in":
                breadPrice = BigDecimal.valueOf(0.75);
                break;
            case "8 in":
                breadPrice = BigDecimal.valueOf(1.50);

                break;
            case "12 in":
                breadPrice = BigDecimal.valueOf(2.25);
                break;
        }
        return cheesePrice;
    }

    public void setCheesePrice(BigDecimal cheesePrice) {
        this.cheesePrice = cheesePrice;
    }

    public BigDecimal getExtraMeatPrice() {
        return extraMeatPrice;
    }

    public void setExtraMeatPrice(BigDecimal extraMeatPrice) {
        this.extraMeatPrice = extraMeatPrice;
    }

    public BigDecimal getExtraCheesePrice() {
        return extraCheesePrice;
    }

    public void setExtraCheesePrice(BigDecimal extraCheesePrice) {
        this.extraCheesePrice = extraCheesePrice;
    }

    //custom getter
    public BigDecimal getTotalSandwichPrice(Sandwich sandwich) {
        String size = sandwich.getSize();
        meat = sandwich.getMeat();
        cheese = sandwich.getCheese();

        int numOfMeat = sumHashMapValues(meat);
        int numOfCheese = sumHashMapValues(cheese);

        if (numOfMeat == 0) {
            meatPrice = BigDecimal.valueOf(0);
        }
        if (numOfCheese == 0) {
            cheesePrice = BigDecimal.valueOf(0);
        }

        setExtraCheesePrice(cheesePrice.divide(BigDecimal.valueOf(2.5), RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(numOfCheese - 1)));
        setExtraMeatPrice(meatPrice.divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(numOfMeat - 1)));

        BigDecimal price = breadPrice.add(
                meatPrice.add(extraMeatPrice.add(cheesePrice.add(extraCheesePrice))));


        return price.setScale(2, RoundingMode.HALF_UP);
    }

    //methods
    public static <T> HashMap<T, Integer> pickItemWithQuantity(List<T> list) {

        HashMap<T, Integer> selectedItem = new HashMap<>();
        while (true) {
            System.out.print("Enter the number of the item you want to pick (0 to finish): ");
            int index;
            try {
                index = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue; // Restart loop if input is invalid
            }

            // Finish selection if index is 0
            if (index == 0) {
                System.out.println("No items selected.");
                return selectedItem;
            }

                // Validate index
                if (index < 1 || index > list.size()) {
                    System.out.println("Invalid input. Please enter a number within the range.");
                    continue; // Restart loop if index is invalid
                }

                System.out.print("Enter the quantity of the item: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                if (quantity <= 0) {
                    System.out.println("Invalid quantity. Please enter a positive integer.");
                    continue; // Restart loop if quantity is invalid
                }

                T item = list.get(index - 1); // Adjust index by -1 because index starts from 1
                selectedItem.put(item, quantity);
            }
        }


    public static <T> T pickItemNoQuantity(List<T> list) {
        while (true) {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the number of the item you want to pick: ");
                int index = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                return list.get(index - 1); // Adjust index by -1 because index starts from 1
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Invalid input. Please enter a number within the range.");
            }
        }
    }


    //method to add the values of a hashmap together
    public static <K, V extends Number> int sumHashMapValues(HashMap<K, V> Hashmap) {
        int sum = 0;

        // Loop through the values and add them up
        for (V value : Hashmap.values()) {
            sum += value.intValue();
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");
        sb.append(bread).append(" $").append(getBreadPrice().setScale(2, RoundingMode.HALF_UP)).append("\n");
        if (!meat.isEmpty()) {
            sb.append(mapToString(meat)).append("\n");
        }
        if (!cheese.isEmpty()) {
            sb.append(mapToString(cheese)).append("\n");
        }
        if (!otherToppings.isEmpty()) {
            sb.append(mapToString(otherToppings)).append("\n");
        }
        if (!sauces.isEmpty()) {
            sb.append(mapToString(sauces)).append("\n");
        }
        if (!sides.isEmpty()) {
            sb.append(mapToString(sides)).append("\n");
        }
        if (isToasted) {
            sb.append("Toasted");
        }
        sb.append("\n");

        return sb.toString();
    }

    // Helper method to convert HashMap to string
    private String mapToString(HashMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                sb.append(entry.getKey()).append(" * ").append(entry.getValue()).append("\n");
            } else if (entry.getValue() == 1) {
                sb.append(entry.getKey()).append(" \n");
            }
        }
        if (!map.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.toString();
    }


}





