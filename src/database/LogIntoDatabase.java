package database;

import java.io.Serializable;

public class LogIntoDatabase implements Serializable {


    public static final String DB_NAME = "epolyakovadb";
    public static final String DB_USER = "epolyakova";
    public static final String DB_PASSWORD = "q67q3q67q3pvm9lpvm9l";

    private String dbName;
    private String dbUser;
    private String dbPassword;
    private String dbLocation;

    public LogIntoDatabase(String dbName, String dbUser, String dbPassword) {
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public LogIntoDatabase(String dbLocation, String dbName, String dbUser, String dbPassword) {
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbLocation = dbLocation;
    }

    public LogIntoDatabase() {
        this.dbName = DB_NAME;
        this.dbUser = DB_USER;
        this.dbPassword = DB_PASSWORD;
        dbLocation = "jdbc:mysql://localhost/";
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbLocation() {
        return dbLocation;
    }
}
