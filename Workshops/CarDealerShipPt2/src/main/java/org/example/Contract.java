package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public Contract(String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    //getters and setters
    public String getDate() {
        date = LocalDate.now().format(fmt);
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    //methods
    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();
}
