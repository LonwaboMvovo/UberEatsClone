import java.util.ArrayList;

public class Restaurant {

    // Fields/Instance variables:
    private String name;
    private ArrayList<Dish> dishes;
    private String location;

    // Constructor:
    public Restaurant(String name, ArrayList<Dish> dishes, String location) {
        this.name = name;
        this.dishes = dishes;
        this.location = location;
    }

    // Getters:
    public String getName() {
        return name;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public String getLocation() {
        return location;
    }

    // Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    // Methods:
    @Override
    public String toString() {
        return name + ", " + location + "\nSignature Dishes: " + dishes;
    }
}
