package org.example;

import java.util.Scanner;

import static org.example.Library.books;

public class Screens {


/*------------------------------Screens------------------------------*/
    //home screen
    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Home Screen-----");
        System.out.println("1) Show Available Books.\n2) Show Checked Out Books.\n3) Close Application.");
        int option = optionPicker();
        switch (option) {
            case 1:
                availableBooks();
                break;
            case 2:
                checkedOutBooks();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Please choose from one of the options above.");
                homeScreen();
                break;
        }

    }

    //Show available books
    public static void availableBooks() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of books checked in: ");
        Library.numberOfCheckedInBooks();
        System.out.println("-----Currently Available books-----");
        Library.getCheckedInBooks(false);
        System.out.println("Would you like to check out a book?\n1) Yes\n2) No");
        int option = optionPicker();
        switch (option) {
            case 1:
                checkOutBook();
                homeScreen();
                break;
            case 2:
                System.out.println("Returning to Home Screen...");
                homeScreen();
                break;
            default:
                System.out.println("Please choose from one of the options above.");
                break;
        }

    }

    //show checked out books
    public static void checkedOutBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of books checked out: ");
        Library.numberOfCheckedOutBooks();
        System.out.println("-----Currently Checked Out books-----");
        Library.getCheckedOutBooks(true);
        System.out.println("Would you like to check in a book?\n1) Yes\n2) No");
        int option = optionPicker();
        switch (option) {
            case 1:
                checkInBook();
                break;
            case 2:
                System.out.println("Returning to Home Screen...");
                homeScreen();
                break;
            default:
                System.out.println("Please choose from one of the options above.");
                break;
        }
    }
    /*------------------------------screen helping methods------------------------------*/

    //check in a book
    public static void checkInBook() {
        int loopCounter = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Id of the book you want to checkin:");
        int bookCheckout = scanner.nextInt();

        String customerName = scanner.nextLine();
        for (Book book : books) {
            if (bookCheckout == book.getId()) {
                book.checkIn();
            }
            if(loopCounter == books.length){
                System.out.println("Please enter a valid book ID.");
                checkOutBook();
            }
            loopCounter++;

        }
    }

    //Allows for user to pick appropriate options
    public static int optionPicker() {
        Scanner scanner = new Scanner(System.in);
        int optionChoice = scanner.nextInt();
        return optionChoice;
    }

    //ask user if they want to check out a book
    public static void checkOutBook() {
        int loopCounter = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Id of the book you want to checkout:");
        int bookCheckout = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter your Name:");
        String customerName = scanner.nextLine();
        for (Book book : books) {
            if (bookCheckout == book.getId()) {
                book.checkOut(customerName);
            }
            if(loopCounter == books.length){
                System.out.println("Please enter a valid book ID.");
                checkOutBook();
            }
            loopCounter++;

        }
    }
}

