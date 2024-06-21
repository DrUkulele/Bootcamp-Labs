package com.example.CarDealershipAPI.models.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleSearchParams {
    private Integer minYear;
    private Integer maxYear;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String color;
    private Integer minOdometer;
    private Integer maxOdometer;
    private Double minPrice;
    private Double maxPrice;
    private Boolean sold;
}
