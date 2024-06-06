#Orders table is the left Column
Select orders.OrderID, employees.EmployeeID, employees.FirstName, employees.LastName, customers.CompanyName
From orders
Join employees On Orders.EmployeeID = Employees.EmployeeId
Join customers on Orders.CustomerID = Customers.CustomerId;

#Which customers do we have that don't have any orders?
Select Orders.OrderId, Orders.CustomerId, Customers.CustomerId
From customers
Left Join Orders on Customers.CustomerId = Orders.CustomerId
Where Orders.OrderId is Null;
