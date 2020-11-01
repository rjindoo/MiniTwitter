import javax.swing.*;
import java.awt.*;

public class UserViewGui extends JFrame {

    UserPanel userPanel;

    public UserViewGui() {
        super("User-View");
        setLayout(new BorderLayout());
        setSize(650, 500);
        setVisible(true);

        /** Form for adding users and userGroups... see (CreateUsersPanel.java) */
        userPanel = new UserPanel();

        /** Content Pane to place widgets */
        Container c = getContentPane();

        c.add(userPanel, BorderLayout.CENTER);
    }

}
