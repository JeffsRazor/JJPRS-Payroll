package UI;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


import DatabaseCode.DatabaseCalls;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen implements ActionListener {
    private static JLabel userLabel;
    private static JTextField usernameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordField;
    private static JButton loginButton;
    private static JLabel loginSucess;
    private static JLabel title;
    private static JFrame frame;
    private static JPanel p;
    
    public static void main(String[] args) {
        // Create frame and panel
         frame = new JFrame();
         p = new JPanel();
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(p);
        p.setLayout(null);

        title = new JLabel("Login to the JJPRS Payroll System");
        title.setBounds(150, 0, 300, 25);
        p.add(title);

        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 50, 80, 25);
        p.add(userLabel);

        usernameText = new JTextField("Input your username here", 20);
        usernameText.setBounds(100, 50, 165, 25);
        p.add(usernameText);

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

        frame.setVisible(true);

    }
    public void createLogin(){}
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = usernameText.getText();
        String password = passwordField.getText();
        int id = Integer.parseInt(user);
        System.out.println(user + " " + password);
        //make DB call here to check username/password (or maybe have login do ID instead of username)
       try {
           String dbPassword = DatabaseCalls.callDB(id);
           System.out.println(dbPassword);
           if(dbPassword.equals(password)) {
            loginSucess.setText("Login Successful!");
            // if(DatabaseCalls.CallDB(id) >> function for finding admin bool in table)
                //call hr dashboard
            //can instantiate the welcomescreen from here
            EmployeeDashboard.createDashboard();
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