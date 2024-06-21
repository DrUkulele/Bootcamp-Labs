package com.example.CarDealershipAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @Column(name = "vehicle_vin")
    private int vin;
    @Column(name = "Year")
    private int year;
    @Column(name = "make")
    private String vehicleMake;
    @Column(name = "model")
    private String vehicleModel;
    @Column(name = "type")
    private String vehicleType;
    @Column(name = "color")
    private String color;
    @Column(name = "Odometer")
    private int odometer;
    @Column(name = "Price")
    private double price;
    @Column(name = "Sold")
    private boolean sold;

}
