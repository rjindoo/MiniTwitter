import com.sun.source.tree.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame{

    //Hashtable<String, User> users = new Hashtable();
    Admin admin = Admin.getInstance();
    private int numUser = 0;
    private int numGroupUser = 0;
    private int numMessages = 0;
    private int numNiceMessages = 0;

    public Gui(){
        super();

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
            /**
                Button action to add a new user
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.addUser(new User());
                ++numUser;
            }
        });
        createGroupUserButton.addActionListener(new ActionListener() {
            /**
                Button action to add a new groupUser
            */
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.addUserGroup(new UserGroup());
                ++numGroupUser;
            }
        });
        getNumOfUsers.addActionListener(new ActionListener() {
            /**
                Button action to get total number of users
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "# of users: " + numUser);

            }
        });
        getNumOfGroupUsers.addActionListener(new ActionListener() {
            /**
                Button action to get total number of groupUsers
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                /*for(Users user: admin.getTwitterUsers()) {
                    textArea.append(""+user+"\n");
                }*/
                JOptionPane.showMessageDialog(null, "# of groupUsers: " + numGroupUser);
            }
        });
    }

}
