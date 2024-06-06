# 1. What is the product name(s) of the most expensive products? HINT: Find the max price in a subquery and then use that value to find products whose price equals that value.
Select products.ProductName
From products
Where UnitPrice =
(
Select Max(UnitPrice)
From products
);

# 2. What is the order id, shipping name and shipping address of all orders shipped via "Federal Shipping"? HINT: Find the shipper id of "Federal Shipping" in a subquery and then use that value to find the orders that used that shipper.
Select orders.OrderID, orders.ShipName, orders.ShipAddress
From orders
Where ShipVia = 
(
Select shippers.ShipperID
From shippers
Where shippers.CompanyName = "Federal Shipping"
);

# 3. What are the order ids of the orders that ordered "Sasquatch Ale"? HINT: Find the product id of "Sasquatch Ale" in a subquery and then use that value to find the matching orders from the order details` table. 
# Because the `order details table has a space in its name, you will need to surround it with back ticks in the FROM clause.
Select `order details`.OrderID
From `order details`
Where `order details`.ProductID = 
(
Select products.ProductId
from products
Where products.ProductName = "Sasquatch Ale"
);

# 4. What is the name of the employee that sold order 10266?
Select employees.FirstName, employees.LastName
From employees
Where EmployeeID = 
(
Select orders.EmployeeID
From orders
Where orders.OrderID = '10266'
);

# 5. What is the name of the customer that bought order 10266?
Select customers.CompanyName
From customers
Where customers.CustomerID = 
(
Select orders.CustomerID
From orders
Where orders.OrderID = '10266'
);





