package Testing;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import DatabaseCode.UserAccountDAO;

public class DAOTEST {
	@Test
	public void test() throws SQLException{                                                           
		Connection db =DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccounts", "root", "");//make sure to put your password here
		UserAccountDAO dao = new UserAccountDAO(db);
		
		assertEquals("abc123", dao.getPassword(12345));//Password
		assertEquals("Ryan", dao.getName(12345));//Name
		assertEquals("1987-10-08",(dao.getDob(12345)).toString());//Date of Birth
		assertEquals(16, dao.getHours(12345));//Hours
		assertEquals("12345", dao.getEmployeeID(12345));//ID
		assertEquals("Full-Time", dao.getPosition(12345));//Position
		assertEquals("7189872653", dao.getPhoneNum(12345));//Phone Number
		assertEquals("ryanemail@gmail.com", dao.getEmail(12345));//Email
		assertEquals(true, dao.getRetirement(12345));//Retirement 
		assertEquals("Gold", dao.getHealthInsurance(12345));//Health Insurance
		assertEquals(40000, dao.getSalary(12345));//Salary
		assertEquals(true, dao.getAdmin(12345));//Admin
		assertEquals("New York", dao.getLocation(12345));//Location
		assertEquals(false, dao.getMaritalStatus(12345));//Married?
		assertEquals("Active", dao.getEmploymentStatus(12345));//Employed?
	
	}
}
