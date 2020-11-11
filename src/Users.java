public interface Users {

    public String getName();

    public void accept(UsersVisitor visitor);
}
