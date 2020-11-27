public interface Users {

    public String getName();

    public long getCreationTime();

    public void accept(UsersVisitor visitor);
}
