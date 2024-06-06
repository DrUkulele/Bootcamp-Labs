# 1. How many suppliers are there? Use a query!
Select Count(SupplierID)
From suppliers;

# 2. What is the sum of all the employee's salaries?
Select Sum(Salary)
From employees;

# 3. What is the price of the cheapest item that Northwind sells?
Select Min(UnitPrice)
From products;

# 4. What is the average price of items that Northwind sells?
Select Avg(UnitPrice)
From products;

# 5. What is the price of the most expensive item that Northwind sells?
Select Max(UnitPrice)
From products;

# 6. What is the supplier ID of each supplier and the number of items they supply? You can answer this query by only looking at the Products table.
Select SupplierId, Count(ProductId) As Num_Items_Supplied
From products
group By SupplierID;

# 7. What is the category ID of each category and the average price of each item in the category? You can answer this query by only looking at the Products table.
Select CategoryId, Avg(UnitPrice) As Avg_UnitPrice
From products
Group By CategoryID;

# 8. For suppliers that provide at least 5 items to Northwind, what is the supplier ID of each supplier and the number of items they supply? You can answer this query by only looking at the Products table.
Select SupplierId, Count(ProductId) As Num_Items_Supplied
From products
Group By SupplierID
Having Num_Items_Supplied >= 5;

# 9. List the product id, product name, and inventory value (calculated by multiplying unit price by the number of units on hand). Sort the results in descending order by value. If two or more have the same value, order by product name.
Select ProductId, ProductName, UnitPrice * UnitsInStock As InventoryValue
From products
Order By InventoryValue Desc, ProductName;

