package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MainWindow extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;
    public static String firstName;
    public static String email;
    private ArrayList<String> developers = new ArrayList<String>();

    MainWindow(){
        //Adding the Developers of the app
        developers.add("Mark Andrey Rubio - this app needs more work.");
        developers.add("Salahuddin Majed");
        developers.add("Alay Kidane");
        developers.add("Arshdeep Singh");


        //Creating a new panel
        JPanel mainPanel = new JPanel();

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
                getContentPane().removeAll();
                var AboutPanel = new AboutPanel(firstName, email, developers);
                AboutPanel.setVisible(true);
                getContentPane().add(AboutPanel);

                validate();
            }
        });

        SetProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                var newSetProfilePanel = new SetProfilePanel(firstName, email);
                newSetProfilePanel.setVisible(true);
                getContentPane().add(newSetProfilePanel);

                validate();
            }
        });


        //Panel properties
        getContentPane().add(mainPanel);

        //Main Window Properties
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
    }
}
