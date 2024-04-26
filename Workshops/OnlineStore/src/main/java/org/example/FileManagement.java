package org.example;

import java.beans.Customizer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Cart.customerCart;

public class FileManagement {
    // methods for product file
    //method to get products from file
    public static List<Product> getProduct(String filePath) {
        //product ArrayList
        List<Product> products = new ArrayList<>();

        //filepath for loading products to Arraylist
        String productFilePath = filePath;

        //loading the arraylist with products from the file using buffered reader and auto closing using try-with
        try (BufferedReader reader = new BufferedReader(new FileReader(productFilePath))) {
            String line;
            //deserialize products from file
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                //split file using |
                String[] data = line.split("\\|");
                String productSku = data[0];
                String productName = data[1];
                double productPrice = Double.parseDouble(data[2]);
                String productDepartment = data[3];

                //create product based on file
                Product product = new Product(productSku, productName, productPrice, productDepartment);
                products.add(product);
            }

        } catch (IOException ex) {
            System.out.println("Sorry file could not be written to or dose not exist.");

        }
        return products;
    }

    //methods for customer file

    //method to write the customer cart file
    public static void writeProductToFile() {
        String filePath = "src/main/resources/CustomerCart.csv";
        for(Product product: customerCart)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(product.getProductSku() + "|" + product.getProductName() + "|" + product.getProductPrice() + "|" + product.getProductDepartment());

        } catch (IOException ex) {
            System.out.println("File could not be written to.");
        }
    }

    //helper method for write to customer file
    public static void addProductToCart() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the sku of the product you would like to add:");
            String sku = scanner.nextLine();
            int counter = 0;
            for (Product product : FileManagement.getProduct("src/main/resources/products.csv")) {
                if (sku.equalsIgnoreCase(product.getProductSku())) {
                    Cart.addToCart(product);
                    counter++;
                }

            }
            if (counter == 0) {
                System.out.println("Please enter a valid sku.");

            } else
                break;
        }
    }



    //set header for customer file
    public static void setCustomerFileHeader() {
        String filePath = "src/main/resources/CustomerCart.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("SKU|Product Name|Price|Department");
            writer.newLine();
            System.out.println("New order started.");
        } catch (IOException ex) {
            System.out.println("File could not be written to.");
        }
    }
}
