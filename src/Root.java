import java.util.ArrayList;
import java.util.List;

public class Root {
    private List<Users> users = new ArrayList();


    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public void addUser(Users user){
        users.add(user);
    }

}
