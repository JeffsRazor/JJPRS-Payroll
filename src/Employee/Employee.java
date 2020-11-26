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
        this.salary = dao.getSalary(id);
        this.retirement = dao.getRetirement(id);
        this.healthInsurance = dao.getHealthInsurance(id);
        this.admin = dao.getAdmin(id);
        this.location = dao.getLocation(id);
        this.status = dao.getStatus(id);
    }

    public String getName()
    {
        return this.name;
    }

    public Boolean isRetirement() {
        return this.retirement;
    }

    public Boolean isAdmin() {
        return this.admin;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public UserAccountDAO getDao() {
        return this.dao;
    }


    public Date getDob() {
        return this.dob;
    }

    public int getHours() {
        return this.hours;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public String getPosition() {
        return this.position;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getEmail() {
        return this.email;
    }

    public String getHealthInsurance() {
        return this.healthInsurance;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getLocation() {
        return this.location;
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