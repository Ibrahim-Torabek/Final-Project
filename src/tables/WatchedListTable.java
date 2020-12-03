package tables;

import daos.WatchedListDAO;
import database.DBConst;
import database.Database;
import pojo.WatchedList;

import javax.print.DocFlavor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WatchedListTable implements WatchedListDAO {
    Database db = Database.getInstance();
    ArrayList<WatchedList> watchedMovies;

    @Override
    public ArrayList<WatchedList> getAllWatchedMovies() {
        String query = "SELECT * FROM " + DBConst.TABLE_WATCHED_LIST;
        watchedMovies = new ArrayList<>();

        try{
            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                WatchedList watchedList = new WatchedList(
                        resultSet.getInt(DBConst.WATCHED_LIST_COLUMN_ID),
                        resultSet.getInt(DBConst.WATCHED_LIST_COLUMN_USER_ID),
                        resultSet.getInt(DBConst.WATCHED_LIST_COLUMN_MOVIE_ID)
                );
                watchedMovies.add(watchedList);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return watchedMovies;
    }

    @Override
    public WatchedList getWatchedMovie() {
        return null;
    }

    @Override
    public void insertWatchedMovie(WatchedList watchedMovie) {
        String query = "INSERT INTO " + DBConst.TABLE_WATCHED_LIST +
                " VALUES (0, " +
                watchedMovie.getUserId() + ", " +
                watchedMovie.getMovieId() + ")";

        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException throwables) {
            System.out.println(query);
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteWatchedMovie(int watchedId) {

    }
}
