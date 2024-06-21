package com.example.CarDealershipAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
}

