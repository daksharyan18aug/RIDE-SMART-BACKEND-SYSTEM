import admin.AdminComponent;
import booking.BookingComponent;
import booking.TransactionSystem;
import utils.GraphTrackingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instantiate components
        AdminComponent adminComponent = new AdminComponent();
        BookingComponent bookingComponent = new BookingComponent();
        TransactionSystem transactionSystem = new TransactionSystem();
        GraphTrackingSystem graphTrackingSystem = new GraphTrackingSystem();

        // Register and login an agent
        adminComponent.registerAgent("agent002", "password123");
        boolean loggedIn = adminComponent.loginAgent("agent002", "password123");

        if (loggedIn) {
            System.out.println("Agent logged in!");

            // Add drivers
            bookingComponent.addDriver("MUMBAI", 4.9, "SUV");
            bookingComponent.addDriver("NEW Delhi", 4.5, "Sedan");

            // Search drivers sorted by rating
            System.out.println("Available drivers sorted by rating:");
            for (BookingComponent.Driver driver : bookingComponent.searchAndSortDriversByRating()) {
                System.out.println(driver);
            }

            // Add transactions
            transactionSystem.addTransaction("Booking 1: Mumbai to Pune");
            transactionSystem.addTransaction("Booking 2: New Delhi to Lucknow");

            // Process transactions
            transactionSystem.processTransactions();

            // Track vehicles using Dijkstra's Algorithm
            graphTrackingSystem.addEdge("Mumbai ", "Pune", 150);
            graphTrackingSystem.addEdge("NEW Delhi", "Lucknow", 600);
            System.out.println("Shortest distances from New Delhi: " + graphTrackingSystem.dijkstra("New Delhi"));
        }

        // Logout
        adminComponent.logoutAgent("agent002");
    }
}
