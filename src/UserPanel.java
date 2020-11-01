import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel {

    public UserPanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Admin Panel"));


        final JTextField userIdField = new JTextField("User Id", 10);
        final JTextField userGroupIdField = new JTextField("Group Id", 10);


        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton addGroupUserButton = new JButton("Add Group");
        addGroupUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton openUserView = new JButton("Open User View");
        openUserView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton showUserTotal = new JButton("Show User Total");
        showUserTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton showUserGroupTotal = new JButton("Show Group Total");
        showUserGroupTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton showMessagesTotal = new JButton("Show # of messages");
        showMessagesTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton showPositiveMessagesTotal = new JButton("Show % of posi messages");
        showPositiveMessagesTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });


        /** Setting up layout for AdminPanel */
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

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




