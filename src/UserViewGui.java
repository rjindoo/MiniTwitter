import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UserViewGui extends JFrame {

    UserPanel userPanel;

    public UserViewGui(User user, HashMap<Integer, User> setOfCurrentUsers) {
        super("User-View");
        setLayout(new BorderLayout());
        setSize(650, 500);
        setVisible(true);

        /** Form for adding users and userGroups... see (CreateUsersPanel.java) */
        userPanel = new UserPanel(user, setOfCurrentUsers);

        /** Content Pane to place widgets */
        Container c = getContentPane();

        c.add(userPanel, BorderLayout.CENTER);
    }

}
