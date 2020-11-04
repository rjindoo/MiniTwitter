import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class UserPanel extends JPanel {

    // pass in a set of existing users
    public UserPanel(User user, HashMap<Integer, Users> setOfCurrentUsers) {
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder(user + "\'s Panel"));


        final JTextField userIdField = new JTextField("User Id", 10);
        final JTextField postField = new JTextField("Mini-Tweet", 10);

        final JTextArea currentFollowing = new JTextArea();
        final JTextArea newsFeed = new JTextArea();


        JButton followUserButton = new JButton("Follow User");
        followUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(setOfCurrentUsers.containsKey(userIdField.getText().hashCode())) {
                    user.create(setOfCurrentUsers.get(userIdField.getText().hashCode()));
                    currentFollowing.append("Currently following " + user.getFollowing() + "\n");
                }
                else{
                    currentFollowing.append("Could not find " + userIdField.getText() + "\n");
                }
            }
        });

        JButton postButton = new JButton("Post");
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Observer Pattern for messages
            }
        });


        /** Setting up layout for AdminPanel */
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0.1;
        gc.weighty = 0.1;
        /** Row 0 */
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridy = 0;
        gc.gridx = 0;
        add(userIdField, gc);
        gc.gridx = 1;
        add(followUserButton, gc);

        /** Row 2 */
        gc.weighty = 0.1;
        gc.weightx = 0.1;
        gc.gridy = 2;
        gc.gridx = 0;
        add(postField, gc);
        gc.gridx = 1;
        add(postButton, gc);

        /** Row 3 */
        gc.gridy = 3;
        gc.gridx = 0;

        /** Row 1 */
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 0.0;
        gc.weighty = 0.5;
        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 1;
        JScrollPane scrollPane = new JScrollPane(currentFollowing);
        add(scrollPane, gc);
        gc.fill = GridBagConstraints.NONE;
    }
}




