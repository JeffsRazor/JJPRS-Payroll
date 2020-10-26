package UI;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

import DatabaseCode.DatabaseCalls;
import DatabaseCode.UserAccountDAO;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen implements ActionListener {
    private static JLabel idLabel;
    private static JTextField idText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordField;
    private static JButton loginButton;
    private static JLabel loginSucess;
    private static JLabel title, image;
    private static JFrame frame;
    private static JPanel p;
    private UserAccountDAO dao;
    private static Connection logindb;
    private static Icon icon;
    
    public static void createLogin(Connection db){
        // Create frame and panel
        logindb = db;
        frame = new JFrame();
        p = new JPanel();
       frame.setSize(600, 500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       frame.add(p);
       p.setLayout(null);

       title = new JLabel("Login to the JJPRS Payroll System");
       title.setBounds(150, 0, 300, 25);
       p.add(title);

       idLabel = new JLabel("Employee ID");
       idLabel.setBounds(10, 50, 80, 25);
       p.add(idLabel);

       idText = new JTextField("Input your Employee ID here", 20);
       idText.setBounds(100, 50, 165, 25);
       p.add(idText);

       passwordLabel = new JLabel("Password");
       passwordLabel.setBounds(10, 70, 80, 25);
       p.add(passwordLabel);

       passwordField = new JPasswordField();
       passwordField.setBounds(100, 70, 165, 25);
       p.add(passwordField);

       loginButton = new JButton("Login");
       loginButton.setBounds(10, 100, 80, 25);
       loginButton.addActionListener(new LoginScreen());
       p.add(loginButton);

       loginSucess = new JLabel();
       loginSucess.setBounds(10, 130, 300, 25);
       p.add(loginSucess);
       icon = new ImageIcon("src/JJRPSLOGO.png");
       image = new JLabel(icon);
       image.setBounds(10, 180, 300, 300);
       p.add(image);
       frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String empID = idText.getText();
        String password = passwordField.getText();
        int id = Integer.parseInt(empID);
        System.out.println(empID + " " + password);
        //make DB call here to check username/password (or maybe have login do ID instead of username)
       try {
           System.out.print(logindb);
           dao = new UserAccountDAO(logindb);
           String dbPassword = dao.getPassword(id);
           
           System.out.println(dbPassword);
           if(dbPassword.equals(password)) {
            loginSucess.setText("Login Successful!");
            if(dao.getAdmin(id)){
                HRDashboard.createDashboard(logindb, id);
            }
            else{
                EmployeeDashboard.createDashboard(logindb, id);
            }
            
            frame.dispose();
            }
            
            else {
                loginSucess.setText("Wrong credentials");
            }
        
       } 
       catch (Exception a) {
        System.out.println("yeeet");
       }
       
    }
}

//querries 
//SELECT employeeID from employee