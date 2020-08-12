import java.util.ArrayList;

public class Restaurant {

    // Fields/Instance variables:
    String name;
    ArrayList<Dish> dishes;
    ArrayList<Double> costs;

    // Constructor:
    public Restaurant(String name, ArrayList<Dish> dishes, ArrayList<Double> costs) {
        this.name = name;
        this.dishes = dishes;
        this.costs = costs;
    }

    // Getters:
    public String getName() {
        return name;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public ArrayList<Double> getCosts() {
        return costs;
    }

    // Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setCosts(ArrayList<Double> costs) {
        this.costs = costs;
    }


    // Methods:
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", dishes=" + dishes +
                ", costs=" + costs +
                '}';
    }
}