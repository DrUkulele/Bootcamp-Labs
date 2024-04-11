package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //variables
        String pickUpDate;
        double startingCharge = 29.99;
        double daysToRent; //= 10;
        double options = 0;
        double surcharge = 0;
        boolean underAge; //= true;
        boolean tollTag; //= true;
        boolean gps; //= true;
        boolean roadSide; //= true;
        Scanner scanner = new Scanner(System.in);

        //Introduction
        System.out.println("Hello and welcome to xyz car rental company rental site.");
//        double total = startingCharge * daysToRent;
//        System.out.printf("Your total is: %f\n", total);

        pickUpDate = Methods.pickupdate();
//        //System.out.printf("This method returns %s\n", pickUpDate);
        daysToRent = Methods.daystorent();
//        //System.out.printf("This method returns %f\n", daysToRent);
        tollTag = Methods.tolltag();
//        //System.out.printf("This method returns %B\n", tollTag);
        gps = Methods.gps();
//        //System.out.printf("This method returns %B\n", gps);
        roadSide = Methods.roadside();
        //System.out.printf("This method returns %B\n", roadSide);
        underAge = Methods.age();
        //System.out.printf("This method returns %d\n", currentAge);

        double total = startingCharge * daysToRent;
        double basicRental = startingCharge * daysToRent;


        if (underAge = true) {
            surcharge = (total * .30);
            total = surcharge + total;
            //System.out.println(total);
        }

        if (tollTag == true) {
            options = (3.95 * daysToRent) + options;
            //total = options + total;
            //System.out.println(total);
        }
        if (gps == true) {
            options = (2.95 * daysToRent) + options;
            //total = options + total;
            //System.out.println(total);
        }
        if (roadSide == true) {
            options = (3.95 * daysToRent) + options;
            //total = options + total;
            //System.out.println(total);
        }
        total = options + total;

        System.out.printf("Your base rental charge is: $%.2f\n", basicRental);
        System.out.printf("Your optinal additions charge is: $%.2f\n", options);
        if (underAge == true) {
            System.out.printf("You are under the age of 25. There is a surcharge of: $%.2f\n", surcharge);
        }
        System.out.printf("Your total is: $%.2f", total);


        //Do not comment out Main method }
    }
    //Do not comment out mainMethod }


    //Do not comment out below this line method and class }}
}







