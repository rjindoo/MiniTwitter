import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        UserViewGui temp = this;

        userPanel = new UserPanel(user, setOfCurrentUsers, tweets);
        JButton refresh = new JButton("Refresh Tweets");

        Container c = getContentPane();

        c.add(userPanel, BorderLayout.CENTER);
        c.add(refresh, BorderLayout.SOUTH);
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserViewGui newGui = new UserViewGui(user, setOfCurrentUsers, tweets);
                newGui.setVisible(true);
                temp.dispose();
            }
        });
    }

}
