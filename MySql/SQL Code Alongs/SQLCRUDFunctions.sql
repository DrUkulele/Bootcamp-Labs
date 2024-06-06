#CRUD Create, Read, Update, Delete

#CREATE (Needed-(Name, DataType), Optinal-(Other Information))
Create Table pokemon
(
PokemonId Int auto_increment,
MoveSet Varchar(100) Not NUll,
PokemonType Varchar(10),
Name Varchar(50) Not Null,
HP Int,
IsEvolved bit,
Primary Key (PokemonId)
);

#to put data into a table (Only have to have all non nullable columns)
Insert Into pokemon(MoveSet, PokemonType, Name, HP, IsEvolved)
Values('Blasting things with lightning' , 'Eletric', 'Pikachu', 50, 1),
('Hits things with water', 'Water', 'Squirtle', 65, 0),
('Creeped me out as a kid', 'Psychic', 'MewTwo', 1000, 0); 


#READ
Select *
From products;

#UPDATE
Update products
Set UnitsInStock = 45, UnitsOnOrder = 20
Where ProductID = 1;

#Altering a table(Drop columns)
Alter Table pokemon
Drop column Name;

#(Add columns)
Alter Table pokemon
Add PokemonName Varchar(50);


#DELETE(Hard Delete)
Delete
From customers
Where CustomerID = 'ZODRA';


#Foreign Keys
Create Table authors
(
AuthorID Int auto_Increment,
AuthorName Varchar(100),
Primary Key (AuthorId)
);

Create Table books (
BookID Int auto_increment, 
BookTitle Varchar(255),
AuthorID Int,
Primary Key (BookID),
Foreign Key (AuthorId) References authors(AuthorID)
);

Insert Into authors(AuthorName)
 Values('Isaac Asimov'), ('CiXin Liu'), ('Terry Pratchett');
 
 Insert Into books(BookTitle, AuthorId)
 Values ('Times End', 2);
 
 Delete
 From authors
 Where AuthorID = 3;




