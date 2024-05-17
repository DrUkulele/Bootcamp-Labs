package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContractFileManager {
    private static final String filePath = "src/main/resources/contract.csv";
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Contract> contract = new ArrayList<>();

    //Read the file
    public static Dealership getDealership(){
        throw new UnsupportedOperationException();
    }

    //Write contracts to file
    public static void saveContracts(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if(contract instanceof SalesContract){
                writer.write("SALE" + "|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" + contract.getVehicleSold().toString() + "|" + ((SalesContract) contract).getSalesTax() + "|" + ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getProcessingFee() + "|" + contract.getTotalPrice() + "|" + (((SalesContract) contract).isFinance() ? "YES" : "No") + "|" + contract.getMonthlyPayment());
                writer.newLine();
            }
           if ((contract instanceof LeaseContract)){
               writer.write("LEASE" + "|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" + contract.getVehicleSold().toString() + "|" + ((LeaseContract) contract).getExpectedEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment());
               writer.newLine();
           }
        } catch (IOException ex) {
            System.out.println("Sorry, could not write to file!");
        }
    }
}
