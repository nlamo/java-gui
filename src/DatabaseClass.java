import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseClass {

    public static Connection connectToDatabase() throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/first_java_gui", "user", "password");
            System.out.println("You have successfully connected to your database.");

            return connection;
        }
        catch (Exception e) {
            System.out.println("Error:" + e);
        }

        return null;
    }

}
