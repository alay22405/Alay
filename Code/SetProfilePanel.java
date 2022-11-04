package Code;

import javax.swing.*;
import java.awt.*;

public class SetProfilePanel extends JPanel
{
    //Default constructor
    SetProfilePanel(String Name, String usermail) {
        setSize(new Dimension(600, 600));
        //Set Profile Panel Components
        //setLayout(new GridLayout(2, 2));
        var firstNameDisplay = new TextField(20);
        firstNameDisplay.setPreferredSize(new Dimension(20,50));
        var emailDisplay = new TextField(50);
        emailDisplay.setPreferredSize(new Dimension(20,50));
        var firstNameButton = new JButton("Set First Name");
        var emailButton = new JButton("Set Email");
        add(firstNameDisplay);
        add(firstNameButton);
        add(emailDisplay);
        add(emailButton);

        firstNameButton.addActionListener(e -> { MainWindow.firstName = firstNameDisplay.getText();
        });
        emailButton.addActionListener(e -> MainWindow.email = emailDisplay.getText());
    }
}
