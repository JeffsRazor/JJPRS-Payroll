package UI;

import Payroll.Payroll;

import Employee.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DatabaseCode.DatabaseConnection;

import java.sql.Connection;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PrintCheck {
    private static double totalEarning;
    private static double totalTax;
    private static double totalDeduction;
    private static double netpay;
    private static double federalTaxes;
    private static double stateTaxes;
    private static String name;
    private static String employeeID;
    private static Date date;
    private static String companyName; 
    private static String maritalStatus;
    private static ImageIcon icon;

    //Panel
    private static JFrame frame;
    private static JPanel panel1;
    private static JLabel totalEarningLabel, federalTaxesLabel, stateTaxesLabel, totalTaxLabel, totalDeductionLabel, netpayLabel, nameLabel,
     employeeIDLabel, dateLabel, maritalStatusLabel, payDate, employer,image;
    //Place holders for the deductions
    private static JLabel  placeHolder1, placeHolder2;
    private static JLabel taxesTitle, payPeriodTitle, employerTitle, employeeTitle,deductionTitle, summaryTitle;

    public static void createPaycheck(Connection db,int id, Employee emp)
    {
        //get the information
        Payroll payroll = new Payroll(db,id);
        totalEarning = payroll.getSalary();
        federalTaxes = payroll.getFederalIncomeTax();
        stateTaxes = payroll.getLocalIncomeTax();
        totalTax = payroll.getTotalTax();
        //Place holder for Jarrett and Patrick totalDeductions = 
        netpay = payroll.getNetPay();
        name = emp.getName();
        employeeID = emp.getEmployeeID();
        companyName = "JJPRS Company";

        //Check maritalStatus
        if(emp.isMaritalStatus())
        {
            maritalStatus = "Married";
        }
        else
         maritalStatus = "Single";

        //Set Date format
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        date = new Date();
        //create the  frame and panels 
        frame = new JFrame();
        frame.setTitle(companyName);
		frame.setSize(775, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		panel1 = new JPanel();
        panel1.setLayout(null);

        //Display the information
        dateLabel = new JLabel("This check was printed on " + dateFormat.format(date));
        dateLabel.setBounds(200, 10, 325, 25);
        dateLabel.setFont(dateLabel.getFont().deriveFont(Font.BOLD, 15f));

        employeeTitle = new JLabel("Employee");
        employeeTitle.setBounds(10, 130, 350 , 25);
        employeeTitle.setFont(employeeTitle.getFont().deriveFont(Font.BOLD, 20f));

        nameLabel = new JLabel("Employee Name................................. " + name);
        nameLabel.setBounds(10, 150, 350 , 25);
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.ITALIC, 15f));

        employeeIDLabel = new JLabel("Employee ID Number........................ #" + employeeID);
        employeeIDLabel.setBounds(10, 170, 350 , 25);
        employeeIDLabel.setFont(employeeIDLabel.getFont().deriveFont(Font.ITALIC, 15f));

        maritalStatusLabel = new JLabel("Marital Status.................................... " + maritalStatus);
        maritalStatusLabel.setBounds(10, 190, 350 , 25);
        maritalStatusLabel.setFont(maritalStatusLabel.getFont().deriveFont(Font.ITALIC, 15f));
       
        taxesTitle = new JLabel("Taxes");
        taxesTitle.setBounds(400, 50, 100 , 25);
        taxesTitle.setFont(taxesTitle.getFont().deriveFont(Font.BOLD, 20f));

        federalTaxesLabel = new JLabel("Federal Income Taxes............................. $" + federalTaxes);
        federalTaxesLabel.setBounds(400, 70, 350 , 25);
        federalTaxesLabel.setFont(federalTaxesLabel.getFont().deriveFont(Font.ITALIC, 15f));

        stateTaxesLabel = new JLabel("State Income Taxes................................ $" + stateTaxes);
        stateTaxesLabel.setBounds(400, 90, 350 , 25);
        stateTaxesLabel.setFont(stateTaxesLabel.getFont().deriveFont(Font.ITALIC, 15f));

        employerTitle = new JLabel("Employer");
        employerTitle.setBounds(10, 50, 250 , 25);
        employerTitle.setFont(employerTitle.getFont().deriveFont(Font.BOLD, 20f));

        employer = new JLabel("Employer Name................................" + companyName);
        employer.setBounds(10, 70, 350 , 25);
        employer.setFont(employer.getFont().deriveFont(Font.ITALIC, 15f));

        payPeriodTitle = new JLabel("Pay Period");
        payPeriodTitle.setBounds(400, 220, 200 , 25);
        payPeriodTitle.setFont(payPeriodTitle.getFont().deriveFont(Font.BOLD, 20f));

        DateFormat datePaid = new SimpleDateFormat("MM/dd/yyyy");
        payDate = new JLabel("Pay Date................................................" + datePaid.format(date));
        payDate.setBounds(400, 240, 350 , 25);
        payDate.setFont(payDate.getFont().deriveFont(Font.ITALIC, 15f));

        summaryTitle = new JLabel("Summary");
        summaryTitle.setBounds(400, 280, 350 , 25);
        summaryTitle.setFont(summaryTitle.getFont().deriveFont(Font.BOLD, 20f));

        totalEarningLabel = new JLabel("Gross Pay............................................... $" + totalEarning);
        totalEarningLabel.setBounds(400, 310, 350 , 25);
        totalEarningLabel.setFont(totalEarningLabel.getFont().deriveFont(Font.BOLD, 15f));

        totalTaxLabel = new JLabel("Total Taxes............................................. $" + totalTax);
        totalTaxLabel.setBounds(400, 340, 350 , 25);
        totalTaxLabel.setFont(totalTaxLabel.getFont().deriveFont(Font.BOLD, 15f));

        netpayLabel = new JLabel("Net Pay.................................................... $" + netpay);
        netpayLabel.setBounds(400, 370, 350 , 25);
        netpayLabel.setFont(netpayLabel.getFont().deriveFont(Font.BOLD, 15f));

        deductionTitle = new JLabel("Deductions");
        deductionTitle.setBounds(400, 140, 350 , 25);
        deductionTitle.setFont(deductionTitle.getFont().deriveFont(Font.BOLD, 20f));

        //Deduction place holders. Replace with deduction values
        placeHolder1 = new JLabel("Deduction Place Holder................................$blah");
        placeHolder1.setBounds(400, 160, 350 , 25);
        placeHolder1.setFont(placeHolder1.getFont().deriveFont(Font.ITALIC, 15f));

        placeHolder2 = new JLabel("Deduction Place Holder................................$blah" );
        placeHolder2.setBounds(400, 180, 350 , 25);
        placeHolder2.setFont(placeHolder2.getFont().deriveFont(Font.ITALIC, 15f));

    

        panel1.add(taxesTitle);
        panel1.add(employerTitle);
        panel1.add(employer);
        panel1.add(payPeriodTitle);
        panel1.add(payDate);
        panel1.add(dateLabel);
        panel1.add(employeeTitle);
        panel1.add(nameLabel);
        panel1.add(employeeIDLabel);
        panel1.add(maritalStatusLabel);
        panel1.add(totalEarningLabel);
        panel1.add(federalTaxesLabel);
        panel1.add(stateTaxesLabel);
        panel1.add(totalTaxLabel);
        panel1.add(summaryTitle);
        panel1.add(netpayLabel);
        panel1.add(deductionTitle);

        //deduction place holders
        panel1.add(placeHolder1);
        panel1.add(placeHolder2);
       
        //display logo
        icon = new ImageIcon("src/JJRPSLOGO.png");
        image = new JLabel(icon);
        image.setBounds(10, 200, 300, 300);
        panel1.add(image);
        frame.add(panel1);
        frame.setVisible(true);
        
    }


    //simply used for testing. DELETE WHEN THIS CLASS WORKS
    public static void main(String[] args) throws Exception {
        PrintCheck pc = new PrintCheck();
        Connection db = DatabaseConnection.getDatabase();
        Employee emp = new Employee(db, 54321);
        pc.createPaycheck(db, 54321, emp);
    }
}
