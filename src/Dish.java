package src;

// Dish class for each restaurant signature dish
public class Dish {

    // Fields/Instance variables:
    // Name of dish
    private String name;
    // Cost of dish
    private double cost;

    // Constructor:
    public Dish(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    // Getters:
    // Return name of dish
    public String getName() {
        return name;
    }

    // Return cost of dish
    public double getCost() {
        return cost;
    }

    // Setters:
    // Set name of dish
    public void setName(String name) {
        this.name = name;
    }

    // Set cost of dish
    public void setCost(double cost) {
        this.cost = cost;
    }

    // Methods:
    @Override
    public String toString() {
        // Message to be printed when object of class is printed (toString method called)
        return name + " worth R" + String.format("%.2f", cost);
    }
}
