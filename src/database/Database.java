package database;

import java.sql.Connection;
import java.sql.DriverManager;

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
                connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                            + LogIntoDatabase.DB_NAME + "?serverTimezone=UTC",
                            LogIntoDatabase.DB_USER, LogIntoDatabase.DB_PASSWORD);
                System.out.println("Created connection.");
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
}
