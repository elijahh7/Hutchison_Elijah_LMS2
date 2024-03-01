/*
 * Elijah Hutchison
 * CEN 3024C-24667
 * 2/28/2024
 *
 * Class Name: Main
 *
 * Description:
 *   This is the main class and it's function is to scan in files from the users and display
 *   a list of actions that the user can perform. This class is integrated with my library
 *   class, this is how the menu option carry out the intended actions of the user.
 *
 *
 *   The file is added to the library using a scanner in the main method.
 *
 *   The user is able to choose what action they want to perform using the
 *   the menu system.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the file path containing books and receive it from the user
        System.out.println("Enter the full path of the file containing books:");
        String filePath = scanner.nextLine();

        // Attempt to open the file
        try {
            // Create a file object with the specified file path
            File file = new File(filePath);


            // Create a scanner object to read from the file
            Scanner fileScanner = new Scanner(file);

            // Create a library object to store the books
            library myLibrary = new library();

            // Read each line from the file and add each book to the library
            while (fileScanner.hasNextLine()) {
                // Read the line containing barcode number and book title separated by comma
                String line = fileScanner.nextLine();

                // Split the line by comma to get barcode number and title
                String[] parts = line.split(",");

                // Ensure that the line contains both barcode number and title
                if (parts.length == 2) {
                    String barcodeString = parts[0].trim();
                    String bookTitle = parts[1].trim();

                    try {
                        // Attempt to convert the barcode string to an integer
                        int barcodeNumber = Integer.parseInt(barcodeString);

                        // Add the book to the library
                        myLibrary.addBook(barcodeString, bookTitle);
                        System.out.println("Adding books to library...");
                    } catch (NumberFormatException e) {
                        // Handle the case where the barcode string cannot be parsed as an integer
                        System.out.println("Invalid barcode format for book: " + bookTitle);
                    }
                } else {
                    System.out.println("Invalid format for book: " + line);
                }
            }


            // Close the file scanner
            fileScanner.close();

            // Print a message indicating that the books have been added to the library
            System.out.println("Books have been added to the library from the file.");

            // Display library
            myLibrary.printLibraryContents();

            int option;

            Scanner scannerTwo = new Scanner(System.in);

            // Loop to display the menu and process user input
            while (true) {
                // Menu header
                System.out.println("\nSelect an option:\n1. Remove book using barcode\n2. Remove book using title\n3. Checkout book\n4. Check book in\n5. Display library\n6. Exit");

                // Read user input
                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (option) {
                    case 1:
                        // Prompt the user to enter barcode of book they want to remove
                        System.out.println("Please enter the barcode number of the book you want to remove.");
                        int barcodeToRemove = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        // Remove the book from the library
                        myLibrary.removeBookWithBarcode(barcodeToRemove);

                        // Display library
                        myLibrary.printLibraryContents();
                        break;
                    case 2:
                        System.out.println("Please enter the title of the book you want to remove.");
                        String titleToRemove = scanner.nextLine();

                        // Remove the book from the library
                        myLibrary.removeBookWithTitle(titleToRemove);

                        // Display library
                        myLibrary.printLibraryContents();
                        break;
                    case 3:
                        System.out.println("Please enter the title of the book you want to checkout.");
                        String titleToCheckOut = scanner.nextLine();

                        // Check out book from the library
                        myLibrary.checkoutBook(titleToCheckOut);

                        // Display library
                        myLibrary.printLibraryContents();
                        break;
                    case 4:
                        System.out.println("Please enter the title of the book you want to check in.");
                        String titleToCheckIn = scanner.nextLine();

                        // Check out book from the library
                        myLibrary.checkInBook(titleToCheckIn);

                        // Display library
                        myLibrary.printLibraryContents();
                        break;
                    case 5:
                        myLibrary.printLibraryContents();
                        break;
                    case 6:
                        // Exit the program
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid option. Please select a valid option from the menu.");
                }
            }
        } catch (FileNotFoundException e) {
            // Print an error message if the file is not found
            System.out.println("File not found: " + filePath + "\nPlease use the correct format, example books.txt");
        } catch (NumberFormatException e) {
            // Print an error message if a non-integer barcode is encountered
            System.out.println("Invalid barcode format. Please ensure barcode numbers are integers.");
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}

