import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class UserGroup implements Users{

    private String groupId;
    //private List<Users> users = new ArrayList();
    private HashMap<Integer, Users> users = new HashMap();

    public UserGroup(String groupId){
        this.groupId = groupId;
        groupId.hashCode();
    }

    @Override
    public void create(Users user) {
        this.users.put(user.getId().hashCode(), user);
    }

    @Override
    public String getId() {
        return groupId;
    }

    public Collection<Users> getUsers(){
        return this.users.values();
    }

    public void setUsers(List<Users> users){
        // TODO??
    }

}
