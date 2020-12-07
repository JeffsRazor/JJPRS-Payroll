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

	private static JLabel benefits, sickLeave, childCare, paidVacation, dentalInsurance, lifeInsurance, personalLeave, 
		health, insurance, image,premium,deductible,outOfPocketMaximum;

	private static JPanel panel1;

	private static JButton goBack;

	private static ImageIcon icon;

	private static  EmployeeDashboard employeeDashboard = new EmployeeDashboard();
	
	private static HRDashboard hrDashboard = new HRDashboard();

	public static void createDashboard(Connection db, int id, Employee emp) {
		

		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());

//		if (emp.isRetirement()) {
//			benefits = new JLabel("Retirement Plan On");
//			benefits.setBounds(150, 0, 100, 100);
//			benefits.setFont(benefits.getFont().deriveFont(20f));
//		} else {
//			benefits = new JLabel("Retirement Plan Off");
//			benefits.setBounds(150, 0, 100, 100);
//			benefits.setFont(benefits.getFont().deriveFont(20f));
//		}
		
		EmployeePlan curEmployeePlan = new EmployeePlan(db,id);
		
		benefits = new JLabel("List of Current Benefits");
		benefits.setBounds(150, 600, 100, 100);
		benefits.setFont(benefits.getFont().deriveFont(Font.BOLD, 24f));
		
		panel1.add(benefits);
		
		curEmployeePlan.setBenefits(curEmployeePlan);
		
		if (curEmployeePlan.getHasSickLeave()==true) {
			sickLeave= new JLabel("-Sick Leave: 5 Days");
			sickLeave.setBounds(300, 500, 300, 300);
			sickLeave.setFont(sickLeave.getFont().deriveFont(20f));
		}
		else {
			sickLeave= new JLabel("-No Sick Leave");
			sickLeave.setBounds(300, 500, 300, 300);
			sickLeave.setFont(sickLeave.getFont().deriveFont(20f));
		}
		if(curEmployeePlan.getHasDentalInsurance()==true) {
			dentalInsurance = new JLabel("-Dental Insurance Provided");
			dentalInsurance.setBounds(300, 500, 300, 300);
			dentalInsurance.setFont(dentalInsurance.getFont().deriveFont(20f));
		}
		else {
			dentalInsurance = new JLabel("-No Dental Insurance");
			dentalInsurance.setBounds(300, 500, 300, 300);
			dentalInsurance.setFont(dentalInsurance.getFont().deriveFont(20f));
		}
		if (curEmployeePlan.getHasLifeInsurance()==true) {
			lifeInsurance = new JLabel("-Life Insurance Provided");
			lifeInsurance.setBounds(300, 500, 300, 300);
			lifeInsurance.setFont(lifeInsurance.getFont().deriveFont(20f));
		}
		else {
			lifeInsurance = new JLabel("-No Life Insurance");
			lifeInsurance.setBounds(300, 500, 300, 300);
			lifeInsurance.setFont(lifeInsurance.getFont().deriveFont(20f));
		}
		
		if(curEmployeePlan.getHasChildCare()==true) {
			childCare = new JLabel("-Child Care Provided");
			childCare.setBounds(300, 500, 300, 300);
			childCare.setFont(childCare.getFont().deriveFont(20f));
		}
		else {
			childCare = new JLabel("-No Child Care");
			childCare.setBounds(300, 500, 300, 300);
			childCare.setFont(childCare.getFont().deriveFont(20f));
		}
		if(curEmployeePlan.getHasPaidVacation()==true) {
			paidVacation = new JLabel("-Paid Vacation:7 Days");
			paidVacation.setBounds(300, 500, 300, 300);
			paidVacation.setFont(paidVacation.getFont().deriveFont(20f));
		}
		else{
			paidVacation = new JLabel("-No Paid Vacation");
			paidVacation.setBounds(300, 500, 300, 300);
			paidVacation.setFont(paidVacation.getFont().deriveFont(20f));
		}
		if(curEmployeePlan.getHasPersonalLeave()==true) {
			personalLeave = new JLabel("-Personal Leave:7 Days");
			personalLeave.setBounds(300, 500, 300, 300);
			personalLeave.setFont(personalLeave.getFont().deriveFont(20f));
		}
		else {
			personalLeave = new JLabel("-No Personal Leave");
			personalLeave.setBounds(300, 500, 300, 300);
			personalLeave.setFont(personalLeave.getFont().deriveFont(20f));
		}
				
		panel1.add(sickLeave);
		panel1.add(dentalInsurance);
		panel1.add(lifeInsurance);
		panel1.add(childCare);
		panel1.add(paidVacation);
		panel1.add(personalLeave);
		
		curEmployeePlan.setHealthPlan(curEmployeePlan);

		health = new JLabel("Your Current Health Plan");
		health.setFont(health.getFont().deriveFont(Font.BOLD,24f));
		health.setBounds(300, 400, 300, 25);
		
		insurance = new JLabel("Your Health Insurance Type: " + curEmployeePlan.getPlanType());
		insurance.setFont(insurance.getFont().deriveFont(20f));
		insurance.setBounds(300, 350, 300, 25);
		
		premium = new JLabel("Premium:$" + curEmployeePlan.getPremium());
		premium.setFont(premium.getFont().deriveFont(20f));
		premium.setBounds(300, 300, 300, 300);
		deductible = new JLabel("Deductible:$" + curEmployeePlan.getDeductible());	
		deductible.setFont(premium.getFont().deriveFont(20f));
		deductible.setBounds(300, 300, 300, 300);
		outOfPocketMaximum = new JLabel("OOP:$" + curEmployeePlan.getOutOfPocket());	
		outOfPocketMaximum.setFont(outOfPocketMaximum.getFont().deriveFont(20f));
		outOfPocketMaximum.setBounds(300, 300, 300, 300);
			
		panel1.add(health);
		panel1.add(insurance);		
		panel1.add(premium);
		panel1.add(deductible);
		panel1.add(outOfPocketMaximum);

		// go back to dash board
		goBack = new JButton("Return to dashboard");
		goBack.setBounds(20, 10, 300, 25);
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(emp.isAdmin()){
				hrDashboard.createDashboard(db, id);
				frame.dispose();
			
				}
				else{
					employeeDashboard.createDashboard(db, id);
					frame.dispose();
				}
			}

		});
		panel1.add(goBack);
		icon = new ImageIcon("src/JJRPSLOGO.png");
       image = new JLabel(icon);
       image.setBounds(10, 0, 300, 300);
       panel1.add(image);
		frame = new JFrame();

		frame.setSize(400, 700);
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