/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
public class Library {

    public String libraryName;
    public Book book1;
    public Book book2;
    public Book book3;

    public void addBook(Book book, int slot) {
        if (slot == 1) {
            book1 = book;
        }
        if (slot == 2) {
            book2 = book;
        }
        if (slot == 3) {
            book3 = book;
        }
    }

    public void removeBook(int slot) {
        if (slot == 1) {
            book1 = null;
        }
        if (slot == 2) {
            book2 = null;
        }
        if (slot == 3) {
            book3 = null;
        }
    }

    public void printLibraryDetails() {
        System.out.println("Library: " + libraryName);
        System.out.println();
        printBookDetails(book1);
        System.out.println();
        printBookDetails(book2);
        System.out.println();
        printBookDetails(book3);
    }

    public void checkBookAvailability(int slot) {
        Book book = null;
        if (slot == 1) {
            book = book1;
        }
        if (slot == 2) {
            book = book2;
        }
        if (slot == 3) {
            book = book3;
        }

        if (book != null) {
            System.out.println(book.title + " is available.");
        } else {
            System.out.println("Book in slot " + slot + " is not available.");
        }
    }

    public void updateBookPrice(int slot, double newPrice) {
        Book book = null;
        if (slot == 1) {
            book = book1;
        }
        if (slot == 2) {
            book = book2;
        }
        if (slot == 3) {
            book = book3;
        }

        if (book != null) {
            book.price = newPrice;
            System.out.println("Updated price of " + book.title + " to $" + newPrice + ".");
        } else {
            System.out.println("No book in this slot.");
        }
    }

    public void printBookDetails(Book book) {
        if (book != null) {
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Publisher: " + book.publisher);
            System.out.println("Year Published: " + book.yearPublished);
            System.out.println("Price: $" + book.price);
            if (book.isAvailable == true) {
                System.out.println("Available: " + "Yes");
            } else {
                System.out.println("Available: " + "No");
            }
        } else {
            System.out.println("No book in this slot.");
        }
    }
}
