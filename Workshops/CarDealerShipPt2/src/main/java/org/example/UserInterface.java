package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static Dealership dealership;

    public static Dealership getDealership() { dealership = DealershipFileManager.getDealership();
        return dealership;
    }

    public static void userInterface() {
        System.out.println("Hello and Welcome to your " + dealership.getName() + " Dealership!");

        while (true) {
            try {
                System.out.println("""
                        -----What can we do for you today?-----
                        1)  Display vehicles by price range!
                        2)  Display vehicles by make and model!
                        3)  Display vehicles by year!
                        4)  Display vehicles by color!
                        5)  Display vehicles by mileage
                        6)  Display vehicles by vehicle type!
                        7)  Display all vehicles!
                        8)  Add a vehicle
                        9)  Remove a vehicle
                        10) Create Contract
                        0) Quit""");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Please answer the following questions: ");
                        processGetByPriceRequest();
                        break;
                    case 2:
                        System.out.println("Please answer the following questions: ");
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        System.out.println("Please answer the following questions: ");
                        processGetByYearRequest();
                        break;
                    case 4:
                        System.out.println("Please answer the following questions: ");
                        processGetByColorRequest();
                        break;
                    case 5:
                        System.out.println("Please answer the following questions: ");
                        processGetByMileageRequest();
                        break;
                    case 6:
                        System.out.println("Please answer the following questions: ");
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        System.out.println("Here is a list of all vehicles! ");
                        processGetAllVehicleRequest();
                        break;
                    case 8:
                        System.out.println("Please answer the following questions: ");
                        processAddVehicleRequest();
                        break;
                    case 9:
                        System.out.println("Please enter the vehicle vin you would like to remove: ");
                        processRemoveVehicle();
                        break;
                    case 10:
                        findCar();

                        break;
                    case 0:
                        System.out.println("""
                                ----------⚠ EXITING APPLICATION ⚠----------
                                 ----------HOPE TO SEE YOU SOON!----------
                                """);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("----------⚠ Sorry that is not an option! Try again! ⚠----------");
                        break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter your option in number format! ⚠----------");
            }
        }
    }

    public static void display(List<Vehicle> vehicles) {
        int counter = 0;
        for (Vehicle vehicle : vehicles) {
            System.out.printf("Vin: %s|Year: %d|Make: %s|Model: %s|Type: %s|Color: %s|Odometer: %d|Price: %.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getVehicleMake(), vehicle.getVehicleModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            counter++;
        }
        if (counter == 0) {
            System.out.println("Sorry, no vehicles were found :( ");
        }
        System.out.printf("This is the total amount of vehicles displayed: %d\n", counter);
    }

    //method for price
    public static void processGetByPriceRequest() {
        while (true) {
            try {
                System.out.print("What would be the min price? $");
                double minPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("What would be the max price? $");
                double maxPrice = Double.parseDouble(scanner.nextLine());

                List<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);

                display(vehiclesByPrice);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter price in number format! ⚠----------");
            }
        }
    }

    //method for make and model
    public static void processGetByMakeModelRequest() {
        while (true) {
            try {
                System.out.println("What would be the make and model of the car? ");
                System.out.print("Make: ");
                String vehicleMake = scanner.nextLine();
                System.out.print("Model: ");
                String vehicleModel = scanner.nextLine();

                List<Vehicle> vehiclesByMakeAndModel = dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel);

                display(vehiclesByMakeAndModel);
                break;
            } catch (Exception exception) {
                System.out.println("----------⚠ Please try again! ⚠----------");
            }
        }
    }

    //Method to process request to find vehicles by year range
    public static void processGetByYearRequest() {
        while (true) {
            try {
                System.out.print("What would be the min year? ");
                int minYear = scanner.nextInt();
                System.out.print("What would be the max year? ");
                int maxYear = scanner.nextInt();

                List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear);

                display(vehiclesByYear);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter year in number format! ⚠----------");
            }
        }
    }

    //method for color
    public static void processGetByColorRequest() {
        while (true) {
            try {
                System.out.println("What color would you like to sort by? ");
                String vehicleColor = scanner.nextLine();

                List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(vehicleColor);

                display(vehiclesByColor);
                break;
            } catch (Exception exception) {
                System.out.println("----------⚠ Please try again! ⚠----------");
            }
        }
    }

    //method for mileage
    public static void processGetByMileageRequest() {
        while (true) {
            try {
                System.out.print("What would be the min mileage? ");
                int minMileage = Integer.parseInt(scanner.nextLine());
                System.out.print("What would be the max mileage? ");
                int maxMileage = Integer.parseInt(scanner.nextLine());

                List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
                display(vehiclesByMileage);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter the mileage in number format! ⚠----------");
            }
        }
    }

    //method for vehicle type
    public static void processGetByVehicleTypeRequest() {
        while (true) {
            try {
                System.out.print("What would be the type of vehicle you are looking for? ");
                String vehicleType = scanner.nextLine();

                List<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);

                display(vehiclesByType);
                break;
            } catch (Exception exception) {
                System.out.println("----------⚠ Please try again! ⚠----------");
            }
        }
    }

    //method for displaying all vehicles
    public static void processGetAllVehicleRequest() {
        display(dealership.getAllVehicles());
    }

    //method for adding vehicles
    public static void processAddVehicleRequest() {
        while (true) {
            try {
                System.out.print("Please enter the vin: ");
                int vehicleVin = Integer.parseInt(scanner.nextLine());

                System.out.print("Please enter the year? ");
                int vehicleYear = Integer.parseInt(scanner.nextLine());

                System.out.print("Please enter the vehicle make: ");
                String vehicleMake = scanner.nextLine();

                System.out.print("Please enter the vehicle model: ");
                String vehicleModel = scanner.nextLine();

                System.out.print("Please enter the vehicle type: ");
                String vehicleType = scanner.nextLine();

                System.out.print("Please enter the vehicle color: ");
                String vehicleColor = scanner.nextLine();

                System.out.print("Please enter the vehicle's odometer: ");
                int vehicleOdometer = Integer.parseInt(scanner.nextLine());

                System.out.print("Please enter the vehicle price: ");
                double vehiclePrice = Double.parseDouble(scanner.nextLine());

                Vehicle addedVehicle = new Vehicle(vehicleVin, vehicleYear, vehicleModel, vehicleMake, vehicleType, vehicleColor, vehicleOdometer, vehiclePrice);
                dealership.addVehicle(addedVehicle);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter valid information! ⚠----------");
            }
        }
    }

    //method for removing vehicles
    public static void processRemoveVehicle() {
        while (true) {
            try {
                System.out.print("Please enter the vin: ");
                int vehicleVin = Integer.parseInt(scanner.nextLine());

                dealership.removeVehicle(vehicleVin);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("----------⚠ Please enter a number! ⚠----------");
            }
        }
    }

    //method for getting the contract type
    public static void contractType(int vin) {
        while (true) {
            try {
                Vehicle isAvalible = dealership.carIsAvalivble(vin);
                System.out.println("""
                        What type of contract would you like to create.
                        1) Sales Contract
                        2) Lease Contract
                        3) Back""");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        createSalesContract(vin, isAvalible);
                        break;
                    case 2:
                        createLeaseContract(vin, isAvalible);
                        break;
                    case 3:
                        userInterface();
                        break;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter your option as a number.");
            }
        }
    }

    //method for Selling a vehicle
    public static void createSalesContract(int vin, Vehicle vehicle) {
        while (true) {
            try {
                boolean finance = true;
                System.out.println("Customers name: ");
                String customerName = scanner.nextLine();
                System.out.println("Customers email: ");
                String customerEmail = scanner.nextLine();
                System.out.println("""
                        Would you like to finance?
                        1) Yes
                        2) No""");
                int option = Integer.parseInt(scanner.nextLine());
                if (option == 2) {
                    finance = false;
                    SalesContract salesContract = new SalesContract(customerName, customerEmail, vehicle, finance);
                    System.out.printf("The Total price for the " + vehicle.getYear() + " " + vehicle.getVehicleModel() + " " + vehicle.getVehicleMake() + " will be:\n Total Price: %.2f\n", salesContract.getTotalPrice());
                    finalizeContract(vin, salesContract);
                    break;

                }
                SalesContract salesContract = new SalesContract(customerName, customerEmail, vehicle, finance);
                System.out.printf("The total Monthly payment and Total price for the " + vehicle.getYear() + " " + vehicle.getVehicleModel() + " " + vehicle.getVehicleMake() + " will be:\n Monthly Payment: %.2f \n Total Price: %.2f\n", salesContract.getMonthlyPayment(), salesContract.getTotalPrice());
                finalizeContract(vin, salesContract);
                break;


            } catch (NumberFormatException ex) {
                System.out.println("Please enter your option as a number");
            }
        }
    }

    //method for leasing vehicles
    public static void createLeaseContract(int vin, Vehicle vehicle) {
        while (true) {
            try {
                System.out.println("Customers name: ");
                String customerName = scanner.nextLine();
                System.out.println("Customers email: ");
                String customerEmail = scanner.nextLine();
                LeaseContract leaseContract = new LeaseContract(customerName, customerEmail, vehicle);
                System.out.printf("The total Monthly payment and Total price for the " + vehicle.getYear() + " " + vehicle.getVehicleModel() + " " + vehicle.getVehicleMake() + " will be:\n Monthly Payment: %.2f \n Total Price: %.2f\n", leaseContract.getMonthlyPayment(), leaseContract.getTotalPrice());
                finalizeContract(vin, leaseContract);
                break;
            } catch (UnsupportedOperationException ex) {
                System.out.println("Something went wrong.\n Please Try Again!");
            }
        }
    }

    //finalize sales contract
    public static void finalizeContract(int vin, Contract contract) {
        if (contract instanceof SalesContract) {
            System.out.println("""
                    Would you like to finalize the contract?
                    1) Yes
                    2) No""");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    ContractFileManager.saveContracts(contract);
                    dealership.removeVehicle(vin);
                    System.out.println("Vehicle Sold!");
                    break;
                case 2:
                    System.out.println("Contract Canceled. Returning to home screen.");
                    userInterface();
                    break;
            }
        }
        if (contract instanceof LeaseContract) {
            System.out.println("""
                    Would you like to finalize the contract?
                    1) Yes
                    2) No""");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    ContractFileManager.saveContracts(contract);
                    dealership.removeVehicle(vin);
                    System.out.println("Vehicle Leased!");
                    break;
                case 2:
                    System.out.println("Contract Canceled. Returning to home screen.");
                    userInterface();
                    break;

            }
        }

    }
    public static void findCar() {
        while (true) {
            try {
                System.out.println("Please enter the Vin number of the car you wish to Create the Contract for: ");
                int vin = Integer.parseInt(scanner.nextLine());
                if (dealership.carIsAvalivble(vin) != null) {
                    contractType(vin);
                    break;
                } else {
                    System.out.println("Car not found.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Enter vin as a number");
            }
        }
    }
}






