package com.example.CarDealershipAPI.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Entity
@Table(name = "salescontracts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesContract extends Contract {
    //properties
    @Id
    @Column(name = "SalesContractID")
    private int salesContractId;
    @Setter
    @Column(name = "SalesTax")
    private  BigDecimal salesTax;
    @Getter
    private final BigDecimal recordingFee = new BigDecimal("100");
    @Setter
    @Column(name = "ProcessingFee")
    private BigDecimal processingFee; //$295 for vehicles under $10,000 and $495 for all others
    @Getter
    @Setter
    @Column(name = "Finance")
    private boolean finance;
    @Setter
    @Column(name = "IntrestRate")
    private BigDecimal interestRate; //all loans are 4.25%(.0425) for 48 months if the price is $10,000 or more, otherwise they are 5.25%(.0525) for 24 months
    @Column(name = "MonthlyPayment")
    private BigDecimal monthlyPayment;


    //constructor
    public SalesContract(String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(customerName, customerEmail, vehicleSold);
        this.finance = finance;
    }

    //getters and setters
    public BigDecimal getSalesTax() {
        salesTax = BigDecimal.valueOf(getVehicle().getPrice()).multiply(BigDecimal.valueOf(.05));
        return salesTax;
    }

    public BigDecimal getProcessingFee() {
        if(BigDecimal.valueOf(getVehicle().getPrice()).compareTo(BigDecimal.valueOf(10000)) < 0){
            processingFee = new BigDecimal("295");
        }
        else{
            processingFee = new BigDecimal("495");
        }
        return processingFee;
    }

    public BigDecimal getInterestRate() {
        if(BigDecimal.valueOf(getVehicle().getPrice()).compareTo(BigDecimal.valueOf(10000)) >= 0){ // 4.25 interest rate if price is 10,000 or more
            interestRate = new BigDecimal("0.0425");
        }
        else{
            interestRate = new BigDecimal("0.0525");
        }

        return interestRate;
    }

    //methods
    @Override
    public BigDecimal getTotalPrice() {
        //((vehicle price) * sales tax) + vehicle price + recording fee + Processing fee
        BigDecimal totalFees = recordingFee.add(getProcessingFee()); //recording fee + Processing fee
        BigDecimal total = BigDecimal.valueOf(getVehicle().getPrice()).add(totalFees).add(getSalesTax()).setScale(2 , RoundingMode.HALF_UP);
        return total;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        if (finance == true) {
            MathContext mathContextDenominator = new MathContext(10, RoundingMode.HALF_UP);
            MathContext mathContextMonthlyInterest = new MathContext(10, RoundingMode.FLOOR);
            var carPrice = getVehicle().getPrice();
            BigDecimal monthlyInterestRate = getInterestRate().divide(BigDecimal.valueOf(12), mathContextMonthlyInterest);
            BigDecimal one = new BigDecimal("1");
            int loanTerm;
            BigDecimal denominator;


            if (BigDecimal.valueOf(carPrice).compareTo(BigDecimal.valueOf(10000)) >= 0) { //
                loanTerm = 48;

            } else {
                loanTerm = 24;
            }

            denominator = one.add(monthlyInterestRate).pow(-loanTerm, mathContextDenominator);

            //Monthly payment = (loan amount) × (interest rate / 12) / (1 − (1 + (interest rate / 12)) ^ (-loan term)).
            monthlyPayment = (BigDecimal.valueOf(carPrice) // (loan amount)
                    .multiply(monthlyInterestRate //× (interest rate / 12)
                            .divide(one.subtract(denominator), RoundingMode.HALF_DOWN)));// / (1 − (1 + (interest rate / 12)) ^ (-loan term))

            return monthlyPayment = monthlyPayment.setScale(2, RoundingMode.HALF_UP);
        }
        else
            return BigDecimal.valueOf(0);
    }

}
