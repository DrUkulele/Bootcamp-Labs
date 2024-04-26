package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Product {
    //properties
    private String productSku;
    private String productName;
    private double productPrice;
    private String productDepartment;

    //constructor
    public Product(String productSku, String productName, double productPrice, String productDepartment) {
        this.productSku = productSku;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDepartment = productDepartment;
    }

    //getters and setters
    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDepartment() {
        return productDepartment;
    }

    public void setProductDepartment(String productDepartment) {
        this.productDepartment = productDepartment;
    }
    //methods

    //display all products
    public static void displayAllProducts(List<Product> products) {
        for (Product product : products) {
            System.out.printf("Sku: %s Name: %s Price: $%.2f Department: %s\n", product.productSku, product.productName, product.productPrice, product.productDepartment);
        }

    }


    //sort by department
    public static void sortByDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which department would you like to sort by? 1) Audio Video 2) Computers 3) Games 4) Electronics");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                for (Product product : FileManagement.getProduct("src/main/resources/products.csv")) {
                    if (product.getProductDepartment().equals("Audio Video")) {
                        System.out.printf("Sku: %s Name: %s Price: $%.2f Department: %s\n", product.productSku, product.productName, product.productPrice, product.productDepartment);

                    }
                }
                Screens.addProductScreen();
                break;
            case "2":
                for (Product product : FileManagement.getProduct("src/main/resources/products.csv")) {
                    if (product.getProductDepartment().equals("Computers")) {
                        System.out.printf("Sku: %s Name: %s Price: $%.2f Department: %s\n", product.productSku, product.productName, product.productPrice, product.productDepartment);

                    }
                }
                Screens.addProductScreen();
                break;
            case "3":
                for (Product product : FileManagement.getProduct("src/main/resources/products.csv")) {
                    if (product.getProductDepartment().equals("Games")) {
                        System.out.printf("Sku: %s Name: %s Price: $%.2f Department: %s\n", product.productSku, product.productName, product.productPrice, product.productDepartment);

                    }
                }
                Screens.addProductScreen();
                break;
            case "4":
                for (Product product : FileManagement.getProduct("src/main/resources/products.csv")) {
                    if (product.getProductDepartment().equals("Electronics")) {
                        System.out.printf("Sku: %s Name: %s Price: $%.2f Department: %s\n", product.productSku, product.productName, product.productPrice, product.productDepartment);

                    }
                }
                Screens.addProductScreen();
                break;
        }
    }

    //sort by price range
    public static void sortByPriceRange() {
        //add try catch
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a price range.");
        System.out.print("Minimum Price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Maximum Price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : FileManagement.getProduct("src/main/resources/products.csv")) {
            if (product.getProductPrice() >= minPrice && product.getProductPrice() <= maxPrice) {
                filteredProducts.add(product);
            }
        }

        // Sort the filtered products by price
        Collections.sort(filteredProducts, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getProductPrice(), p2.getProductPrice());
            }
        });

        // Print the sorted filtered products
        for (Product product : filteredProducts) {
            System.out.printf("Sku: %s Name: %s Price: $%.2f Department: %s\n", product.productSku, product.productName, product.productPrice, product.productDepartment);
        }
        Screens.addProductScreen();
    }

    public static void searchByName(String name) {
        while (true) {
            int counter = 0;
            for (Product product : FileManagement.getProduct("src/main/resources/products.csv")) {
                String productName = product.getProductName().toLowerCase();
                if (productName.contains(name.toLowerCase())) {
                    System.out.printf("Sku: %s Name: %s Price: $%.2f Department: %s\n", product.productSku, product.productName, product.productPrice, product.productDepartment);
                    counter++;
                }

            }
            if (counter == 0) {
                System.out.println("No Items found");
            }
            Screens.addProductScreen();
        }
    }
}


