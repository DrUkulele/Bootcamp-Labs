package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //properties
    private static final Scanner scanner = new Scanner(System.in);
    private static Sandwich sandwich;
    private static Menu menu;
    private static Cart cart;
    private static boolean newOrder = true;

    static {
        menu = new Menu();
        sandwich = new Sandwich();
        cart = new Cart();
    }

    //getters and setters
    private Sandwich getSandwich() {
        return sandwich;
    }

    private void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static void setMenu(Menu menu) {
        UserInterface.menu = menu;
    }

    //methods
    //Home screen
    public static void userInterface() {
        while (true) {
            try {
                System.out.println("""
                        -----Home Screen-----
                        1) New Order
                        2) Exit""");
                switch (optionPicker()) {
                    case 1:
                        cart.clearCart();
                        newOrder = true;
                        orderScreen();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Please enter option as a number.");
            }
        }
    }

    //order screen
    private static void orderScreen() {

        while (newOrder) {
            try {
                System.out.println("""
                        1) Add Sandwich
                        2) Add Drink
                        3) Add Chips
                        4) Edit Order
                        5) Checkout
                        0) Cancel Order""");
                switch (optionPicker()) {
                    case 1:
                        addSandwichScreen();
                        break;
                    case 2:
                        addDrinkScreen();
                        break;
                    case 3:
                        addChipsScreen();
                        break;
                    case 4:
                        editOrderScreen();
                        break;
                    case 5:
                        checkoutScreen();
                        break;
                    case 0:
                        cart.clearCart();
                        System.out.println("Order canceled");
                        newOrder = false;
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Please enter option as a number.");

            }
        }

    }

    //method to add a sandwich calling the sandwich builder class to build the sandwich
    private static void addSandwichScreen() {
        while (true) {
            try {
                System.out.println("---Add Sandwich---");

                // Display sandwich sizes
                while (true) {
                    try {
                        System.out.println("---Sandwich size---");
                        displayWithNumbers(menu.getSizeList());
                        sandwich.setSize(Sandwich.pickItemNoQuantity(menu.getSizeList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting sandwich size.");
                    }
                }

                // Display bread options
                while (true) {
                    try {
                        System.out.println("---Bread---");
                        displayWithNumbers(menu.getBreadList());
                        sandwich.setBread(Sandwich.pickItemNoQuantity(menu.getBreadList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting bread.");
                    }
                }

                // Display meat options
                while (true) {
                    try {
                        System.out.println("---Meat---");
                        displayWithNumbers(menu.getMeatList());
                        sandwich.setExtraMeat(sandwich.pickItemWithQuantity(menu.getMeatList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting meat.");
                    }
                }

                // Display cheese options
                while (true) {
                    try {
                        System.out.println("---Cheese---");
                        displayWithNumbers(menu.getCheeseList());
                        sandwich.setExtraCheese(sandwich.pickItemWithQuantity(menu.getCheeseList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting cheese.");
                    }
                }

                // Display other toppings options
                while (true) {
                    try {
                        System.out.println("---Other Toppings---");
                        displayWithNumbers(menu.getOtherToppingsList());
                        sandwich.setOtherToppings(sandwich.pickItemWithQuantity(menu.getOtherToppingsList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting other toppings.");
                    }
                }

                // Display sauces options
                while (true) {
                    try {
                        System.out.println("---Sauces---");
                        displayWithNumbers(menu.getSaucesList());
                        sandwich.setSauces(sandwich.pickItemWithQuantity(menu.getSaucesList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting sauces.");
                    }
                }

                // Display sides options
                while (true) {
                    try {
                        System.out.println("---Sides---");
                        displayWithNumbers(menu.getSidesList());
                        sandwich.setSides(sandwich.pickItemWithQuantity(menu.getSidesList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting sides.");
                    }
                }

                // Display toasted options
                while (true) {
                    try {
                        System.out.println("---Toasted---");
                        System.out.println("1) Toasted");
                        System.out.println("2) Not Toasted");
                        switch (optionPicker()) {
                            case 1:
                                sandwich.setToasted(true);
                                break;
                            case 2:
                                sandwich.setToasted(false);
                                break;
                            default:
                                System.out.println("Invalid option. Please enter 1 or 2.");
                                continue; // Restart the loop if an invalid option is selected
                        }
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting toasted.");
                    }
                }

                // Confirming toasted
                boolean toasted = sandwich.isToasted();
                System.out.println("Toasted: " + (toasted ? "Yes" : "No"));

                // Creating a new sandwich object
                Sandwich newsandwich = new Sandwich(sandwich.getSize(), sandwich.getBread(), sandwich.getMeat(),
                        sandwich.getCheese(), sandwich.getExtraMeat(), sandwich.getExtraCheese(), sandwich.getOtherToppings(), sandwich.getSauces(),
                        sandwich.getSides(), sandwich.isToasted(), sandwich.getTotalSandwichPrice());
                cart.addSandwich(newsandwich);


                // If all steps are successful, exit the method
                break;
            } catch (Exception ex) {
                System.out.println("Error adding sandwich.");
            }
        }
    }

    //method to add drinks to the order
    private static void addDrinkScreen() {
        while (true) {
            try {
                System.out.println("---Drinks---");
                System.out.println("Please choose drink size: ");
                displayWithNumbers(menu.getDrinkSizes()); //display size drink size array
                String size = Menu.pickItemFromArray(menu.getDrinkSizes());//allow user to pick from drink array for size
                System.out.println("Please choose drink flavor: ");
                displayWithNumbers(menu.getDrinkFlavors());//display drink flavor array
                String flavor = Menu.pickItemFromArray(menu.getDrinkFlavors()); //allow user to pick from drink array for flavor
                System.out.println("Please enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                //add drink size, flavor and quantity to order
                Drink drink = new Drink(size, flavor, quantity);
                cart.addDrink(drink);

                break;
            } catch (Exception ex) {
                System.out.println("Error adding drink.");
            }
        }
    }

    //method to add chips to order
    private static void addChipsScreen() {
        while (true) {
            try {
                System.out.println("---Chips---");
                System.out.println("Please choose chip type: ");
                displayWithNumbers(menu.getChipTypes());  //display chip type array
                String type = Menu.pickItemFromArray(menu.getChipTypes());//allow user to pick from chip type array
                System.out.println("Please enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                //add chip quantity to order quantity to order
                Chip chip = new Chip(type, quantity);
                cart.addChip(chip);

                break;
            } catch (Exception ex) {
                System.out.println("Error adding chips");

            }
        }
    }

    //method for editing order
    private static void editOrderScreen() {
        boolean editOrder = true;
        while (editOrder) {
            try {

                System.out.println("""
                        ---Edit Order---
                        1) Remove Item From Order
                        2) Edit Sandwich
                        3) Edit Drink
                        4) Edit Chips
                        0) Go Back""");
                switch (optionPicker()) {
                    case 1:
                        removeItemScreen();
                        break;
                    case 2:
                        //method to edit a sandwich, after displaying all current sandwiches in the order, by picking one from the array, then allowing for ingredient editing
                        editSandwich();
                        break;
                    case 3:
                        //method to edit a drink, after displaying all current drinks
                        editDrink();
                        break;
                    case 4:
                        //method to edit chips, after displaying all current chips
                        editChips();
                        break;
                    case 0:
                        System.out.println("Returning to Order Screen");
                        editOrder = false;
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
                System.out.println("An error has occurred please try again.");
            }
        }
    }

    public static void editSandwich() {
        int sandwichToEdit;
        while (true) {
            try {
                System.out.println("---Edit Sandwich---");
                displayWithNumbers(cart.getSandwiches());
                System.out.print("Please chose which sandwich you would like to edit: ");
                sandwichToEdit = Integer.parseInt(scanner.nextLine()) - 1;
                break;
            } catch (Exception ex) {
                System.out.println("Please chooses a valid option.");
            }
        }
        while (true) {
            try {
                System.out.println("---Edit---");
                System.out.println(sandwich);
                System.out.println("""
                        1) Size
                        2) Bread
                        3) Meat
                        4) Cheese
                        5) Other Toppings
                        6) Sauces
                        7) Sides
                        0) Go Back""");
                int optionToEdit = Integer.parseInt(scanner.nextLine());
                if (optionToEdit == 0) {
                    break;
                } else {
                    Sandwich.editSandwich(cart.getSandwiches().get(sandwichToEdit), optionToEdit);
                }
            } catch (Exception ex) {
                System.out.println("Please chooses a valid option.");
            }
        }
    }

    public static void editDrink() {
        int drinkToEdit;
        while (true) {
            try {
                System.out.println("---Edit Drink---");
                displayWithNumbers(cart.getDrinks());
                System.out.print("Please chose which drink you would like to edit: ");
                drinkToEdit = Integer.parseInt(scanner.nextLine()) - 1;
                break;
            } catch (Exception ex) {
                System.out.println("Please chooses a valid option.");
            }
        }
        while (true) {
            try {
                System.out.println("---Edit---");
                System.out.println();
                System.out.println("""
                        1) Size
                        2) Flavor
                        0) Go Back""");
                int optionToEdit = Integer.parseInt(scanner.nextLine());
                if (optionToEdit == 0) {
                    break;
                } else {
                    Drink.editDrink(cart.getDrinks().get(drinkToEdit), optionToEdit);
                }
            } catch (Exception ex) {
                System.out.println("Please chooses a valid option.");
            }
        }
    }

    public static void editChips() {
        int chipsToEdit;
        while (true) {
            try {
                System.out.println("---Edit Chips---");
                displayWithNumbers(cart.getChips());
                System.out.print("Please chose which chips you would like to edit: ");
                chipsToEdit = Integer.parseInt(scanner.nextLine()) - 1;
                Chip.editChips(cart.getChips().get(chipsToEdit));
                break;
            } catch (Exception ex) {
                System.out.println("Please chooses a valid option.");
            }
        }
    }


    //method for picking which item to remove
    public static void removeItemScreen() {
        boolean removeItem = true;
        int index;
        while (removeItem) {
            try {
                System.out.println("---RemoveItem---");
                System.out.println("""
                        1) Sandwich
                        2) Drink
                        3) Chips
                        0) Go Back""");
                switch (optionPicker()) {
                    case 1:
                        displayWithNumbers(cart.getSandwiches());
                        System.out.print("Please pick the number of the Sandwich you wish to remove(0 to go back): ");
                        index = Integer.parseInt(scanner.nextLine());
                        if (index == 0) {
                            removeItem = false;
                        }
                    cart.removeItemFromCart(cart.getSandwiches(), index);
                    break;
                    case 2:
                        displayWithNumbers(cart.getDrinks());
                        System.out.print("Please pick the number of the Drink you wish to remove(0 to go back): ");
                        index = Integer.parseInt(scanner.nextLine());
                        if (index == 0) {
                            removeItem = false;
                        }
                        cart.removeItemFromCart(cart.getDrinks(), index);
                        break;
                    case 3:
                        displayWithNumbers(cart.getChips());
                        System.out.print("Please pick the number of the Chips you wish to remove(0 to go back): ");
                        index = Integer.parseInt(scanner.nextLine());
                        cart.removeItemFromCart(cart.getChips(), index);
                        if (index == 0) {
                            removeItem = false;
                        }
                        break;
                    case 0:
                        System.out.println("Returning to Edit Order Screen");
                        removeItem = false;
                        break;
                    default:
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Please chooses a valid option.");
            }
        }
    }


    //checkoutMethod
    private static void checkoutScreen() {
        while (true) {
            try {
                System.out.println("---CheckOut---");
                //display the order back to user
                if (cart.getSandwiches() != null || !cart.getSandwiches().isEmpty()) {
                    displayList(cart.getSandwiches());
                }
                if (cart.getDrinks() != null || !cart.getDrinks().isEmpty()) {
                    displayList(cart.getDrinks());
                }
                if (cart.getChips() != null || !cart.getChips().isEmpty()) {
                    displayList(cart.getChips());
                }
                //display the total of the order
                System.out.println(formatDescription("Total: ", Cart.getNewTotalPrice(), 20));
                System.out.println("""
                        1) Confirm
                        2) Go Back""");
                if (optionPicker() == 1) {
                    cart.writeReceiptFromCart();
                    newOrder = false;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Error occurred while checking out.");
            }


        }
    }


    //helper methods
//option picker return an int to signify what number option was picked
    private static int optionPicker() {
        return Integer.parseInt(scanner.nextLine());
    }

    //method to display any array list given to it. In this case bread, meat, cheese, ect
    public static <T> void displayWithNumbers(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            System.out.println((i + 1) + ") " + item);
        }
    }

    public static <T> void displayList(List<T> list) {
        for (T someList : list) {
            System.out.println(someList);
        }
    }

    private static String formatDescription(String description, BigDecimal price, int maxDescriptionLength) {

        // Calculate the adjusted width by adding additional spaces to maxDescriptionLength
        int adjustedWidth = 50 - maxDescriptionLength;

        // Format the description and price with the adjusted width
        return String.format("%-" + adjustedWidth + "s $%.2f", description, price.setScale(2, RoundingMode.HALF_UP));
    }
}


