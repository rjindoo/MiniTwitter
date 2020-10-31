import java.util.ArrayList;
import java.util.List;

public class UserGroup implements Users{

    private String groupId;
    private List<Users> users = new ArrayList();

    public UserGroup(String groupId){
        this.groupId = groupId;
    }


    @Override
    public void addUser(Users user) {
        this.users.add(user);
    }

    @Override
    public String getId() {
        return groupId;
    }

    public List<Users> getUsers(){
        return this.users;
    }

    public void setUsers(List<Users> users){
        this.users = users;
    }

}
