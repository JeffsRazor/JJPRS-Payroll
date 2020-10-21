import java.sql.*;
import java.util.Scanner;
public class DatabaseCalls {
    public static void main(String[] args) throws Exception {

        //Create the database connection 
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccounts",
            "root", "MySQLpassword");
           
            //call method
            //allEmployees(conn);
            //manipulateDatabase(conn);
            //changeHours(conn);
            createAccount(conn);
            //deleteAccount(conn);
            //Close the connection to the database
            conn.close();
    }

    //this method will print out every employee in my database with all of their information 
    public static void allEmployees(Connection conn)
    {
        ResultSet rs =null;

        try
        {
            //Create the statement
            Statement stmt = conn.createStatement();

            //Gather the result set.. in other words create the query
            rs= stmt.executeQuery("SELECT * FROM employee");
            
            //Using the result set Print out every field within the database
            while(rs.next())
            {
                int employeeID = rs.getInt("employeeID");
                String employeeName =rs.getString("Name");
                Date dob = rs.getDate("Dob");
                int hours = rs.getInt("Hours");
                String position = rs.getString("Position");
                String password = rs.getString("Password");
                String phoneNum = rs.getString("PhoneNum");
                String email = rs.getString("Email");
                Boolean retirementPlan = rs.getBoolean("Retirement");
                String healthInsurance = rs.getString("HealthInsurance");
                int salary = rs.getInt("Salary");
                Boolean admin = rs.getBoolean("Admin");
                
                //Simply print out all the information
                System.out.println(employeeID + " " + employeeName + " " + dob + " " +
                 hours + " " + position + " " + password + " " +
                 phoneNum + " " + email + " " + retirementPlan + " " +
                 healthInsurance + " " + salary + " " + admin);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    //Change the employee hours
    public static void changeHours(Connection conn)
    {
        Scanner scan= new Scanner(System.in); //System in is standard input stream
        //Enter Employee ID
        System.out.print("Enter the employee ID: ");
        int id = scan.nextInt();
       
        //Enter hours
        System.out.print("Please enter the amount of hours worked: ");
        int hours = scan.nextInt();

        //Close the scanner
        scan.close();
        try
        {
            //Create the Prepared statement
             PreparedStatement stmt = conn.prepareStatement("UPDATE employee SET Hours = ? WHERE employeeID = ?");
             stmt.setInt(1, hours);
             stmt.setInt(2, id);
            
            stmt.executeUpdate();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    }
    
    //Changes position
    public static void changePosition(Connection conn)
    {
        Scanner scan= new Scanner(System.in); //System in is standard input stream
        //Enter Employee ID
        System.out.print("Enter the employee ID: ");
        int id = scan.nextInt();
       
        //Enter Position
        System.out.print("Please enter the Employee Position: ");
        String position = scan.nextLine();

        //Close the scanner
        scan.close();   
        try
        {
            //Create the Prepared statement
             PreparedStatement stmt = conn.prepareStatement("UPDATE employee SET Position = ? WHERE employeeID = ?");
             stmt.setString(1, position);
             stmt.setInt(2, id);
            
            stmt.executeUpdate();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    }
    //Creates a new Account 
    public static void createAccount(Connection conn)
    {
        Scanner scan= new Scanner(System.in); //System in is standard input stream

        //Enter Name
        System.out.print("Enter the employee name: ");
        String name = scan.nextLine();
       
        //Enter Date of birth
        System.out.print("Please enter employee Date of Birth: (yyyy-mm-dd) ");
        String dob = scan.nextLine();
        
        //Enter the Employee ID
        System.out.print("Please enter the Employee ID: ");
        int employeeID = scan.nextInt();
        scan.nextLine(); //needs this to take '/n'

        //Enter Position
        System.out.print("Please enter the Employee Position: ");
        String position = scan.nextLine();

        //Enter the employee Password
        System.out.print("Please enter the employee Password: ");
        String password = scan.nextLine();

        //Employee Phonenumber
        System.out.print("Please enter the Employee Phone number: ");
        String phoneNum = scan.nextLine();
        
        //Enter Email
        System.out.print("Please enter the Employee email: ");
        String email = scan.nextLine();

        //enter Retirement
        System.out.print("Does the Employee have Retirement? (True/False): ");
        Boolean retirement = scan.nextBoolean();
        scan.nextLine(); // Needed to take the '/n'

        //Enter HealthInsurance
        System.out.print("Please enter the HealthInsurance: ");
        String healthInsurance = scan.nextLine();

        //Enter salary
        System.out.print("Please enter the Employee Salary: ");
        int salary = scan.nextInt();

        //Enter Admin
        System.out.print("Is the Employee an admin? (True/False): ");
        Boolean admin = scan.nextBoolean();
        scan.nextLine(); //Needed to take the '/n'

        //Enter Location
        System.out.print("Please enter the Employee Location: ");
        String location = scan.nextLine();


        //Close the scanner
        scan.close();  
        try
        {
            //Create the Prepared statement
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO employee (Name,Dob,EmployeeID,Position,Password,PhoneNum,Email,Retirement, HealthInsurance,Salary,Admin, Location) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
             stmt.setString(1, name);
             stmt.setString(2, dob);
             stmt.setInt(3,employeeID);
             stmt.setString (4, position);
             stmt.setString(5, password);
             stmt.setString(6,phoneNum);
             stmt.setString(7, email);
             stmt.setBoolean(8, retirement);
             stmt.setString(9,healthInsurance);
             stmt.setInt(10, salary);
             stmt.setBoolean(11, admin);
             stmt.setString(12,location);
            stmt.executeUpdate();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    }

    //Delete account
     public static void deleteAccount(Connection conn)
    {   
       

        Scanner scan= new Scanner(System.in); //System in is standard input stream
        //Enter Employee ID
        System.out.print("Enter the employee ID to delete: ");
        int id = scan.nextInt();
        
        //Insure that they want to delete this account
        System.out.println("Are you sure that you want to delete this account? (True/False)");
        Boolean areYouSure = scan.nextBoolean();

        //Close the scanner
        scan.close();

        if(areYouSure)
        {

            try
            {
                //Create the Prepared statement
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM employee WHERE EmployeeID = ?");
                stmt.setInt(1, id);
                stmt.executeUpdate();

                System.out.println("The account was deleted!");
    
            }
            catch(SQLException e)
            {
             e.printStackTrace();
            } 
        }
        else
        {
            System.out.print("The account was NOT deleted");
        } 
    }
}
