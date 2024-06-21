package com.example.CarDealershipAPI.models.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private int vin;
    private int year;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;
    private boolean sold;
}
