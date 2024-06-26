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
        question();
        calculation = scanner.nextLine();

        //do calculation
        if (calculation.equalsIgnoreCase("Add") || calculation.equals("+")) {
            add(firstNumber, secondNumber);

        } else if (calculation.equalsIgnoreCase("Subtract") || calculation.equals("-")) {
            subtract(firstNumber, secondNumber);

        } else if (calculation.equalsIgnoreCase("Multiply") || calculation.equals("*")) {
            multiply(firstNumber, secondNumber);

        } else if (calculation.equalsIgnoreCase("Divide") || calculation.equals("/")) {
            divide(firstNumber, secondNumber);
        } else
            System.out.println("You entered an incorrect operator. Please try again. ");
    }

    public static void question(){
        System.out.println("Please enter one if the following Possible calculations\n");
        System.out.println("Add or +.\n");
        System.out.println("Subtract or -.\n");
        System.out.println("Multiply or *.\n");
        System.out.println("Divided or /.\n");
    }

    public static void add(float firstNumber, float secondNumber){
        System.out.printf("%.2f + %.2f = %.2f ", firstNumber, secondNumber, (firstNumber + secondNumber));
    }
    public static void subtract(float firstNumber, float secondNumber){
        System.out.printf("%.2f - %.2f = %.2f ", firstNumber, secondNumber, (firstNumber - secondNumber));
    }
    public static void multiply(float firstNumber, float secondNumber){
        System.out.printf("%.2f * %.2f = %.2f ", firstNumber, secondNumber, (firstNumber * secondNumber));
    }
    public static void divide(float firstNumber, float secondNumber){
        System.out.printf("%.2f / %.2f = %.2f ", firstNumber, secondNumber, (firstNumber / secondNumber));
    }
}