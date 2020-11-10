import java.util.HashMap;

public class UserGroup implements Users{

    private String groupId;
    private HashMap<Integer, Users> users = new HashMap();
    private UsersVisitor addNewUserGroup = new NewUserVisitor();

    public UserGroup(String groupId){
        this.groupId = groupId;
    }

    @Override
    public String getName() {
        return groupId;
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
    public String toString(){
        return groupId;
    }
}
