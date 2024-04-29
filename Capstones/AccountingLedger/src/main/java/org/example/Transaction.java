package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    //properties
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;
    DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter fmtTime = DateTimeFormatter.ofPattern("HH:mm:ss");

    //constructor
    public Transaction(String date, String time, String description, String vendor, double amount) {
        this.date = LocalDate.now().format(fmtDate);
        this.time = LocalTime.now().format(fmtTime);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Transaction() {
        this.date = LocalDate.now().format(fmtDate);
        this.time = LocalTime.now().format(fmtTime);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //methods
    //update the date or the current transaction
    public void updateDate(){
        this.date = LocalDate.now().format(fmtDate);
    }

    //update the time for the current transaction
    public void updateTime(){
        this.time = LocalTime.now().format(fmtTime);
    }

}
