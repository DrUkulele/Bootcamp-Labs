# 1. Retrieve all the columns from the Customers table for customers who are from the UK.
Select *
From customers
Where Country = 'UK';

# 2. Using the Products table, list the product names and their unit prices where the unit price is greater than 30.
Select ProductName, UnitPrice
From products
Where UnitPrice > 30;

# 3. Count the number of products in the Products table that have been discontinued.
Select count(Discontinued) As ProductsDiscontinued
From products
Where Discontinued = 1;

# 4. Find the average, maximum, and minimum unit prices from the Products table.
Select Avg(UnitPrice) As AvgPrice, Max(UnitPrice) As MAxPrice, Min(UnitPrice) As MinPrice
From products;

# 5. Retrieve the names of categories and the count of products in each category from the Categories and Products tables.
Select categories.CategoryName, Count(products.ProductID) As ProductCount
From categories
Join products On categories.CategoryID = products.CategoryID
Group by categories.CategoryName;

# 6. List the suppliers (SupplierID and CompanyName) from the Suppliers table who are not from USA, Germany, or UK.
Select supplierId, CompanyName
From suppliers
Where Country Not In('Usa', 'Germany', 'UK');

# 7. Retrieve all the distinct countries from the Customers table.
Select Distinct(Country)
From customers;

# 8. Find the top 5 most expensive products (Product name and Unit price) from the Products table.
Select ProductName, UnitPrice
From products
Order By UnitPrice Desc
Limit 5;

# 9. Using the Orders and Order Details tables, calculate the total revenue for each order (OrderID).
Select `Order Details`.OrderID, Sum(UnitPrice * Quantity)
From `Order Details`
Group By `order details`.OrderID;

# 10. List all employees (FirstName and LastName) and the count of orders they have taken from the Employees and Orders tables.
Select employees.FirstName, employees.LastName, count(orders.EmployeeID) As OrdersTaken
From orders
Join employees On orders.EmployeeID = employees.EmployeeID
Group By employees.EmployeeID;

# 11. Retrieve customers (CustomerID and CompanyName) who have placed more than 10 orders using the Customers and Orders tables.
SELECT Customers.CustomerID, Customers.CompanyName
FROM Customers
JOIN Orders ON Customers.CustomerID = Orders.CustomerID
GROUP BY Customers.CustomerID, Customers.CompanyName
HAVING COUNT(Orders.OrderID) > 10;

# 12. From the Products table, retrieve the names of products that are out of stock (units in stock is 0).
Select ProductName
From products
Where UnitsInStock = 0;

# 13. Using the Products and Categories tables, list the names of products and their respective categories where the category is either 'Beverage' or 'Confectionery'.
Select products.ProductName, categories.CategoryName
From products
Join categories On products.CategoryID = categories.CategoryID
Where categories.CategoryName In ('Beverages', 'Confections');

# 14. Identify which supplier (SupplierID and CompanyName from Suppliers table) has the highest number of products in the Products table.
Select products.SupplierID, suppliers.CompanyName
From products
Join suppliers On products.SupplierID = suppliers.SupplierID
Group by products.SupplierID, suppliers.CompanyName
Order By count(products.SupplierID) Desc
Limit 1;

#15. List all the products (ProductID and ProductName) which have never been ordered. Use the Products and Order Details tables.
Select products.ProductID, products.ProductName
From products
Left Join `order details` On products.ProductID = `order details`.ProductID
Where `order details`.ProductID Is Null;

# 16. Retrieve all orders (OrderID from Orders table) that were placed in December 1997.
Select OrderID
From orders
WHERE YEAR(OrderDate) = 1997 AND MONTH(OrderDate) = 12;

# 17. Using the Employees and Orders tables, find out which employee has processed the most number of orders in 1998.
Select employees.EmployeeID, employees.FirstName, employees.LastName
From employees
Join orders On employees.EmployeeID = orders.EmployeeID
Where Year(OrderDate) = 1998
Group By employees.EmployeeID, employees.FirstName, employees.LastName 
Order By count(orders.EmployeeID) Desc
Limit 1;

# 18. Find the customer (CustomerID and CompanyName from Customers table) who has purchased the most by quantity in the Order Details table.
Select customers.CustomerID, customers.CompanyName
From customers
Join orders On customers.CustomerID = orders.CustomerID
Join `order details` On orders.OrderID = `order details`.OrderID
Group by customers.CustomerID, customers.CompanyName
Order By count(`order details`.Quantity) Desc
Limit 1;

# 19. From the Shippers and Orders tables, determine which shipper has delivered the most number of orders.
Select shippers.CompanyName
From shippers
Join orders On shippers.ShipperID = orders.ShipVia
Group by shippers.CompanyName
Order by count(orders.ShipVia) Desc
Limit 1;

# 20. Identify the top 3 categories in terms of the number of products they have using the Categories and Products tables
Select categories.CategoryName
From categories
Join products On categories.CategoryID = products.CategoryID
Group By categories.CategoryName 
Order By count(products.CategoryID) Desc
Limit 3;