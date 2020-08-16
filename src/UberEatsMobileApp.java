package src;

// 'ArrayList' class to make array lists
import java.util.ArrayList;
// 'Locale' class to change output formats
import java.util.Locale;
// 'Scanner' class to take user input
import java.util.Scanner;

// Uber eats user app
public class UberEatsMobileApp {

    // Scanner object 'input' to take user input from terminal
    private static final Scanner input = new Scanner(System.in);

    // 'main' method to run uber eats mobile app
    public static void main(String[] args) {

        // Set default locale to US so that doubles are formatted with a dot instead of a comma
        Locale.setDefault(Locale.US);

        // Welcome message
        System.out.println("Welcome to UberEatsApp - signature dish edition\n");

        // Set user's name by calling 'userInput' method
        String name = userInput("Please enter your name: ");
        // Capitalize name
        name = name.substring(0,1).toUpperCase() + name.substring(1);

        // Set user's balance (amount of money they have) by calling 'userInput' method and specifying the type of input to a double
        double balance = Double.parseDouble(userInput("Please enter your balance: ", "double"));

        // Set user's selected area by calling 'userInput' method
        String location = userInput("Select location to load restaurants. Options are Rondebosch, Kenilworth, Seapoint or all: ");

        // Create new 'Person' object
        Person me = new Person(name, location, balance);

        // Search for all the restaurants found in the user's selected area
        System.out.println("\nLoading restaurants in your selected area...");
        // Create new 'Database' object
        Database DB = new Database();
        // 'restos' array list of all restaurants in selected area by calling 'getRestaurantByLocation' method from 'Database' class
        ArrayList<Restaurant> restos = DB.getRestaurantByLocation(location);

        // Check if no restaurants were found in the selected area by checking the size of the 'restos' array list
        if (restos.size() == 0) {
            System.out.println("Unfortunately no restaurants were found in your selected area.");
        // Otherwise if at least one restaurant was found
        } else {
            // Print out names and locations of all the restaurants found in the user's selected area
            for (int i = 0; i < restos.size(); i++) {
                System.out.println((i + 1) + ". " + restos.get(i).getName() + ", " + restos.get(i).getLocation());
            }

            System.out.println();

            // Set user's selected restaurant number (restaurant they would like to order from) by calling 'userInput' method and specifying the type of input to a input
            int restaurantNumber = Integer.parseInt(userInput("Select restaurant number (eg '1' for KFC): ", "integer")) - 1;
            // Error handling for restaurant number
            while (restaurantNumber >= restos.size() || restaurantNumber < 0) {
                System.out.println("Restaurant number out of range.");
                restaurantNumber = Integer.parseInt(userInput("Select restaurant number (eg '1' for KFC): ", "integer")) - 1;
            }

            // Create a new 'Restaurant' object for the chosen restaurant
            Restaurant restaurant = restos.get(restaurantNumber);

            // Initialize 'prompt' which will deal with user inputs from now on to "g"
            String prompt = "g";

            // Notify user that their cart is empty and print the cart
            System.out.println("\nYour cart is currently empty\n");
            System.out.println("Your Cart: " + me.getCart());

            // Run while the user wishes to not checkout
            while (!prompt.equals("c")) {
                // Print signature dishes from the chosen restaurant
                System.out.println("\nLoading dishes from your selected restaurant...");
                for (int j = 0; j < restaurant.getDishes().size(); j++) {
                    System.out.println((j + 1) + ". " + restaurant.getDishes().get(j));
                }

                // Terminal gap
                System.out.println();

                // Prompt user for dish they would like to add to cart and error handling for dish number
                int dishNumber = Integer.parseInt(userInput("Enter 'a dishNumber' to add to your cart: ", "integer")) - 1;
                while (dishNumber >= restaurant.getDishes().size() || dishNumber < 0) {
                    System.out.println("Dish number out of range");
                    dishNumber = Integer.parseInt(userInput("Enter 'a dishNumber' to add to your cart: ", "integer")) - 1;
                }

                // Create 'Dish' object for selected dish and add it to the users cart
                Dish dish = restaurant.getDishes().get(dishNumber);
                me.addDish(dish);

                // Print current dishes in cart
                System.out.println("Your Cart: " + me.getCart());

                // Prompt the user if they would like to checkout or add another dish
                prompt = userInput("\nWould you like to (C)heckout or (A)dd another dish: ");
            }

            // Set 'prompt' to "d"
            prompt = "d";

            while (prompt.substring(0,1).toLowerCase().equals("d") && me.getCart().size() > 0) {
                // Prompt user if they would like to delete a dish
                prompt = userInput("\nWould you like to delete anything from your cart (Y)es or (N)o: ");

                // Check if they answered yes
                if (prompt.equals("y")) {

                    // Terminal gap
                    System.out.println();

                    // Prompt user for the dish they would like to delete and handle errors
                    prompt = userInput("Enter 'd index' to delete item from cart: ");
                    int promptInt = -1;
                    if (prompt.length() > 1) {
                        String givenInputInt = prompt.substring(1).trim();
                        while (true) {
                            try {
                                Integer.parseInt(givenInputInt);
                                break;
                            } catch(NumberFormatException e) {
                                System.out.print("Invalid index integer. Enter 'index' to delete item from cart: ");
                                givenInputInt = input.nextLine().trim();
                            }
                        }
                        promptInt = Integer.parseInt(givenInputInt);
                    }

                    if (promptInt >= me.getCart().size() || promptInt < 0) {
                        System.out.println("\nItem index out of range or not given");
                    } else {
                        me.deleteDish(promptInt);
                    }

                    // Print current dishes in cart
                    System.out.println("\nYour Cart: " + me.getCart());
                }
            }

            // Check if there is at least one dish in the cart
            if (me.getCart().size() > 0) {
                // Ask user to confirm their order
                prompt = userInput("\nPlease confirm your order by entering 'Y' for yes: ");

                // Check if the user would like to confirm their order
                if (prompt.equals("y")) {
                    // Print out their cart
                    System.out.println("\nYour Cart: " + me.getCart());

                    // Calculate the cost of their order and print out the value
                    double orderCost = 0;
                    for (int k = 0; k < me.getCart().size(); k++) {
                        orderCost += me.getCart().get(k).getCost();
                    }
                    System.out.println("Cost of Order: R" + orderCost);

                    System.out.println("\nOrder has been placed! Thank you for your time " + me.getName() + ". Restaurant will process your order soon!");

                    // Check if the user's balance was not sufficient
                    if (orderCost > me.getBalance()) {
                        System.out.println("\nUnfortunately you have insufficient funds. The order has been canceled.");
                    } else {
                        // Add order to 'orders' csv file by calling the 'addOrder' method
                        System.out.println("\nOrder successful");
                        DB.addOrder(restaurant.getName(), me.getCart(), restaurant.getLocation());
                    }
                // Otherwise if user did not confirm order print message to indicate it did not go through
                } else {
                    System.out.println("\nYour order has been canceled. Thank you for your time " + me.getName() + ".");
                }
            // Otherwise notify user that no dishes were found in their cart
            } else {
                System.out.println("\nNo dishes were found in your cart.");
            }

            // Close the input object from reading inputs from terminal
            input.close();
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

    // Method to handle user inputs of integer or double type, errors and return that given input (METHOD OVERLOADING)
    private static String userInput(String inputMsg, String type) {
        System.out.print(inputMsg);
        String givenInput = input.nextLine().trim();
        if (type.equals("double")) {
            while (true) {
                if (!givenInput.trim().isEmpty()) {
                    try {
                        Double.parseDouble(givenInput);
                        break;
                    } catch(NumberFormatException e) {
                        System.out.print("Invalid input. " + inputMsg);
                        givenInput = input.nextLine().trim();
                    }
                }
            }
        } else if (type.equals("integer")) {
            while (true) {
                if (!givenInput.trim().isEmpty()) {
                    try {
                        Integer.parseInt(givenInput);
                        break;
                    } catch(NumberFormatException e) {
                        System.out.print("Invalid input. " + inputMsg);
                        givenInput = input.nextLine().trim();
                    }
                }
            }
        }
        return givenInput.toLowerCase();
    }
}