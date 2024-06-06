# 1. List the product id, product name, unit price and category name of all products. Order by category name and within that, by product name.
Select products.ProductID, products.ProductName, products.UnitPrice, categories.CategoryName
From products
Join categories On products.CategoryID = categories.CategoryID
Order By CategoryName, ProductName;

# 2. List the product id, product name, unit price and supplier name of all products that cost more than $75. Order by product name.
Select products.ProductID, products.ProductName, products.UnitPrice, suppliers.CompanyName
From products
Join suppliers On products.SupplierID = suppliers.SupplierID
Where products.UnitPrice > 75
Order By products.ProductName;

# 3. List the product id, product name, unit price, category name, and supplier name of every product. Order by product name.
Select products.ProductID, products.ProductName, products.UnitPrice, categories.CategoryName, suppliers.CompanyName
From products
Join categories On products.CategoryID = categories.CategoryID
Join suppliers On products.SupplierID = suppliers.SupplierID
Order By products.ProductName;

# 4. What is the product name(s) and categories of the most expensive products? HINT: Find the max price in a subquery and then use that in your more complex query that joins products with categories.
Select products.ProductName, categories.CategoryName
From products
Join categories On products.CategoryID = categories.CategoryID
Where products.UnitPrice = 
(
Select max(products.UnitPrice)
From products
);

# 5. List the order id, ship name, ship address, and shipping company name of every order that shipped to Germany.
Select orders.OrderID, orders.ShipName, orders.ShipAddress, shippers.CompanyName 
From orders
Join shippers On orders.ShipVia = shippers.ShipperID
Where orders.ShipCountry = 'Germany';

# 6. List the order id, order date, ship name, ship address of all orders that ordered "Sasquatch Ale"?
Select orders.OrderID, orders.OrderDate, orders.ShipName, orders.ShipAddress
from orders
Join `order details` On orders.OrderID  = `order details`.OrderID
Join products On `order details`.ProductID = products.ProductID
Where products.ProductName = 'Sasquatch Ale';




