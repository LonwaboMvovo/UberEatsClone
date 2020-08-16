package src;

import java.io.*;
import java.util.ArrayList;

// 'ArrayList' class to make array lists

// Database class for any time an Uber eats app is run to interact with the CSV's
public class Database {

    // Fields/Instances variable:
    // 'Restaurant' array list of restaurants found
    private ArrayList<Restaurant> restaurants;

    private ArrayList<Order> orders;

    // Constructor:
    Database () {};

    // Getters:
    // Return restaurants found
    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    // Setters:
    // Set 'restaurants'
    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    // Methods:
    // Read 'restos' csv and set 'restaurants' to all restaurants found
    private void getRestaurantsArray() {
        try {
            // Create 'BufferedReader' object to read from 'restos.csv' file
            BufferedReader csvReader = new BufferedReader(new FileReader("restos.csv"));
            String row = null;
            int i = 0;
            // Instantiate 'restaurants' array list
            restaurants = new ArrayList<>();

            // While there is a line in the csv file
            while ((row = csvReader.readLine()) != null) {
                if(i > 0) {
                    // Split each row by the comma and set 'data' to that array
                    String[] data = row.split(",");
                    // Create 'Dish' objects for the 3 signature dishes of each restaurant
                    Dish signatureDish1 = new Dish(data[1].trim(), Double.parseDouble(data[2].trim()));
                    Dish signatureDish2 = new Dish(data[3].trim(), Double.parseDouble(data[4].trim()));
                    Dish signatureDish3 = new Dish(data[5].trim(), Double.parseDouble(data[6].trim()));

                    // Add all dishes to 'dishes' array list
                    ArrayList<Dish> dishes = new ArrayList<>();
                    dishes.add(signatureDish1);
                    dishes.add(signatureDish2);
                    dishes.add(signatureDish3);

                    // Create 'Restaurant' object with the name, dishes, and location from data array
                    Restaurant restaurant = new Restaurant(data[0].trim(),dishes, data[7].trim());

                    // Add the restaurant to the 'restaurant' array list
                    restaurants.add(restaurant);
                }

                i++;
            }

            // Close the csv reader
            csvReader.close();
        // Catch errors that could occur and print them
        } catch(Exception e) {
            System.out.println("Error:\n" + e.toString());
        }
    }

    public void getOrdersArray() {
        try {
            // Create 'BufferedReader' object to read from 'orders.csv' file
            BufferedReader csvReader = new BufferedReader(new FileReader("orders.csv"));
            String row = null;
            int i = 0;
            // Instantiate 'orders' array list
            orders = new ArrayList<>();

            // While there is a line in the csv file
            while ((row = csvReader.readLine()) != null) {
                if(i > 0) {
                    // Split each row by the comma and set 'data' to that array
                    String[] data = row.split(",");

                    // Split the 2nd array value by underscore which is what the orders are set to be split by
                    String[] itemsOrdered = data[1].trim().split(";");

                    // Create new Order object with name, items ordered and location
                   Order order = new Order(data[0].trim(), itemsOrdered, data[2].trim());

                    // Add the order to the 'orders' array list
                    orders.add(order);
                }

                i++;
            }

            // Close the csv reader
            csvReader.close();
            // Catch errors that could occur and print them
        } catch(Exception e) {
            System.out.println("Error:\n" + e.toString());
        }
    }

    // Return all restaurants found in a given location
    public ArrayList<Restaurant> getRestaurantByLocation(String location) {
        getRestaurantsArray();
        // Create a new 'Restaurant' array list
        ArrayList<Restaurant> restaurantsByLocation = new ArrayList<>();

        // Check if the user would like the ability to order from all areas
        if (location.equals("all")) {
            // Return all restaurants found
            return restaurants;
        // Otherwise add a 'Restaurant' to 'restaurantsByLocation' if it matches the user selected location
        } else {
            for (int i = 0; i < restaurants.size(); i++) {
                if (restaurants.get(i).getLocation().equals(location)) {
                    restaurantsByLocation.add(restaurants.get(i));
                }
            }
        }

        // Return all restaurants found in a given location
        return restaurantsByLocation;
    }

    // Once user is done with app 'addOrder' method is called to add the order to the 'orders' csv
    public void addOrder(String restaurant, ArrayList<Dish> order, String location) {
        // Add orders names to 'orders' and separating each order with a semi-colon
        String orders = order.get(0).getName();
        for (int i = 1; i < order.size(); i++) {
            orders += ";" + order.get(i).getName();
        }
        // 'content' representing the row to concatenate to the 'orders' csv
        String content = "\n" + restaurant + ", " + orders + ", " + location;

        // Try to create a new 'FileWriter' object and add 'content' to 'orders.csv' file
        try (FileWriter writer = new FileWriter("orders.csv", true);
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(content);

        } catch (IOException e) {
            // Print the error is couldn't write to the csv file
            System.err.format("IOException: %s%n", e);
        }
    }

    public ArrayList<Order> getOrdersByName(String name) {
        getOrdersArray();
        // Create a new 'Order' array list
        ArrayList<Order> ordersByName = new ArrayList<>();

        // Check if the user would like the ability to check orders from all restaurants
        if (name.equals("all")) {
            // Return all orders found
            return orders;
            // Otherwise add an 'Order' to 'ordersByName' if it matches the user selected restaurant name
        } else {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getName().toLowerCase().equals(name)) {
                    ordersByName.add(orders.get(i));
                }
            }
        }

        // Return all orders found with given restaurant name
        return ordersByName;
    }
}
