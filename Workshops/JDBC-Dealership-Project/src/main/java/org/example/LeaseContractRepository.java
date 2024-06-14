package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeaseContractRepository {
    private BasicDataSource basicDataSource;
    LocalDateTime date = LocalDateTime.now();

    public LeaseContractRepository(String url, String userName, String password) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

    public Vehicle getVehicleLeaseContract(int vehicleVin1) {
        String query = "{Call isVehicleLease(?)}";
        Vehicle vehicle = null;

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, vehicleVin1);
            ResultSet rs = cs.executeQuery();


            int vehicleVin = rs.getInt("VehicleVin");
            int year = rs.getInt("Year");
            String make = rs.getString("Make");
            String model = rs.getString("Model");
            String type = rs.getString("Type");
            String color = rs.getString("Color");
            int odometer = rs.getInt("Odometer");
            double price = rs.getDouble("Price");
            boolean sold = rs.getBoolean("Sold");
            vehicle = new Vehicle(vehicleVin, year, make, model, type, color, odometer, price, sold);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicle;
    }

    public void addLeaseContract(int vin, LeaseContract leaseContract) {
        String query = "{Call addLeaseContract(?,?,?,?,?,?)}";
        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setBigDecimal(1, leaseContract.getVehiclePrice());
            cs.setBigDecimal(2, leaseContract.getLeaseFee());
            cs.setBigDecimal(3, leaseContract.getIntrestRate());
            cs.setBigDecimal(4, leaseContract.getLeaseTerm());
            cs.setString(5, date.toString());
            cs.setInt(6, vin);


            cs.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


