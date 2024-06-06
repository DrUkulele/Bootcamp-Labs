/*Warmup Question 1: List Orders with Customer Names
Question:
Write a SQL query to list the OrderID, OrderDate, and CompanyName of the customer who placed each order. Use an inner join to combine the Orders and Customers tables.*/
Select orders.OrderId, orders.OrderDate, customers.CompanyName
From orders
Join customers On orders.CustomerID = customers.CustomerID;

/*Warmup Question 2: List Products with Supplier Names
Question:
Write a SQL query to list the ProductName and the CompanyName of the supplier for each product. Use an inner join to combine the Products and Suppliers tables.*/
Select products.ProductName, suppliers.CompanyName
from products
Join suppliers On products.SupplierID = suppliers.SupplierID;

/*Warmup Question 3: List Employees with Orders Over $1000
Question:
Write a SQL query to list the EmployeeID, LastName, and OrderID for orders where the total order amount (Freight) is greater than $100. */
Select orders.OrderID, employees.EmployeeID, employees.LastName
From orders 
Join employees On orders.EmployeeID = employees.EmployeeID
Where orders.Freight > 100;