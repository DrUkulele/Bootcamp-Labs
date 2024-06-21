package com.example.CarDealershipAPI.models;

import com.example.CarDealershipAPI.models.constants.FinancialConstants;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Entity
@Table(name = "leasecontracts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseContract extends Contract {
    //properties
    @Id
    @Column(name = "LeaseContractId")
    private int leaseContractId;
    @Getter
    @Setter
    @Column(name = "VehiclePrice")
    private BigDecimal vehiclePrice;
    @Transient
    private BigDecimal expectedEndingValue;//(50% of original price) could do / 2 but easier to convert using * 0.5 with Big Decimal
    @Column(name = "LeaseFee")
    private BigDecimal leaseFee; //(7% of original price)

    @Getter
    private final BigDecimal leaseTerm = new BigDecimal("36") ;


    //constructor
    public LeaseContract(String customerName, String customerEmail, Vehicle vehicleSold) {
        super(customerName, customerEmail, vehicleSold);

    }

    //getters and setters
    public BigDecimal getExpectedEndingValue() {
        expectedEndingValue = vehiclePrice.multiply(BigDecimal.valueOf(.5));
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(BigDecimal expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public BigDecimal getLeaseFee() {
        leaseFee = vehiclePrice.multiply(BigDecimal.valueOf(.07));
        return leaseFee;
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }

    //methods
    @Override
    public BigDecimal getTotalPrice() {
        //Price of the car + (price of car * 0.07) <-- calculated lease fee
        MathContext mcTotal = new MathContext(7, RoundingMode.HALF_UP);
        BigDecimal leaseFee = vehiclePrice.multiply(BigDecimal.valueOf(.07));
        BigDecimal total = vehiclePrice.add(leaseFee, mcTotal);
        return total;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        /*1. original price = vehicle price
        2. (original price * .5) = expected ending value
        3. (original price * 0.07) = lease fee
        4. ((original price - expected ending value) / lease term) = depreciation fee
        5. (interest rate / 2400) = money factor
        6. ((original price + expected ending value) * money factor) = finance fee
        7. (Lease fee / lease term) = Lease fee per month
        8. (depreciation fee + finance fee + lease fee per month) = total monthly payment*/
        MathContext mcMoneyFactor = new MathContext(10, RoundingMode.HALF_UP);

        BigDecimal expectedEndingValue = vehiclePrice.multiply(BigDecimal.valueOf(.5)); //(original price * .5) = expected ending value
        BigDecimal leaseFee = vehiclePrice.multiply(BigDecimal.valueOf(.07)); // (original price * 0.07) = lease fee
        BigDecimal depreciationFee = (vehiclePrice.subtract(expectedEndingValue)).divide(leaseTerm, RoundingMode.HALF_UP); //((original price - expected ending value) / lease term) = depreciation fee
        BigDecimal moneyFactor = FinancialConstants.interestRate.divide(BigDecimal.valueOf(2400), mcMoneyFactor);
        BigDecimal financeFee = (vehiclePrice.add(expectedEndingValue)).multiply(moneyFactor);
        BigDecimal leaseFeePerMonth = leaseFee.divide(leaseTerm, RoundingMode.HALF_UP);

        BigDecimal monthlyPayment = depreciationFee.add(financeFee).add(leaseFeePerMonth).setScale(2, RoundingMode.HALF_UP);
        return monthlyPayment;
    }

}
