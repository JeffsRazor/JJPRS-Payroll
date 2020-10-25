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
    private static JLabel payrollInfo;
    private static JLabel benefits;
    private static JLabel title;

    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel panel3;
    private static JPanel panel4;

    private static JButton button;

    private static Employee emp;

    public static void createDashboard(Connection db, int id) {
        emp = new Employee(db, id);
        frame = new JFrame();
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        title = new JLabel(emp.getName());
        title.setBounds(0, 0, 300, 25);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        button = new JButton("send");
        panel1.setLayout(new FlowLayout());
        panel1.add(title);
        panel1.add(new JButton("Payroll Info"));
        panel1.setBackground(Color.green);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        panel2.add(new JButton("Profile Info"));
        panel2.setBackground(Color.green);
        panel2.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        panel3.add(new JButton("Time Management"));
        panel3.setBackground(Color.green);
        panel3.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        //panel4.add(new JButton("Benefits"));
        panel4.setBackground(Color.green);
        panel4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        JLabel name = new JLabel(emp.getName());
        name.setBounds(10, 70, 80, 25);
        panel4.add(name);
       

        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        frame.add(panel1);
        frame.setVisible(true);
    }

    public static void main(String args[]) throws SQLException {
        createDashboard(DatabaseConnection.getDatabase(), 12345);
    }
}
