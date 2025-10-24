package com.pluralsight;

import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);
    private DealershipFileManager fileManager = new DealershipFileManager();

    public void display() {
        loadDealership(); // ask user which dealership to load

        int choice;
        do {
            System.out.println("\n--- Dealership Menu (" + dealership.getName() + ") ---");
            System.out.println("1 - Find vehicles by price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Switch Dealership");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            processUserInput(choice);
        } while (choice != 99);

        fileManager.saveDealership(dealership);
        System.out.println("Application closed. Data saved.");
    }

    private void loadDealership() {
        System.out.print("Enter dealership filename (e.g., AutoMart.csv): ");
        String filename = scanner.nextLine();
        dealership = fileManager.getDealership(filename);

        if (dealership == null) {
            System.out.println("File not found. Creating a new dealership profile.");
            System.out.print("Enter dealership name: ");
            String name = scanner.nextLine();
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            dealership = new Dealership(name, address, phone);
            fileManager.saveDealership(dealership, filename);
        }

        System.out.println("Loaded dealership: " + dealership.getName());
    }

    private void processUserInput(int choice) {
        switch (choice) {
            case 7:
                displayVehicles(dealership.getAllVehicles());
                break;
            case 10:
                fileManager.saveDealership(dealership);
                loadDealership();
                break;
            case 99:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Option not implemented yet.");
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }
}