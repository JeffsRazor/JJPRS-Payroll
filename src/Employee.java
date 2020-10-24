import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DatabaseCode.*;
public class Employee {

    private UserAccountDAO dao;
    
    public Employee(Connection db) {
        this.dao = new UserAccountDAO(db);
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