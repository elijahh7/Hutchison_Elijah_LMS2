/*
 * Elijah Hutchison
 * CEN 3024C-24667
 * 2/28/2024
 *
 * Class Name: books
 *
 * Description:
 *   This is my books class, it creates the book object for use in the library class.
 *   A book has three variables, barcode number, title, and checked out status. Each
 *   variable has a getter and a setter. The toString method is also overridden to
 *   to display more relevant results in the correct format.
 */

public class books {
    // Create variables
    private String barcodeNumber;
    private String bookTitle;
    private boolean isCheckedOut;

    // Define constructors
    public books(String barcodeNumber, String bookTitle) {
        this.barcodeNumber = barcodeNumber;
        this.bookTitle = bookTitle;
    }

    // Getters
    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    //Setters
    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    // Creating toString for books class
    @Override
    public String toString() {
        return "Book [Barcode Number: " + barcodeNumber + ", Title: " + bookTitle + "]";
    }
}