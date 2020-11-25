package database;

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
                connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                            + LogIntoDatabase.DB_NAME + "?serverTimezone=UTC",
                            LogIntoDatabase.DB_USER, LogIntoDatabase.DB_PASSWORD);
                System.out.println("Created connection.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //create tables
            try {
                createTable(DBConst.TABLE_COMPANY, DBConst.CREATE_TABLE_COMPANY, connection);
                createTable(DBConst.TABLE_LOGIN, DBConst.CREATE_TABLE_LOGIN, connection);
                createTable(DBConst.TABLE_USER, DBConst.CREATE_TABLE_USER, connection);
                createTable(DBConst.TABLE_MOVIE, DBConst.CREATE_TABLE_MOVIE, connection);
                createTable(DBConst.TABLE_WATCHED_LIST, DBConst.CREATE_TABLE_WATCHED, connection);
                createTable(DBConst.TABLE_WISH_LIST, DBConst.CREATE_TABLE_WISH_LIST, connection);
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
