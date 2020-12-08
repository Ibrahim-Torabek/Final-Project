package daos;

import pojo.Movie;
import pojo.User;

import java.util.ArrayList;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This is an interface for UserTable</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see tables.UserTable
 *
 */
public interface UserDAO {
    public ArrayList<User> getAllUsers();
    public User getUser(int id);
    public void insertUser(User user);

}
