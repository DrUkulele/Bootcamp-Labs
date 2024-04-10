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
    }


    public static String pickupdate(){
        Scanner scanner = new Scanner(System.in);
        String confirm = "n";
        String pickUpDate = "";

        while(confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
            //user enters pickup date
            System.out.println("Please enter the date you want to pick up the rental care in mm-dd-yyyy format.");
            pickUpDate = scanner.nextLine();
            System.out.printf("The pickup date you entered is %s. Is that the correct date? (y/n)\n", pickUpDate);
            confirm = scanner.nextLine();

        }
        return pickUpDate;
    }

    public static int daystorent(){
        Scanner scanner = new Scanner(System.in);
        String confirm = "n";
        int daysToRent = 0;

        while(confirm.equalsIgnoreCase("n")) {
            //user enters pickup date
            System.out.println("Please enter how many days you want to rent the car.");
            daysToRent = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("You want to rent the car for %d. (y/n)\n", daysToRent);
            confirm = scanner.nextLine();

        }
        return daysToRent;
    }

    public static boolean tolltag(){
        Scanner scanner = new Scanner(System.in);
        String confirm = "n";
        boolean tollTag = false;

        while(!tollTag){

        }
    }

}

