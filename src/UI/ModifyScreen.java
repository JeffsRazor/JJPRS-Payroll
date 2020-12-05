package UI;

import DatabaseCode.*;
import Employee.HR;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonListener;

public class ModifyScreen {
    private static JFrame frame;
    
    private static JLabel title;

    private static JPanel panel1;

    private static JButton logoutButton;
    
    private static JRadioButton radioButton1, radioButton2;

    private static HR emp;

    private static ImageIcon icon;
    private static LoginScreen loginScreen = new LoginScreen();

    public static void createDashboard(Connection db, int id) {
        emp = new HR(db, id);
        frame = new JFrame();
        frame.setSize(300, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        title = new JLabel("Modify Screen");
        title.setBounds(0, 0, 300, 25);
        
        panel1 = new JPanel();

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {

           loginScreen.createLogin(db);
           frame.dispose();
          }
        });

        ButtonGroup a = new ButtonGroup();
        radioButton1 = new JRadioButton("Bronze");
        radioButton2 = new JRadioButton("Gold");
        a.add(radioButton1);
        a.add(radioButton2);
        radioButton1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {
                try {
                    emp.updateHI("Bronze", id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
          }
          
        });

        radioButton2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {
            try {
                emp.updateHI("Gold", id);
            } catch (SQLException e) {
                e.printStackTrace();
            }

          }
          
        });
      

        panel1.setLayout(new FlowLayout());
        panel1.add(title);
        panel1.add(radioButton1);
        panel1.add(radioButton2);
        panel1.add(logoutButton);
        panel1.setBackground(Color.white);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        frame.add(panel1);
        
        frame.setVisible(true);
    }
}
