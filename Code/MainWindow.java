package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;
    private static String firstName;
    private static String email;
    private ArrayList<String> developers = new ArrayList<String>();
    private static JPanel mainPanel = new JPanel();

    /**
     * Creates the main window, and add the main panel to the frame.
     * It also adds all the names of the developers into an ArrayList
     * @Author Mark Andrey Rubio
     **/
    MainWindow(){
        //Adding the Developers of the app
        developers.add("Mark Andrey Rubio - Mark.");
        developers.add("Salahuddin Majed - Salahuddin");
        developers.add("Alay Kidane - Alay");
        developers.add("Arshdeep Singh - Singh");

        //adding the main panel to the frame
        getContentPane().add(mainPanel);

        //adding the main menu components like about and profile
        generateMenuPanel();

        //setting the size and visibility of the main window
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
    }

    /***
     * Adds all the buttons of the main menu to the main panel and their events.
     * @Author Mark Andrey Rubio
     **/
    public void generateMenuPanel(){
        //remove any pre-existing GUI components
        mainPanel.removeAll();

        //creates the About and Profile Buttons
        var AboutButton = new JButton("About");
        AboutButton.setPreferredSize(new Dimension(100,60));
        AboutButton.setVisible(true);
        var SetProfileButton = new JButton("Profile");
        SetProfileButton.setPreferredSize(new Dimension(100,60));
        SetProfileButton.setVisible(true);

        mainPanel.add(AboutButton);
        mainPanel.add(SetProfileButton);

        //About Button event
        AboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutPanel();
            }
        });

        //Profile Button event
        SetProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetProfilePanel();
            }
        });

        //refresh the GUI/Window
        revalidate();
        repaint();
    }

    /**
     * Resets the main panel and adds the set profile gui components
     * @Author Mark Andrey Rubio
     * **/
    public void SetProfilePanel(){
        //remove any pre-existing GUI components
        mainPanel.removeAll();
        var firstNameDisplay = new TextField(20);
        firstNameDisplay.setPreferredSize(new Dimension(20,50));
        var emailDisplay = new TextField(50);
        emailDisplay.setPreferredSize(new Dimension(20,50));
        var firstNameButton = new JButton("Set First Name");
        var emailButton = new JButton("Set Email");
        var backButton = new JButton("Back");
        mainPanel.add(firstNameDisplay);
        mainPanel.add(firstNameButton);
        mainPanel.add(emailDisplay);
        mainPanel.add(emailButton);
        mainPanel.add(backButton);

        firstNameButton.addActionListener(e -> { firstName = firstNameDisplay.getText();
        });
        emailButton.addActionListener(e -> email = emailDisplay.getText());
        backButton.addActionListener(e -> generateMenuPanel());

        //refresh the GUI/Window
        revalidate();
        repaint();
    }

    /**
     * Resets the main panel and adds about panel components
     * @Author Mark Andrey Rubio
     * **/
    public void AboutPanel(){
        //remove any pre-existing GUI components
        mainPanel.removeAll();
        var text = new JTextArea();
        if (firstName == null) {
            text.setText("This is registered to no one\n");
            addDevelopers(text, developers);
        } else {
            text.setText("This app is registered to: " + firstName+ "\n");
            addDevelopers(text, developers);
        }
        var backButton = new JButton("Back");
        mainPanel.add(text);
        mainPanel.add(backButton);
        backButton.addActionListener(e -> generateMenuPanel());

        //refresh the GUI/Window
        revalidate();
        repaint();
    }

    /**
     * A helper method to append the names of the developers to a JTextArea
     * **/
    private void addDevelopers(JTextArea textArea, ArrayList<String> developers){
        textArea.append("This app is provided by: \n");
        for (String text: developers
        ) {
            textArea.append(text + "\n");
        }
    }
}