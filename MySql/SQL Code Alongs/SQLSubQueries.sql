#Which products in the product table are above the average price?
Select *
From products
Where UnitPrice > 
(
Select avg(UnitPrice) 
From products
);