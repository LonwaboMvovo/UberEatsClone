package src;

// 'ArrayList' class to make array lists
import java.util.Arrays;

// Order class for each order in orders csv file
public class Order {

    // Fields/Instance Variables:
    // Name of order's restaurant
    private String name;
    // Items ordered by user from restaurant
    private String[] itemsOrdered;
    // Location of order's restaurant
    private String location;

    // Constructor:
    public Order(String name, String[] itemsOrdered, String location) {
        this.name = name;
        this.itemsOrdered = itemsOrdered;
        this.location = location;
    }

    // Getters:
    // Return name of order's restaurant
    public String getName() {
        return name;
    }

    // Return items ordered by user from order's restaurant
    public String[] getItemsOrdered() {
        return itemsOrdered;
    }

    // Return location of order's restaurant
    public String getLocation() {
        return location;
    }

    // Setters:
    // Set restaurant name
    public void setName(String name) {
        this.name = name;
    }

    // Set items ordered from restaurant
    public void setItemsOrdered(String[] itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    // Set location of restaurant
    public void setLocation(String location) {
        this.location = location;
    }

    // Methods:
    @Override
    public String toString() {
        return name + "\nItems Ordered: " + Arrays.toString(itemsOrdered) + "\n" + location;
    }
}
