package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

public class GUIHandler extends JFrame {
    //Window Default Sizes
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;
    //Developers
    private ArrayList<String> developers = new ArrayList<String>();
    //Main Window Main Panel
    private static JPanel mainPanel = new JPanel();

    //Current User
    private static User CurrentUser;
    //Users
    private static ArrayList<User> users;

    //FileHandler- handles all file exporting and importing
    FilesHandler FileHandler = new FilesHandler();

    /**
     * Creates the main window, and add the main panel to the frame.
     * It also adds all the names of the developers into an ArrayList
     * @Author Mark Andrey Rubio
     **/
    GUIHandler(){
        //Adding the Developers of the app
        developers.add("Mark.txt Andrey Rubio - Mark.txt.");
        developers.add("Salahuddin Majed - Salahuddin");
        developers.add("Alay Kidane - Alay");
        developers.add("Arshdeep Singh - Singh");

        //adding the main panel to the frame
        getContentPane().add(mainPanel);

        generateSignInPanel();

        //setting the size and visibility of the main window
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);

        //when the window is closed when want to run this method
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FileHandler.generateUserFilesAfterWindowClosed(users);
                System.exit(0);
            }
        });
    }


    /**
     * Generates a sign in panel and checks whether they exist or not already
     * @Author Mark Andrey Rubio
     * */
    public void generateSignInPanel(){
        //remove any pre-existing GUI components
        mainPanel.removeAll();
        users = FileHandler.generateUsersFromPackageOrFolder(new File("Code/AccountFiles"));

        //generate UI components
        var SignInDisplay = new TextField(20);
        SignInDisplay.setPreferredSize(new Dimension(20,50));
        var signInButton = new JButton("SIGN IN");
        mainPanel.add(SignInDisplay);
        mainPanel.add(signInButton);
        System.out.println(users.size());
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if the user already exists or not
                Boolean userExists = false;
                for (User user: users) {
                    if (user.getUserName().equals(SignInDisplay.getText())) {
                        System.out.println("User Exists");
                        userExists = true;
                        CurrentUser = user;
                        generateMenuPanel();
                    }
                }
                //if the user does not exist then ask them to set their account/user settings
                if (!userExists) {
                    //if there is no other users the new user becomes an admin
                    if (users.size() == 0) {
                        CurrentUser = new Admin("","");
                        users.add(CurrentUser);
                        SetProfilePanel();
                    }
                    //if there are other users then the new user becomes a regular user
                    else {
                        CurrentUser = new User("","", false);
                        users.add(CurrentUser);
                        SetProfilePanel();
                    }

                }
            }
        });
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

        firstNameButton.addActionListener(e -> { CurrentUser.setUserName(firstNameDisplay.getText());
        });
        emailButton.addActionListener(e -> { CurrentUser.setEmail(emailDisplay.getText());});
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
        if (CurrentUser.getUserName() == null) {
            text.setText("This is registered to no one\n");
            addDevelopers(text, developers);
        } else {
            text.setText("This app is registered to: " + CurrentUser.getUserName()+ "\n");
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