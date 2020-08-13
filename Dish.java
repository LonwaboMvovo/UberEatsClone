public class Dish {

    //Instance VARIABLES
    private String name;

    private double cost;

// CONSTRUCTOR
    public Dish(String name, double cost) {
        this.name = name;
        
        this.cost = cost;
    }    
// SETTERS
    
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    // GETTERS
    public String getName() {
        return name;
   
    }
    public double getCost() {
        return cost;
    }
// Method
    @Override
    public String toString() {
        return this.name + " Price: " + this.cost;
    }

}
