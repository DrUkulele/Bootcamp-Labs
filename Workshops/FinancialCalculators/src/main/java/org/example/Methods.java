package org.example;

import java.util.Scanner;

public class Methods {
    //intro screen
    public static void introScreen() {
        int calculatorOption;
        System.out.println("Welcome to xyz financial organization\nPlease pick one of the following calculators: ");
        System.out.println("1) Mortgage Calculator.\n2) Future Value Calculator. \n3) Ordinary Annuity Present Value Calculator.");
        System.out.print("Enter option number: ");
        Scanner scanner = new Scanner(System.in);
        int optionPicker = scanner.nextInt();

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
                introScreen();
        }
    }

    //confirm to switch calculators
    public static void calculatorSwitch(int option) {
        boolean optionChoice = Methods.continueMenu();
        switch (option) {
            case 1:
                System.out.println("You have chosen the Mortgage calculator.");
                if (optionChoice == false) {
                    introScreen();
                }
                else if (optionChoice == true){
                    Main.mortgage();
                }
                break;
            case 2:
                System.out.println("You have chosen the Future Value Calculator.");
                optionChoice = Methods.continueMenu();
                if (optionChoice == false) {
                    introScreen();
                }
                else
                    Main.futureValue();
                break;

            case 3:
                System.out.println("You have chosen the Ordinary Annuity Present Value Calculator.");
                optionChoice = Methods.continueMenu();
                if (optionChoice == false) {
                    introScreen();
                }
                else
                    Main.presentValue();
                break;

            default:
        }

    }
    public static boolean continueMenu(){
        System.out.println("Continue?\n1.) Yes\n2.) No");
        Scanner scanner = new Scanner(System.in);
        int continueChoice = scanner.nextInt();
       boolean returnValue;
        if(continueChoice == 1)
            returnValue = true;
        else if (continueChoice == 2) {
            returnValue = false;
        } else if (continueChoice != 1 && continueChoice != 2 ) {
            System.out.println("You have entered an incorrect key please try again");
            continueMenu();


        }
        return returnValue;
    }
}


