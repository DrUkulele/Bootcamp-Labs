package org.example;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are using company xyz's Future Value Calculator.");
        System.out.print("Please enter your Initial Deposit amount:");
        double initialDeposit = scanner.nextDouble();
        System.out.print("Please enter your annual interest rate: ");
        double annualInterestRate = scanner.nextDouble();
        System.out.print("Please enter the time in years: ");
        double timeInYears= scanner.nextDouble();
        System.out.printf("\nPlease review the information you have entered.\nInitial Deposit amount: %.2f\nAnnual interest rate: %.3f%%\nYears: %.2f", initialDeposit, annualInterestRate, timeInYears);
        boolean optionChoice = Methods.continueMenu();
        if (optionChoice == false) {
            futureValue();
        }
        //Future Value = Initial deposit * (1+((decimal interest rate/daily compounding)^(daily compounding*years)))
        // decimal interest rate = annual interest rate / 100
        // interest rate = future value - initial deposit
        double decimalInterestRate = annualInterestRate / 100;
        double futureValue = initialDeposit * Math.pow(1+(decimalInterestRate/365),(365 * timeInYears));
        double interestEarned = futureValue - initialDeposit;

        System.out.printf("Your Future value will be: $%.2f\n Your total interest paid will be: $%.2f.", futureValue, interestEarned);


    }

    //calculate the present value of an ordinary annuity
    public static void presentValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are using company xyz's Present Value of an Ordinary Annuity Calculator.");
        System.out.print("Please enter your monthly payout amount:");
        double monthyPayout = scanner.nextDouble();
        System.out.print("Please enter your expected interest rate: ");
        double expectedInterestRate = scanner.nextDouble();
        System.out.print("Please enter the years to payout: ");
        double yearsToPayout= scanner.nextDouble();
        System.out.printf("\nPlease review the information you have entered.\nMonthly payout amount: $%.2f\nExpected interest rate: %.3f%%\nYears to payout: %.2f", monthyPayout, expectedInterestRate, yearsToPayout);
        boolean optionChoice = Methods.continueMenu();
        if (optionChoice == false) {
            presentValue();
        }
        //Present value = monthly payout * (1 - ((1 + decimal interest rate)^(-total monthly paments)) / decimal interest)
        //decimal interest = (expected interest rate / 12) / 100
        //total monthly payments = years to payout * 12
        double decimalInterestRate = ((expectedInterestRate / 12) / 100);
        System.out.println(decimalInterestRate);
        double totalMonthlyPayments = yearsToPayout * 12;
        System.out.println(totalMonthlyPayments);
        double presentValue = monthyPayout * ((1 - Math.pow((1 + decimalInterestRate),(-1 * totalMonthlyPayments))) / decimalInterestRate);

        System.out.printf("The present value of your Ordinary Annuity is: $%.2f", presentValue);

    }
}