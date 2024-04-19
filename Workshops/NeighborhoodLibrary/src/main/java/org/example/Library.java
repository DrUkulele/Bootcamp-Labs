package org.example;

import java.util.Arrays;

public class Library {
    //array
    static Book[] books = {new Book(1, "978-0-553-57340-9", "To Kill a Mockingbird"),
            new Book(2, "978-0-312-85798-9", "1984"),
            new Book(3, "978-0-440-53981-8", "The Catcher in the Rye"),
            new Book(4, "978-0-8129-7647-9", "The Great Gatsby"),
            new Book(5, "978-0-307-74314-4", "Pride and Prejudice"),
            new Book(6, "978-0-7432-0169-4", "To Kill a Mockingbird"),
            new Book(7, "978-0-7432-0169-4", "Harry Potter and the Sorcerer's Stone"),
            new Book(8, "978-0-7432-0169-4", "The Hobbit"),
            new Book(9, "978-0-7432-0169-4", "Animal Farm"),
            new Book(10, "978-0-7432-0169-4", "Lord of the Flies"),
            new Book(11, "978-0-7432-0169-4", "The Grapes of Wrath"),
            new Book(12, "978-0-7432-0169-4", "Brave New World"),
            new Book(13, "978-0-7432-0169-4", "Frankenstein"),
            new Book(14, "978-0-7432-0169-4", "The Picture of Dorian Gray"),
            new Book(15, "978-0-7432-0169-4", "Moby-Dick"),
            new Book(16, "978-0-7432-0169-4", "War and Peace"),
            new Book(17, "978-0-7432-0169-4", "Crime and Punishment"),
            new Book(18, "978-0-7432-0169-4", "The Odyssey"),
            new Book(19, "978-0-7432-0169-4", "The Lord of the Rings"),
            new Book(20, "978-0-7432-0169-4", "Wuthering Heights")};

    //methods
    //get all books
    public static void getAllBooks() {
        for (Book book : books) {
            System.out.printf("Id: %d, Isbn: %s, Title: %s, Checked out: %b, Checked out to: %s\n", book.getId(), book.getIsbn(), book.getTitle(), book.isCheckedOut(), book.getCheckedOutTo());
        }
    }

    //get all books that are checked out
    public static void getCheckedOutBooks(boolean isCheckedOut) {
        int counter = 0;
        for (Book book : books) {
            if (book.isCheckedOut() == isCheckedOut) {
                System.out.printf("Id: %d, Isbn: %s, Title: %s Checked out to: %s\n", book.getId(), book.getIsbn(), book.getTitle(), book.checkedOutTo);
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("No books currently checked out.");
        }
    }

    //get all books that are checked in
    public static void getCheckedInBooks(boolean isCheckedOut) {
        int counter = 0;
        for (Book book : books) {
            if (book.isCheckedOut() == isCheckedOut) {
                System.out.printf("Id: %d, Isbn: %s, Title: %s\n", book.getId(), book.getIsbn(), book.getTitle());
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("No books currently checked in.");
        }
    }



    //get number of checked out books
    public static void numberOfCheckedOutBooks(){
        int numberCheckedOut = 0;
        for (Book book : books) {
            if (book.isCheckedOut()) {
                numberCheckedOut++;
            }
        }
        System.out.println(numberCheckedOut);
    }
    //get number of checked in books
    public static void numberOfCheckedInBooks(){
        int numberCheckedOut = 0;
        for (Book book : books) {
            if (book.isCheckedOut() == false) {
                numberCheckedOut++;
            }
        }
        System.out.println(numberCheckedOut);
    }

}
