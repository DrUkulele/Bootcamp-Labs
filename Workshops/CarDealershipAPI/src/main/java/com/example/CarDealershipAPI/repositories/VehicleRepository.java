package com.example.CarDealershipAPI.repositories;

import com.example.CarDealershipAPI.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>, JpaSpecificationExecutor<Vehicle> {

    List<Vehicle> findByPriceBetween(double minPrice, double maxPrice);
    List<Vehicle> findVByVehicleMakeContainingIgnoreCase(String make);
    List<Vehicle> findByVehicleModelContainingIgnoreCase(String model);
    List<Vehicle> findByYearBetween(int minYear, int maxYear);
    List<Vehicle> findByColorContainingIgnoreCase(String color);
    List<Vehicle> findByOdometerBetween(int minOdometer, int maxOdometer);
    List<Vehicle> findByVehicleTypeContainingIgnoreCase(String type);


}
