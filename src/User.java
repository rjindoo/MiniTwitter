import java.util.*;

public class User implements Users, Observer, Subject {

    private String userId;
    private long creationTime;
    private long lastUpdateTime;
    private Set<Observer> observers = new HashSet();
    private Set<User> following = new HashSet();
    private List<String> tweets = new ArrayList();

    private TotalUserVisitor addNewUser = new TotalUserVisitor();
    private MessageVisitor newMessage = new MessageVisitor();

    public User(String userId){
        this.userId = userId;
        creationTime = System.currentTimeMillis();
        lastUpdateTime = Long.MAX_VALUE-1;
    }

    public boolean followUser(User user) {
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
    public String getName() {
        return userId;
    }

    @Override
    public long getCreationTime() {
        return creationTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Override
    public void accept(UsersVisitor visitor) {
        visitor.visit(this);
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
    public void notification(User user, String message) {
        lastUpdateTime = System.currentTimeMillis();
        this.appendTweet(user+ " posted: " + message);
        System.out.println(userId + " updated: " + lastUpdateTime);
    }

    public void post(String message){
        notifyObservers(message);
        appendTweet("You posted: " + message);
        lastUpdateTime = System.currentTimeMillis();
        System.out.println(userId + " updated: " + lastUpdateTime);
    }

    public Set<User> getFollowing(){
        return following;
    }

    @Override
    public String toString(){
        return userId;
    }
}
