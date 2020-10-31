import java.util.HashSet;
import java.util.Set;

public class AdminPanel {

    private static AdminPanel pointer; // lazy instantiation
    private Set<Users> twitterUsers;

    public static AdminPanel getInstance() {
        if(pointer == null){
            pointer = new AdminPanel();
        }
        return pointer;
    }

    private AdminPanel() {
        twitterUsers = new HashSet<>();
    }

    public void addUser(Users user) {
        twitterUsers.add(user);
    }

    public void addUserGroup(Users user){
        twitterUsers.add(user);
    }

    public Set<Users> getTwitterUsers() {
        return twitterUsers;
    }

}
