package org.example;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

    private BasicDataSource basicDataSource;

    public VehicleRepository(String url, String userName, String password) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

    public List<Vehicle> getAllVehicles(int dealershipId) {
        String query = "{Call GetAllVehicles(?)}";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, dealershipId);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int vehicleVin = rs.getInt("VehicleVin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String type = rs.getString("Type");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");
                Vehicle vehicle = new Vehicle(vehicleVin, year, make, model, type, color, odometer, price, sold);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeAndModel(int dealershipId, String vMake, String vModel) {
        String query = "{Call GetVehicleByMakeAndModel(?,?,?)}";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, dealershipId);
            cs.setString(2, vMake);
            cs.setString(3, vModel);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int vehicleVin = rs.getInt("VehicleVin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String type = rs.getString("Type");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");
                Vehicle vehicle = new Vehicle(vehicleVin, year, make, model, type, color, odometer, price, sold);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByPriceRange(int dealershipId, double startPrice, double endPrice) {
        String query = "{Call GetVehicleByPriceRange(?,?,?)}";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, dealershipId);
            cs.setDouble(2, startPrice);
            cs.setDouble(3, endPrice);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int vehicleVin = rs.getInt("VehicleVin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String type = rs.getString("Type");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");
                Vehicle vehicle = new Vehicle(vehicleVin, year, make, model, type, color, odometer, price, sold);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYearRange(int dealershipId, int startYear, int endYear) {
        String query = "{Call GetVehicleByYearRange(?,?,?)}";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, dealershipId);
            cs.setInt(2, startYear);
            cs.setInt(3, endYear);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int vehicleVin = rs.getInt("VehicleVin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String type = rs.getString("Type");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");
                Vehicle vehicle = new Vehicle(vehicleVin, year, make, model, type, color, odometer, price, sold);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(int dealershipId, String vColor) {
        String query = "{Call GetVehicleByColor(?,?)}";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, dealershipId);
            cs.setString(2, vColor);


            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int vehicleVin = rs.getInt("VehicleVin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String type = rs.getString("Type");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");
                Vehicle vehicle = new Vehicle(vehicleVin, year, make, model, type, color, odometer, price, sold);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileageRange(int dealershipId, int minMileage, int maxMileage) {
        String query = "{Call GetVehicleByMileageRange(?,?,?)}";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, dealershipId);
            cs.setInt(2, minMileage);
            cs.setInt(3, maxMileage);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int vehicleVin = rs.getInt("VehicleVin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String type = rs.getString("Type");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");
                Vehicle vehicle = new Vehicle(vehicleVin, year, make, model, type, color, odometer, price, sold);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public List<Vehicle> getVehicleByType(int dealershipId, String vehicleType) {
        String query = "{Call GetVehicleByType(?,?)}";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, dealershipId);
            cs.setString(2, vehicleType);


            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int vehicleVin = rs.getInt("VehicleVin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String type = rs.getString("Type");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");
                Vehicle vehicle = new Vehicle(vehicleVin, year, make, model, type, color, odometer, price, sold);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public void addVehicle(int dealershipId, Vehicle vehicle) {
        String query = "{Call addVehicle(?,?,?,?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, dealershipId);
            cs.setInt(2, vehicle.getVin());
            cs.setInt(3, vehicle.getYear());
            cs.setString(4, vehicle.getVehicleMake());
            cs.setString(5, vehicle.getVehicleModel());
            cs.setString(6, vehicle.getVehicleType());
            cs.setString(7, vehicle.getColor());
            cs.setInt(8, vehicle.getOdometer());
            cs.setDouble(9, vehicle.getPrice());
            cs.setBoolean(10, vehicle.isSold());

            cs.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeVehicle(int vehicleVin) {
        String query = "{Call removeVehicle(?)}";

        try (Connection conn = basicDataSource.getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, vehicleVin);
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
