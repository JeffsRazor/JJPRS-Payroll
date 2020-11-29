package UI.UI;

import java.awt.event.ActionListener;
import DatabaseCode.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import DatabaseCode.DatabaseCalls;
import DatabaseCode.UserAccountDAO;
import Employee.Employee;
import Employee.HR;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class ModifyScreen implements ActionListener {
	private static JLabel currentSalary, ask, modifyHealthInsurance, modifyPosition,modifyES;
	private static JTextField idText, salaryText;
	private static JLabel passwordLabel, image;
	private static JPasswordField passwordField;
	private static JButton button, goBacktoModify, goBacktoEmployeeDash, submitButton;
	private static JLabel idLabel, employeeExist;
	private static JLabel title, title2;
	private static JFrame frame1, frame2;
	private static JPanel panel1, panel2;
	private static UserAccountDAO dao;
	private static Connection logindb;
	private static ImageIcon icon;
	private static JRadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9;
	private static HRDashboard HRDashboard = new HRDashboard();
	private static int originalID; //to store id of the original login

	public static void startModifyScreen(Connection db, int id) {
		originalID = id; // store the original login id to use with go back button
		frame1 = new JFrame();
		panel1 = new JPanel();
		frame1.setSize(600, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame1.add(panel1);
		panel1.setLayout(null);

		title = new JLabel("Choose Employee to Modify");
		title.setBounds(150, 0, 300, 25);
		panel1.add(title);

		idLabel = new JLabel("Employee ID");
		idLabel.setBounds(10, 50, 80, 25);
		panel1.add(idLabel);

		idText = new JTextField("Input the Employees ID here", 20);
		idText.setBounds(100, 50, 165, 25);
		panel1.add(idText);
		
		employeeExist = new JLabel();
		employeeExist.setBounds(10, 130, 300, 25);
		panel1.add(employeeExist);



		submitButton = new JButton("Submit");
		submitButton.setBounds(10, 100, 80, 25);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				String empID = idText.getText();
				int modifyempID = Integer.parseInt(empID);

				try {
					
						HR emp = new HR(db, modifyempID);

						//Check to make sure that the employee Exists NEED TO MAKE THIS MORE SECURE
						if(emp.getName() != null){
							ModifyScreen.createModifyScreen(db, modifyempID, emp);	
							frame1.dispose();
						}else
						{
							employeeExist.setText("This Employee does not exist! Try another!");
						}
							
						
				} catch (Exception a) {
					System.out.println("ERROR!");
				}

			}
		});
		panel1.add(submitButton);
		
		goBacktoEmployeeDash = new JButton("Return to employee dashboard");
        goBacktoEmployeeDash.setBounds(100, 100, 225, 25);
        goBacktoEmployeeDash.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {
			HRDashboard.createDashboard(db,id);
           frame1.dispose();
          }
        });
        panel1.add(goBacktoEmployeeDash);
		icon = new ImageIcon("src/JJRPSLOGO.png");
		image = new JLabel(icon);
		image.setBounds(10, 180, 300, 300);
		panel1.add(image);
		frame1.setVisible(true);
	}

	public static void createModifyScreen(Connection db, int id, HR HRemp) {

		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		title2 = new JLabel("Modify " + HRemp.getName() + "'s Account");
		title2.setBounds(150, 0, 300, 25);
		panel2.add(title2);

		// Modify Insurance policy
		modifyHealthInsurance = new JLabel("Modify HealthInsurance");
		modifyHealthInsurance.setFont(modifyHealthInsurance.getFont().deriveFont(20f));
		panel2.add(modifyHealthInsurance);

		ButtonGroup a = new ButtonGroup();
		radioButton1 = new JRadioButton("Bronze");
		radioButton2 = new JRadioButton("Gold");
		a.add(radioButton1);
		a.add(radioButton2);

		radioButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updateHI("Bronze", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});

		radioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updateHI("Gold", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		});
		panel2.add(radioButton1);
		panel2.add(radioButton2);
		// Modify Insurance end

		// Modify Position
		modifyPosition = new JLabel("Modify Employee Position");
		modifyPosition.setFont(modifyPosition.getFont().deriveFont(20f));
		panel2.add(modifyPosition);

		ButtonGroup b = new ButtonGroup();
		radioButton3 = new JRadioButton("Full-Time");
		radioButton4 = new JRadioButton("Part-Time");
		b.add(radioButton3);
		b.add(radioButton4);

		radioButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updatePosition("Full-Time", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});

		radioButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updatePosition("Part-Time", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		});
		panel2.add(radioButton3);
		panel2.add(radioButton4);
		// Modify Position end

		//Modify Employee Status
		modifyES = new JLabel("Modify Employment Status");
		modifyES.setFont(modifyES.getFont().deriveFont(20f));
		panel2.add(modifyES);

		ButtonGroup c = new ButtonGroup();
		radioButton5 = new JRadioButton("Active");
		radioButton6 = new JRadioButton("Terminated");
		radioButton7 = new JRadioButton("Disabled");
		radioButton8 = new JRadioButton("Deceased");
		radioButton9 = new JRadioButton("Quit");
		c.add(radioButton5);
		c.add(radioButton6);
		c.add(radioButton7);
		c.add(radioButton8);
		c.add(radioButton9);

		radioButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updateEmploymentStatus("Active", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});

		radioButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updateEmploymentStatus("Terminated", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});

		radioButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updateEmploymentStatus("Disabled", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});

		radioButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updateEmploymentStatus("Deceased", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});

		radioButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					HRemp.updateEmploymentStatus("Quit", id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});
		panel2.add(radioButton5);
		panel2.add(radioButton6);
		panel2.add(radioButton7);
		panel2.add(radioButton8);
		panel2.add(radioButton9);
		//Modify Employee Status end
		
		// Modify Salary
		currentSalary = new JLabel("Current Salary: " + HRemp.getSalary());
		currentSalary.setFont(currentSalary.getFont().deriveFont(20f));
		panel2.add(currentSalary);

		ask = new JLabel("Update Salary: ");
		ask.setFont(ask.getFont().deriveFont(20f));
		panel2.add(ask);

		salaryText = new JTextField("Enter New Salary Here", 20);
		salaryText.setBounds(100, 50, 165, 25);
		panel2.add(salaryText);

		passwordField = new JPasswordField();
		passwordField.setBounds(100, 70, 165, 25);

		button = new JButton("Submit");
		button.setSize(400, 180);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String salary = salaryText.getText();
				int newSalary = Integer.parseInt(salary);

				try {
					HRemp.updateSalary(newSalary, id);

				} catch (Exception a) {
					System.out.println("yeeet");
				}

			}
		});
		panel2.add(button);
		// Modify Salary end

		goBacktoModify = new JButton("Return to Modify Employee");
		goBacktoModify.setSize(400, 180);
		goBacktoModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ModifyScreen.startModifyScreen(db, originalID);
				frame2.dispose();
			}
		});
		panel2.add(goBacktoModify);
		icon = new ImageIcon("src/JJRPSLOGO.png");
		image = new JLabel(icon);
		image.setBounds(10, 180, 300, 300);
		panel2.add(image);
		frame2 = new JFrame();
		frame2.setSize(300, 600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(new BorderLayout());
		frame2.add(panel2);

		frame2.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}