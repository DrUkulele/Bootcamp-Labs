package org.example;

import java.util.Scanner;

public class Methods {
    //intro screen
    public static void introScreen() {
        int calculatorOption;
        System.out.println("Welcome to xyz financial organization\n Please pick one of the following calculators: ");
        System.out.println("1) Mortgage Calculator.\n2) Future Value Calculator. \n3) Ordinary Annuity Present Value Calculator.");
        System.out.print("Enter option number: ");
        int optionPicker = Methods.optionPicker();

        switch (optionPicker) {
            case 1:
                System.out.println("Changing to Mortgage Calculator.");
                calculatorOption = 1;
                Methods.calculatorSwitch(calculatorOption);
                break;
            case 2:
                System.out.println("Changing to Future Value Calculator.");
                calculatorOption = 2;
                Methods.calculatorSwitch(calculatorOption);
                break;
            case 3:
                System.out.println("Changing to Ordinary Annuity Present Value Calculator.");
                calculatorOption = 3;
                Methods.calculatorSwitch(calculatorOption);
                break;
            default:
                System.out.println("You have entered an incorrect key please try again. ");
        }
    }

    //option picker
    public static int optionPicker() {
        Scanner scanner = new Scanner(System.in);
        int optionChoice = scanner.nextInt();
        ;
        return optionChoice;
    }

    //confirm to switch calculators
    public static int calculatorSwitch(int option) {
        int optionChoice;
        switch (option) {
            case 1:
                System.out.println("You have chosen the Mortgage calculator.\nContinue?\n1.) Yes\n2.) No");
                optionChoice = Methods.optionPicker();

                if (optionChoice == 2) {
                    introScreen();
                } else if (optionChoice == 1) {
                    Main.mortgage();
                } else if (optionChoice != 1 && optionChoice != 2) {
                    System.out.println("You have entered an incorrect key. Please try again.");
                    calculatorSwitch(option);
                }
                break;
            case 2:
                System.out.println("You have chosen the Future Value Calculator.\nContinue?\n1.) Yes\n2.) No");
                optionChoice = Methods.optionPicker();

                if (optionChoice == 2) {
                    introScreen();
                } else if (optionChoice == 1) {
                    Main.futureValue();
                } else if (optionChoice != 1 && optionChoice != 2) {
                    System.out.println("You have entered an incorrect key. Please try again.");
                    calculatorSwitch(option);
                }

                break;
            case 3:
                System.out.println("You have chosen the Ordinary Annuity Present Value Calculator.\nContinue?\n1.) Yes\n2.) No");
                optionChoice = Methods.optionPicker();

                if (optionChoice == 2) {
                    introScreen();
                } else if (optionChoice == 1) {
                    Main.presentValue();
                } else if (optionChoice != 1 && optionChoice != 2) {
                    System.out.println("You have entered an incorrect key. Please try again.");
                    calculatorSwitch(option);
                }

                break;
            default:
        }
        return 0;

    }
}
