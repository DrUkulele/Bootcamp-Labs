package org.example;

import java.util.Arrays;

public class Library {
    //array
    static Book[] books = {new Book(1, "978-3-16-148410-0", "Java Programming"),
                           new Book(2, "978-1-23-456789-0", "Introduction to Algorithms"),
                           new Book(3, "978-0-12-345678-9", "Data Structures and Algorithms in Java"),
                           new Book(4, "978-0-99-829560-8", "Clean Code: A Handbook of Agile Software Craftsmanship"),
                           new Book(5, "978-0-13-235088-4", "Head First Design Patterns"),
                           new Book(6, "978-0-321-34970-8", "Effective Java"),
                           new Book(7, "978-0-672-33618-7", "Learning Python"),
                           new Book(8, "978-0-07-802212-8", "Operating System Concepts"),
                           new Book(9, "978-0-321-87978-9", "Cracking the Coding Interview"),
                           new Book(10, "978-0-201-63385-6", "Design Patterns: Elements of Reusable Object-Oriented Software"),
                           new Book(11, "978-0-672-32955-9", "Python Crash Course"),
                           new Book(12, "978-1-59327-552-9", "Automate the Boring Stuff with Python"),
                           new Book(13, "978-0-596-52068-7", "Learning Perl"),
                           new Book(14, "978-0-13-595705-9", "Computer Networking: A Top-Down Approach"),
                           new Book(15, "978-1-449-34205-4", "Learning JavaScript Design Patterns"),
                           new Book(16, "978-1-59327-614-4", "Eloquent JavaScript"),
                           new Book(17, "978-0-321-58361-0", "Introduction to the Theory of Computation"),
                           new Book(18, "978-0-201-36131-1", "Artificial Intelligence: A Modern Approach"),
                           new Book(19, "978-1-4842-4213-1", "Deep Learning"),
                           new Book(20, "978-0-672-33490-9", "C Programming Absolute Beginner's Guide")};


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
        if (counter == 0) {
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
        if (counter == 0) {
            System.out.println("No books currently checked in.");
        }
    }

    //get number of checked out books
    public static void numberOfCheckedOutBooks() {
        int numberCheckedOut = 0;
        for (Book book : books) {
            if (book.isCheckedOut()) {
                numberCheckedOut++;
            }
        }
        System.out.println(numberCheckedOut);
    }

    //get number of checked in books
    public static void numberOfCheckedInBooks() {
        int numberCheckedOut = 0;
        for (Book book : books) {
            if (book.isCheckedOut() == false) {
                numberCheckedOut++;
            }
        }
        System.out.println(numberCheckedOut);
    }

}
