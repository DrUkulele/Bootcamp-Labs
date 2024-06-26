# 1. Write a SQL query to select all columns from the Customers table.
Select *
From customers;

# 2. Write a SQL query to select only the CompanyName and ContactName from the Customers table.
Select CompanyName, ContactName
From customers; 

# 3. Write a SQL query to find all distinct Country values in the Customers table.
Select Distinct(Country)
From customers;

# 4. Write a SQL query to find all customers from the Customers table who are from the UK.
Select *
From customers
Where Country = 'UK';

# 5. Write a SQL query to list all orders from the Orders table where the Freight is between 50 and 100.
Select *
From orders
Where Freight 
Between 50 And 100;

# 6. Write a SQL query to find all orders from the Orders table where the OrderDate is after '1997-01-01' AND the ShipCountry is either 'USA' or 'Canada'.
SELECT *
FROM Orders
WHERE OrderDate > '1997-01-01' 
AND ShipCountry IN ('USA', 'Canada');

# 7. Write a SQL query to display orders from the Orders table where the ShipCountry is in ('France', 'Belgium', 'Germany').
Select *
From orders
Where ShipCountry
In ('France', 'Belgium', 'Germany');

# 8. Write a SQL query to select all products from the Products table with a UnitPrice between 10 and 20.
Select *
From products
Where UnitPrice
Between 10 And 20;

# 9. Write a SQL query to select all suppliers from the Suppliers table and order them by Country in ascending order.
Select *
From suppliers
Order By Country;

# 10. Write a SQL query to list all customers from the Customers table and sort them by ContactName in descending order.
Select *
From customers
Order By ContactName Desc;

# 11. Ask students to identify the data types of columns in the Employees table.


# 12. Write a SQL query to find all orders in the Orders table where the OrderDate is '1996-07-04'.
Select *
From orders
Where OrderDate = '1996-07-04';

#These two questions you will need to do by hand, no query

# 13. Find the CompanyName of all customers who placed an order with OrderID '10248'. Use the 'Orders' table to find the CustomerID, 
#and then use this ID in the 'Customers' table to find the corresponding CompanyName.

/* CustomerID: 'VINET' CompanyName: 'Vins et alcools Chevalier'*/



# 14. Identify the ProductName for the product with ProductID '11'. First, find the ProductID in the 'Order Details' table for any order, 
#and then use this ID in the 'Products' table to find the corresponding ProductName.

/* ProductName: 'Queso Cabrales'*/
