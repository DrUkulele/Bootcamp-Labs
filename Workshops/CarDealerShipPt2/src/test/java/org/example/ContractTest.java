package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContractTest {

    @ParameterizedTest
    @CsvSource({"10000, 226.91", "10001, 226.93", "9000, 395.85", "2000, 87.97"})
    //expected must have 2 decimal places
    public void putInAVehicle_getMonthlyPayment(double price, BigDecimal expected) {
        Vehicle vehicle = new Vehicle(1234, 2016, "Dodge", "Charger", "Sedan", "Black", 10, price);
        SalesContract salesContract = new SalesContract("Billy", "Billy@gmail.com", vehicle, true);

        assertEquals(expected, salesContract.getMonthlyPayment());

    }

    @ParameterizedTest
    @CsvSource({"10000, 11095.00", "2000, 2495.00"})
    //expected must have 2 decimal places
    public void putInAVehicle_geTotal(double price, BigDecimal expected) {
        Vehicle vehicle = new Vehicle(1234, 2016, "Dodge", "Charger", "Sedan", "Black", 10, price);
        SalesContract salesContract = new SalesContract("Billy", "Billy@gmail.com", vehicle, true);

        assertEquals(expected, salesContract.getTotalPrice());
    }

    @ParameterizedTest
    @CsvSource({"10000, 158.58 ", "31995.00, 507.39", "2000, 31.72 "})
    //expected must have 2 decimal places
    public void putInAVehicle_getMonthlyLeasePayment(double price, BigDecimal expected) {
        Vehicle vehicle = new Vehicle(1234, 2016, "Dodge", "Charger", "Sedan", "Black", 10, price);
        LeaseContract leaseContract = new LeaseContract("Billy", "Billy@gmail.com", vehicle);

        assertEquals(expected, leaseContract.getMonthlyPayment());
    }
    @ParameterizedTest
    @CsvSource({"10000, 10700.00", "31995, 34234.65"})
    //expected must have 2 decimal places
    public void putInAVehicle_getLeaseTotal(double price, BigDecimal expected){
        Vehicle vehicle = new Vehicle(1234, 2016, "Dodge", "Charger", "Sedan", "Black", 10, price);
        LeaseContract leaseContract = new LeaseContract("Billy", "Billy@gmail.com", vehicle);

        assertEquals(expected, leaseContract.getTotalPrice());
    }

    @Test
    public void putInContract_WriteToFile(){
        Vehicle vehicle = new Vehicle(1234, 2016, "Dodge", "Charger", "Sedan", "Black", 10, 10000);
        LeaseContract leaseContract = new LeaseContract("Billy", "Billy@gmail.com", vehicle);
        SalesContract salesContract = new SalesContract("Billy", "Billy@gmail.com", vehicle, false);

        ContractFileManager.saveContracts(leaseContract);
        ContractFileManager.saveContracts(salesContract);
    }
}