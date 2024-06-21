package com.example.CarDealershipAPI.models.dto;

import com.example.CarDealershipAPI.models.Vehicle;
import lombok.*;


import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesContractDTO {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;
    private BigDecimal salesTax;
    private BigDecimal processingFee;
    private boolean finance;
    private BigDecimal interestRate;
}
