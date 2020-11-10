public class UserVisitor implements UsersVisitor {
    @Override
    public void visitUser(User user) {
        System.out.println("Added a new user");
    }

    @Override
    public void visitUserGroup(UserGroup userGroup) {
        System.out.println("Added a new userGroup");
    }
}
