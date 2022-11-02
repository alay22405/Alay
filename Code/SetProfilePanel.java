package Code;

import javax.swing.*;
import java.awt.*;

public class SetProfilePanel extends JPanel
{
    private String firstName;
    private String email;

    //Default constructor
    SetProfilePanel(){
        //Set Profile Panel Components
        setLayout(new GridLayout(2,2));
        var firstNameDisplay = new TextField(20);
        var emailDisplay = new TextField(50);
        var firstNameButton = new JButton("Set First Name");
        var emailButton = new JButton("Set Email");
        add(firstNameDisplay);
        add(firstNameButton);
        add(emailDisplay);
        add(emailButton);

        firstNameButton.addActionListener(e -> firstName = firstNameDisplay.getText());
        emailButton.addActionListener(e -> email = emailDisplay.getText());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
