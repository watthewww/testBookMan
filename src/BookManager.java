import java.io.*;
import java.util.*;

public class BookManager {
    ArrayList<Book> books;

    public BookManager() {
        // TODO: your code here
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        // TODO: your code here
        return books;
    }

    void loadFromFile() throws FileNotFoundException {
        File f1 = new File("books.txt");
        Scanner sc = new Scanner(f1);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int id = Integer.parseInt(s.substring(0, 6).trim());
            String name = s.substring(6, 50);
            double price = Double.parseDouble(s.substring(50, 60));
            Book book = new Book(id, name, price);
            books.add(book);
        }
        System.out.println("Loading books...");
        // TODO: your code here
    }

    public void printBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("(empty)");
        } else {
            System.out.printf("%-5s %-45s %-10s %n", "ID", "Name", "Price");
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
        // TODO: your code here
    }

    public boolean add(Book book) {
        boolean addable = true;
        for (Book value : books) {
            int idAvail = value.id;
            if (book.id == idAvail) {
                addable = false;
                break;
            }
        }
        if (addable) {
            books.add(book);
        }
        return addable;
    }

    /**
     * return book specified by id, null if not found
     */

    public Book getBookById(int id) {
        Book bookResult = null;
        for (Book book : books) {
            if (id == book.id) {
                bookResult = book;
            }
            break;
        }
        return bookResult;
    }

    /**
     * remove book from this.books
     */
    public void remove(Book book) {
        books.remove(book);
    }

    /**
     * update this.books to be sorted by price from high -> low
     */
    public void sortDescByPrice() {
        if (books.isEmpty()) {
            System.out.println("(empty)");
        } else {
            ArrayList <Book> copy = new ArrayList<>(books);
            copy.sort((b1, b2) -> Double.compare(b2.price, b1.price));
            System.out.println("After sorting: ");
            System.out.printf("%-5s %-45s %-10s %n", "ID", "Name", "Price");
            for (Book book : copy) {
                System.out.println(book.toString());
            }
        }
    }

    /**
     * return all books having name contains keyword (case in-sensitive)
     */
    public ArrayList<Book> searchByName(String keyword) {
        ArrayList<Book> matches = new ArrayList<>();

        // TODO: your code here

        return matches;
    }

    public void saveToFile() throws IOException {
        File file = new File("books.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file));
        for (Book book : books) {
            output.write(String.valueOf(book));
            output.newLine();
        }
        System.out.println("Bye!");
        output.close();
    }
}

