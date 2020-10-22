package UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EmployeeDashboard {
    
    private static JLabel payrollInfo;
    private static JLabel benefits;

    public static void createDashboard() {

    
    JFrame frame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel subPanel1 = new JPanel();
    frame.setSize(600, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(mainPanel);
    frame.add(subPanel1);
    mainPanel.setLayout(null);
    subPanel1.setLayout(null);

    payrollInfo = new JLabel("Payroll Infos");
    payrollInfo.setBounds(50, 100, 100, 25);
    mainPanel.add(payrollInfo);

    benefits = new JLabel("List Benefits");
    benefits.setBounds(100, 100, 100, 25);
    subPanel1.add(benefits);
    frame.setVisible(true);
    }
}
