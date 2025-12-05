package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private int id; // NEW
    private String name;
    private String address;
    private String phone;

    public Dealership(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
    }

    public void removeVehicle(Vehicle v) {
        inventory.remove(v);
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                matches.add(v);
            }
        }
        return matches;
    }


}
