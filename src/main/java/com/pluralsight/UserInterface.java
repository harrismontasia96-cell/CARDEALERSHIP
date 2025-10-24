package com.pluralsight;

import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void display() {
        int choice;
        do {
            System.out.println("\n--- Dealership Menu ---");
            System.out.println("1 - Find vehicles by price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            processUserInput(choice);
        } while (choice != 99);
    }

    private void processUserInput(int choice) {
        switch (choice) {
            case 7:
                displayVehicles(dealership.getAllVehicles());
                break;
            // Add cases 1–6, 8–9 here
            case 99:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}

