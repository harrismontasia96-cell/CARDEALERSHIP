package com.pluralsight.Dao;

import com.pluralsight.LeaseContract;
import java.sql.*;


public class LeaseContractDao {  private Connection connection;

    public LeaseContractDao(Connection connection) {
        this.connection = connection;
    }

    public void insertLeaseContract(LeaseContract contract) {

        String sql = "INSERT INTO lease_contracts " +
                "(vehicle_id, customer_name, customer_address, start_date, " +
                "expected_value, lease_fee, monthly_payment) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contract.getVehicleId());
            stmt.setString(2, contract.getCustomerName());
            stmt.setString(3, contract.getCustomerAddress());
            stmt.setString(4, contract.getStartDate());
            stmt.setDouble(5, contract.getExpectedValue());
            stmt.setDouble(6, contract.getLeaseFee());
            stmt.setDouble(7, contract.getMonthlyPayment());

            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}


