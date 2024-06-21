package com.example.CarDealershipAPI.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleDTO {

    @NotBlank(message = "Vin is mandatory")
    @Size(max = 17, message = "Vin can not exceed 17 characters")
    private int vin;
    @NotBlank(message = "Year is mandatory")
    private int year;
    @NotBlank(message = "Make is mandatory")
    private String vehicleMake;
    @NotBlank(message = "Model is mandatory")
    private String vehicleModel;
    @NotBlank(message = "Type is mandatory")
    private String vehicleType;
    @NotBlank(message = "Color is mandatory")
    private String color;
    @NotBlank(message = "Odometer is mandatory")
    private int odometer;
    @NotBlank(message = "Price is mandatory")
    private double price;
    @NotBlank(message = "Sold is mandatory")
    private boolean sold;
}
