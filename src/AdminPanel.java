import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AdminPanel {

    private static AdminPanel pointer; // lazy instantiation
    private HashMap<Integer, Users> twitterUsers;

    public static AdminPanel getInstance() {
        if(pointer == null){
            pointer = new AdminPanel();
        }
        return pointer;
    }

    private AdminPanel() {
        twitterUsers = new HashMap();
    }

    public void addUser(Users user) {
        twitterUsers.put(user.getId().hashCode(), user);
    }

    public void addUserGroup(Users user){
        twitterUsers.put(user.getId().hashCode(), user);
    }

    public Collection<Users> getTwitterUsers() {
        return twitterUsers.values();
    }

}
