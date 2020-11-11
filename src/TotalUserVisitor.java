public class TotalUserVisitor implements UsersVisitor {

    @Override
    public void visit(Users user) {
        System.out.println("Visiting " + user.getName());
    }

}
