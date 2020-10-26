package UI;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import DatabaseCode.DatabaseCalls;
import DatabaseCode.UserAccountDAO;
import Employee.Employee;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TimeScreen implements ActionListener {
	private static JLabel hours, ask;
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

	
	public static void createDashboard(Connection db, int id, Employee emp) {
	

		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		hours = new JLabel("Current Hours: " + emp.getHours());
		hours.setFont(hours.getFont().deriveFont(20f));
		panel1.add(hours);
		
		ask = new JLabel("Update Hours: ");
		ask.setFont(ask.getFont().deriveFont(20f));
		panel1.add(ask);
		
		idText = new JTextField("Enter Hours Here", 20);
		idText.setBounds(100, 50, 165, 25);
		panel1.add(idText);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 70, 165, 25);
		
		button = new JButton("Submit");
		button.setSize(400, 180);
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String hour = idText.getText();
			int hours = Integer.parseInt(hour);
		
			
			try {
				emp.updateHours(hours, id);
				
				
				
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
				EmployeeDashboard.createDashboard(db, id);
				frame.dispose();
			}
		});
		panel1.add(goBack);
		icon = new ImageIcon("src/JJRPSLOGO.png");
       image = new JLabel(icon);
       image.setBounds(10, 180, 300, 300);
       panel1.add(image);
		frame = new JFrame();
		frame.setSize(300, 600);
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