package com.pluralsight;

public class LeaseContract extends Contract {
    private int id;
    private int vehicleId;
    private String customerName;
    private String customerAddress;
    private double expectedValue;
    private double leaseFee;
    private double monthlyPayment;
    private String startDate;

    // constructor, getters, etc
}


    private static final double INTEREST_RATE = 0.04;
    private static final double LEASE_TERM_MONTHS = 36;
    private static final double LEASE_RATE = 0.60;

    private Vehicle vehicleSold;

    public LeaseContract(String date, String customerName, String customerEmail,
                         Vehicle vehicleSold) {
        super(
                "LEASE",
                customerName,
                customerEmail,
                vehicleSold.getVin(),
                vehicleSold.getYear(),
                vehicleSold.getMake(),
                vehicleSold.getModel(),
                vehicleSold.getVehicleType(),
                vehicleSold.getColor(),
                vehicleSold.getOdometer(),
                vehicleSold.getMake() + " " + vehicleSold.getModel(),
                0.0,
                0.0
        );

        this.vehicleSold = vehicleSold;

        double totalPrice = getTotalPrice();
        double monthlyPayment = getMonthlyPayment();

        super.setTotalPrice(totalPrice);
        super.setMonthlyPayment(monthlyPayment);

    }


    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() * LEASE_RATE;
    }
    @Override
    public double getMonthlyPayment() {
        double leasePrice = getTotalPrice();
        double monthlyRate = INTEREST_RATE / 12;
        return (leasePrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -LEASE_TERM_MONTHS));
    }


