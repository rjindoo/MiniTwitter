import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{

    //Hashtable<String, User> users = new Hashtable();
    AdminPanel adminPanel = AdminPanel.getInstance();
    CreateUsersPanel createUsersPanel;

    public Gui(){
        super("Mini-Twitter");

        setLayout(new BorderLayout());

        final JTextArea textArea = new JTextArea();

        /**
         * Form for adding users and usergroups... see (CreateUsersPanel.java)
         */
        createUsersPanel = new CreateUsersPanel(adminPanel);

        /**
         * Content Pane to place widgets
         */
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(createUsersPanel, BorderLayout.EAST);

    }

}
