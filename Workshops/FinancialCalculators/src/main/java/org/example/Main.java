package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Ask user which calculator they would like to use and take their input
        Methods.introScreen();

    }

    //mortgage calculator
    public static void mortgage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are using company xyz's Mortgage Calculator.");
        System.out.print("Please enter your Principle amount:");
        double principleAmount = scanner.nextDouble();
        System.out.print("Please enter your interest rate: ");
        double intrestRate = scanner.nextDouble();
        System.out.print("Please enter the length of your loan in years: ");
        double loanLength = scanner.nextDouble();
        System.out.printf("\nPlease review the information you have entered.\nPrincipal amount: %.2f\nInterest rate: %.3f%%\nLength of loan(years): %.2f", principleAmount, intrestRate, loanLength);
        boolean optionChoice = Methods.continueMenu();
        if (optionChoice == false) {
            mortgage();
        }
        //Monthly payment = Principal(interest rate((1+ decimal interest rate)^years in months)) / (((1+decimal interest rate)^years in months)-1)
        //decimal interest rate = ((interest rate annually / 12)/100)
        //years in months = years * 12
        //total interest = (monthly payments * years in months) - principle
        double decimalInterestRate = ((intrestRate / 12) / 100);
        double yearsInMonths = loanLength * 12;
        double monthlyPayment = principleAmount * (decimalInterestRate * Math.pow((1+ decimalInterestRate), yearsInMonths)) / (Math.pow((1+decimalInterestRate),yearsInMonths)-1);
        double totalIntrest = (monthlyPayment * yearsInMonths) - principleAmount;
        System.out.printf("Your monthly payment will be: %.2f\n Your total interest paid will be: %.2f.", monthlyPayment, totalIntrest);

    }

    //future value calculator
    public static void futureValue() {
        System.out.println("This function has not been implemented!");

    }

    //calculate the present value of an ordinary annuity
    public static void presentValue() {
        System.out.println("This function has not been implemented!");

    }
}