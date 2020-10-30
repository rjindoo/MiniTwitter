import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame{

    //Hashtable<String, User> users = new Hashtable();
    List<Users> rootsUsers = new ArrayList();
    private int numUser = 0;
    private int numGroupUser = 0;
    private int numMessages = 0;
    private int numNiceMessages = 0;

    public Gui(String title){
        super(title);

        setLayout(new BorderLayout());

        final JTextArea textArea = new JTextArea();
        JButton createUserButton = new JButton("Create User");
        JButton createGroupUserButton = new JButton("Create Group");
        JButton viewUser = new JButton("Open User View"); // button not drawn or listening
        JButton getNumOfUsers = new JButton("Get # of Users");
        JButton getNumOfGroupUsers = new JButton("Get # of GroupUsers");

        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(createUserButton, BorderLayout.SOUTH);
        c.add(createGroupUserButton, BorderLayout.NORTH);
        c.add(getNumOfUsers, BorderLayout.EAST);
        c.add(getNumOfGroupUsers, BorderLayout.WEST);


        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rootsUsers.add(new User());
                ++numUser;
            }
        });
        createGroupUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rootsUsers.add(new UserGroup());
                ++numGroupUser;
            }
        });
        getNumOfUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //for(Users user: rootsUsers) {}
                JOptionPane.showMessageDialog(null, "# of users: " + numUser);

            }
        });
        getNumOfGroupUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //for(Users user: rootsUsers) {}
                JOptionPane.showMessageDialog(null, "# of groupUsers: " + numGroupUser);
            }
        });
    }

}
