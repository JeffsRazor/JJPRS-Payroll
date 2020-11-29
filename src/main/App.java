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