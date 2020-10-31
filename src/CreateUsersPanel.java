import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUsersPanel extends JPanel {
    public CreateUsersPanel(AdminPanel adminPanel) {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.RED));

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
                adminPanel.addUser(new User(userIdField.getText()));
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
                adminPanel.addUser(new UserGroup(userGroupIdField.getText()));
                JOptionPane.showMessageDialog(null, "Added " + userGroupIdField.getText());
            }
        });


        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        /**
         * Column 1
         */
        gc.gridx = 0;
        gc.gridy = 0;
        add(userIdField, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        add(userGroupIdField, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        /**
         * Column 2
         */
        gc.gridx = 1;
        gc.gridy = 0;
        add(addUserButton, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(addGroupUserButton, gc);
    }

}
