package a1_2101040039;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BookManager bookM = new BookManager();
    static ArrayList<Book> books = bookM.getBooks();

    public static Book handleAddInput() {
        int id = 0;
        String name = "";
        double price = 0;
        try {
            System.out.println("Enter book id: ");
            id = Integer.parseInt(sc.nextLine());
            System.out.println("Enter book name: ");
            name = sc.nextLine();
            System.out.println("Enter book price: ");
            price = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input.");
        }
        return new Book(id, name, price);
    }

    public static void handleEditInput(Book book) {
        System.out.println("Enter book name: ");
        book.name = sc.nextLine();
        try {
            System.out.println("Enter book price: ");
            book.price = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input.");
        }
    }

    public static int idInput() {
        int idInput = 0;
        try {
        System.out.println("Enter book id: ");
        idInput = Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException nfe) {
            System.out.println("Invalid input.");}
        return idInput;
    }

    public static String nameInput() {
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();
        return keyword;
    }


    public static void consoleMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. list all books");
        System.out.println("2. add a new book");
        System.out.println("3. edit book");
        System.out.println("4. delete a book");
        System.out.println("5. search books by name");
        System.out.println("6. sort books descending by price");
        System.out.println();
        System.out.println("0. save & exit");
        System.out.println("-----------------------------------");
        System.out.print("Your option: ");
    }

    public static void executeOption(int option) throws IOException {

        switch (option) {
            case 1:
                bookM.printBooks(books);
                break;

            case 2:
                Book book2 = handleAddInput();
                if (bookM.add(book2)) {
                    System.out.println("Added successfully.");
                } else {
                    if (book2.id == 0 || book2.price == 0) {
                        System.out.println("Unable to add book.");
                    } else {
                        System.out.println("Duplicated ID!");
                    }
                }
                break;

            case 3:
                Book book3 = bookM.getBookById(idInput());
                if (book3 == null) {
                    System.out.println("Invalid ID!");
                } else {
                    handleEditInput(book3);
                    System.out.println("Updated successfully.");
                }
                break;

            case 4:
                Book book4 = bookM.getBookById(idInput());
                if (book4 == null) {
                    System.out.println("Invalid ID!");
                } else {
                    bookM.remove(book4);
                    System.out.println("Deleted Successfully.");
                }
                break;

            case 5:
                ArrayList<Book> matches = new ArrayList<>(bookM.searchByName(nameInput()));
                if (matches.isEmpty()) {
                    System.out.println("(empty)");
                } else {
                    for (Book book : matches) {
                        System.out.println(book);
                    }
                }
                break;

            case 6:
                bookM.sortDescByPrice();
                break;

            case 0:
                bookM.saveToFile();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    public static void main(String[] args) throws IOException {
        int option;
        bookM.loadFromFile();
        do {
            consoleMenu();
            option = Integer.parseInt(sc.nextLine());
            executeOption(option);
        } while (option != 0);

    }
}
