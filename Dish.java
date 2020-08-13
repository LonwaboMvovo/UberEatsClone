public class Dish {
    private String name;
    private int cost;

    public Dish(String name,int cost){
        this.name = name;
        this.cost = cost;
    }
    public String getName(){ 
        return this.name; 
    }
    public int getCost(){ 
        return this.cost; 
    }

    @Override
    public String toString(){
        return this.name + "  Price:" +this.cost;
    }
}
