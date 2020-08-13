import java.io.*;
import java.util.ArrayList;

public class Database {

    // Field/Instance variable:
    private ArrayList<Restaurant> restaurants;

    // Constructor:
    Database () {};

    // Getters:
    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    // Setters:
    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    // Methods:
    private void getRestaurantsArray() {

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("restos.csv"));
            String row = null;
            int i = 0;
            restaurants = new ArrayList<>();

            while ((row = csvReader.readLine()) != null) {
                if(i > 0) {
                    String[] data = row.split(",");
                    Dish signatureDish1 = new Dish(data[1].trim(), Double.parseDouble(data[2].trim()));
                    Dish signatureDish2 = new Dish(data[3].trim(), Double.parseDouble(data[4].trim()));
                    Dish signatureDish3 = new Dish(data[5].trim(), Double.parseDouble(data[6].trim()));

                    ArrayList<Dish> dishes = new ArrayList<>();
                    dishes.add(signatureDish1);
                    dishes.add(signatureDish2);
                    dishes.add(signatureDish3);

                    Restaurant restaurant = new Restaurant(data[0].trim(),dishes, data[7].trim());

                    restaurants.add(restaurant);
                }

                i++;
            }

            csvReader.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public ArrayList<Restaurant> getRestaurantByLocation(String location) {
        getRestaurantsArray();
        ArrayList<Restaurant> restaurantsByLocation = new ArrayList<>();

        if (location.equals("all")) {
            return restaurants;
        } else {
            for(int i = 0; i < restaurants.size(); i++) {
                if (restaurants.get(i).getLocation().equals(location)) {
                    restaurantsByLocation.add(restaurants.get(i));
                }
            }
        }

        return restaurantsByLocation;
    }

    public void addOrder(String restaurant, ArrayList<Dish> order, String location) {
        String orders = order.get(0).getName();
        for (int i = 1; i < order.size(); i++) {
            orders += "|" + order.get(i);
        }
        String content = "\n" + restaurant + ", " + orders + ", " + location;

        try (FileWriter writer = new FileWriter("orders.csv", true);
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(content);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
