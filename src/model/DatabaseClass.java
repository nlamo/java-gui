package model;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseClass {

    public static Connection connectToDatabase() throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/first_java_gui", "username", "password");

            return connection;
        }
        catch (Exception e) {
            System.out.println("Error:" + e);
        }

        return null;
    }

}
