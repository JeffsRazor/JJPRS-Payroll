package UI;

import java.awt.*;
import java.sql.Connection;
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

import Payroll.*;

public class PayrollScreen implements ActionListener {
	private static JFrame frame;

	private static JLabel salary, netpay, position,image;

	private static JPanel panel1;

	private static JButton goBack;

	private static ImageIcon icon;
	private static Payroll payroll;

	public static void createDashboard(Connection db, int id, Employee emp) {

		payroll = new Payroll(db, id);
		frame = new JFrame();
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		position = new JLabel("Your position: " + emp.getPosition());
		position.setFont(position.getFont().deriveFont(20f));
		if (emp.getPosition().equals("Part-Time")) {
			salary = new JLabel("Your Salary: $" + Integer.toString(emp.getSalary()) + " Per Hour");
			salary.setFont(salary.getFont().deriveFont(20f));
			panel1.add(salary);
		} else if (emp.getPosition().equals("Full-Time")) {
			salary = new JLabel("Your Salary: $" + Integer.toString(emp.getSalary()) + " Per Year");
			netpay = new JLabel("Your Net Pay: " + payroll.getNetPay() + " After Taxes");
			salary.setFont(salary.getFont().deriveFont(20f));
			netpay.setFont(netpay.getFont().deriveFont(20f));
			panel1.add(salary);
			panel1.add(netpay);

		}

		System.out.println(payroll.getTotalTax() + " " + payroll.getLocalIncomeTax() + " " + payroll.getIncome());

		panel1.add(position);

		System.out.println("yeet");
		goBack = new JButton("Return to employee dashboard");
		goBack.setBounds(50, 50, 75, 25);
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
		frame.add(panel1);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}