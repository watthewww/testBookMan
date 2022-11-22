import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BookManager bookM = new BookManager();
    static ArrayList<Book> books = bookM.getBooks();

    public static Book handleAddInput() {
        System.out.print("Enter book id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter book name: ");
        String name = sc.nextLine();
        System.out.print("Enter book price: ");
        double price = Double.parseDouble(sc.nextLine());
        return new Book(id, name, price);
    }

    public static void handleEditInput(Book book) {
        System.out.print("Enter book name: ");
        book.name = sc.nextLine();
        System.out.print("enter book price: ");
        book.price = Double.parseDouble(sc.nextLine());
    }

    public static int idInput() {
        System.out.print("Enter book id: ");
        return Integer.parseInt(sc.nextLine());
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

        if (option == 1) {
            bookM.printBooks(books);
        } else if (option == 2) {
            if (bookM.add(handleAddInput())) {
                System.out.println("Successfully");
            } else {
                System.out.println("Duplicated ID!");
            }
        } else if (option == 3) {
            Book book = bookM.getBookById(idInput());
            if (book == null) {
                System.out.println("Invalid ID!");
            } else {
                handleEditInput(book);
                System.out.println("Updated successfully.");
            }
        } else if (option == 4) {
            Book book = bookM.getBookById(idInput());
            if (book == null) {
                System.out.println("Invalid ID!");
            } else {
                bookM.remove(book);
                System.out.println("Deleted Successfully.");
            }
        } else if (option == 5) {
            ArrayList<Book> matches = new ArrayList<>(bookM.searchByName(nameInput()));
            if (matches.isEmpty()) {
                    System.out.println("(empty)");
                } else {
                    for (Book book : matches) {
                        System.out.println(book);
                    }
                }
            }
        else if (option == 6) {
            bookM.sortDescByPrice();
        } else if (option == 0) {
            bookM.saveToFile();
        } else {
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
