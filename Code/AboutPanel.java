package Code;

import javax.swing.*;
import java.util.ArrayList;

public class AboutPanel extends JPanel {
    AboutPanel(String UserFirstName, String UserEmail, ArrayList<String> developers){
        var text = new JTextArea();
        if (UserFirstName == null || UserEmail == null) {
            text.setText("This is registered to no one\n");
            addDevelopers(text, developers);
        } else {
            text.setText("This app is registered to: " + UserFirstName);
            addDevelopers(text, developers);
        }
        add(text);

    }

    private void addDevelopers(JTextArea textArea, ArrayList<String> developers){
        textArea.append("This app is provided by: \n");
        for (String text: developers
             ) {
            textArea.append(text + "\n");
        }
    }

}
