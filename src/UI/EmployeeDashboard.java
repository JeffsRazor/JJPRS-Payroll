package UI;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
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
import UI.*;

public class EmployeeDashboard implements ActionListener{
    private static JFrame frame;
    
    private static JLabel title, image;

    private static JPanel panel1;
    
    private static JButton logoutButton, payrollButton, profileButton, timeManagementButton, benefitsButton;

    private static Employee emp;

    private static ImageIcon icon;

    public static void createDashboard(Connection db, int id) {
        emp = new Employee(db, id);
        frame = new JFrame();
        frame.setSize(300, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        title = new JLabel("Welcome, " + emp.getName());
        title.setBounds(0, 0, 300, 25);
        icon = new ImageIcon("src/JJRPSLOGO.png");
        panel1 = new JPanel();
        image = new JLabel(icon);
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {

           LoginScreen.createLogin(db);
           frame.dispose();
          }
        });
        payrollButton = new JButton("Payroll Info");
        payrollButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {

           PayrollScreen.createDashboard(db, id, emp);
           frame.dispose();
          }
        });
        profileButton = new JButton("Profile Info");
        profileButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {

            ProfileScreen.createProfile(db, emp,id);
           frame.dispose();
          }
        });

        timeManagementButton = new JButton("Time Management");
        timeManagementButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {

           TimeScreen.createDashboard(db, id, emp);
           frame.dispose();
          }
        }); 

        benefitsButton = new JButton("Benefits");
        benefitsButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {

           BenefitsScreen.createDashboard(db, id, emp);
           frame.dispose();
          }
        });

        panel1.setLayout(new FlowLayout());
        panel1.add(title);
        panel1.add(payrollButton);
        panel1.add(profileButton);
        panel1.add(timeManagementButton);
        panel1.add(benefitsButton);
        panel1.add(logoutButton);
        panel1.setBackground(Color.white);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        panel1.add(image);
        frame.add(panel1);
        
        frame.setVisible(true);
    }
    
    public static void main(String args[]) throws SQLException {
        createDashboard(DatabaseConnection.getDatabase(), 12345);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
