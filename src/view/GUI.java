package view;
import controller.ControllerClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    // Our controller class, which is tightly coupled with the GUI
    ControllerClass controller = new ControllerClass();

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

    // Submit user - button
    JButton submitUser = new JButton("Submit User");

    // Delete user
    JLabel deleteUserLabel = new JLabel("To delete a user, please enter a surname: ");
    JTextField deleteUserText = new JTextField(6);
    JButton deleteUser = new JButton("Delete User");

    public GUI() {

        // Creating new frame
        JFrame jframe = new JFrame("Java GUI");

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
        userPanel.add(submitUser, constraints);

        emptyLabel = new JLabel(" ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 16;
        userPanel.add(emptyLabel, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 17;
        userPanel.add(deleteUserLabel, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 18;
        userPanel.add(deleteUserText, constraints);

        emptyLabel = new JLabel(" ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 19;
        userPanel.add(emptyLabel, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 20;
        userPanel.add(deleteUser, constraints);

        submitUser.addActionListener(this);
        deleteUser.addActionListener(this);

        // actually show the frame (window)
        jframe.setVisible(true);
    }

    // Button event handling
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("Submit User")) {

            System.out.println("Button is responding.");

            controller.insertUser(userNameText, userHeightText, userWeightText, userProgLangPrefText);
        }

        if (ae.getActionCommand().equals("Delete User")) {

            System.out.println("Button is responding");

            controller.deleteUser(deleteUserText);
        }
    }
}
