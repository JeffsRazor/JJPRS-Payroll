# JJRPS 
This project contains the code for a payroll system.
# Contributors
Jarrett, Jason, Patrick, Ryan, Serhan 
# Folders
The code used for this project is java.
The src folder contains all the code used in this project.
-Database code 
Connect to mysql database with these.
-Employee
Sets and gets for employee information.
-Payroll
Math for calculating taxes and the such.
-UI
UI for each option in the payroll system.
-Main
Main function for the payroll system.
-org/mindrot/jbcrypt
Password hashing
# Installation
1) clone repository
2) make database using mysql
3) connect using database connector in the Database code folder
```java
public class DatabaseConnection {

	public static Connection getDatabase() throws SQLException {
		 return DriverManager.getConnection("jdbc:mysql://localhost:3306/---", replace --- to whatever your database is called in mysql
		 "root", " "); //Add password between the " " with the one you made when setting up mysql 
	}

}
``` 
