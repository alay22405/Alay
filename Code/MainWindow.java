package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

public class MainWindow extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;
    private String firstName;
    private String email;


    MainWindow(){
        //Creating a new panel
        JPanel mainPanel = new JPanel();
        JPanel setProfilePanel = new JPanel();
        JPanel ProfilePanel = new JPanel();
        JPanel AboutPanel = new JPanel();
        setProfilePanel.setVisible(false);
        ProfilePanel.setVisible(false);
        AboutPanel.setVisible(false);
        mainPanel.setVisible(true);


        //Panel properties
        add(mainPanel);
        //add(setProfilePanel);
        //add(ProfilePanel);
        //add(AboutPanel);


        var AboutButton = new JButton("About");
        AboutButton.setPreferredSize(new Dimension(100,60));
        AboutButton.setVisible(true);
        var SetProfileButton = new JButton("Profile");
        SetProfileButton.setPreferredSize(new Dimension(100,60));
        SetProfileButton.setVisible(true);

        mainPanel.add(AboutButton);
        mainPanel.add(SetProfileButton);

        AboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                AboutPanel.setVisible(true);
            }
        });

        SetProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                setProfilePanel.setVisible(true);
            }
        });


        //Set Profile Panel Components
        setProfilePanel.setLayout(new GridLayout(2,2));
        var firstNameDisplay = new TextField(20);
        var emailDisplay = new TextField(50);
        var firstNameButton = new JButton("Set First Name");
        var emailButton = new JButton("Set Email");
        setProfilePanel.add(firstNameDisplay);
        setProfilePanel.add(firstNameButton);
        setProfilePanel.add(emailDisplay);
        setProfilePanel.add(emailButton);

        firstNameButton.addActionListener(e -> firstName = firstNameDisplay.getText());
        emailButton.addActionListener(e -> email = emailDisplay.getText());

        //About Panel Components
        var ProfileButton = new JButton("Profile");
        ProfileButton.setPreferredSize(new Dimension(100,60));
        var AboutCompanyButton = new JButton("About Developers");
        AboutCompanyButton.setPreferredSize(new Dimension(100,60));
        AboutPanel.add(ProfileButton);
        AboutPanel.add(AboutCompanyButton);

        var AboutCompanyPanel = new JPanel();
        add(AboutCompanyPanel);
        AboutCompanyPanel.setVisible(false);


        //ProfilePanel Components
        JTextArea profileInfo = new JTextArea();
        profileInfo.setText("First Name: \n" +
                "Email: \n");
        ProfilePanel.add(profileInfo);


        ProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //What to do when profile button is pressed
                if (firstName == null || email == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "First Name or Email fields are empty!");
                } else{
                    profileInfo.setText("First Name: "  + firstName + "\n" +
                            "Email: " + email);
                    ProfilePanel.setVisible(true);
                }
            }
        });




        //Main Window Properties
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
        setLayout(null);
    }
}
