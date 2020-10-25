package DatabaseCode;

import java.sql.Connection;
import java.sql.Date;
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
    public String getPassword(int id) throws SQLException {
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt = db.createStatement();
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

    //Getters get user information from the database 
    public String getName(int id)
    {
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt =  db.createStatement();
            rs = stmt.executeQuery("SELECT Name FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getString("Name");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Date getDob(int id)
    {

        ResultSet rs = null;
        Date s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Dob FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getDate("Dob");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public int getHours(int id)
    {

        ResultSet rs = null;
        int s = 0; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Hours FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getInt("Hours");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getEmployeeID(int id)
    {
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT employeeID FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getString("EmployeeID");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getPosition(int id)
    {
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Position FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getString("Position");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    
    public String getPhoneNum(int id)
    {
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT PhoneNum FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getString("PhoneNum");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getEmail(int id)
    {
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Email FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getString("Email");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Boolean getRetirement(int id)
    {
        ResultSet rs = null;
        Boolean s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Retirement FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getBoolean("Retirement");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getHealthInsurance(int id)
    {
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT HealthInsurance FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getString("HealthInsurance");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public int getSalary(int id)
    {
        ResultSet rs = null;
        int s = 0; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Salary FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getInt("Salary");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Boolean getAdmin(int id)
    {
        ResultSet rs = null;
        Boolean s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Admin FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getBoolean("Admin");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getLocation(int id)
    {
        ResultSet rs = null;
        String s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Location FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getString("Location");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Boolean getStatus(int id)
    {
        ResultSet rs = null;
        Boolean s = null; 
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery("SELECT Status FROM employee WHERE employeeID =" + id );
            rs.next();
            s = rs.getBoolean("Status");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    //End Getters
	
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