package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //variables
        String pickUpDate;
        int daysToRent;
        int currentAge;
        boolean tollTag;
        boolean gps;
        boolean roadSide;
        Scanner scanner = new Scanner(System.in);

        //Introduction
        System.out.println("Hello and welcome to xyz car rental company rental site.");

        pickUpDate = pickupdate();
        daysToRent = daystorent();
        tollTag = tolltag();
        gps = gps();
        roadSide = roadside();
    }


    public static String pickupdate() {
        Scanner scanner = new Scanner(System.in);
        String confirm = "n";
        String pickUpDate = "";

        while (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
            //user enters pickup date
            System.out.println("Please enter the date you want to pick up the rental care in mm-dd-yyyy format.");
            pickUpDate = scanner.nextLine();
            System.out.printf("The pickup date you entered is %s. Is that the correct date? (y/n)\n", pickUpDate);
            confirm = scanner.nextLine();

        }
        return pickUpDate;
    }

    public static int daystorent() {
        Scanner scanner = new Scanner(System.in);
        String confirm = "n";
        int daysToRent = 0;

        while (confirm.equalsIgnoreCase("n")) {
            //user enters pickup date
            System.out.println("Please enter how many days you want to rent the car.");
            daysToRent = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("You want to rent the car for %d. (y/n)\n", daysToRent);
            confirm = scanner.nextLine();

        }
        return daysToRent;
    }

    public static boolean tolltag() {
        Scanner scanner = new Scanner(System.in);
        String confirm = "";
        boolean tollTag = false;
        boolean userInput = true;

        while (userInput == true) {
            //user enters pickup date
            System.out.println("Would you like to add an Electronic Toll Tag for $3.95 a day?(y/n) ");
            confirm = scanner.nextLine();
            switch (confirm.toLowerCase()) {
                case "y":
                    System.out.println("You have chosen to add an electronic Toll Tag for $3.95 a day.\n Is that correct?(y/n)");
                    confirm = scanner.nextLine();
                    switch (confirm.toLowerCase()) {
                        case "y":
                            System.out.println("You have added the Toll Tag.");
                            tollTag = true;
                            userInput = false;
                            break;
                        case "n":
                            tolltag();
                            break;

                    }
                    break;

                case "n":
                    System.out.println("You have chosen not to add an electronic Toll Tag for $3.95 a day.\n Is that correct?(y/n)");
                    confirm = scanner.nextLine();
                    switch (confirm.toLowerCase()) {
                        case "y":
                            System.out.println("You have not added the Toll Tag.");
                            userInput = false;
                            break;
                        case "n":
                            tolltag();
                            break;
                    }
                    break;
            }

        }
        return tollTag;
    }

    public static boolean gps() {
        Scanner scanner = new Scanner(System.in);
        String confirm = "";
        boolean gps = false;
        boolean userInput = true;

        while (userInput == true) {
            //user enters pickup date
            System.out.println("Would you like to add GPS for $2.95 a day?(y/n) ");
            confirm = scanner.nextLine();
            switch (confirm.toLowerCase()) {
                case "y":
                    System.out.println("You have chosen to add GPS for $2.95 a day.\n Is that correct?(y/n)");
                    confirm = scanner.nextLine();
                    switch (confirm.toLowerCase()) {
                        case "y":
                            System.out.println("You have added the GPS.");
                            gps = true;
                            userInput = false;
                            break;
                        case "n":
                            gps();
                            break;

                    }
                    break;

                case "n":
                    System.out.println("You have chosen not to add GPS for $2.95 a day.\n Is that correct?(y/n)");
                    confirm = scanner.nextLine();
                    switch (confirm.toLowerCase()) {
                        case "y":
                            System.out.println("You have not added the GPS.");
                            userInput = false;
                            break;
                        case "n":
                            gps();
                            break;
                    }
                    break;
            }

        }
        return gps;
    }

    public static boolean roadside() {
        Scanner scanner = new Scanner(System.in);
        String confirm = "";
        boolean roadSide = false;
        boolean userInput = true;

        while (userInput == true) {
            //user enters pickup date
            System.out.println("Would you like to add Roadside Assistance for $3.95 a day?(y/n) ");
            confirm = scanner.nextLine();
            switch (confirm.toLowerCase()) {
                case "y":
                    System.out.println("You have chosen to add Roadside Assistance for $3.95 a day.\n Is that correct?(y/n)");
                    confirm = scanner.nextLine();
                    switch (confirm.toLowerCase()) {
                        case "y":
                            System.out.println("You have added Roadside Assistance.");
                            roadSide = true;
                            userInput = false;
                            break;
                        case "n":
                            roadside();
                            break;

                    }
                    break;

                case "n":
                    System.out.println("You have chosen not to add Roadside Assistance for $3.95 a day.\n Is that correct?(y/n)");
                    confirm = scanner.nextLine();
                    switch (confirm.toLowerCase()) {
                        case "y":
                            System.out.println("You have not added Roadside Assistance.");
                            userInput = false;
                            break;
                        case "n":
                            roadside();
                            break;
                    }
                    break;
            }

        }
        return roadSide;

    }
}


