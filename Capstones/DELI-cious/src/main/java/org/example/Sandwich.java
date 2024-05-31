package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Sandwich {
    //properties
    private static Menu menu = new Menu();
    private static final Scanner scanner = new Scanner(System.in);
    private String size;
    private String bread;
    private String meat = "";
    private String cheese = "";
    private HashMap<String, Integer> extraMeat = new HashMap<>();
    private HashMap<String, Integer> extraCheese = new HashMap<>();
    ;
    private HashMap<String, Integer> otherToppings;
    private HashMap<String, Integer> sauces;
    private HashMap<String, Integer> sides;
    private boolean isToasted;
    private BigDecimal breadPrice = BigDecimal.valueOf(0);
    private BigDecimal meatPrice = BigDecimal.valueOf(0);
    private BigDecimal cheesePrice = BigDecimal.valueOf(0);
    private BigDecimal extraMeatPrice = BigDecimal.valueOf(0);
    private BigDecimal extraCheesePrice = BigDecimal.valueOf(0);
    int maxDescriptionLength = 20;
    private BigDecimal total = BigDecimal.valueOf(0);


    //constructor
    public Sandwich(String size, String bread, String meat, String cheese, HashMap<String, Integer> extraMeat, HashMap<String, Integer> extraCheese, HashMap<String, Integer> otherToppings, HashMap<String, Integer> sauces, HashMap<String, Integer> sides, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.otherToppings = otherToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted;
    }

    public Sandwich() {
    }

    public Sandwich(String size, String bread, String meat, String cheese, HashMap<String, Integer> extraMeat, HashMap<String, Integer> extraCheese, HashMap<String, Integer> otherToppings, HashMap<String, Integer> sauces, HashMap<String, Integer> sides, boolean isToasted, BigDecimal total) {
        this.size = size;
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.otherToppings = otherToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted;
        this.total = total;
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

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public HashMap<String, Integer> getExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(HashMap<String, Integer> extraMeat) {
        this.extraMeat = extraMeat;

    }

    public HashMap<String, Integer> getExtraCheese() {

        return extraCheese;
    }

    public void setExtraCheese(HashMap<String, Integer> extraCheese) {
        this.extraCheese = extraCheese;

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
        if (!getMeat().isEmpty() && getMeat() != null) {
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
        } else {
            meatPrice = BigDecimal.valueOf(0);
        }
        return meatPrice;
    }

    public void setMeatPrice(BigDecimal meatPrice) {
        this.meatPrice = meatPrice;
    }

    public BigDecimal getCheesePrice() {
        if (!getCheese().equals("") && getCheese() != null) {
            switch (size) {
                case "4 in":
                    cheesePrice = BigDecimal.valueOf(0.75);
                    break;
                case "8 in":
                    cheesePrice = BigDecimal.valueOf(1.50);

                    break;
                case "12 in":
                    cheesePrice = BigDecimal.valueOf(2.25);
                    break;
            }
        } else {
            cheesePrice = BigDecimal.valueOf(0);
        }
        return cheesePrice;
    }

    public void setCheesePrice(BigDecimal cheesePrice) {
        this.cheesePrice = cheesePrice;
    }

    public BigDecimal getExtraMeatPrice() {
        int numOfExtraMeat = sumHashMapValues(extraMeat);
        if (numOfExtraMeat == 0) {
            extraMeatPrice = BigDecimal.valueOf(0);
        } else {
            BigDecimal currentMeatPrice = getMeatPrice();
            extraMeatPrice = currentMeatPrice.divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(numOfExtraMeat));
        }
        return extraMeatPrice;
    }

    public void setExtraMeatPrice(BigDecimal extraMeatPrice) {
        this.extraMeatPrice = extraMeatPrice;
    }

    public BigDecimal getExtraCheesePrice() {
        int numOfExtraCheese = sumHashMapValues(extraCheese);
        if (numOfExtraCheese == 0) {
            extraCheesePrice = BigDecimal.valueOf(0);
        } else {
            extraCheesePrice = cheesePrice.divide(BigDecimal.valueOf(2.5), RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(numOfExtraCheese));
        }

        return extraCheesePrice;
    }

    public void setExtraCheesePrice(BigDecimal extraCheesePrice) {
        this.extraCheesePrice = extraCheesePrice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    //custom getter
    public BigDecimal getTotalSandwichPrice() {

        BigDecimal sandwichBreadPrice = getBreadPrice();
        BigDecimal sandwichMeatPrice = getMeatPrice();
        BigDecimal sandwichExtraMeatPrice = getExtraMeatPrice();
        BigDecimal sandwichCheesePrice = getCheesePrice();
        BigDecimal sandwichExtraCheesePrice = getExtraCheesePrice();


        BigDecimal price = sandwichBreadPrice.add(sandwichMeatPrice).add(sandwichExtraMeatPrice).add(sandwichCheesePrice).add(sandwichExtraCheesePrice);


        return price.setScale(2, RoundingMode.HALF_UP);
    }

    //methods
    public  <T> HashMap<T, Integer> pickItemWithQuantity(List<T> list) {
        HashMap<T, Integer> selectedItem = new HashMap<>();
        int index;
        int quantity = 0;
        while (true) {
            System.out.print("Enter the number of the item you want to pick (0 to finish): ");
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

            while (quantity <= 0) {
                System.out.print("Enter the quantity of the item: ");
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue; // Restart loop if input is invalid
                }

                if (quantity <= 0) {
                    System.out.println("Invalid quantity. Please enter a positive integer.");

                }
            }


            T item = list.get(index - 1); // Adjust index by -1 because index starts from 1
            if (menu.getMeatList().contains(item) && meat != null && meat.isEmpty()) {
                if (quantity > 1) {
                    setMeat(item.toString());
                    quantity -= 1;

                } else {
                    setMeat((String) item);
                }


            } else if (menu.getCheeseList().contains(item) && quantity > 1 && cheese != null && cheese.isEmpty()) {
                if (item != null) {
                    setCheese(item.toString());
                    quantity -= 1;

                } else {
                    setCheese((String) item);
                }

            }
            if (selectedItem.containsKey(item)) {
                int oldQuantity = selectedItem.get(item);
                if (item != null) {
                    quantity += oldQuantity;
                    selectedItem.put(item, quantity);
                }
            }
            selectedItem.put(item, quantity);
            quantity = 0;
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

    //method to edit a sandwich
    public static void editSandwich(Sandwich sandwich, int partToEdit) {
        int itemToEdit = -1;
        String keyToEdit = null;
        switch (partToEdit) {
            case 1:
                while (true) {
                    try {
                        System.out.println("-----Edit Size-----");
                        System.out.println("Current size: " + sandwich.getSize());
                        System.out.println("-------------------");
                        UserInterface.displayWithNumbers(menu.getSizeList());
                        int newSize = Integer.parseInt(scanner.nextLine());
                        sandwich.setSize(menu.getSizeList().get(newSize - 1));
                        System.out.println("New Size: " + sandwich.getSize());
                        break;
                    } catch (Exception ex) {
                        System.out.println("PLease choose a size from the list.");
                    }
                }
                break;
            case 2:
                while (true) {
                    try {
                        System.out.println("-----Edit Bread-----");
                        System.out.println("Current Bread: " + sandwich.getBread());
                        System.out.println("--------------------");
                        UserInterface.displayWithNumbers(menu.getBreadList());
                        int newBread = Integer.parseInt(scanner.nextLine());
                        sandwich.setBread(menu.getBreadList().get(newBread - 1));
                        System.out.println("New Bread: " + sandwich.getBread());
                        break;
                    } catch (Exception ex) {
                        System.out.println("PLease choose a bread from the list.");
                    }
                }
                break;
            case 3:
                System.out.println("-----Edit Meat-----");
                if (!sandwich.getExtraMeat().isEmpty()) {
                System.out.println("---Current Meat---");
                    String key = sandwich.getMeat();
                    if (sandwich.getExtraMeat().containsKey(key)) {
                        int currentQuantity = sandwich.getExtraMeat().get(key);
                        sandwich.getExtraMeat().put(key, currentQuantity + 1);
                    }
                    UserInterface.displayList(sandwich.mapToArrayListNoPrice(sandwich.getExtraMeat()));
                }
                else if(!sandwich.getMeat().isEmpty()){
                    sandwich.getExtraMeat().put(sandwich.getMeat(), 1);
                }
                // Let the user pick a meat item by number
                while (true) {
                    try {
                        if (!sandwich.getExtraMeat().isEmpty()){
                            System.out.println("---Pick Meat To Edit---");

                        UserInterface.displayWithNumbers(sandwich.mapToArrayListNoPrice(sandwich.getExtraMeat()));
                            System.out.println("00) Add Meat");
                    }
                       else{
                           System.out.println("00) Add Meat");

                        }

                        itemToEdit = Integer.parseInt(scanner.nextLine());

                        if(itemToEdit == 00){
                            System.out.println("Pick Meat to add");
                            // Call the method to get the HashMap
                            HashMap<String, Integer> extraMeat = sandwich.getExtraMeat();
                            UserInterface.displayWithNumbers(menu.getMeatList());
                            HashMap<String, Integer> meatList = sandwich.pickItemWithQuantity(menu.getMeatList());

                            // Update extraMeat with missing info from meatList
                            for (Map.Entry<String, Integer> entry : meatList.entrySet()) {
                                String key = entry.getKey();
                                Integer value = entry.getValue();

                                // Check if key is missing in extraMeat
                                if (!extraMeat.containsKey(key) && sandwich.getMeat().isEmpty()) {
                                    // Add key-value pair from meatList to extraMeat
                                    sandwich.setMeat(key);
                                    extraMeat.put(key, value - 1);
                                }
                                else if(!extraMeat.containsKey(key) && !sandwich.getMeat().equals(key))
                                    extraMeat.put(key, value);
                            }

                           break;
                        }
                        else {

                            // Convert the selected item number to the corresponding key
                            List<String> meatList = new ArrayList<>(sandwich.getExtraMeat().keySet());
                            if (itemToEdit >= 1 && itemToEdit <= meatList.size()) {
                                keyToEdit = meatList.get(itemToEdit - 1); // Adjust for 0-based indexing
                            } else {
                                System.out.println("Invalid selection.");
                                continue;
                            }

                            // Get the quantity of the selected meat item
                            int currentQuantity = sandwich.getExtraMeat().get(keyToEdit);
                            System.out.println("Meat to Edit: " + keyToEdit);
                            System.out.print("Please enter new quantity: ");
                            int newQuantity = Integer.parseInt(scanner.nextLine());

                            // Update quantity if the new quantity is valid
                            if (newQuantity >= 0) {
                                // Remove meat from primary string if quantity is set to 0
                                if (newQuantity == 0) {
                                    sandwich.getExtraMeat().remove(keyToEdit);
                                    if (sandwich.getMeat().equals(keyToEdit)) {
                                        // Update primary meat to a new meat if available in extra meat HashMap
                                        if (!sandwich.getExtraMeat().isEmpty()) {
                                            String newPrimaryMeat = sandwich.getExtraMeat().keySet().iterator().next();
                                            sandwich.setMeat(newPrimaryMeat);
                                            System.out.println("Primary meat set to " + newPrimaryMeat);
                                            // Decrement quantity of the new primary meat
                                            sandwich.getExtraMeat().put(newPrimaryMeat, sandwich.getExtraMeat().get(newPrimaryMeat) - 1);
                                            System.out.println("Quantity of " + newPrimaryMeat + " decremented to " + (sandwich.getExtraMeat().get(newPrimaryMeat)));
                                        } else {
                                            sandwich.setMeat(""); // No meat available, set primary meat to empty string
                                            System.out.println("Primary meat removed from sandwich.");
                                        }
                                    }
                                } else {
                                    if (sandwich.getMeat().equals(keyToEdit))
                                        newQuantity --;

                                    // Update quantity of the meat item in the extra meat HashMap
                                    sandwich.getExtraMeat().put(keyToEdit, newQuantity);
                                    System.out.println("Quantity of " + keyToEdit + " updated to " + newQuantity);

                                    // Check if the primary meat needs to be updated
                                    if (newQuantity == 1 && !keyToEdit.equals(sandwich.getMeat())) {
                                        // Update primary meat string
                                        sandwich.setMeat(keyToEdit);
                                        System.out.println("Primary meat set to " + keyToEdit);
                                    }
                                }
                                break; // Exit the loop if input is valid
                            } else {
                                System.out.println("Invalid quantity. Please enter a non-negative number.");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }
                break;
            case 4:
                System.out.println("-----Edit Cheese-----");
                if (!sandwich.getExtraCheese().isEmpty()) {
                    System.out.println("---Current Cheese---");
                    String key = sandwich.getCheese();
                    if (sandwich.getExtraCheese().containsKey(key)) {
                        int currentQuantity = sandwich.getExtraCheese().get(key);
                        sandwich.getExtraCheese().put(key, currentQuantity + 1);
                    }
                    UserInterface.displayList(sandwich.mapToArrayListNoPrice(sandwich.getExtraCheese()));
                }
                else if(!sandwich.getCheese().isEmpty()){
                    sandwich.getExtraCheese().put(sandwich.getCheese(), 1);
                }
                // Let the user pick a Cheese item by number
                while (true) {
                    try {
                        if (!sandwich.getExtraCheese().isEmpty()){
                            System.out.println("---Pick Cheese To Edit---");

                            UserInterface.displayWithNumbers(sandwich.mapToArrayListNoPrice(sandwich.getExtraCheese()));
                            System.out.println("00) Add Cheese");
                        }
                        else{
                            System.out.println("00) Add Cheese");

                        }

                        itemToEdit = Integer.parseInt(scanner.nextLine());

                        if(itemToEdit == 00){
                            System.out.println("Pick Cheese to add");
                            // Call the method to get the HashMap
                            HashMap<String, Integer> extraCheese = sandwich.getExtraCheese();
                            UserInterface.displayWithNumbers(menu.getCheeseList());
                            HashMap<String, Integer> CheeseList = sandwich.pickItemWithQuantity(menu.getCheeseList());

                            // Update extraCheese with missing info from CheeseList
                            for (Map.Entry<String, Integer> entry : CheeseList.entrySet()) {
                                String key = entry.getKey();
                                Integer value = entry.getValue();

                                // Check if key is missing in extraCheese
                                if (!extraCheese.containsKey(key) && sandwich.getCheese().isEmpty()) {
                                    // Add key-value pair from CheeseList to extraCheese
                                    sandwich.setCheese(key);
                                    extraCheese.put(key, value - 1);
                                }
                                else if(!extraCheese.containsKey(key) && !sandwich.getCheese().equals(key))
                                    extraCheese.put(key, value);
                            }

                            break;
                        }
                        else {

                            // Convert the selected item number to the corresponding key
                            List<String> CheeseList = new ArrayList<>(sandwich.getExtraCheese().keySet());
                            if (itemToEdit >= 1 && itemToEdit <= CheeseList.size()) {
                                keyToEdit = CheeseList.get(itemToEdit - 1); // Adjust for 0-based indexing
                            } else {
                                System.out.println("Invalid selection.");
                                continue;
                            }

                            // Get the quantity of the selected Cheese item
                            System.out.println("Cheese to Edit: " + keyToEdit);
                            System.out.print("Please enter new quantity: ");
                            int newQuantity = Integer.parseInt(scanner.nextLine());

                            // Update quantity if the new quantity is valid
                            if (newQuantity >= 0) {
                                // Remove Cheese from primary string if quantity is set to 0
                                if (newQuantity == 0) {
                                    sandwich.getExtraCheese().remove(keyToEdit);
                                    if (sandwich.getCheese().equals(keyToEdit)) {
                                        // Update primary Cheese to a new Cheese if available in extra Cheese HashMap
                                        if (!sandwich.getExtraCheese().isEmpty()) {
                                            String newPrimaryCheese = sandwich.getExtraCheese().keySet().iterator().next();
                                            sandwich.setCheese(newPrimaryCheese);
                                            System.out.println("Primary Cheese set to " + newPrimaryCheese);
                                            // Decrement quantity of the new primary Cheese
                                            sandwich.getExtraCheese().put(newPrimaryCheese, sandwich.getExtraCheese().get(newPrimaryCheese) - 1);
                                            System.out.println("Quantity of " + newPrimaryCheese + " decremented to " + (sandwich.getExtraCheese().get(newPrimaryCheese)));
                                        } else {
                                            sandwich.setCheese(""); // No Cheese available, set primary Cheese to empty string
                                            System.out.println("Primary Cheese removed from sandwich.");
                                        }
                                    }
                                } else {
                                    if (sandwich.getCheese().equals(keyToEdit))
                                        newQuantity --;

                                    // Update quantity of the Cheese item in the extra Cheese HashMap
                                    sandwich.getExtraCheese().put(keyToEdit, newQuantity);
                                    System.out.println("Quantity of " + keyToEdit + " updated to " + newQuantity);

                                    // Check if the primary Cheese needs to be updated
                                    if (newQuantity == 1 && !keyToEdit.equals(sandwich.getCheese())) {
                                        // Update primary Cheese string
                                        sandwich.setCheese(keyToEdit);
                                        System.out.println("Primary Cheese set to " + keyToEdit);
                                    }
                                }
                                break; // Exit the loop if input is valid
                            } else {
                                System.out.println("Invalid quantity. Please enter a non-negative number.");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }
                break;
            case 5:
                while (true) {
                    try {
                        System.out.println("---Edit Other Toppings---");
                        break;
                    } catch (Exception ex) {
                        System.out.println("PLease choose a bread from the list.");
                    }
                }
                //Other Toppings
                break;
            case 6:
                while (true) {
                    try {
                        System.out.println("---Edit Sauces---");
                        break;
                    } catch (Exception ex) {
                        System.out.println("PLease choose a bread from the list.");
                    }
                }
                //Sauces
                break;
            case 7:
                while (true) {
                    try {
                        System.out.println("---Edit Sides---");
                        break;
                    } catch (Exception ex) {
                        System.out.println("PLease choose a bread from the list.");
                    }
                }
                // Sides
                break;
            case 8:
                while (true) {
                    try {
                        break;
                    } catch (Exception ex) {
                        System.out.println("PLease choose a bread from the list.");
                    }
                }
                break;
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //int maxDescriptionLength = Math.max(bread.length(), Math.max(meat.length(), Math.max(cheese.length(), Math.max(mapToString(otherToppings).length(), Math.max(mapToString(sauces).length(), mapToString(sides).length())))));
        sb.append(size).append("\n");
        sb.append(formatDescription(bread, getBreadPrice(), maxDescriptionLength)).append("\n");
        if (!meat.isEmpty()) {
            sb.append(formatDescription(meat, getMeatPrice(), maxDescriptionLength)).append("\n");
        }
        if (!cheese.isEmpty()) {
            sb.append(formatDescription(cheese, getCheesePrice(), maxDescriptionLength)).append("\n");
        }
        if (!otherToppings.isEmpty()) {

            sb.append((mapToString(otherToppings)));
        }
        if (!sauces.isEmpty()) {
            sb.append(mapToString(sauces));
        }
        if (!sides.isEmpty()) {
            sb.append(mapToString(sides));
        }
        if (isToasted) {
            sb.append("Toasted").append(" \n");
        }
        if (!extraMeat.isEmpty() || !extraCheese.isEmpty()) {
            sb.append("---Add ons---\n");
        }
        if (!meat.isEmpty()) {
            sb.append(mapToString(extraMeat));
        }
        if (!cheese.isEmpty()) {
            sb.append(mapToString(extraCheese));
        }
        if (total.compareTo(BigDecimal.valueOf(0)) != 0) {
            sb.append(formatDescription("Total: ", getTotalSandwichPrice(), maxDescriptionLength)).append("\n");
        }


        return sb.toString();
    }

    // Helper method to convert HashMap to string
    private String mapToString(HashMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> keys = new ArrayList<>();
        //int maxDescriptionLength = 0;


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String formatKey = entry.getKey() + " * " + entry.getValue();
            if (map == extraMeat) {
                getExtraMeatPrice();
            }
            if (map == extraCheese) {
                getExtraCheesePrice();
            }

            if (entry.getValue() > 1) {
                keys.add(formatKey);
            } else if (entry.getValue() == 1) {
                keys.add(entry.getKey());
            }
        }
        if (!map.isEmpty()) {
            sb.delete(sb.length() - 0, sb.length());
        }


        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String modifiedKey;
            String number = "1";
            if (key.matches(".*\\*\\s*\\d+.*")) {
                modifiedKey = keys.get(i).replaceAll("(.*?)\\*\\s*\\d+", "$1"); // Replace "* number" with an empty string
                number = keys.get(i).replaceAll(".*\\*\\s*(\\d+).*", "$1"); // Extract the number
                modifiedKey = modifiedKey.trim();
            } else {
                modifiedKey = keys.get(i);
            }
            if (menu.getMeatList().contains(modifiedKey)) {
                int meatNumber = sumHashMapValues(extraMeat);
                BigDecimal sandwichExtraMeatPrice = getExtraMeatPrice().divide(BigDecimal.valueOf(meatNumber), RoundingMode.HALF_UP);
                BigDecimal priceForExtraMeat = sandwichExtraMeatPrice.multiply(BigDecimal.valueOf(Long.parseLong(number)));

                sb.append(formatDescription(keys.get(i), priceForExtraMeat, maxDescriptionLength)).append("\n");

            } else if (menu.getCheeseList().contains(modifiedKey)) {
                int cheeseNumber = sumHashMapValues(extraCheese);
                BigDecimal sandwichExtraCheesePrice = getExtraCheesePrice().divide(BigDecimal.valueOf(cheeseNumber), RoundingMode.HALF_UP);
                BigDecimal priceForExtraCheese = sandwichExtraCheesePrice.multiply(BigDecimal.valueOf(Long.parseLong(number)));

                sb.append(formatDescription(keys.get(i), priceForExtraCheese, maxDescriptionLength)).append("\n");
            } else {

                sb.append(formatDescription(keys.get(i), BigDecimal.valueOf(0), maxDescriptionLength)).append("\n");
            }
        }


        return sb.toString();
    }

    private ArrayList<String> mapToArrayListNoPrice(HashMap<String, Integer> map) {

        ArrayList<String> keys = new ArrayList<>();
        //int maxDescriptionLength = 0;


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String formatKey = entry.getKey() + " * " + entry.getValue();
            if (entry.getValue() > 1) {
                keys.add(formatKey);
            } else if (entry.getValue() == 1) {
                keys.add(entry.getKey());
            }
        }


//        for (int i = 0; i < keys.size(); i++) {
//            String key = keys.get(i);
//            String modifiedKey;
//            String number = "1";
//            if (key.matches(".*\\*\\s*\\d+.*")) {
//                modifiedKey = keys.get(i).replaceAll("(.*?)\\*\\s*\\d+", "$1"); // Replace "* number" with an empty string
//                number = keys.get(i).replaceAll(".*\\*\\s*(\\d+).*", "$1"); // Extract the number
//                modifiedKey = modifiedKey.trim();
//            } else {
//                modifiedKey = keys.get(i);
//            }
//            if (menu.getMeatList().contains(modifiedKey)) {
//                int meatNumber = sumHashMapValues(extraMeat);
//                BigDecimal sandwichExtraMeatPrice = getExtraMeatPrice().divide(BigDecimal.valueOf(meatNumber), RoundingMode.HALF_UP);
//                BigDecimal priceForExtraMeat = sandwichExtraMeatPrice.multiply(BigDecimal.valueOf(Long.parseLong(number)));
//
//                sb.append(formatDescription(keys.get(i), priceForExtraMeat, maxDescriptionLength)).append("\n");
//
//            } else if (menu.getCheeseList().contains(modifiedKey)) {
//                int cheeseNumber = sumHashMapValues(extraCheese);
//                BigDecimal sandwichExtraCheesePrice = getExtraCheesePrice().divide(BigDecimal.valueOf(cheeseNumber), RoundingMode.HALF_UP);
//                BigDecimal priceForExtraCheese = sandwichExtraCheesePrice.multiply(BigDecimal.valueOf(Long.parseLong(number)));
//
//                sb.append(formatDescription(keys.get(i), priceForExtraCheese, maxDescriptionLength)).append("\n");
//            } else {
//
//                sb.append(formatDescription(keys.get(i), BigDecimal.valueOf(0), maxDescriptionLength)).append("\n");
//            }
//        }


        return keys;
    }

    private String formatDescription(String description, BigDecimal price, int maxDescriptionLength) {

        // Calculate the adjusted width by adding additional spaces to maxDescriptionLength
        int adjustedWidth = 50 - maxDescriptionLength;

        // Format the description and price with the adjusted width
        return String.format("%-" + adjustedWidth + "s $%.2f", description, price.setScale(2, RoundingMode.HALF_UP));
    }

}






