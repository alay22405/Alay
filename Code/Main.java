package Code;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static String appVersion = "v0.1";
    public static void main(String[] args) {
        EventQueue.invokeLater(()->
                {
                    var mainWindow = new GUIHandler();
                    mainWindow.setTitle("SAMA- Information Organizer Application" + " " + appVersion);
                    mainWindow.setVisible(true);
         }
        );
    }
}
