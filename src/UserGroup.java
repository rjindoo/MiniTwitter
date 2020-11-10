import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class UserGroup implements Users{

    private String groupId;
    private HashMap<Integer, Users> users = new HashMap();
    private UsersVisitor addNewUserGroup = new UserVisitor();

    public UserGroup(String groupId){
        this.groupId = groupId;
        this.create();
    }

    @Override
    public void create() {
        this.accept(addNewUserGroup);
    }

    public boolean addUsers(Users user) {
        /** Creates a user or userGroup in this tree's children */
        if(users.containsKey(user.toString().hashCode())){
            System.out.println("User already exists");
            return false;
        }
        this.users.put(user.toString().hashCode(), user);
        return true;
    }

    @Override
    public void accept(UsersVisitor visitor) {
        visitor.visitUserGroup(this);
     }

    //public Collection<Users> getUsers(){
    //    return this.users.values();
    //}

    @Override
    public String toString(){
        return groupId;
    }

}
