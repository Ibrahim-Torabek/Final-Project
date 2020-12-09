package pojo;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is a Plain Old Java Object class to deal with Login Table in the database.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see tables.LoginTable
 *
 */
public class Login {
    private int loginId;
    private String loginName;
    private String password;

    public Login(int loginId, String loginName, String password) {
        this.loginId = loginId;
        this.loginName = loginName;
        this.password = password;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return loginName;
    }
}
