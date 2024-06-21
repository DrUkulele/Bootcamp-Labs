package com.example.CarDealershipAPI.models.mapper;

import com.example.CarDealershipAPI.models.Vehicle;
import com.example.CarDealershipAPI.models.dto.CreateVehicleDTO;
import com.example.CarDealershipAPI.models.dto.UpdateVehicleDTO;
import com.example.CarDealershipAPI.models.dto.VehicleDTO;

public class VehicleMapper {
    public static VehicleDTO toDTO(Vehicle vehicle){
        VehicleDTO dto = new VehicleDTO();
        dto.setVin(vehicle.getVin());
        dto.setYear(vehicle.getYear());
        dto.setVehicleMake(vehicle.getVehicleMake());
        dto.setVehicleModel(vehicle.getVehicleModel());
        dto.setVehicleType(vehicle.getVehicleType());
        dto.setColor(vehicle.getColor());
        dto.setOdometer(vehicle.getOdometer());
        dto.setPrice(vehicle.getPrice());

        return dto;
    }

    public static Vehicle toEntity(CreateVehicleDTO dto){
        Vehicle vehicle = new Vehicle();

        vehicle.setVin(dto.getVin());
        vehicle.setYear(dto.getYear());
        vehicle.setVehicleMake(dto.getVehicleMake());
        vehicle.setVehicleModel(dto.getVehicleModel());
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setColor(dto.getColor());
        vehicle.setOdometer(dto.getOdometer());
        vehicle.setPrice(dto.getPrice());

        return vehicle;
    }

    public static Vehicle toEntity(UpdateVehicleDTO dto){
        Vehicle vehicle = new Vehicle();

        vehicle.setVin(dto.getVin());
        vehicle.setYear(dto.getYear());
        vehicle.setVehicleMake(dto.getVehicleMake());
        vehicle.setVehicleModel(dto.getVehicleModel());
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setColor(dto.getColor());
        vehicle.setOdometer(dto.getOdometer());
        vehicle.setPrice(dto.getPrice());

        return vehicle;
    }
}
