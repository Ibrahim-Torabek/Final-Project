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
    private static String firstName;
    private static String lastName;
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

//    private void setUser(int loginId){
//        User user1 = new User();
//
//        Database db = Database.getInstance();
//
//        String query = "SELECT * FROM user where user_login_id = " + loginId;
//
//        try{
//            Statement statement = db.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            if(resultSet.next()){
//                user1.userId = resultSet.getInt(DBConst.USER_COLUMN_ID);
//                user1.userLoginId = resultSet.getInt(DBConst.USER_COLUMN_LOGIN_ID);
//                user1.firstName = resultSet.getString(DBConst.USER_COLUMN_FIRST_NAME);
//                user1.lastName = resultSet.getString(DBConst.USER_COLUMN_LAST_NAME);
//                user1.isAdmin = resultSet.getBoolean(DBConst.USER_COLUMN_IS_ADMIN);
//
//                this.user = user1;
//
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public static void setInstance(int userLoginId){

        user = new User(userLoginId);

    }

    public static User getInstance(){
        return user;
    }

}

