package pojo;

import database.DBConst;
import database.Database;
import tables.UserTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is a Plain Old Java Object class to deal with User Table in the database.
 * This class also determines if a user logged in. The class's getInstance static method returns a
 * null value if a user not logged in.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see tables.UserTable
 *
 */
public class User {
    private static User user;

    private int userId;
    private int userLoginId;
    private String firstName;
    private String lastName;
    private boolean isAdmin;

    private User(int loginId) {

    }

    public User(int userId, int userLoginId, String firstName, String lastName, boolean isAdmin) {
        this.userId = userId;
        this.userLoginId = userLoginId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
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

    public int getUserId() {
        return userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static void login(int userLoginId){
        UserTable userTable = new UserTable();

        user = userTable.getUser(userLoginId);
    }

    public static User getInstance(){
        return user;
    }

    public void logout() {
        user = null;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        User.user = user;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(int userLoginId) {
        this.userLoginId = userLoginId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

