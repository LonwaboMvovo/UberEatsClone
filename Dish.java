public class Dish {

    //Instance VARIABLES
    private String name;

    private int cost;

// CONSTRUCTOR
    public Dish(String name, int cost) {
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
    public int getCost() {
        return cost;
    }
// Method
    @Override
    public String toString() {
        return this.name + " Price: " + this.cost;
    }

}
