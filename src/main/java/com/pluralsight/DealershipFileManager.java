package com.pluralsight;

import java.io.*;
import java.util.*;

public class DealershipFileManager {
      try (BufferedReader br = new BufferedReader(new FileReader("dealership.csv"))) {
        String header = br.readLine();
        String[] dealershipInfo = header.split("\\|");
        Dealership dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\|");
            Vehicle v = new Vehicle(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    data[2], data[3], data[4],
                    data[5], Integer.parseInt(data[6]),
                    Double.parseDouble(data[7]));
            dealership.addVehicle(v);
        }
        return dealership;
    } catch (IOException e) {
        e.printStackTrace();
    }
        return null;
}

public void saveDealership(Dealership dealership) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("dealership.csv"))) {
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

