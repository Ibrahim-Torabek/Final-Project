package tasks;

import Panes.BottomPane;
import database.DBConst;
import database.Database;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import pojo.DisplayMovie;
import tables.WishListTable;
import tabs.MovieListTab;

import java.sql.*;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is a multiThread runnable class. It's main purpose is to create databases in the background.
 * It creates all databases based on DBConst class.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Runnable
 * @see Database
 * @see Statement
 * @see ResultSet
 *
 */
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
