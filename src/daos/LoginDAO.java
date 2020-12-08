package daos;

import pojo.Login;

public interface LoginDAO {
    public int login(String loginName, String password);
    public void insert(Login login);
}
