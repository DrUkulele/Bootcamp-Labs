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
public class CreateSalesContractDTO {
    @NotBlank(message = "Date is mandatory")
    private String date;
    @NotBlank(message = "Customer Name is mandatory")
    private String customerName;
    @NotBlank(message = "Customer Email is mandatory")
    private String customerEmail;
    @NotBlank(message = "Vehicle Sold is mandatory")
    private Vehicle vehicleSold;
    @NotBlank(message = "Total Price is mandatory")
    private BigDecimal totalPrice;
    @NotBlank(message = "Monthly Payment is mandatory")
    private BigDecimal monthlyPayment;
    @NotBlank(message = "Sales Tax is mandatory")
    private  BigDecimal salesTax;
    @NotBlank(message = "Processing fee is mandatory")
    private BigDecimal processingFee;
    @NotBlank(message = "Finance is mandatory")
    private boolean finance;
    @NotBlank(message = "Interest Rate is mandatory")
    private BigDecimal interestRate;
}
