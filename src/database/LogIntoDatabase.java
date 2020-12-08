package database;

import java.io.Serializable;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This is a class to save database connection information includes Database name
 * , user and password. It also saves location. This class implements serializable
 * so that can be saved into or read from login.dat file by FileIO class.</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see main.FileIO
 * @see Serializable
 */
public class LogIntoDatabase implements Serializable {


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
