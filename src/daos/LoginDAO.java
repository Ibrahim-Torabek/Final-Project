package daos;

import pojo.Login;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This is an interface for LoginTable</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see tables.LoginTable
 *
 */
public interface LoginDAO {
    public int login(String loginName, String password);
    public void insert(Login login);
}
