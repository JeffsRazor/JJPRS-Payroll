Drop database UserAccounts;
create database UserAccounts;
USE UserAccounts;
create table employee ( 
 Name varchar(50), 
 Dob date,
 Hours integer, 
 EmployeeID varchar(50) PRIMARY KEY,
 Position varchar(50), 
 Password varchar(50), 
 PhoneNum varchar(15),
 Email varchar(50),
 Retirement Boolean, 
 HealthInsurance varchar(50),
 Salary int, 
 Admin Boolean, 
 Location Varchar(100),
 Status Boolean
);
INSERT INTO employee (Name,Dob,Hours,EmployeeID,Position,Password,PhoneNum,Email,Retirement, HealthInsurance,Salary,Admin, Location,Status) 
values ('Ryan', '1987-10-08', '16', 12345, 'Full-Time', 'abc123', '7189872653', 'ryanemail@gmail.com', true, 'Gold', 40000, false,'New York',false); 
INSERT INTO employee (Name,Dob,Hours,EmployeeID,Position,Password,PhoneNum,Email,Retirement,HealthInsurance,Salary,Admin, Location,Status) 
values ('Jason', '1950-10-15', '16', 54321, 'Part-Time', 'abc321', '7182983677', 'jasonemail@gmail.com',false,'Bronze', 40000,false, 'New York',false); 
INSERT INTO employee (Name,Dob,Hours,EmployeeID,Position,Password,PhoneNum,Email,Retirement,HealthInsurance,Salary,Admin, Location,Status) 
values ('Jarrett', '1900-10-25', '5', 09876, 'Part-Time', 'abc123', '9175603999', 'jarrettemail@gmail.com',false,'Bronze', 15,false, 'New York',false); 
Select * from employee;