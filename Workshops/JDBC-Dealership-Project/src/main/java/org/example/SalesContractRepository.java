package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SalesContractRepository {
    LocalDateTime date = LocalDateTime.now();
    private BasicDataSource basicDataSource;
    public SalesContractRepository(String url, String userName, String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

    public Vehicle getVehicleSaleContract(int vehicleVin1) {
        String query = "{Call isVehicleSales(?)}";
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

    public void addSalesContract(int vin, SalesContract salesContract) {
        String query = "{Call addSalesContract(?,?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setBigDecimal(1, salesContract.getSalesTax());
            cs.setBigDecimal(2, salesContract.getRecordingFee());
            cs.setBigDecimal(3, salesContract.getProcessingFee());
            cs.setBoolean(4, salesContract.isFinance());
            cs.setBigDecimal(5, salesContract.getInterestRate());
            cs.setBigDecimal(6, salesContract.getMonthlyPayment());
            cs.setString(7, date.toString());
            cs.setInt(8, vin);


            cs.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

