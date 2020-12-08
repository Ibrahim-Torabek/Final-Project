package database;

import main.Main;
import tasks.CreateDatabases;

import java.sql.*;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This is singleton class for the Database connection.
 * This class will run CreateDatabases multiThread class to create all databases for reduce
 * the launch speed of the program</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see Database
 * @see Connection
 * @see Thread
 * @see CreateDatabases
 *
 */
public class Database {
    /**
     * class Database will use the Singleton design pattern:
     * private constructor,
     * private static instance variable
     * public static getInstance() method
     */

    //private static instance variable
    private static Database instance = null;
    private Connection connection = null;

    //private constructor
    private Database(){
        //setup connection
        if (connection == null) {
            try {
                //define driver to connect to the database
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(Main.loginDB.getDbLocation()
                            + Main.loginDB.getDbName() + "?serverTimezone=UTC",
                            Main.loginDB.getDbUser(), Main.loginDB.getDbPassword());
                System.out.println("Created connection.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //create tables
            try {
                Thread createDatabases = new Thread(new CreateDatabases());
                createDatabases.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //public static getInstance method
    public static Database getInstance(){
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }


    public Connection getConnection() {
        return connection;
    }
}
