package UI.UI;

import java.sql.Connection;

import DatabaseCode.DatabaseConnection;


public class App {
    public static void main(String[] args) throws Exception {
       Connection db = DatabaseConnection.getDatabase();
       LoginScreen loginScreen = new LoginScreen();
        System.out.print(db);
        // create login screen that will call the next dashboards
        loginScreen.createLogin(db);

    }
}
