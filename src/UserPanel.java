import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class UserPanel extends JPanel{

    AdminPanel adminPanel = AdminPanel.getInstance();

    public UserPanel(User user, HashMap<Integer, User> setOfCurrentUsers, List<String> tweets) {
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder(user + "\'s Panel"));


        final DefaultListModel listOfFollowing = new DefaultListModel();
        listOfFollowing.addElement("\t(Current Following)");
        for(User x: user.getFollowing()) {
            listOfFollowing.addElement("- " + x.toString());
        }
        final JList following = new JList(listOfFollowing);
        final JScrollPane scrollingFollowing = new JScrollPane(following);

        final DefaultListModel listOfTweets = new DefaultListModel();
        listOfTweets.addElement("\t(News Feed)");
        for(String tweet: tweets) {
            listOfTweets.addElement("- " + tweet);
        }
        JList newsFeed = new JList(listOfTweets);
        final JScrollPane scrollingNewsFeed = new JScrollPane(newsFeed);


        final JTextField userIdField = new JTextField("User Id", 10);
        final JTextField postField = new JTextField("Mini-Tweet", 10);


        JButton followUserButton = new JButton("Follow User");
        followUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer userKey = userIdField.getText().hashCode();
                if(userKey == user.toString().hashCode()){
                    JOptionPane.showMessageDialog(null, "Can not follow yourself");
                }
                else if(alreadyFollowing(userIdField.getText())) {
                    JOptionPane.showMessageDialog(null, "Already following this User");
                }
                else if(setOfCurrentUsers.containsKey(userKey)) {
                    user.followUser(setOfCurrentUsers.get(userIdField.getText().hashCode()));
                    setOfCurrentUsers.get(userIdField.getText().hashCode()).attach(user);
                    listOfFollowing.addElement("- " + userIdField.getText());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Could not find this user");
                }
            }

            private boolean alreadyFollowing(String text) {
                for(User x: user.getFollowing()) {
                    if(x.toString().equals(text)) {
                        return true;
                    }
                }
                return false;
            }
        });

        JButton postButton = new JButton("Post");
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.accept(new MessageVisitor());
                adminPanel.incrementMessages();
                if(containsPositiveWords(postField.getText())) {
                    adminPanel.incrementNiceMessages();
                    user.accept(new PositiveMessageVisitor());
                }
                user.post(postField.getText());
            }

            private boolean containsPositiveWords(String text) {
                Set<String> positiveWords = new HashSet(Arrays.asList("good","nice","happy"));
                String[] str = text.split(" ");
                for(String s: str) {
                    if(positiveWords.contains(s.toLowerCase())) {
                        return true;
                    }
                }
                return false;
            }
        });


        /** Setting up layout for AdminPanel */
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
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


        gc.weightx = 0.0;
        gc.weighty = 0.5;
        gc.gridwidth = 2;
        /** Row 3 */
        gc.gridy = 3;
        gc.gridx = 0;
        add(scrollingNewsFeed, gc);

        /** Row 1 */
        gc.gridx = 0;
        gc.gridy = 1;
        add(scrollingFollowing, gc);
    }
}




