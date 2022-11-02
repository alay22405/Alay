package Code;

import javax.swing.*;
import java.awt.*;
public class GUI {
    public GUI() {

        JFrame frame = new JFrame();
        frame.setTitle("SAMA");
        frame.setSize(600, 600);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Hello");


        JButton aboutButton = new JButton("ABOUT");
        aboutButton.setBounds(250, 400, 100, 30);
        frame.add(aboutButton);





    }
}

