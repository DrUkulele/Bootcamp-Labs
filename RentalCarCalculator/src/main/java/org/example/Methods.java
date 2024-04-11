package org.example;

import java.util.Scanner;

public class Methods {

    //get users pick up date
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

    //get the days user wants to rent
    public static int daystorent() {
        Scanner scanner = new Scanner(System.in);
        String confirm = "n";
        int daysToRent = 0;

        while (confirm.equalsIgnoreCase("n")) {
            //user enters pickup date
            System.out.println("Please enter how many days you want to rent the car.");
            daysToRent = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("You want to rent the car for %d day(s). (y/n)\n", daysToRent);
            confirm = scanner.nextLine();

        }
        return daysToRent;
    }

    //get if user wants to add the toll tag
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
                    System.out.println("You have chosen to add an electronic Toll Tag for $3.95 a day.\nIs that correct?(y/n)");
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
                    System.out.println("You have chosen not to add an electronic Toll Tag for $3.95 a day.\nIs that correct?(y/n)");
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

    //get if user wants to add the gps
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
                    System.out.println("You have chosen to add GPS for $2.95 a day.\nIs that correct?(y/n)");
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
                    System.out.println("You have chosen not to add GPS for $2.95 a day.\nIs that correct?(y/n)");
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

    //get if user wants to add roadside assistance
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
                    System.out.println("You have chosen to add Roadside Assistance for $3.95 a day.\nIs that correct?(y/n)");
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
                    System.out.println("You have chosen not to add Roadside Assistance for $3.95 a day.\nIs that correct?(y/n)");
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

    //get the users age
    public static boolean age() {
        Scanner scanner = new Scanner(System.in);
        String confirm = "n";
        int ageNum = 0;
        boolean age = false;

        while (confirm.equalsIgnoreCase("n")) {
            //user enters pickup date
            System.out.println("Please enter how old you are in years.");
            ageNum = scanner.nextInt();
            scanner.nextLine();

            if (ageNum < 25) {
                age = true;
                System.out.println(ageNum);
            } else if (ageNum >= 25) {
                age = false;
                System.out.println(ageNum);
            } else
                System.out.println("An error has occured");

            System.out.printf("You are %d years old? (y/n)\n", ageNum);
            confirm = scanner.nextLine();
        }
        return age;
    }
}
