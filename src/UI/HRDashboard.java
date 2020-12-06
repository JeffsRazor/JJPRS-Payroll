package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Employee.*;

public class HRDashboard extends Dashboard implements ActionListener {
    private HR hr;
    private static JFrame frame;
    private static JPanel panel1;
    private static JLabel title, image;
    private static ImageIcon icon;

    private static JButton logoutButton, payrollButton, profileButton, timeManagementButton, benefitsButton, searchButton, modifyButton, printCheckButton;  

    private static LoginScreen loginScreen = new LoginScreen();
    @Override
	public void createDashboard(Connection db, int id) {
    
    hr = new HR(db, id);
    frame = new JFrame();
    frame.setSize(300, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    title = new JLabel("Welcome, " + hr.getName());
    title.setBounds(0, 0, 300, 25);
    icon = new ImageIcon("src/JJRPSLOGO.png");
    panel1 = new JPanel();
    image = new JLabel(icon);
    logoutButton = new JButton("Logout");
    logoutButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {

       loginScreen.createLogin(db);
       frame.dispose();
      }
    });
    payrollButton = new JButton("Payroll Info");
    payrollButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {

       PayrollScreen.createDashboard(db, id, hr);
       frame.dispose();
      }
    });
    profileButton = new JButton("Profile Info");
    profileButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {

        ProfileScreen.createProfile(db, hr,id);
       frame.dispose();
      }
    });

    timeManagementButton = new JButton("Time Management");
    timeManagementButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {

       TimeScreen.createDashboard(db, id, hr);
       frame.dispose();
      }
    }); 

    benefitsButton = new JButton("Benefits");
    benefitsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {

       BenefitsScreen.createDashboard(db, id, hr);
       frame.dispose();
      }
    });

    searchButton = new JButton("Search");//Employee Search 
        searchButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {

           SearchScreen.createDashboard(db, id, hr);
           frame.dispose();
          }
        });  

        printCheckButton = new JButton("Print Check");//Employee Search 
        printCheckButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent evt)
        {
  
          PrintCheck.createPaycheck(db, id, hr);
        }
      });  
        modifyButton = new JButton("Modify Employees");//Employee modifications
        modifyButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
         {
           ModifyScreen.createDashboard(db, id, hr);
           frame.dispose();
          }
         });  


    panel1.setLayout(new FlowLayout());
    panel1.add(title);
    panel1.add(payrollButton);
    panel1.add(profileButton);
    panel1.add(timeManagementButton);
    panel1.add(benefitsButton);
    panel1.add(searchButton);
    panel1.add(printCheckButton);
    panel1.add(modifyButton);

    panel1.add(logoutButton);
   
    panel1.setBackground(Color.white);
    panel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    panel1.add(image);
    frame.add(panel1);
    
    frame.setVisible(true);

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    
    
}
