package src;

// 'ArrayList' class to make array lists
import java.util.ArrayList;

// Restaurant class for a restaurant object that needs to be created
public class Restaurant {

    // Fields/Instance variables:
    // Name of restaurant
    private String name;
    // Signature dishes of restaurant
    private ArrayList<Dish> dishes;
    // Location of restaurant
    private String location;

    // Constructor:
    public Restaurant(String name, ArrayList<Dish> dishes, String location) {
        this.name = name;
        this.dishes = dishes;
        this.location = location;
    }

    // Getters:
    // Return name of restaurant
    public String getName() {
        return name;
    }

    // Return signature dishes of restaurant
    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    // Return location of restaurant
    public String getLocation() {
        return location;
    }

    // Setters:
    // Set name  of restaurant
    public void setName(String name) {
        this.name = name;
    }

    // Set dishes of restaurant
    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    // Set location of restaurant
    public void setLocation(String location) {
        this.location = location;
    }


    // Methods:
    @Override
    public String toString() {
        // Message to be printed when object of class is printed (toString method called)
        return name + ", " + location + "\nSignature Dishes: " + dishes;
    }
}
