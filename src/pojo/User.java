package pojo;

import database.DBConst;
import database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private static User user;

    private int userId;
    private int userLoginId;
    private String firstName;
    private String lastName;
    private boolean isAdmin;

    private User(int loginId) {

        Database db = Database.getInstance();

        String query = "SELECT * FROM user where user_login_id = " + loginId;

        try{
            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                this.userId = resultSet.getInt(DBConst.USER_COLUMN_ID);
                this.userLoginId = resultSet.getInt(DBConst.USER_COLUMN_LOGIN_ID);
                this.firstName = resultSet.getString(DBConst.USER_COLUMN_FIRST_NAME);
                this.lastName = resultSet.getString(DBConst.USER_COLUMN_LAST_NAME);
                this.isAdmin = resultSet.getBoolean(DBConst.USER_COLUMN_IS_ADMIN);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getFullName(){
        return this.firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static void setInstance(int userLoginId){

        user = new User(userLoginId);

    }

    public static User getInstance(){
        return user;
    }

}

