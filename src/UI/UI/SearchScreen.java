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
import javax.swing.Icon;
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

import DatabaseCode.UserAccountDAO;
import Employee.Employee;

public class SearchScreen implements ActionListener {

	private static JLabel findId, ask;
	private static JTextField idText;
	private static JLabel passwordLabel, image;
	private static JPasswordField passwordField;
	private static JButton button, goBack;
	private static JLabel loginSucess;
	private static JLabel title;
	private static JFrame frame;
	private static JPanel panel1;
	private UserAccountDAO dao;
	private static Connection logindb;
	private static ImageIcon icon;
	private static JLabel name, position, phoneNum, email,location;
    private static EmployeeDashboard employeeDashboard = new EmployeeDashboard();
	
	public static void createDashboard(Connection db, int id, Employee emp) {
	
		
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		ask = new JLabel("Employee Searcher");
		ask.setFont(ask.getFont().deriveFont(20f));
		panel1.add(ask);
		
		idText = new JTextField("Enter Employee ID Here", 20);
		idText.setBounds(100, 50, 165, 25);
		panel1.add(idText);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 70, 165, 25);
		
		button = new JButton("Submit");
		button.setSize(400, 180);
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String iD = idText.getText();
			int ID = Integer.parseInt(iD);
			Employee employeeHolder = new Employee (db,ID);//Employee Id Hold
			try {
				name = new JLabel("Employee Name: " + employeeHolder.getName());
		        name.setFont(new Font("Serif", Font.BOLD, 20));
		        name.setBounds(300, 0, 300, 25);
		        panel1.add(name);
		        
		        phoneNum = new JLabel("Phone Number: " + employeeHolder.getPhoneNum());
		        phoneNum.setFont(new Font("Serif", Font.BOLD, 20));
		        phoneNum.setBounds(300, 0, 300, 25);
		        panel1.add(phoneNum);
		        
		        email = new JLabel("Email: " + employeeHolder.getEmail());
		        email.setFont(new Font("Serif", Font.BOLD, 20));
		        email.setBounds(300, 0, 300, 25);
		        panel1.add(email);
		        
		        position= new JLabel("Position: " + employeeHolder.getPosition());
		        position.setFont(new Font("Serif", Font.BOLD, 20));
		        position.setBounds(300, 0, 300, 25);
		        panel1.add(position);
		        
		        location = new JLabel("Location: " + employeeHolder.getLocation());
		        location.setFont(new Font("Serif", Font.BOLD, 20));
		        location.setBounds(300, 0, 300, 25);
		        panel1.add(location);
		        frame.add(panel1);
		        frame.setVisible(true);
		       
								
			}catch(Exception a){
				System.out.println("yeeet");
			}
			
		}
		});
		panel1.add(button);
		
		goBack = new JButton("Return to employee dashboard");
		goBack.setSize(400, 180);
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				employeeDashboard.createDashboard(db, id);
				frame.dispose();
			}
		});
		panel1.add(goBack);
		icon = new ImageIcon("src/JJRPSLOGO.png");
       image = new JLabel(icon);
       image.setBounds(10, 180, 300, 300);
       panel1.add(image);
		frame = new JFrame();
		frame.setSize(300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(panel1);

		frame.setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}