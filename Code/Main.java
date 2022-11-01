package Code;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->
                {
                    var mainWindow = new MainWindow();
                    mainWindow.setTitle("SAMA- Information Organizer Application");
                    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainWindow.setVisible(true);
         }
        );
    }
}
