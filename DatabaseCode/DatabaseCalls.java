package DatabaseCode;
import java.sql.*;



public class DatabaseCalls {
    public static void main(String[] args) throws Exception {

        //Create the database connection 
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccounts",
            "root", "");
           
            //call method
            //allEmployees(conn);
            manipulateDatabase(conn);
            allEmployees(conn);
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

    public static void manipulateDatabase(Connection conn)
    {
        int id= 12345;
        try
        {
            //Create the statement
             PreparedStatement stmt = conn.prepareStatement("update employee set HealthInsurance = ? where employeeID = ?");
             stmt.setString(1,"Gold");
             stmt.setInt(2,id);
            //Gather the result set.. in other words create the query
            stmt.executeUpdate();
                    
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static String callDB(int id) throws SQLException {
        Connection conn = DatabaseConnection.getDatabase();
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT Password FROM employee WHERE employeeID =" + id );
            rs.next();
            System.out.print(rs);
            s = rs.getString("Password");
            System.out.println(s);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        return s;

        
    }
    
}
