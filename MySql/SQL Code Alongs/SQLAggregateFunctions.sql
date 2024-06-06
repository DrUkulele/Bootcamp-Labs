#Aggregate Functions
#Sum, Count, Avg, Min, Max

#How much inventory do we have on hand?
Select Sum(UnitsInStock) As Inventory_On_Hand
From products;

#What is the average price of our products
Select Avg(UnitPrice) As Avg_Price
From products;

#What is the price of the most exspensive product
Select Max(UnitPrice) As Most_Exspensive
From products;

#What is the price of the least exspensive product
Select Min(UnitPrice) As Least_Exspensive
From products;

#How many products do we sell that are beverages? CategoryId 1 means its a beverage
Select Count(ProductID)
From products
Where CategoryID = 1;

#A breakdown of average fright by country
Select Avg(Freight) As Avg_Freight, ShipCountry
From orders
Where ShipCountry In ('Uk', 'Germany', 'Belgium', 'Sweden')
Group By ShipCountry
Having Avg_Freight > 50
Order By Avg_Freight;
