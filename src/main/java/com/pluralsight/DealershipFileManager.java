package com.pluralsight;

import java.io.*;
import java.util.*;

public class DealershipFileManager {

    public Dealership getDealership(String filename) {
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("Error:" + filename + " not found");
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String header = br.readLine();
            if (header == null) {
                System.out.println("Error:" + filename + "is empty or missing header");
                return null;
            }
            String[] dealershipInfo = header.split("\\|");
            if (dealershipInfo.length < 3) {
                System.out.println("Error: Dealership header line is invalid.");
                return null;
            }

            Dealership dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]
            );


            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 8) continue;


                Vehicle v = new Vehicle(
                        Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        data[2], data[3], data[4],
                        data[5], Integer.parseInt(data[6]),
                        Double.parseDouble(data[7])
                );
                dealership.addVehicle(v);
            }
            return dealership;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void saveDealership(Dealership dealership) {
        saveDealership(dealership, "inventory.csv");
    }

    public void saveDealership(Dealership dealership, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");
            for (Vehicle v : dealership.getAllVehicles()) {
                bw.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




