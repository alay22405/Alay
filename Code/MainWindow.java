package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;
    public static String firstName;
    public static String email;
    private ArrayList<String> developers = new ArrayList<String>();
    public static JPanel mainPanel = new JPanel();

    MainWindow(){
        //Adding the Developers of the app
        developers.add("Mark Andrey Rubio - this app needs more work.");
        developers.add("Salahuddin Majed");
        developers.add("Alay Kidane");
        developers.add("Arshdeep Singh");
        getContentPane().add(mainPanel);
        generateMenuPanel();
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
    }

    public void generateMenuPanel(){
        mainPanel.removeAll();
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
                AboutPanel();
            }
        });

        SetProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetProfilePanel();
            }
        });
        revalidate();
        repaint();
    }

    public void SetProfilePanel(){
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
        revalidate();
        repaint();
    }

    public void AboutPanel(){
        mainPanel.removeAll();
        var text = new JTextArea();
        if (firstName == null || email == null) {
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
        revalidate();
        repaint();
    }

    private void addDevelopers(JTextArea textArea, ArrayList<String> developers){
        textArea.append("This app is provided by: \n");
        for (String text: developers
        ) {
            textArea.append(text + "\n");
        }
    }
}