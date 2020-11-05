import java.util.ArrayList;
import java.util.List;

public interface  NewsFeed {

    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notifyObservers(String message);

}
