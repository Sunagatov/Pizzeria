package models;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class Pizza {
    private int id;
    private String name;
    private double size;
    private double price;

    public Pizza(int id, String name, double size, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( " Name: " );
        builder.append( getName() );
        builder.append( " Size: ");
        builder.append( getSize() );
        builder.append( " Price: ");
        builder.append( getPrice() );
        return builder.toString();
    }

}

