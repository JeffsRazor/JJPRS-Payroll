package UI;

import java.awt.*;
import java.sql.Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Employee.*;

public class BenefitsScreen implements ActionListener {
	private static JFrame frame;

	private static JLabel benefits, insurance, image;

	private static JPanel panel1;

	private static JButton goBack;

	private static ImageIcon icon;

	public static void createDashboard(Connection db, int id, Employee emp) {

		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());

		if (emp.isRetirement()) {
			benefits = new JLabel("Retirement Plan On");
			benefits.setBounds(150, 75, 100, 100);
			benefits.setFont(benefits.getFont().deriveFont(20f));
		} else {
			benefits = new JLabel("Retirement Plan Off");
			benefits.setBounds(150, 75, 100, 100);
			benefits.setFont(benefits.getFont().deriveFont(20f));
		}

		insurance = new JLabel("Your health insurance: " + emp.getHealthInsurance());
		insurance.setFont(insurance.getFont().deriveFont(20f));

		panel1.add(benefits);
		panel1.add(insurance);

		// go back to dash board
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

		frame.setSize(400, 550);
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