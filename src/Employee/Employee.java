package Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DatabaseCode.*;
public class Employee {
    private String name;
    private Date dob;
    private int hours;
    private String employeeID;
    private String position;
    private String phoneNum; 
    private String email;
    private Boolean retirement; 
    private String healthInsurance;
    private int salary; 
    private Boolean admin;
    private String location;
    private Boolean status;

    private UserAccountDAO dao;
    
    public Employee(Connection db, int id) {
        this.dao = new UserAccountDAO(db);
        this.name = dao.getName(id);
        this.dob = dao.getDob(id);
        this.hours= dao.getHours(id);
        this.employeeID = dao.getEmployeeID(id);
        this.position = dao.getPosition(id);
        this.phoneNum = dao.getPhoneNum(id);
        this.email = dao.getEmail(id);
    }

    public String getName()
    {
        return this.name;
    }

    public void getDob(int id)
    {
        this.dob = dao.getDob(id);
    }

    public void getHours(int id)
    {
        this.hours= dao.getHours(id);
    }

    public void getEmployeeID(int id)
    {
        this.employeeID = dao.getEmployeeID(id);
    }

    public void getPosition(int id )
    {
        this.position = dao.getPosition(id);
    }
    
    public void getPhoneNum(int id)
    {
        this.phoneNum = dao.getPhoneNum(id);
    }

    public void getEmail(int id)
    {
        this.email = dao.getEmail(id);
    }

    public void getRetirement(int id)
    {
        this.retirement = dao.getRetirement(id);
    }

    public void getHealthInsurance(int id)
    {
        this.healthInsurance = dao.getHealthInsurance(id);
    }

    public void getSalary(int id)
    {
        this.salary = dao.getSalary(id);
    }

    public void getAdmin(int id)
    {
        this.admin = dao.getAdmin(id);
    }

    public void getLocation(int id)
    {
        this.location = dao.getLocation(id);
    }

    public void getStatus(int id)
    {
       this.status = dao.getStatus(id);
    }

    public void viewProfile(int ID) throws SQLException { // Displays all information based on the persons ID
        dao.viewProfile(ID);
    }
    
    public void updateHours(int hours, int ID) throws SQLException { // Updates employees hours
        dao.addHours(hours,ID);
    }
    
    public void updatePhone(String phone, int ID) throws SQLException { // Updates employees hours
        dao.modifyPhoneNumber(phone,ID);
    }
    
    public void updateEmail(String email, int ID) throws SQLException { // Updates employees hours
        dao.modifyEmail(email,ID);
    }
    
    public void updatePassword(String pw, int ID) throws SQLException { // Updates employees hours
        dao.modifyPassword(pw,ID);
    }

}