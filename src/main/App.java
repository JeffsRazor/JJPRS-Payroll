/*
    This application simulates a company's employee payroll system. It uses various swing screens
    to display a GUI. By connecting to a sql database using JDBC, it is able to pull employee 
    records from a table and display that data, It also stores that data in a local variable in 
    order to pass to other functions within the program.

*/

package main;

import java.sql.Connection;

import DatabaseCode.DatabaseConnection;
import UI.LoginScreen;


public class App {
    public static void main(String[] args) throws Exception {
       Connection db = DatabaseConnection.getDatabase();
       LoginScreen loginScreen = new LoginScreen();
        System.out.print(db);
        // create login screen that will call the next dashboards
        loginScreen.createLogin(db);

    }
}

