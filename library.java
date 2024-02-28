/*
 * Elijah Hutchison
 * CEN 3024C-24667
 * 2/28/2024
 *
 * Class Name: library
 *
 * Description:
 *   This is my library class, it only contains one variable, a bookList where I store the
 *   data from the file the user imputed. This class has an addBook function which is used
 *   initially to add the books to the bookList. There are also separate methods to remove
 *   books using either their title or barcode number. Finally there are methods to check
 *   in and out books. The methods that require it test to make sure what the user is
 *   imputing makes sense. Each method also has detailed error messages and print statements
 *   so there should be no unnecessary code in the main class.
 */

import java.util.ArrayList;
import java.util.List;

public class library {
    // Create variable
    private List<books> bookList;

    // Constructor
    public library() {
        bookList = new ArrayList<>();
    }

    /**
     * Adds a new book to the library with the specified barcode number and title.
     *
     * @param barcodeNumber The barcode number of the new book.
     * @param bookTitle The title of the new book.
     * @return void
     */
    public void addBook(String barcodeNumber, String bookTitle) {
        // Create a new book object with the provided barcode number and title
        books newBook = new books(barcodeNumber, bookTitle);

        // Add the new book to the library
        bookList.add(newBook);
    }

    /**
     * Removes a book from the library based on its barcode number.
     * Prints a confirmation message if the book is successfully removed.
     * Prints an error message if the book is not found in the library.
     *
     * @param barcodeNumber The barcode number of the book to be removed.
     * @return void
     */
    public void removeBookWithBarcode(int barcodeNumber) {
        // Iterate through the library to find the book
        for (books book : bookList) {
            // Check if the barcode number of the current book matches the provided barcode number
            if (String.valueOf(book.getBarcodeNumber()).equals(String.valueOf(barcodeNumber))) {
                // Remove the book from the library
                bookList.remove(book);
                // Print a confirmation message if the book is successfully removed
                System.out.println("Book with barcode number " + barcodeNumber + " has been removed from the library.");
                // Exit the method once the book is removed
                return;
            }
        }

        // Print an error message if the book is not found in the library
        System.out.println("Book with barcode number " + barcodeNumber + " was not found in the library.");
    }

    /**
     * Removes a book from the library based on its title.
     * Prints a confirmation message if the book is successfully removed.
     * Prints an error message if the book is not found in the library.
     *
     * @param bookTitle The title of the book to be removed.
     * @return void
     */
    public void removeBookWithTitle(String bookTitle) {
        // Iterate through the library to find the book
        for (books book : bookList) {
            // Check if the barcode number of the current book matches the provided barcode number
            if (book.getBookTitle().equals(bookTitle)) {
                // Remove the book from the library
                bookList.remove(book);
                // Print a confirmation message if the book is successfully removed
                System.out.println("Book titled " + bookTitle + " has been removed from the library.");
                // Exit the method once the book is removed
                return;
            }
        }

        // Print an error message if the book is not found in the library
        System.out.println("Book titled " + bookTitle + " was not found in the library.");
    }

    /**
     * Checks out a book from the library based on its title.
     * Prints a confirmation message if the book is successfully checked out.
     * Prints an error message if the book is not found in the library or is already checked out.
     *
     * @param bookTitle The title of the book to be checked out.
     * @return void
     */
    public void checkoutBook(String bookTitle) {
        // Iterate through the library to find the book
        for (books book : bookList) {
            // Check if the title of the current book matches the provided title
            if (book.getBookTitle().equals(bookTitle)) {
                // Check if the book is already checked out
                if (book.isCheckedOut()) {
                    // Print an error message if the book is already checked out
                    System.out.println("Book titled " + bookTitle + " is already checked out.");
                    return;
                } else {
                    // Set the book as checked out
                    book.setCheckedOut(true);
                    // Print a confirmation message if the book is successfully checked out
                    System.out.println("Book titled " + bookTitle + " has been checked out.");
                    return;
                }
            }
        }

        // Print an error message if the book is not found in the library
        System.out.println("Book titled " + bookTitle + " was not found in the library.");
    }

    /**
     * Checks out a book from the library based on its title.
     * Prints a confirmation message if the book is successfully checked out.
     * Prints an error message if the book is not found in the library or is already checked out.
     *
     * @param bookTitle The title of the book to be checked in.
     * @return void
     */
    public void checkInBook(String bookTitle) {
        // Iterate through the library to find the book
        for (books book : bookList) {
            // Check if the title of the current book matches the provided title (case-insensitive)
            if (book.getBookTitle().equalsIgnoreCase(bookTitle)) {
                // Check if the book is already checked out
                if (book.isCheckedOut()) {
                    // Set the book as checked in
                    book.setCheckedOut(false);
                    // Print a confirmation message if the book is successfully checked in
                    System.out.println("Book titled " + bookTitle + " has been checked in.");
                    return;
                } else {
                    // Print an error message if the book is already checked in
                    System.out.println("Book titled " + bookTitle + " has already been checked in.");
                    return;
                }
            }
        }
        // Print an error message if the book cannot be checked in
        System.out.println("Book titled " + bookTitle + " cannot be checked in.");
    }

    /**
     * Prints the contents of the library.
     */
    public void printLibraryContents() {
        // Check if the library is empty
        if (bookList.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Library Contents:");
            for (books book : bookList) {
                System.out.println(book);
            }
        }
    }
}


