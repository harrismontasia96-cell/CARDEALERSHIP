package com.pluralsight.Dao;

import com.pluralsight.SalesContract;

import java.sql.*;

public class SalesContractDao { private Connection connection;

    public SalesContractDao(Connection connection) {
        this.connection = connection;
    }

    public void insertSalesContract(SalesContract contract) {

        String sql = "INSERT INTO sales_contracts " +
                "(vehicle_id, customer_name, customer_address, date_of_sale, " +
                "sales_tax, processing_fee, total_price) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contract.getVehicleId());
            stmt.setString(2, contract.getCustomerName());
            stmt.setString(3, contract.getCustomerAddress());
            stmt.setString(4, contract.getDateOfSale());
            stmt.setDouble(5, contract.getSalesTax());
            stmt.setDouble(6, contract.getProcessingFee());
            stmt.setDouble(7, contract.getTotalPrice());

            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}

