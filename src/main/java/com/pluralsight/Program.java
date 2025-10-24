package com.pluralsight;

public class Program {
    public class Program {
        public static void main(String[] args) {
            DealershipFileManager fileManager = new DealershipFileManager();
            Dealership dealership = fileManager.getDealership();
            UserInterface ui = new UserInterface(dealership);
            ui.display();
            fileManager.saveDealership(dealership);
        }
    }
}
