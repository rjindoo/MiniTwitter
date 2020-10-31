import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{

    //Hashtable<String, User> users = new Hashtable();
    AdminPanel adminPanel;

    public Gui(){
        super("Mini-Twitter");

        setLayout(new BorderLayout());

        //final JTextArea textArea = new JTextArea();

        /** Form for adding users and userGroups... see (CreateUsersPanel.java) */
        adminPanel = AdminPanel.getInstance();

        /** Content Pane to place widgets */
        Container c = getContentPane();

        c.add(adminPanel, BorderLayout.CENTER);

    }

}
