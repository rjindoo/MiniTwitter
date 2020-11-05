import java.util.*;

public class User implements Users, Observer, NewsFeed{

    private String userId;
    private List<Observer> observers = new ArrayList();

    private Set<User> following = new HashSet();

    public User(String userId){
        this.userId = userId;
    }

    @Override
    public boolean create(Users user) {
        /** Follows another user */
        try {
            following.add((User) user);
            return true;
        }
        catch (ClassCastException e){
            System.out.println("Can not follow a UserGroup "+e);
            return false;
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer observer: observers){
            observer.notification(userId, message);
        }
    }

    @Override
    public String toString(){
        return userId;
    }

    @Override
    public void notification(String user, String message) {
        // TODO: DISPLAY MESSAGE ON THE USERPANELS
        System.out.println(userId + " notified of tweet from " + user);
    }

    public void post(String message){
        notifyObservers(message);
    }

    public Set<User> getFollowing(){
        return following;
    }
}
