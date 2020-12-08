package daos;

public interface LoginDAO {
    public void Login(String loginName, String password);
    public void insert(String username, String password);
}
