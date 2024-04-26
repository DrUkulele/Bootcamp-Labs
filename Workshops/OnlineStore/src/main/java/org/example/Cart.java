package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cart {
    public static List<Product> customerCart = new ArrayList<>();

    public static List<Product> addToCart(Product product) {
        customerCart.add(product);
        System.out.println("Product added.");
        return customerCart;
    }

    public static List<Product> getCustomerCart() {
        return customerCart;
    }

    public static void removeProductFromCart(String sku){

        customerCart = customerCart.stream().filter(product -> !product.getProductSku().equalsIgnoreCase(sku)).collect(Collectors.toList());
        System.out.println("Product removed.");
        }

    public static void calculateTotal(){
        double total = 0;
        for(Product product : customerCart){
            total = total + product.getProductPrice();
        }
        System.out.printf("Total: $%.2f\n", total);
    }

    }


