package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Contract {
    //properties
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
    private String date;

    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;

    //constructor


    //getters and setters
    public String getDate() {
        date = LocalDate.now().format(fmt);
        return date;
    }


    //methods
    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();
}
