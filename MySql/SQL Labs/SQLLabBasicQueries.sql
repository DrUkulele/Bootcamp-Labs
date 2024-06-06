#1. What is the name of the table that holds the items Northwind sells?
SELECT * 
FROM northwind.products;

/*2. Write a query to list the product id, product name, and unit price of every product.
2-33*/
Select ProductID, ProductName, UnitPrice
From products;

#3. Write a query to list the product id, product name, and unit price of every product. Except this time, order then in ascending order by price.
Select ProductID, ProductName, UnitPrice
From products
Order By UnitPrice;

#4. What are the products that we carry where the unit price is $7.50 or less? 
Select *
From products
Where UnitPrice <= '7.50';

#5. What are the products that we carry where we have at least 100 units on hand? Order them in descending order by price.
Select *
From products
Where UnitsInStock >= 100
Order By UnitPrice Desc;

#6. What are the products that we carry where we have at least 100 units on hand? Order them in descending order by price. If two or more have the same price, list those in ascending order by product name.
Select *
From products
Where UnitsInStock >= 100
Order By UnitPrice Desc, ProductName;

#7. What are the products that we carry where we have no units on hand, but 1 or more units of them on backorder? Order them by product name.
Select *
From products
Where UnitsInStock = 0 And UnitsOnOrder >= 1
Order By ProductName;

#8. What is the name of the table that holds the types (categories) of the items Northwind sells?
Select *
From categories;

#9. Write a query that lists all of the columns and all of the rows of the categories table? What is the category id of seafood?
Select *
From categories;

Select *
From categories
Where CategoryID = 8;

#10.Examine the Products table. How does it identify the type (category) of each item sold? Write a query to list all of the seafood items we carry.
Select *
From products
Where CategoryID;

Select *
From products
Where CategoryID = 8;

#11. What are the first and last names of all of the Northwind employees? 
Select FirstName, LastName 
From employees;

#12. What employees have "manager" in their titles?
Select *
From employees
Where Title Like '%Manager%';

#13.List the distinct job titles in employees.
Select Distinct(Title)
From employees;

#14. What employees have a salary that is between $2000 and $2500?
Select *
From employees
Where Salary Between '2000' And '2500'; 

#15.List all of the information about all of Northwind's suppliers.
Select *
from suppliers;

/*16.Examine the Products table. How do you know what supplier supplies
each product? Write a query to list all of the items that "Tokyo Traders" supplies to Northwind*/
Select * 
From products
Where SupplierID;

Select *
From products
Where SupplierID = 4;


