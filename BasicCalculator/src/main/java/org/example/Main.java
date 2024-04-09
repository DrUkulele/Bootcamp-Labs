package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //variables
        float firstNumber;
        float secondNumber;
        String calculations;

        //user input scanner
        Scanner scanner = new Scanner(System.in);

        //what project does
        System.out.println("This is a basic calculator that can do basic math with two numbers.\n");

        //get numbers
        System.out.println("Please enter the first number:");
        firstNumber = scanner.nextFloat();

        System.out.println("Please enter the second number:");
        secondNumber = scanner.nextFloat();

        //ask user for math operation they want ot do
        System.out.println("Please enter one if the following Possible calculations\n");
        System.out.println("Add or +.\n");
        System.out.println("Subtract or -.\n");
        System.out.println("Multiply or *.\n");
        System.out.println("Divided or /.\n");

        calculations = scanner.nextLine();

        //do calculation
        if (calculations.equalsIgnoreCase("Add") || calculations.equals("+")) {
            System.out.println(firstNumber + secondNumber);
        } else if (calculations.equalsIgnoreCase("Subtract") || calculations.equals("-")) {
            System.out.println(firstNumber - secondNumber);

        } else if (calculations.equalsIgnoreCase("Multiply") || calculations.equals("*")) {
            System.out.println(firstNumber * secondNumber);

        } else
            System.out.println(firstNumber / secondNumber);

    }
}