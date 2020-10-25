package UI;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Employee.*;
import DatabaseCode.*;

public class EmployeeDashboard {
    private static JFrame frame;
    
    private static JLabel title;

    private static JPanel panel1;
    
    private static JButton button;

    private static Employee emp;

    public static void createDashboard(Connection db, int id) {
        emp = new Employee(db, id);
        frame = new JFrame();
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        title = new JLabel("Welcome, " + emp.getName());
        title.setBounds(0, 0, 300, 25);
        
        panel1 = new JPanel();

        button = new JButton("Logout");
        
        panel1.setLayout(new FlowLayout());
        panel1.add(title);
        panel1.add(new JButton("Payroll Info"));
        panel1.add(new JButton("Profile Info"));
        panel1.add(new JButton("Time Management"));
        panel1.add(new JButton("Benefits"));
        panel1.add(button);
        panel1.setBackground(Color.white);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
       
        frame.add(panel1);
        frame.setVisible(true);
    }

    public static void main(String args[]) throws SQLException {
        createDashboard(DatabaseConnection.getDatabase(), 12345);
    }
}
