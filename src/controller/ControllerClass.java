// Refactored control logic that I originally had in the event handling of the GUI class

package controller;
import model.DatabaseClass;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class ControllerClass {

    public ControllerClass() {

    }

    // This will insert a user into the SQL database
    public void insertUser(JTextField userNameText,JTextField userHeightText,
                           JTextField userWeightText, JTextField userProgLangPrefText) {

        // TODO: Solve the AUTO INCREMENT issue with insertion into database.
        // All of the the JTextField entries being added to the SQL query, readied for insertion
        String userInsert = "INSERT INTO users VALUES (6, '" + userNameText.getText() + "', " + userHeightText.getText()
                + ", " + userWeightText.getText() + ", '" + userProgLangPrefText.getText() + "')";

        // Connect to database, execute user information insertion query, close database
        try {
            Connection databaseConnection = null;
            Statement sttmnt = null;

            databaseConnection = DatabaseClass.connectToDatabase();

            // If the database isn't closed, then it's running
            if (!databaseConnection.isClosed()) {
                System.out.println("Database connection established.");
            }

            sttmnt = databaseConnection.createStatement();
            sttmnt.executeUpdate(userInsert);
            System.out.println("Values have been successfully inserted!");

            databaseConnection.close();

            // If it's closed, then we let you know
            if (databaseConnection.isClosed()) {
                System.out.println("Database connection closed.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
