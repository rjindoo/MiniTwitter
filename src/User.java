import java.util.*;

public class User implements Users, Observer, Subject {

    private String userId;
    private Set<Observer> observers = new HashSet();
    private Set<User> following = new HashSet();
    private List<String> tweets = new ArrayList();
    private UsersVisitor addNewUser = new UserVisitor();

    public User(String userId){
        this.userId = userId;
        this.create();
    }

    @Override
    public void create() {
        this.accept(addNewUser);
    }

    public boolean followUser(User user) {
        /** Follows another user */
        try {
            following.add((User) user);
            this.accept(addNewUser);
            return true;
        }
        catch (ClassCastException e){
            System.out.println("Can not follow a UserGroup "+e);
            return false;
        }
    }

    @Override
    public void accept(UsersVisitor visitor) {
        visitor.visitUser(this);
    }

    public void appendTweet(String message) {
        tweets.add(message);
    }

    public List<String> getTweets() {
        return tweets;
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
            observer.notification(this, message);
        }
    }

    @Override
    public String toString(){
        return userId;
    }

    @Override
    public void notification(User user, String message) {
        System.out.println(userId + " notified of tweet from " + user);
        this.appendTweet(user+ " posted: " + message);
    }

    public void post(String message){
        notifyObservers(message);
        appendTweet("You posted: " + message);
    }

    public Set<User> getFollowing(){
        return following;
    }
}
