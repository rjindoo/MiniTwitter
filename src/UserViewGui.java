import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UserViewGui extends JFrame {

    UserPanel userPanel;

    public UserViewGui(User user, HashMap<Integer, User> setOfCurrentUsers, List<String> tweets) {
        super("User-View");
        setLayout(new BorderLayout());
        setSize(650, 500);
        setVisible(true);

        userPanel = new UserPanel(user, setOfCurrentUsers, tweets);

        Container c = getContentPane();

        c.add(userPanel, BorderLayout.CENTER);
    }

}
