package com.example.CarDealershipAPI.models.dto;


import com.example.CarDealershipAPI.models.Vehicle;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLeaseContractDTO {
    @NotBlank(message = "Date is mandatory")
    private String date;
    @NotBlank(message = "Customer Name is mandatory")
    private String customerName;
    @NotBlank(message = "Customer Email is mandatory")
    private String customerEmail;
    @NotBlank(message = "Vehicle is mandatory")
    private Vehicle vehicle;
    @NotBlank(message = "Total Price is mandatory")
    private BigDecimal totalPrice;
    @NotBlank(message = "Monthly Payment is mandatory")
    private BigDecimal monthlyPayment;
    @NotBlank(message = "Vehicle Price is mandatory")
    private BigDecimal vehiclePrice;
    @NotBlank(message = "Expected Ending Value is mandatory")
    private BigDecimal expectedEndingValue;
    @NotBlank(message = "Lease Fee is mandatory")
    private BigDecimal leaseFee;



}
