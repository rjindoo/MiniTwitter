import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUsersPanel extends JPanel {

    private int numUser = 0;
    private int numGroupUser = 0;
    private int numMessages = 0;
    private int numNiceMessages = 0;

    public CreateUsersPanel(AdminPanel adminPanel) {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //JLabel userIdLabel = new JLabel("User Id: ");
        //JLabel groupUserIdLabel = new JLabel("Group Id: ");

        final JTextField userIdField = new JTextField("User Id", 10);
        final JTextField userGroupIdField = new JTextField("Group Id", 10);

        /**
         * Button to add a new User, stores to AdminPanel
         */
        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adminPanel.addUser(new User(userIdField.getText()));
                JOptionPane.showMessageDialog(null, "Added " + userIdField.getText());
            }
        });
        /**
         * Button to add a new userGroup, stores to AdminPanel
         */
        JButton addGroupUserButton = new JButton("Add Group");
        addGroupUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adminPanel.addUserGroup(new UserGroup(userGroupIdField.getText()));
                JOptionPane.showMessageDialog(null, "Added " + userGroupIdField.getText());
            }
        });
        /**
         * Button to open a selected user from TreeView
         */
        JButton openUserView = new JButton("Open User View");
        openUserView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });

        JButton showUserTotal = new JButton("Show User Total");
        showUserTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, adminPanel.getTwitterUsers());
            }
        });

        JButton showUserGroupTotal = new JButton("Show Group Total");
        showUserGroupTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, adminPanel.getTwitterUsers());
            }
        });

        JButton showMessagesTotal = new JButton("Show # of messages");
        showMessagesTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, numMessages);
            }
        });

        JButton showPositiveMessagesTotal = new JButton("Show % of posi messages");
        showPositiveMessagesTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, numNiceMessages);
            }
        });


        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 0;
        gc.weighty = 0;
        /**
         * Row 0 / 1
         * Column 0
         */
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 0;
        gc.gridy = 0;
        add(userIdField, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        add(userGroupIdField, gc);

        /**
         * Row 0 / 1
         * Column 1
         */
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 1;
        gc.gridy = 0;
        add(addUserButton, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(addGroupUserButton, gc);

        /**
         * Row 3 / 4
         * Column 0
         */
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 0;
        gc.gridy = 3;
        add(showUserTotal, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        add(showUserGroupTotal, gc);

        /**
         * Row 3 / 4
         * Column 1
         */
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 3;
        add(showMessagesTotal, gc);
        gc.gridx = 1;
        gc.gridy = 4;
        add(showPositiveMessagesTotal, gc);

        /**
         * Fill Column
         * Row 2
         */
        gc.gridwidth = 3;
        gc.weightx = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridy = 2;
        gc.gridx = 0;
        add(openUserView, gc);
    }

}
