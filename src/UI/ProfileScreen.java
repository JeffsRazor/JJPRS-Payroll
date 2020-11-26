package UI;
import java.awt.*;
import java.sql.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonListener;

import Employee.*;
import DatabaseCode.*;
public class ProfileScreen implements ActionListener {


	private static JFrame frame;

    private static JLabel title, name,dob, hours,employeeId, 
    						position, phoneNum, email, retirementLabel, 
    							healthInsurance, salary, admin, location, status, image;
    private static JPanel panel1;
    private static Employee emp;
    private static ImageIcon icon;
    private static Connection db;
    private static JButton goBack;
    
    
    public static void createProfile(Connection db, Employee emp, int id) {
    	frame = new JFrame();
        frame.setSize(270, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        title = new JLabel("Welcome, " + emp.getName());
        title.setBounds(0, 0, 300, 25);
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        
        
     
        name = new JLabel("Employee Name: " + emp.getName());
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setBounds(300, 0, 300, 25);
        panel1.add(name);
       
        
        Date date = emp.getDob();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateHolder = dateFormat.format(date);
        
        dob = new JLabel("Date of Birth: " + dateHolder);
        dob.setFont(new Font("Serif", Font.BOLD, 20));
        dob.setBounds(300, 0, 300, 25);
        panel1.add(dob);
       
        System.out.println("yeet");
        
        hours = new JLabel("Hours: " + Integer.toString(emp.getHours()));
        hours.setFont(new Font("Serif", Font.BOLD, 20));
        hours.setBounds(300, 0, 300, 25);
        panel1.add(hours);
       
        
        employeeId = new JLabel("Employee ID: " + emp.getEmployeeID());
        employeeId.setFont(new Font("Serif", Font.BOLD, 20));
        employeeId.setBounds(300, 0, 300, 25);
        panel1.add(employeeId);
        
        
        position= new JLabel("Position: " + emp.getPosition());
        position.setFont(new Font("Serif", Font.BOLD, 20));
        position.setBounds(300, 0, 300, 25);
        panel1.add(position);
        
        
        phoneNum = new JLabel("Phone Number: " + emp.getPhoneNum());
        phoneNum.setFont(new Font("Serif", Font.BOLD, 20));
        phoneNum.setBounds(300, 0, 300, 25);
        panel1.add(phoneNum);
       
        
        email = new JLabel("Email: " + emp.getEmail());
        email.setFont(new Font("Serif", Font.BOLD, 20));
        email.setBounds(300, 0, 300, 25);
        panel1.add(email);
         
        
        String retirement=" ";
        
        if (emp.isRetirement()) {
        	retirement = "401k ";
        }
        else {
        	retirement = "No plan";
        }
        
        retirementLabel = new JLabel("Retirement PlanStatus: " +  retirement);
        retirementLabel.setFont(new Font("Serif", Font.BOLD, 20));
        retirementLabel.setBounds(300, 0, 300, 25);
        panel1.add(retirementLabel);
        frame.add(panel1);
        frame.setVisible(true);
        
        healthInsurance = new JLabel("Health Insurance: " + emp.getHealthInsurance());
        healthInsurance.setFont(new Font("Serif", Font.BOLD, 20));
        healthInsurance.setBounds(300, 0, 300, 25);
        panel1.add(healthInsurance);
        frame.add(panel1);
        frame.setVisible(true);
        
        salary = new JLabel("Salary: " + Integer.toString(emp.getSalary()));
        salary.setFont(new Font("Serif", Font.BOLD, 20));
        salary.setBounds(300, 0, 300, 25);
        panel1.add(salary);
        frame.add(panel1);
        frame.setVisible(true);
        
        
        String isAdmin=" ";
        
        if (emp.isAdmin()==true) {
        	isAdmin = "Admin";
        }
        else {
        	isAdmin = "Employee";
        }
        
        admin = new JLabel("Admin Privleges: " + isAdmin);
        admin.setFont(new Font("Serif", Font.BOLD, 20));
        admin.setBounds(300, 0, 300, 25);
        panel1.add(admin);
        frame.add(panel1);
        frame.setVisible(true);
        
        location = new JLabel("Location: " + emp.getLocation());
        location.setFont(new Font("Serif", Font.BOLD, 20));
        location.setBounds(300, 0, 300, 25);
        panel1.add(location);
        frame.add(panel1);
        frame.setVisible(true);
        
        String currentStatus=" ";
        if (emp.isStatus()==true) {
        	currentStatus="Married";
        }
        else {
        	currentStatus="Single";
        }
        
        status = new JLabel("Status: " + currentStatus);
        status.setFont(new Font("Serif", Font.BOLD, 20));
        status.setBounds(300, 0, 300, 25);
        panel1.add(status);

        goBack = new JButton("Return to employee dashboard");
        goBack.setBounds(50, 50, 75, 25);
        goBack.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {
           EmployeeDashboard.createDashboard(db,id);
           frame.dispose();
          }
        });

        panel1.add(goBack);
        icon = new ImageIcon("src/JJRPSLOGO.png");
       image = new JLabel(icon);
       image.setBounds(10, 180, 300, 300);
       panel1.add(image);
        frame.add(panel1);
        frame.setVisible(true);
        
        
    }
	
    @Override
	public void actionPerformed (ActionEvent e) {
		
	}
}
