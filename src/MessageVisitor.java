public class MessageVisitor implements UsersVisitor{


    @Override
    public void visit(Users user) {
        System.out.println(user.getName() + " has posted a message");
    }

}
