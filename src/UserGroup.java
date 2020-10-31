import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class UserGroup implements Users{

    private String groupId;
    private HashMap<Integer, Users> users = new HashMap();

    public UserGroup(String groupId){
        this.groupId = groupId;
    }

    @Override
    public boolean create(Users user) {
        /**
         * Creates a user or userGroup in this tree's children
         */
        if(users.containsKey(user.toString().hashCode())){
            System.out.println("User already exists");
            return false;
        }
        this.users.put(user.toString().hashCode(), user);
        return true;
    }

    public Collection<Users> getUsers(){
        return this.users.values();
    }

    public void setUsers(List<Users> users){
        // TODO??
    }

    @Override
    public String toString(){
        return groupId;
    }

}
