#-------------------#
# Database Creation #
#-------------------#
Create Database cardealership;
Use cardealership;

#----------------#
# Table Creation #
#----------------#

#Dealership Table
Create Table dealerships
(
DealershipID Int Auto_Increment,
Name Varchar(50),
Address Varchar(50),
Phone Varchar(12),
Primary Key (DealershipID)
);

#Vehicles Table
Create Table vehicles
(
VehicleVin Int,
Year Int,
Make Varchar(30),
Model Varchar(30),
Type Varchar(20),
Color Varchar (50),
Odometer Int,
Price Double,
Sold Bit Not Null,
Primary Key (VehicleVin)
);

#Inventory Table
Create Table inventory
(
DealershipID Int,
VehicleVin Int,
Foreign Key (DealershipId) References dealerships (DealershipID),
Foreign Key (VehicleVin) References vehicles (VehicleVin)
);

#Sales Contract Table
Create Table salescontracts
(
SalesContractID Int Auto_Increment,
SalesTax Decimal Not Null, 
RecordingFee Decimal Default 100, 
ProcessingFee Decimal Not Null,
Finance bit Not Null,
IntrestRate Decimal,
MonthlyPayment Decimal,
DateFinalized DateTime Not Null,
VehicleVin Int,
Primary Key (SalesContractID),
Foreign Key (VehicleVin) References vehicles (VehicleVin)
);
    
#Lease Contract Table    
Create Table leasecontracts
(
LeaseContractId Int Auto_Increment,
vehiclePrice Decimal Not Null,
LeaseFee Decimal Not Null,
IntrestRate Decimal Default 0.04,
LeaseTerm Decimal,
DateFinalized DateTime Not Null,
VehicleVin Int,
Primary Key (LeaseContractID),
Foreign Key (VehicleVin) References vehicles (VehicleVin)
);

#------------------------------#
# Table Sample Data Population #
#------------------------------#

#Dealership Table
INSERT INTO dealerships (Name, Address, Phone) 
VALUES
('ABC Motors', '123 Main St', '123-456-7890'),
('XYZ Autos', '456 Elm St', '987-654-3210'),
('123 Car Sales', '789 Oak St', '555-123-4567'),
('Best Wheels', '321 Maple St', '111-222-3333');

#Vehicles Table
INSERT INTO vehicles (VehicleVin, Year, Make, Model, Type, Color, Odometer, Price, Sold)
VALUES
(123456789, 2022, 'Toyota', 'Camry', 'Sedan', 'Blue', 5000, 25000.00, 0),
(987654321, 2020, 'Honda', 'Civic', 'Sedan', 'Red', 8000, 20000.00, 1),
(456789123, 2021, 'Ford', 'F-150', 'Truck', 'Black', 10000, 35000.00, 0),
(789123456, 2019, 'Chevrolet', 'Silverado', 'Truck', 'White', 12000, 30000.00, 1),
(135792468, 2018, 'BMW', 'X5', 'SUV', 'Silver', 15000, 40000.00, 0),
(246813579, 2017, 'Mercedes-Benz', 'C-Class', 'Sedan', 'Gray', 20000, 30000.00, 1),
(369258147, 2016, 'Audi', 'Q5', 'SUV', 'Black', 18000, 35000.00, 0),
(987654123, 2023, 'Ford', 'Mustang', 'Coupe', 'Yellow', 4000, 45000.00, 1),
(987123456, 2021, 'Chevrolet', 'Malibu', 'Sedan', 'Blue', 7000, 28000.00, 0),
(654987321, 2020, 'Toyota', 'RAV4', 'SUV', 'White', 9000, 32000.00, 1),
(123789456, 2019, 'Honda', 'Accord', 'Sedan', 'Black', 11000, 27000.00, 0),
(456321789, 2018, 'Nissan', 'Altima', 'Sedan', 'Red', 13000, 25000.00, 1),
(987321654, 2017, 'Kia', 'Sorento', 'SUV', 'Green', 17000, 30000.00, 0),
(741852963, 2016, 'Hyundai', 'Elantra', 'Sedan', 'Silver', 19000, 22000.00, 1),
(369147258, 2015, 'Subaru', 'Outback', 'SUV', 'Blue', 21000, 28000.00, 0),
(258369147, 2022, 'Mazda', 'CX-5', 'SUV', 'Gray', 3000, 33000.00, 1),
(159632487, 2020, 'GMC', 'Sierra', 'Truck', 'White', 8000, 38000.00, 0),
(789456123, 2019, 'Ram', '1500', 'Truck', 'Red', 10000, 35000.00, 1),
(852369741, 2018, 'Jeep', 'Wrangler', 'SUV', 'Black', 12000, 32000.00, 0),
(963258741, 2017, 'Ford', 'Escape', 'SUV', 'Silver', 14000, 29000.00, 1);

#Inventory Table
INSERT INTO inventory (DealershipId, VehicleVin) 
VALUES
(1, 123456789),
(2, 987654321),
(3, 456789123),
(4, 789123456),
(1, 135792468),
(2, 246813579),
(3, 369258147),
(4, 987654123),
(1, 987123456),
(2, 654987321),
(3, 123789456),
(4, 456321789),
(1, 987321654),
(2, 741852963),
(3, 369147258),
(4, 258369147),
(1, 159632487),
(2, 789456123),
(3, 852369741),
(4, 963258741);

#Sales Contract Table
INSERT INTO salescontracts (SalesTax, RecordingFee, ProcessingFee, Finance, IntrestRate, MonthlyPayment, DateFinalized, VehicleVin) 
VALUES
(0.07, 100, 150, 1, 0.05, 500.00, '2024-05-07 11:00:00', 123456789),
(0.08, 100, 200, 0, NULL, NULL, '2024-06-08 01:00:00', 987654321),
(0.06, 100, 180, 1, 0.04, 450.00, '2024-08-09 12:00:00', 456789123),
(0.07, 100, 150, 0, NULL, NULL, '2024-09-10 08:00:00', 789123456),
(0.08, 100, 200, 1, 0.06, 550.00, '2024-10-11 06:00:00', 135792468);

#Lease Contract Table   
INSERT INTO leasecontracts (vehiclePrice, LeaseFee, LeaseTerm, DateFinalized, VehicleVin) VALUES
(25000.00, 400.00, 36, '2024-05-07 12:00:00', 987654123),
(20000.00, 350.00, 24, '2024-06-08 02:00:00', 654987321),
(35000.00, 500.00, 48, '2024-08-09 01:00:00', 123789456),
(30000.00, 450.00, 36, '2024-09-10 09:00:00', 456321789),
(40000.00, 600.00, 48, '2024-10-11 07:00:00', 987321654);

#--------------#
# Test Queries #
#--------------#

# 1. Get all dealerships
Select *
From dealerships;

# 2. Find all vehicles for a specific dealership
Select *
From vehicles
Join inventory ON vehicles.VehicleVin = inventory.VehicleVin
Having inventory.DealershipId = 1;

# 3. Find a car by VIN
Select *
From vehicles
Where VehicleVin = 123456789;

# 4. Find the dealership where a certain car is located, by VIN
Select *
From dealerships
Join inventory On dealerships.DealershipID = inventory.DealershipID
Join vehicles On inventory.VehicleVin = vehicles.VehicleVin
Having vehicles.VehicleVin = 123456789;

# 5. Find all Dealerships that have a certain car type (i.e. Red Ford Mustang)
Select *
From dealerships
Join inventory On dealerships.DealershipID = inventory.DealershipID
Join vehicles On inventory.VehicleVin = vehicles.VehicleVin
WHERE vehicles.Color = 'Blue' AND vehicles.Make = 'Toyota' AND vehicles.Model = 'Camry' AND vehicles.Type = 'Sedan';

# 6. Get all sales information for a specific dealer for a specific date range
SELECT *
FROM dealerships
JOIN inventory ON inventory.DealershipID = dealerships.DealershipID
LEFT JOIN leasecontracts ON inventory.VehicleVin = leasecontracts.VehicleVin
LEFT JOIN salescontracts ON inventory.VehicleVin = salescontracts.VehicleVin
WHERE dealerships.DealershipID = 1
AND ((leasecontracts.DateFinalized BETWEEN '2024-05-07' AND '2024-10-11') OR (salescontracts.DateFinalized BETWEEN '2024-05-07' AND '2024-10-11'))
AND (leasecontracts.VehicleVin IS NOT NULL OR salescontracts.VehicleVin IS NOT NULL);














