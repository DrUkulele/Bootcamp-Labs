# 1. Add a new supplier.
Insert Into suppliers(CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax)
Values('Ty Inc.', 'Tyler Priest', 'CEO', '123 Somewhere ST.', 'Nowhere', 'TX', '12345', 'USA', '123-456-7890', '098-765-4321');  

# 2. Add a new product provided by that supplier 
Insert Into products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
Values('Stuff', 30, 1, '20', 120.00, 200, 0, 0, 1);

#3. List all products and their suppliers.
Select products.ProductName, suppliers.CompanyName
From products
Join suppliers On products.SupplierId = suppliers.SupplierId;

# 4. Raise the price of your new product by 15%.
Update products
Set UnitPrice = UnitPrice + (UnitPrice * .15)
Where products.productID = 78;


# 5. List the products and prices of all products from that supplier.
Select products.ProductName, products.UnitPrice
From products
Where products.SupplierID = 30; 

# 6. Delete the new product.
Delete
From products
Where products.SupplierID = 30;

# 7. Delete the new supplier.
Delete
From suppliers
Where suppliers.SupplierId = 30;

# 8. List all products.
Select * 
From products;

# 9. List all suppliers.
Select *
From suppliers;