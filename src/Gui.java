import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{

    //Hashtable<String, User> users = new Hashtable();
    AdminPanel adminPanel = AdminPanel.getInstance();
    CreateUsersPanel createUsersPanel;

    public Gui(){
        super();

        setLayout(new BorderLayout());

        final JTextArea textArea = new JTextArea();

        /**
         * Buttons
         */
        JButton viewUser = new JButton("Open User View"); // button not drawn or listening
        JButton getNumOfUsers = new JButton("Get # of Users");
        JButton getNumOfUserGroups = new JButton("Get # of GroupUsers");

        /**
         * Form for adding users and usergroups
         */
        createUsersPanel = new CreateUsersPanel(adminPanel);

        /**
         * Content Pane to place widgets
         */
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        //c.add(getNumOfUsers, BorderLayout.EAST);
        c.add(getNumOfUserGroups, BorderLayout.WEST);
        c.add(createUsersPanel, BorderLayout.EAST);

    }

}
