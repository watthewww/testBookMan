package a1_2101040039;

import java.io.Serializable;

public class Book implements Serializable {
    int id;
    String name;
    double price;


    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public void setName(String name) {
        this.name = name;
        // TODO: your code here
    }

    public void setPrice(double price) {
        this.price = price;
        // TODO: your code here
    }

    @Override
    public String toString() {
        return String.format("%5d %-45s %10.2f", id, name, price);
    }
}
