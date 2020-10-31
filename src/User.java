import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User implements Users{

    private String userId;
    private List<User> followers = new ArrayList<>();
    private List<User> following = new ArrayList<>();

    public User(String userId){
        this.userId = userId;
    }

    @Override
    public void addUser(Users user) {
        try {
            following.add((User) user);
        }
        catch (ClassCastException e){
            System.out.println("Can not follow a UserGroup "+e);
        }
    }

    public String getId(){
        return userId;
    }

    public void post(String message){
        System.out.println(message);
    }

    public List<User> getFollowers(){
        return followers;
    }

    public List<User> getFollowing(){
        return following;
    }

}
