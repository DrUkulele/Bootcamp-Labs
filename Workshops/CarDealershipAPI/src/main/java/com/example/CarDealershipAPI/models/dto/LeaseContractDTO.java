package com.example.CarDealershipAPI.models.dto;

import com.example.CarDealershipAPI.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseContractDTO {
    private String date;
    private String customerName;
    private String customerEmail;
    private int vehicle_vin;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;
    private BigDecimal vehiclePrice;
    private BigDecimal leaseFee;

}
