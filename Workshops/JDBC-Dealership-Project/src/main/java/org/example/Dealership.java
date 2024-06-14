package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dealership {
    //properties
    private int dealershipId = 1;
    private String name;
    private String address;
    private String phone;
    VehicleRepository vr = new VehicleRepository(DBConfig.getUrl(), DBConfig.getUserName(), DBConfig.getPassword());
    SalesContractRepository sr = new SalesContractRepository(DBConfig.getUrl(), DBConfig.getUserName(), DBConfig.getPassword());
    LeaseContractRepository lr = new LeaseContractRepository(DBConfig.getUrl(), DBConfig.getUserName(), DBConfig.getPassword());

    List<Vehicle> inventory = new ArrayList<>();



    //methods
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        // Iterate through the sorted inventory list
        return vr.getVehiclesByPriceRange(dealershipId ,min, max);

    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {

        return vr.getVehiclesByMakeAndModel(dealershipId, make, model);
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return  vr.getVehiclesByYearRange(dealershipId, min, max);
    }

    public List<Vehicle> getVehiclesByColor(String color) {

        return vr.getVehiclesByColor(dealershipId, color);
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {

        return vr.getVehiclesByMileageRange(dealershipId, min, max);
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {

        return vr.getVehicleByType(dealershipId, vehicleType);
    }

    public List<Vehicle> getAllVehicles() {

        return vr.getAllVehicles(dealershipId);
    }

    public void addVehicle(Vehicle vehicle) {
        vr.addVehicle(dealershipId, vehicle);
    }

    public void removeVehicle(int vin) {
        vr.removeVehicle(vin);
    }

    //method to check if car is available
    public Vehicle carIsAvalivble(int vin) {
         if(sr.getVehicleSaleContract(vin) != null){
            return sr.getVehicleSaleContract(vin);
        }
         else if (lr.getVehicleLeaseContract(vin) != null) {
            return lr.getVehicleLeaseContract(vin);
        }
         return null;
    }

    public void addSalesContract(int vin, Contract contract){
        sr.addSalesContract(vin, (SalesContract) contract);

    }

    public void addLeaseContract(int vin, Contract contract) {
        lr.addLeaseContract(vin, (LeaseContract) contract);
    }
}

