package DatabaseCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//setters, getters, and database modifications
public class UserAccountDAO {
	
	private Connection db;
	
	public UserAccountDAO(Connection db) {
		this.db = db;
	}
	
	
	public void viewProfile(int ID) throws SQLException { // Displays all information based on the persons ID
		 try
         {
		Statement myStmt = db.createStatement();
			ResultSet myRs = myStmt.executeQuery("Select * from employee WHERE EmployeeID = " + ID);
			
			 while (myRs.next()) {
				  System.out.println(myRs.getString("name") + ", " + myRs.getString("Dob") + ", " + myRs.getString("Hours")+ ", " +myRs.getString("EmployeeID") + ", " + myRs.getString("Position")+ 
						  ", " + myRs.getString("Password") + ", " + myRs.getString("PhoneNum")+ ", " +myRs.getString("Email") + ", " + myRs.getString("Retirement")+ ", " +myRs.getString("HealthInsurance") + ", " + 
						  myRs.getString("Salary")+ ", " +myRs.getString("Admin")+ ", " +myRs.getString("Location"));
			  }
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
	}
	
	 //Employee
    public void addHours(int hours, int ID) throws SQLException {
    	  try
          {
             PreparedStatement stmt = db.prepareStatement("UPDATE employee SET Hours = ? WHERE employeeID = ?");
             stmt.setInt(1, hours);
             stmt.setInt(2, ID);

             stmt.executeUpdate();
          }
          catch(SQLException e)
          {
              e.printStackTrace();
          }
  	}
    

    //Employee
    public void modifyPhoneNumber(String pnum, int ID) throws SQLException {
    	try
        {
           PreparedStatement stmt = db.prepareStatement("UPDATE employee SET PhoneNum = ? WHERE employeeID = ?");
           stmt.setString(1, pnum);
           stmt.setInt(2, ID);

           stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Employee
    public void modifyEmail(String email, int ID) {
    	try
        {
           PreparedStatement stmt = db.prepareStatement("UPDATE employee SET Email = ? WHERE employeeID = ?");
           stmt.setString(1, email);
           stmt.setInt(2, ID);

           stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //Employee
    public void modifyPassword(String pw, int ID) {
    	try
        {
           PreparedStatement stmt = db.prepareStatement("UPDATE employee SET Password = ? WHERE employeeID = ?");
           stmt.setString(1, pw);
           stmt.setInt(2, ID);

           stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //HR
    public void modifyInsurance(String ie, int ID) {
    	try
        {
           PreparedStatement stmt = db.prepareStatement("UPDATE employee SET HealthInsurance = ? WHERE employeeID = ?");
           stmt.setString(1, ie);
           stmt.setInt(2, ID);

           stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    //HR
    public void modifySalary(int sal, int ID) {
    	try
        {
           PreparedStatement stmt = db.prepareStatement("UPDATE employee SET Salary = ? WHERE employeeID = ?");
           stmt.setInt(1, sal);
           stmt.setInt(2, ID);

           stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    //HR
    public void modifyPosition(String pos, int ID) {
    	try
        {
           PreparedStatement stmt = db.prepareStatement("UPDATE employee SET Position = ? WHERE employeeID = ?");
           stmt.setString(1, pos);
           stmt.setInt(2, ID);

           stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    //HR
    public void modifyRetirement(boolean retire, int ID) {
    	try
        {
           PreparedStatement stmt = db.prepareStatement("UPDATE employee SET Retirement = ? WHERE employeeID = ?");
           stmt.setBoolean(1, retire);
           stmt.setInt(2, ID);

           stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    //HR
    public void addAccount() {
    	//jason
    }
    
    //HR
    public void deleteAccount() {
    	//jason
    }
}