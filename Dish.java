public class Dish {
    private String name;
    private String signaturedish1;
    private String signaturedish2;
    private String signaturedish3;
    private int cost1;
    private int cost2;
    private int cost3;

    public Dish(String name, String signaturedish1, String signaturedish2, String signaturedish3, String location, int cost1, int cost2, int cost3) {
        this.name = name;
        this.signaturedish1 = signaturedish1;
        this.signaturedish2 = signaturedish2;
        this.signaturedish3 = signaturedish3;
        this.cost1 = cost1;
        this.cost2 = cost2;
        this.cost3 = cost3;

    }
    public void setName(String name) {
        this.name = name;

    }
    public void setSignaturedish1(String signaturedish1) {
        this.signaturedish1 = signaturedish1;

    }
    public void setSignaturedish2(String signaturedish2) {
        this.signaturedish2 = signaturedish2;

    }
    public void setSignaturedish3(String signaturedish3) {
        this.signaturedish3 = signaturedish3;
    }
    public void setCost1(int cost1) {
        this.cost1 = cost1;
    }
    public void setCost2(int cost2) {
        this.cost2 = cost2;
    }
    public void setCost3(int cost3) {
        this.cost3 = cost3;
    }
    public String getName() {
        return name;
    }
    public String getSignaturedish1() {
        return signaturedish1;
    }
    public String getSignaturedish2() {
        return signaturedish2;
    }
    public String getSignaturedish3() {
        return signaturedish3;
    }
    public int getCost1() {
        return cost1;
    }
    public int getCost2() {
        return cost2;
    }
    public int getCost3() {
        return cost3;
    }





}