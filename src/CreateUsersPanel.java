import javax.swing.*;
import java.awt.*;

public class CreateUsersPanel extends JPanel {
    public CreateUsersPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.RED));

        //JLabel userIdLabel = new JLabel("User Id: ");
        //JLabel groupUserIdLabel = new JLabel("Group Id: ");

        JTextField userIdField = new JTextField("User Id", 10);
        JTextField groupUserIdField = new JTextField("Group Id", 10);

        JButton addUserButton = new JButton("Add User");
        JButton addGroupUserButton = new JButton("Add Group");

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
        add(groupUserIdField, gc);

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
