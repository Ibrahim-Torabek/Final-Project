package daos;

import pojo.Movie;
import pojo.User;

import java.util.ArrayList;

public interface UserDAO {
    public ArrayList<User> getAllUsers();
    public User getUser(int id);
    public void insertUser(User user);

}
