package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float firstNumber;
        float secondNumber;
        System.out.println("This is a basic calculator that can do basic math with two numbers.\n");
        System.out.println("Please enter the first number:");

        Scanner scanner = new Scanner(System.in);
        firstNumber = scanner.nextFloat();

        System.out.println("Please enter the second number:");
        secondNumber = scanner.nextFloat();

    }
}