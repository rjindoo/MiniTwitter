import javax.swing.*;
import java.awt.*;


public class AdminGui extends JFrame{

    AdminPanel adminPanel;

    public AdminGui(){
        super("Mini-Twitter");
        setLayout(new BorderLayout());


        /** Form for adding users and userGroups... see (CreateUsersPanel.java) */
        adminPanel = AdminPanel.getInstance();

        /** Content Pane to place widgets */
        Container c = getContentPane();

        c.add(adminPanel, BorderLayout.CENTER);

    }

}
