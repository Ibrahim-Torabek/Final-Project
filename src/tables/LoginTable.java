package tables;

import daos.LoginDAO;
import database.DBConst;
import database.Database;
import pojo.CompanyList;
import pojo.Login;
import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an implemented class from LoginDAO interface. This class
 * maintain the CRUD operations of login table in database.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see daos.LoginDAO
 * @see Database
 * @see Statement
 * @see ResultSet
 * @see Login
 *
 */
public class LoginTable implements LoginDAO {



    @Override
    public int login(String loginName, String password) {
        Database db = Database.getInstance();

        String query = "SELECT " + DBConst.LOGIN_COLUMN_ID + " FROM " +
                DBConst.TABLE_LOGIN + " WHERE " +
                DBConst.LOGIN_COLUMN_NAME + " = \"" + loginName + "\" AND " +
                DBConst.LOGIN_COLUMN_PASSWORD + " = \"" + password +"\"";

        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                return resultSet.getInt(DBConst.LOGIN_COLUMN_ID);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public void insert(Login login) {
        Database db = Database.getInstance();
        String query = "INSERT INTO " + DBConst.TABLE_LOGIN +
                " VALUES (0, '" +
                login.getLoginName() + "', '" +
                login.getPassword() + "')";

        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException throwables) {
            System.out.println(query);
            throwables.printStackTrace();
        }
    }
}
