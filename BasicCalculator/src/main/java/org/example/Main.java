package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //variables
        float firstNumber;
        float secondNumber;
        String calculation;

        //user input scanner
        Scanner scanner = new Scanner(System.in);

        //what project does
        System.out.println("This is a basic calculator that can do basic math with two numbers.\n");

        //get numbers
        System.out.println("Please enter the first number:");
        firstNumber = scanner.nextFloat();

        System.out.println("Please enter the second number:");
        secondNumber = scanner.nextFloat();
        scanner.nextLine();

        //ask user for math operation they want ot do
        System.out.println("Please enter one if the following Possible calculations\n");
        System.out.println("Add or +.\n");
        System.out.println("Subtract or -.\n");
        System.out.println("Multiply or *.\n");
        System.out.println("Divided or /.\n");

        calculation = scanner.nextLine();

        //do calculation
        if (calculation.equalsIgnoreCase("Add") || calculation.equals("+")) {
            System.out.printf("%.2f + %.2f = " + (firstNumber + secondNumber), firstNumber, secondNumber);

        } else if (calculation.equalsIgnoreCase("Subtract") || calculation.equals("-")) {
            System.out.printf("%.2f - %.2f = " + (firstNumber - secondNumber), firstNumber, secondNumber);

        }
        else if (calculation.equalsIgnoreCase("Multiply") || calculation.equals("*")) {
            System.out.printf("%.2f * %.2f = " + (firstNumber * secondNumber), firstNumber, secondNumber);

        } else
            System.out.printf("%.2f / %.2f = " + (firstNumber / secondNumber), firstNumber, secondNumber);

    }
}