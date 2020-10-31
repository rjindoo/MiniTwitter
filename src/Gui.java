import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{

    //Hashtable<String, User> users = new Hashtable();
    AdminPanel adminPanel = AdminPanel.getInstance();
    CreateUsersPanel createUsersPanel;
    private int numUser = 0;
    private int numGroupUser = 0;
    private int numMessages = 0;
    private int numNiceMessages = 0;

    public Gui(){
        super();

        setLayout(new BorderLayout());

        final JTextArea textArea = new JTextArea();

        /**
         * Buttons
         */
        JButton viewUser = new JButton("Open User View"); // button not drawn or listening
        JButton getNumOfUsers = new JButton("Get # of Users");
        JButton getNumOfUserGroups = new JButton("Get # of GroupUsers");

        /**
         * Form for adding users and usergroups
         */
        createUsersPanel = new CreateUsersPanel(adminPanel);

        /**
         * Content Pane to place widgets
         */
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        //c.add(getNumOfUsers, BorderLayout.EAST);
        c.add(getNumOfUserGroups, BorderLayout.WEST);
        c.add(createUsersPanel, BorderLayout.EAST);


        getNumOfUsers.addActionListener(new ActionListener() {
            /**
             *  Button action to get total number of users
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "# of users: " + numUser);
            }
        });
        getNumOfUserGroups.addActionListener(new ActionListener() {
            /**
             *   Button action to get total number of groupUsers
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Users user: adminPanel.getTwitterUsers()) {
                    textArea.append(""+user.getId()+"\n");
                }
                //JOptionPane.showMessageDialog(null, "# of groupUsers: " + numGroupUser);
            }
        });
    }

}
