package tables;

import daos.UserDAO;
import database.DBConst;
import database.Database;
import pojo.DisplayMovie;
import pojo.Movie;
import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an implemented class from UserDAO interface. This class
 * maintain the CRUD operations of movie table in database.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see daos.UserDAO
 * @see Database
 * @see Statement
 * @see ResultSet
 * @see User
 *
 */
public class UserTable implements UserDAO {
    @Override
    public ArrayList<pojo.User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(int id) {
        Database db = Database.getInstance();

        String query = "SELECT * FROM user where user_login_id = " + id;

        try{
            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                User user = new User(
                        resultSet.getInt(DBConst.USER_COLUMN_ID),
                        resultSet.getInt(DBConst.USER_COLUMN_LOGIN_ID),
                        resultSet.getString(DBConst.USER_COLUMN_FIRST_NAME),
                        resultSet.getString(DBConst.USER_COLUMN_LAST_NAME),
                        resultSet.getBoolean(DBConst.USER_COLUMN_IS_ADMIN)
                );
                return user;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        Database db = Database.getInstance();
        String query = "INSERT INTO " + DBConst.TABLE_USER +
                " VALUES (0, " +
                user.getUserLoginId() + ", '" +
                user.getFirstName() + "', '" +
                user.getLastName() + "', " +
                user.isAdmin() + ")";

        try{
            db.getConnection().createStatement().execute(query);

        } catch (SQLException throwables) {
            System.out.println(query);
            throwables.printStackTrace();
        }
    }
}
