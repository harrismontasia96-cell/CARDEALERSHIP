package com.pluralsight;

public abstract class Contract {

    protected String contractType;
    protected String DateOfContract;
    protected String customerName;
    protected String customerEmail;
    protected int vehicleVin;
    protected int year;
    protected String make;
    protected String model;
    protected String vehicleType;
    protected String color;
    protected double odometer;
    protected String vehicleSold;
    protected int totalPrice;
    protected double monthlyPayment;

    public Contract(String contractType, String dateOfContract, String customerName,
                    String customerEmail, String vehicleVin, int year,
                    String make, String model, String vehicleType,
                    String color, double odometer, String vehicleSold) {
        this.contractType = contractType;
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleVin = vehicleVin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.vehicleSold = vehicleSold;
        this.totalPrice = 0;
        this.monthlyPayment = 0;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public String getDateOfContract() {
        return dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getVehicleSold() {
        return vehicleSold;
    }

    public double getTotalPriceValue() {
        return totalPrice;
    }

    public double getMonthlyPaymentValue() {
        return monthlyPayment;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setVehicleSold(String vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}

