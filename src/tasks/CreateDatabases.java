package tasks;

import database.DBConst;
import database.Database;

import java.sql.*;

public class CreateDatabases implements Runnable {
    @Override
    public void run() {
        Connection connection = Database.getInstance().getConnection();

        try {
            createTable(DBConst.TABLE_COMPANY, DBConst.CREATE_TABLE_COMPANY, connection);
            createTable(DBConst.TABLE_LOGIN, DBConst.CREATE_TABLE_LOGIN, connection);
            createTable(DBConst.TABLE_USER, DBConst.CREATE_TABLE_USER, connection);
            createTable(DBConst.TABLE_MOVIE, DBConst.CREATE_TABLE_MOVIE, connection);
            createTable(DBConst.TABLE_WATCHED_LIST, DBConst.CREATE_TABLE_WATCHED, connection);
            createTable(DBConst.TABLE_WISH_LIST, DBConst.CREATE_TABLE_WISH_LIST, connection);
        } catch (SQLException throwables) {
            System.out.println(DBConst.CREATE_TABLE_WATCHED);
            System.out.println(DBConst.CREATE_TABLE_MOVIE);
            throwables.printStackTrace();
        }


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

}
