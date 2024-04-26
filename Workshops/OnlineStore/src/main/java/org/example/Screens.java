package org.example;

import java.util.Scanner;

import static org.example.Cart.customerCart;

public class Screens {
    //screens methods
    public static void homeScreen() {

        //close using scanner.close(); when moving methods
        //Home screens display
        while (true) {
            //initialize scanner
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("""
                        -----Welcome to xyz's Online Grocery-----
                        1) Display Products
                        2) Display Cart
                        3) Exit""");
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        displayProductsScreen();
                        break;
                    case "2":
                        displayCartScreen();
                        break;
                    case "3":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please choose an option by typing 1, 2, or 3. mate ");
                        break;

                }
            } catch (NumberFormatException ex) {
                System.out.println("Please choose an option by typing 1, 2, or 3.");
            }
        }
    }

    public static void displayProductsScreen() {
        while (true) {
            //initialize scanner
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("""
                        1) Display all products
                        2) Search for a product
                        3) Filter products
                        4) Return to home screen""");
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        Product.displayAllProducts(FileManagement.getProduct("src/main/resources/products.csv"));
                        Screens.addProductScreen();
                        break;
                    case "2":
                        System.out.println("Enter product name:");
                        String name = scanner.nextLine();
                        Product.searchByName(name);
                        break;
                    case "3":
                        filterProduct();
                        break;
                    case "4":
                        homeScreen();
                        break;
                    default:
                        System.out.println("Please choose from one of the option choices");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter your option choice as a number");
            }
        }
    }

    public static void displayCartScreen() {
        while (true) {
            //initialize scanner
            Scanner scanner = new Scanner(System.in);
            Product.displayAllProducts(Cart.getCustomerCart());
            Cart.calculateTotal();
            System.out.println("1) Check out 2) Remove items 3) Go back");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    checkOutScreen();
                    break;
                case "2":
                    System.out.println("Please enter the sku you want to remove:");
                    String sku = scanner.nextLine();
                    Cart.removeProductFromCart(sku);
                    break;
                case "3":
                    homeScreen();
                    break;
            }
        }
    }


    //helper methods for the screen methods
    public static void filterProduct() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Filter by: 1) Department 2) Price range");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    Product.sortByDepartment();
                    break;
                case "2":
                    Product.sortByPriceRange();
                    break;
                default:
                    System.out.println("Please pick from one of the options.");
            }
        }
    }

    public static void addProductScreen() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1) add product to cart 2) Start new order 3) return to Home screen");
            String option2 = scanner.nextLine();
            switch (option2) {
                case "1":
                    FileManagement.addProductToCart();
                    break;
                case "2":
                    FileManagement.setCustomerFileHeader();

                    break;
                case "3":
                    homeScreen();
                    break;
                default:
                    System.out.println("Please pick from one of the options.");
            }
        }
    }
    public static void checkOutScreen(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("(WIP) Receipt");
            FileManagement.writeProductToFile();
            Cart.calculateTotal();
            System.out.println("1) Go back");
            String option = scanner.nextLine();
            if(option.equals("1")){
                homeScreen();
            }
            else
                homeScreen();
        }
    }
}


