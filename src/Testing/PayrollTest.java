package Testing;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import Payroll.Payroll;

public class PayrollTest {
	
	@Test
	public void test1() throws SQLException {
		Connection db =DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccounts", "root", "akamegakill123");//make sure to put your password here
		Payroll prtest1 = new Payroll(db, 12345);	
		double test1 = prtest1.calculateLocalTax("test", 123123, false, "test"); //Parameters don't matter because it takes info from database
		                    //ID 12345 = Ryan     New-York 40000  False   Full-Time
		double test2 = prtest1.calculateFederalTax(false, 40000, "Full-Time"); //Parameters matter
		double test3 = prtest1.calculateTotalTax(test1, test2); //Parameters matter
		double test4 = prtest1.calculateDeductions(test3, 40000, 200, 200); //Parameters matter
		
		//System.out.print(test4);
		
		assertEquals(2532.0, test1, 0); //Local Tax
		assertEquals(4800.0, test2, 0); //Fed Tax
		assertEquals(7332.0, test3, 0); //Total Tax
		assertEquals(32668.0, test4, 0); //Net Pay
	}
	
	@Test
	public void test2() throws SQLException {
		Connection db =DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccounts", "root", "akamegakill123");//make sure to put your password here	
		Payroll prtest2 = new Payroll(db, 54321);
		double test1 = prtest2.calculateLocalTax("New-York", 40000, false, "Full-Time"); //Parameters don't matter because it takes info from database
							//ID 54321 = Jason    New-York   20000  False   Part-Time	
		double test2 = prtest2.calculateFederalTax(false, 20000, "Part-Time"); //Parameters matter
		double test3 = prtest2.calculateTotalTax(test1, test2); //Parameters matter
		double test4 = prtest2.calculateDeductions(test3, 20000, 200, 200); //Parameters matter
		 
		//System.out.print(test3);	
	
		assertEquals(35620.0,test1, 0); //Local Tax
		assertEquals(2400.0, test2, 0); //Fed Tax
		assertEquals(38020.0, test3, 0); //Total Tax
		//assertEquals(---, test4, 0); //No Net Pay because part time
	}
	
	@Test
	public void test3() throws SQLException {
		Connection db =DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccounts", "root", "akamegakill123");//make sure to put your password here
		Payroll prtest3 = new Payroll(db, 9876);
		double test1 = prtest3.calculateLocalTax("New-York", 40000, false, "Full-Time"); //Parameters don't matter because it takes info from database
        					//ID 12345 = Jarrett  New-York   15    False   Part-Time
		double test2 = prtest3.calculateFederalTax(false, 15, "Part-Time"); //Parameters matter
		double test3 = prtest3.calculateTotalTax(test1, test2); //Parameters matter
		double test4 = prtest3.calculateDeductions(test3, 15, 202, 200); //Parameters matter
		//System.out.print(test3);
		assertEquals(15.6,test1, 0); //Local Tax
		assertEquals(1.5, test2, 0); //Fed Tax
		assertEquals(17.1, test3, 0); //Total Tax
		//assertEquals(---, test4, 0); //No Net Pay because part time
	}
	
}
