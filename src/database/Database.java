package database;

import main.Main;
import tasks.CreateDatabases;

import java.sql.*;

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

    //create a table
    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTables;
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, tableName,null);

        //check if a table already exists
        if (resultSet.next()) {
            System.out.println(tableName + " table is already exists");
        } else { //create a table
            createTables = connection.createStatement();
            createTables.execute(tableQuery);
            System.out.println(tableName + " table has been placed in the database.");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
