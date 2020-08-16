package src;

// 'Scanner' class to take user input

import java.util.ArrayList;
import java.util.Scanner;

// Uber eats restaurant app
public class UberEatsRestaurantApp {

    // Scanner object 'input' to take user input from terminal
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to UberEatsApp - signature dish edition FOR RESTAURANTS\n");

        // Prompt user to enter restaurant name
        String restaurantName = userInput("Enter restaurant name: ");

        System.out.println("\nLoading all orders placed...\n");
        // Create new 'Database' object to be able to read from orders csv file
        Database DB = new Database();

        // Create ArrayList of 'Order' objects with all orders by given restaurant name
        ArrayList<Order> orders = DB.getOrdersByName(restaurantName);

        // Load all orders found for given restaurant if at least one oder was found
        if (orders.size() > 0) {
            // Order number
            int orderIndex = 1;
            // For each 'Order' in 'orders'
            for (int i = 0; i < orders.size(); i++) {
                // For each order in an 'Order' (complicated structure but is done so because each 'Order' object in the 'orders' ArrayList contains literal orders)
                for (int j = 0; j < orders.get(i).getItemsOrdered().length; j++) {
                    // Create new 'Order' object for current order
                    Order order = orders.get(i);
                    // Orders location
                    String orderLocation = order.getLocation();
                    // Order message
                    System.out.println(orderIndex + ". " + order.getItemsOrdered()[j] + " from " + orderLocation.substring(0,1).toUpperCase() + orderLocation.substring(1));
                    // Increment order number by one
                    orderIndex++;
                }
            }
        // Otherwise if no orders were found print alerting message
        } else {
            System.out.println("No orders were found for specified restaurant.");
        }
    }

    // Method to handle user inputs of string type, errors and return that given input
    private static String userInput(String inputMsg) {
        System.out.print(inputMsg);
        String givenInput = input.nextLine().trim();
        while (true) {
            if (!givenInput.trim().isEmpty()) {
                break;
            }
            System.out.print("Invalid input. " + inputMsg);
            givenInput = input.nextLine().trim();
        }
        return givenInput.toLowerCase();
    }
}