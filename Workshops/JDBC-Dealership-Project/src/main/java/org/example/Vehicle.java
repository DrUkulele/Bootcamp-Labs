package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private int vin;
    private int year;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;
    private boolean sold;

    @Override
    public String toString(){
        return vin + "|" + year +  "|" + vehicleMake +  "|" + vehicleModel +  "|" + vehicleType + "|" + color + "|" + odometer + "|" + price;
    }

}
