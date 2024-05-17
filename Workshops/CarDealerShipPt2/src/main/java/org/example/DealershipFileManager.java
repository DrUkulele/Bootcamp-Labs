package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {
        private static final String filePath = "src/main/resources/inventory.csv";
        private static final Scanner scanner = new Scanner(System.in);
        private static final ArrayList<Vehicle> vehicles = new ArrayList<>();

        //Read the file
        public static Dealership getDealership(){
            String dealershipName = "";
            String dealershipAddress = "";
            String dealershipPhoneNumber = "";

            //Loop through vehicles in file
            try(FileReader fileReader = new FileReader(filePath)){
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                //Reading first line
                String firstLine = reader.readLine();
                String[] dealershipInfo = firstLine.split("\\|");
                dealershipName = dealershipInfo[0];
                dealershipAddress = dealershipInfo[1];
                dealershipPhoneNumber = dealershipInfo[2];
                //reading the rest of file
                while((line = reader.readLine()) != null) {
                    String[] data = line.split("\\|");
                    int vin = Integer.parseInt(data[0]);
                    int year = Integer.parseInt(data[1]);
                    String vehicleModel = data[2];
                    String vehicleMake = data[3];
                    String vehicleType = data[4];
                    String color = data[5];
                    int odometer = Integer.parseInt(data[6]);
                    double price = Double.parseDouble(data[7]);

                    Vehicle vehicle = new Vehicle(vin, year, vehicleModel, vehicleMake, vehicleType, color, odometer, price);
                    vehicles.add(vehicle);
                }
            }
            catch (IOException e){
                System.out.println("File not found :( ");
            }
            catch (Exception exception){
                System.out.println("File could not be read :( ");
            }

            Dealership dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhoneNumber);
            dealership.setInventory(vehicles);
            return dealership;
        }
    //Write to the file
    public static void saveDealership(Dealership dealership){
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){

                writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
                writer.newLine();
                for(Vehicle vehicle: dealership.getInventory()){
                    writer.write(vehicle.toString());
                    writer.newLine();
                }
            }
            catch(IOException ex){
                System.out.println("Sorry, could not write to file!");
            }
    }
}
