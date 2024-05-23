package org.example;
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
        this.meat = meat;
    }

    public HashMap<String, Integer> getCheese() {
        return cheese;
    }

    public void setCheese(HashMap<String, Integer> cheese) {
        this.cheese = cheese;
    }

    public HashMap<String, Integer> getOtherToppings() {
        return otherToppings;
    }

    public void setOtherToppings(HashMap<String, Integer> otherToppings) {
        this.otherToppings = otherToppings;
    }

    public HashMap<String, Integer> getSauces() {
        return sauces;
    }

    public void setSauces(HashMap<String, Integer> sauces) {
        this.sauces = sauces;
    }

    public HashMap<String, Integer> getSides() {
        return sides;
    }

    public void setSides(HashMap<String, Integer> sides) {
        this.sides = sides;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    //methods
    public static <T> HashMap<T, Integer> pickItemWithQuantity(List<T> list) {
        HashMap<T, Integer> selectedItem = new HashMap<>();
        while (true) {
            System.out.print("Enter the number of the item you want to pick (0 to finish): ");
            int index = Integer.parseInt(scanner.nextLine());

            // Finish selection if index is 0
            if (index == 0) {
                if (selectedItem.isEmpty()) {
                    System.out.println("No items selected.");
                    return null;
                } else {
                    return selectedItem;
                }
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the item you want to pick: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Validate index
        if (index < 1 || index > list.size()) {
            System.out.println("Invalid input. Please enter a number within the range.");
            return null;
        }

        return list.get(index - 1); // Adjust index by -1 because index starts from 1
    }


}
