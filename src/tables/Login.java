package tables;

import daos.LoginDAO;
import database.DBConst;
import database.Database;
import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login implements LoginDAO {

    public Login(String loginName, String password) {
        Database db = Database.getInstance();

        String query = "SELECT " + DBConst.LOGIN_COLUMN_ID + " FROM " +
                DBConst.TABLE_LOGIN + " WHERE " +
                DBConst.LOGIN_COLUMN_NAME + " = \"" + loginName + "\" AND " +
                DBConst.LOGIN_COLUMN_PASSWORD + " = \"" + password +"\"";

        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                User.login(resultSet.getInt(DBConst.LOGIN_COLUMN_ID));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void Login(){

    }

    @Override
    public void Login(String loginName, String password) {

    }

    @Override
    public void insert(String username, String password) {

    }
}
