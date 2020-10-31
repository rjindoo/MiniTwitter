import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Admin {

    private static Admin pointer; // lazy instantiation
    private Set<Users> twitterUsers;

    public static Admin getInstance() {
        if(pointer == null){
            pointer = new Admin();
        }
        return pointer;
    }

    private Admin() {
        twitterUsers = new HashSet();
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
