import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AdminPanel extends JPanel {

    private static AdminPanel pointer; // lazy instantiation
    private int numUser = 0;
    private int numUserGroups = 0;
    private int numMessages = 0;
    public void incrementMessages(){++numMessages;}
    private int numNiceMessages = 0;
    public void incrementNiceMessages(){++numNiceMessages;}
    private DynamicTree treePanel;
    HashMap<Integer, User> setOfCurrentUsers = new HashMap();
    HashMap<Integer, Users> setOfCurrentUserGroups = new HashMap();


    public static AdminPanel getInstance() {
        if(pointer == null){
            pointer = new AdminPanel();
        }
        return pointer;
    }

    private AdminPanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Admin Panel"));


        /** Creating components for the admin panel */
        treePanel = new DynamicTree();
        treePanel.setPreferredSize(new Dimension(300, 150));

        final JTextField userIdField = new JTextField("User Id", 10);
        final JTextField userGroupIdField = new JTextField("Group Id", 10);


        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User newUser = null;
                if(setOfCurrentUsers.containsKey(userIdField.getText().hashCode())) {
                    JOptionPane.showMessageDialog(null, "This user already exists");
                }
                else {
                    newUser = new User(userIdField.getText());
                }
                /** Adds the user to tree if they do not already exist **/
                if(newUser == null) { }
                else if(treePanel.addUsers(newUser) == null){
                    JOptionPane.showMessageDialog(null, "Can not add Users to a User");
                }
                else {
                    ++numUser;
                    try {
                        setOfCurrentUsers.put(newUser.toString().hashCode(), newUser);
                    }
                    catch (NullPointerException exception) {}
                }
            }
        });

        JButton addGroupUserButton = new JButton("Add Group");
        addGroupUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Users newUser = null;
                if(setOfCurrentUserGroups.containsKey(userGroupIdField.getText().hashCode())) {
                    JOptionPane.showMessageDialog(null, "This userGroup already exists");
                }
                else {
                    newUser = new UserGroup(userGroupIdField.getText());
                }
                /** Adds the userGroup to tree if they do not already exist **/
                if(newUser == null) { }
                else if(treePanel.addUsers(newUser) == null){
                    JOptionPane.showMessageDialog(null, "Can not add Users to a User");
                }
                else {
                    ++numUserGroups;
                    try {
                        setOfCurrentUserGroups.put(newUser.toString().hashCode(), newUser);
                    }
                    catch (NullPointerException exception) {}
                }
            }
        });

        JButton openUserView = new JButton("Open User View");
        openUserView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User selectedUser = (User) treePanel.accessCurrentNode();
                if(selectedUser == null) {
                    JOptionPane.showMessageDialog(null, "Can not open a view for a UserGroup");
                }
                else{
                    UserViewGui userViewGui = new UserViewGui(selectedUser, setOfCurrentUsers, selectedUser.getTweets());
                    userViewGui.setVisible(true);
                }
            }
        });

        JButton showUserTotal = new JButton("Show User Total");
        showUserTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Total Users: " + numUser);
            }
        });

        JButton showUserGroupTotal = new JButton("Show Group Total");
        showUserGroupTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Total UserGroups: " + numUserGroups);
            }
        });

        JButton showMessagesTotal = new JButton("Show # of messages");
        showMessagesTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Messages button: " + numMessages);
            }
        });

        JButton showPositiveMessagesTotal = new JButton("Show % of posi messages");
        showPositiveMessagesTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Positive Messages: " + numNiceMessages);
            }
        });


        /** Setting up layout for AdminPanel */
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 2;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.VERTICAL;
        add(treePanel, gc);

        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1;
        gc.weighty = 0.1;
        /**
         * Row 0 / 1
         * Column 0
         */
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(userIdField, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(userGroupIdField, gc);

        /**
         * Row 0 / 1
         * Column 1
         */
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 2;
        gc.gridy = 0;
        add(addUserButton, gc);
        gc.gridx = 2;
        gc.gridy = 1;
        add(addGroupUserButton, gc);

        /**
         * Row 3 / 4
         * Column 0
         */
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 3;
        add(showUserTotal, gc);
        gc.gridx = 1;
        gc.gridy = 4;
        add(showUserGroupTotal, gc);

        /**
         * Row 3 / 4
         * Column 1
         */
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 2;
        gc.gridy = 3;
        add(showMessagesTotal, gc);
        gc.gridx = 2;
        gc.gridy = 4;
        add(showPositiveMessagesTotal, gc);

        /**
         * Fill Column
         * Row 2
         */
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridwidth = 3;
        gc.weighty = .5;
        gc.anchor = GridBagConstraints.NORTH;
        gc.gridy = 2;
        gc.gridx = 1;
        add(openUserView, gc);
    }
}




