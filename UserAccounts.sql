Drop database UserAccounts;
create database UserAccounts;
USE UserAccounts;
create table employee ( 
 Name varchar(50), 
 Dob date,
 Hours integer, 
 EmployeeID varchar(50) PRIMARY KEY,
 Position varchar(50),
 Password varchar(100),
 PhoneNum varchar(15),
 Email varchar(50),
 Retirement Boolean,
 HealthInsurance varchar(50),
 Salary int,
 Admin Boolean,
 Location Varchar(100),
 MaritalStatus Boolean,
 EmploymentStatus varchar(50)
);
INSERT INTO employee (Name,Dob,Hours,EmployeeID,Position,Password,PhoneNum,Email,Retirement, HealthInsurance,Salary,Admin, Location, MaritalStatus, EmploymentStatus) 
values ('Ryan', '1987-10-08', '16', 12345, 'Full-Time', '$2a$16$eNohLyWy6mtBXSxUFOsqOu4PuwhTWO7mKyjqDi0bAw9u/P6M8z9Ge', '7189872653', 'ryanemail@gmail.com', true, 'Gold', 40000, false, 'Connecticut',false, 'Active'); 
INSERT INTO employee (Name,Dob,Hours,EmployeeID,Position,Password,PhoneNum,Email,Retirement,HealthInsurance,Salary,Admin, Location, MaritalStatus, EmploymentStatus) 
values ('Jason', '1950-10-15', '16', 54321, 'Part-Time', '$2a$16$UKUorrnyGagHDmRKC0SDIep8HEBsXMhEa9e6MQOPlM3VWRl7jkTzW', '7182983677', 'jasonemail@gmail.com',false,'Bronze', 40000,false, 'New Jersey',true, 'Active'); 
INSERT INTO employee (Name,Dob,Hours,EmployeeID,Position,Password,PhoneNum,Email,Retirement,HealthInsurance,Salary,Admin, Location, MaritalStatus, EmploymentStatus) 
values ('Jarrett', '1900-10-25', '5', 09876, 'Part-Time', '$2a$16$49zh6HnWhgXEU9d6KurBU.NC31Tlgk91IqSxHQx2FJapY6YMC.b.O', '9175603999', 'jarrettemail@gmail.com',false,'Bronze', 15,true, 'New York',false, 'Active'); 
Select * from employee;
