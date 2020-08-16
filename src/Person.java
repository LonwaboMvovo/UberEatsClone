package src;

// 'ArrayList' class to make array lists
import java.util.ArrayList;

// Person class for a person that uses the Uber eats mobile app
public class Person {

    // Fields/Instance variables:
    // Person's name
    private String name;
    // Person's selected area to order from
    private String location;
    // Person's cart of all the dishes they would like to order
    private ArrayList<Dish> cart = new ArrayList<>();
    // Person's balance (amount of money they have)
    private double balance;

    // Constructor:
    public Person(String name, String location, double balance) {
        this.name = name;
        this.location = location;
        this.balance = balance;
    }

    // Getters:
    // Return person's name
    public String getName() {
        return name;
    }

    // Return person's selected area
    public String getLocation() {
        return location;
    }

    // Return person's cart
    public ArrayList<Dish> getCart() {
        return cart;
    }

    // Return person's balance
    public double getBalance() {
        return balance;
    }

    // Setters:
    // Set person's name
    public void setName(String name) {
        this.name = name;
    }

    // Set person's location
    public void setLocation(String location) {
        this.location = location;
    }

    // Set person's cart
    public void setCart(ArrayList<Dish> cart) {
        this.cart = cart;
    }

    // Set person's balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods:
    @Override
    public String toString() {
        // Message to be printed when object of class is printed (toString method called)
        return name + "\nLocation: " + location + "\ncart: " + cart + "\nBalance: " + balance;
    }

    // Add a dish to the cart
    public void addDish(Dish dish) {
        cart.add(dish);
    }

    // Remove a dish from the cart
    public void deleteDish(int dishIndex) {
        cart.remove(dishIndex);
    }
}
