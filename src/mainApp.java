/* I'll give a quick MVC overview here.
*
*  This mainApp class runs the Swing application by importing from view.ControllerClass, which it creates and runs
*  a new instance of. What does this do, you ask?
*
*  ControllerClass creates a new instance of our GUI, which it imports from view.GUI. This keeps the logic of
*  running the application somewhat separate from the creation of the user view.
*
*  Finally, the GUI itself is importing from the model, which contains our database logic as well as our .sql database
*  file, which really doesn't need to be there, but it's useful to keep it there for our purposes.
*
*/

import controller.ControllerClass;
import javax.swing.*;

// TODO: Separate chunk - make a login page for a user. No need for serious authentication/hashing.. yet.
// TODO: Make a 'Delete' button that will remove data from SQL database given certain inputs (e.g. name).
// TODO: Eventually, make an interface that will display certain kinds of data based on inputs.

public class mainApp {

   public static void main(String[] args) throws Exception {

       // This creates the frame on the event dispatching thread
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               new ControllerClass();
           }
       });

   }
}
