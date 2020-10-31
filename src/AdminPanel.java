import java.util.*;

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
        // ^^ is bad, creating a new user with same name will override previous user
    }

    public boolean addUser(Users user) {
        if(twitterUsers.containsKey(user.getId().hashCode())){
            System.out.println("User already exists");
            return false;
        }
        twitterUsers.put(user.getId().hashCode(), user);
        return true;
    }

    public boolean addUserGroup(Users user){
        if(twitterUsers.containsKey(user.getId().hashCode())){
            System.out.println("UserGroup already exists");
            return false;
        }
        twitterUsers.put(user.getId().hashCode(), user);
        return true;
    }

    public Collection<Users> getTwitterUsers() {
        return twitterUsers.values();
    }

}
