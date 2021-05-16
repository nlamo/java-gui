/* I'll give a quick MVC overview here.
*
*  This mainApp class imports the GUI and runs it. Okay, well, what does the GUI do?
*
*  Within the GUI, ControllerCLass is imported. It instantiates an object of ControllerClass, which it
*  can then use within the event handling methods (e.g. actionPerformed) to perform the application logic.
*
*  Finally, our ControllerClass imports from DatabaseClass. The controller needs access to the database in order to
*  carry out the logic that is imported in the GUI.
*
*/

import view.GUI;

import javax.swing.*;

// TODO: Separate chunk - make a login page for a user. No need for serious authentication/hashing.. yet.
// TODO: Make a 'Delete' button that will remove data from SQL database given certain inputs (e.g. name).
// TODO: Eventually, make an interface that will display certain kinds of data based on inputs.

public class mainApp {

   public static void main(String[] args) throws Exception {

       // This creates the frame on the event dispatching thread
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               new GUI();
           }
       });

   }
}
