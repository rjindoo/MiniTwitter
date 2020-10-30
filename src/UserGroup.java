import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserGroup implements Users{

    private String userId = UUID.randomUUID().toString();
    private List<Users> users = new ArrayList();


    @Override
    public void addUser(Users user) {
        this.users.add(user);
    }

    @Override
    public String getId() {
        return userId;
    }

    public List<Users> getUsers(){
        return this.users;
    }

    public void setUsers(List<Users> users){
        this.users = users;
    }

}
