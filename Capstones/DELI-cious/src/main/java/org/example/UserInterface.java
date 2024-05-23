package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //properties
    private static final Scanner scanner = new Scanner(System.in);
    private static Sandwich sandwich;
    private static Menu menu;

    static {
        menu = new Menu();
        sandwich = new Sandwich(null, null, null, null, null, null, null, false);
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
                        orderScreen();
                        break;
                    case 2:
                        //just break
                        break;
                    default:
                        break;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Please enter option as a number.");
            }
        }
    }

    //order screen
    private static void orderScreen() {
        while (true) {
            try {
                System.out.println("""
                        1) Add Sandwich
                        2) Add Drink
                        3) Add Chips
                        4) Checkout
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
                        checkoutScreen();
                        break;
                    case 0:
                        //cancel order  method
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
                        display(menu.getSizeList());
                        sandwich.setSize(Sandwich.pickItemNoQuantity(menu.getSizeList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting sandwich size: " + ex.getMessage());
                    }
                }

                // Display bread options
                while (true) {
                    try {
                        System.out.println("---Bread---");
                        display(menu.getBreadList());
                        sandwich.setBread(Sandwich.pickItemNoQuantity(menu.getBreadList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting bread: " + ex.getMessage());
                    }
                }

                // Display meat options
                while (true) {
                    try {
                        System.out.println("---Meat---");
                        display(menu.getMeatList());
                        sandwich.setMeat(Sandwich.pickItemWithQuantity(menu.getMeatList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting meat: " + ex.getMessage());
                    }
                }

                // Display cheese options
                while (true) {
                    try {
                        System.out.println("---Cheese---");
                        display(menu.getCheeseList());
                        sandwich.setCheese(Sandwich.pickItemWithQuantity(menu.getCheeseList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting cheese: " + ex.getMessage());
                    }
                }

                // Display other toppings options
                while (true) {
                    try {
                        System.out.println("---Other Toppings---");
                        display(menu.getOtherToppingsList());
                        sandwich.setOtherToppings(Sandwich.pickItemWithQuantity(menu.getOtherToppingsList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting other toppings: " + ex.getMessage());
                    }
                }

                // Display sauces options
                while (true) {
                    try {
                        System.out.println("---Sauces---");
                        display(menu.getSaucesList());
                        sandwich.setSauces(Sandwich.pickItemWithQuantity(menu.getSaucesList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting sauces: " + ex.getMessage());
                    }
                }

                // Display sides options
                while (true) {
                    try {
                        System.out.println("---Sides---");
                        display(menu.getSidesList());
                        sandwich.setSides(Sandwich.pickItemWithQuantity(menu.getSidesList()));
                        break; // Exit the loop if selection is successful
                    } catch (Exception ex) {
                        System.out.println("Error selecting sides: " + ex.getMessage());
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
                        System.out.println("Error selecting toasted: " + ex.getMessage());
                    }
                }

                // Confirming toasted
                boolean toasted = sandwich.isToasted();
                System.out.println("Toasted: " + (toasted ? "Yes" : "No"));

                // Creating a new sandwich object
                sandwich = new Sandwich(sandwich.getSize(), sandwich.getBread(), sandwich.getMeat(),
                        sandwich.getCheese(), sandwich.getOtherToppings(), sandwich.getSauces(),
                        sandwich.getSides(), sandwich.isToasted());

                // If all steps are successful, exit the method
                break;
            } catch (Exception ex) {
                System.out.println("Error adding sandwich: " + ex.getMessage());
            }
        }
    }

//method to add drinks to the order
private static void addDrinkScreen() {
    while (true) {
        try {
            System.out.println("---Drinks---");
            System.out.println("Please choose drink size: ");
            //display size drink size array
            //allow user to pick from drink array for size
            System.out.println("Please choose drink flavor: ");
            //display drink flavor array
            //allow user to pick from drink array for flavor
            System.out.println("Please enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            //add drink size, flavor and quantity to order
        } catch (Exception ex) {
            System.out.println("ADD ERROR MESSAGE HERE!");
        }
    }
}

//method to add chips to order
private static void addChipsScreen() {
    while (true) {
        try {
            System.out.println("---Chips---");
            System.out.println("Please choose chip type: ");
            //display chip type array
            //allow user to pick from chip type array
            System.out.println("Please enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            //add chip quantity to order quantity to order
        } catch (Exception ex) {
            System.out.println("ADD ERROR MESSAGE HERE!");

        }
    }
}

//checkoutMethod
private static void checkoutScreen() {
    while (true) {
        try {
            System.out.println("---CheckOut---");
            //display the order back to user
            //display the total of the order
            System.out.println("""
                    1) Confirm
                    2) Cancel""");
            switch (optionPicker()) {
                case 1:
                    //confirm order by writing the receipt as a new file and then return to home screen
                    break;
                case 2:
                    //call method to cancel order
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ADD ERROR MESSAGE HERE!");
        }
    }
}


//helper methods
//option picker return an int to signify what number option was picked
private static int optionPicker() {
    return Integer.parseInt(scanner.nextLine());
}

//method to display any array list given to it. In this case bread, meat, cheese, ect
public static <T> void display(List<T> list) {
    for (int i = 0; i < list.size(); i++) {
        T item = list.get(i);
        System.out.println((i + 1) + ") " + item);
    }
}

}

