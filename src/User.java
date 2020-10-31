import java.util.*;

public class User implements Users{

    private String userId;
    private Set<User> followers = new HashSet();
    private Set<User> following = new HashSet();

    public User(String userId){
        this.userId = userId;
    }

    @Override
    public void create(Users user) {
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

    public Set<User> getFollowers(){
        return followers;
    }

    public Set<User> getFollowing(){
        return following;
    }

}
