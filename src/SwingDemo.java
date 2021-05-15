import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

// TODO: Sync this up with a GitHub repository that I"ve already made.
// TODO: Separate chunk - make a login page for a user. No need for serious authentication/hashing.. yet.
// TODO: Make a 'Delete' button that will remove data from SQL database given certain inputs (e.g. name)
// TODO: Eventually, make an interface that will display certain kinds of data based on inputs

// Just runs the main method
public class SwingDemo extends GUI {

   public static void main(String[] args) throws Exception {

       // This creates the frame on the event dispatching thread
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               new SwingDemo();
           }
       });

   }
}
