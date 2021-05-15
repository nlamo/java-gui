import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GUI implements ActionListener {

    // Top label
    JLabel jlabel = new JLabel("*** Personal Information ***");
    JLabel emptyLabel = new JLabel(" ");

    // Name
    JLabel userName = new JLabel("Please enter your first name:");
    JTextField userNameText = new JTextField(6);

    // Height
    JLabel userHeight = new JLabel("Please enter your height in cm:");
    JTextField userHeightText = new JTextField(6);

    // Weight
    JLabel userWeight = new JLabel("Please enter your weight in kg:");
    JTextField userWeightText = new JTextField(6);

    // Programming language preference
    JLabel userProgLangPref = new JLabel("Please enter your favourite programming language:");
    JTextField userProgLangPrefText = new JTextField(6);

    // Submit button
    JButton submitHumanProperties = new JButton("Submit");

    GUI() {

        // Creating new frame
        JFrame jframe = new JFrame("Tutorial Swing Application");

        // Creating a GridBagLayout
        GridBagLayout mainLayout = new GridBagLayout();

        // Setting GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();

        // Setting a FlowLayout
        FlowLayout flow = new FlowLayout();
        flow.setVgap(15);

        // Users panel
        JPanel userPanel = new JPanel();

        // Set the flow for the frame
        jframe.setLayout(flow);

        // Add userPanel to frame
        jframe.add(userPanel, BorderLayout.NORTH);

        // setting gridBagLayout
        userPanel.setLayout(mainLayout);

        // size of the frame (window)
        jframe.setSize(400, 600);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ** Title **
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 1;
        userPanel.add(jlabel, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 2;
        userPanel.add(emptyLabel, constraints);

        // ** First name **
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        userPanel.add(userName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        userPanel.add(userNameText, constraints);

        emptyLabel = new JLabel(" ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 5;
        userPanel.add(emptyLabel, constraints);

        // ** Height **
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        userPanel.add(userHeight, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        userPanel.add(userHeightText, constraints);

        emptyLabel = new JLabel(" ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 8;
        userPanel.add(emptyLabel, constraints);

        // ** Weight **
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        userPanel.add(userWeight, constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        userPanel.add(userWeightText, constraints);

        emptyLabel = new JLabel(" ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 11;
        userPanel.add(emptyLabel, constraints);

        // ** Programming Language Preference **
        constraints.gridx = 0;
        constraints.gridy = 12;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        userPanel.add(userProgLangPref, constraints);

        constraints.gridx = 0;
        constraints.gridy = 13;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        userPanel.add(userProgLangPrefText, constraints);

        emptyLabel = new JLabel(" ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 14;
        userPanel.add(emptyLabel, constraints);

        // ** Submit Button **
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 15;
        userPanel.add(submitHumanProperties, constraints);

        submitHumanProperties.addActionListener(this);

        // actually show the frame (window)
        jframe.setVisible(true);
    }

    // Button event handling
    // Will contain all of the logic for any buttons contained within this file until I refactor it into
    // Multiple different files
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("Submit")) {

            System.out.println("Button is responding.");

            // TODO: Solve the AUTO INCREMENT issue with insertion into database
            // All of the the JTextField entries being added to the SQL query, readied for insertion
            String userInsert = "INSERT INTO users VALUES (1, '" + userNameText.getText() + "', " + userHeightText.getText()
                                 + ", " + userWeightText.getText() + ", '" + userProgLangPrefText.getText() + "')";

            // Connect to database, execute user information insertion query, close database
            try {
                Connection databaseConnection = null;
                Statement sttmnt = null;

                databaseConnection = DatabaseClass.connectToDatabase();
                sttmnt = databaseConnection.createStatement();

                sttmnt.executeUpdate(userInsert);

                System.out.println("Values have been successfully inserted!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
