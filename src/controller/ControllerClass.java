// Refactored control logic that I originally had in the event handling of the GUI class

package controller;
import model.DatabaseClass;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class ControllerClass {

    public ControllerClass() {

    }

    // This inserts a user into the MySQL database
    public void insertUser(JTextField userNameText,JTextField userHeightText,
                           JTextField userWeightText, JTextField userProgLangPrefText) {

        // Auto-increment issue was solved by having the number 0 given for the first column
        String userInsertQuery = "INSERT INTO `users` VALUES (0, '" + userNameText.getText() + "', " + userHeightText.getText()
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
            sttmnt.executeUpdate(userInsertQuery);
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

    // This deletes a user from the MySQL database
    public void deleteUser(JTextField deleteUserText) {

        // Auto-increment issue was solved by having the number 0 given for the first column
        String userDeleteQuery = "DELETE FROM `users` WHERE `first_name` = \"" + deleteUserText.getText() + "\"";

        // Connect to database, execute user deletion query, close database
        try {
            Connection databaseConnection = null;
            Statement sttmnt = null;

            databaseConnection = DatabaseClass.connectToDatabase();

            // If the database isn't closed, then it's running
            if (!databaseConnection.isClosed()) {
                System.out.println("Database connection established.");
            }

            sttmnt = databaseConnection.createStatement();
            sttmnt.executeUpdate(userDeleteQuery);
            System.out.println("User deleted!");

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
