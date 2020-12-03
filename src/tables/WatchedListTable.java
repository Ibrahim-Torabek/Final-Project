package tables;

import daos.WatchedListDAO;
import database.DBConst;
import database.Database;
import pojo.DisplayMovie;
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

    public ArrayList<DisplayMovie> prettyDisplay(int user_id){
        ArrayList<DisplayMovie> displayMovies = new ArrayList<>();

        String query = "SELECT DISTINCT movie.movie_id, movie.movie_title, movie.director, " +
                "company_list.company_name, movie.release_year, movie.length_minutes, " +
                "movie.rating, movie.genre FROM movie " +
                "JOIN company_list ON company_list.company_id = movie.production_company " +
                "JOIN watched_movies ON watched_movies.movie_id = movie.movie_id " +
                "WHERE watched_movies.user_id = " + user_id;

        try {
            ResultSet resultSet = db.getConnection().createStatement().executeQuery(query);
            while (resultSet.next()) {
                DisplayMovie movie = new DisplayMovie(
                        resultSet.getInt(DBConst.MOVIE_COLUMN_ID),
                        resultSet.getString(DBConst.MOVIE_COLUMN_TITLE),
                        resultSet.getString(DBConst.MOVIE_COLUMN_DIRECTOR),
                        resultSet.getString(DBConst.COMPANY_COLUMN_NAME),
                        resultSet.getInt(DBConst.MOVIE_RELEASE_YEAR),
                        resultSet.getInt(DBConst.MOVIE_LENGTH_MINUTES),
                        resultSet.getString(DBConst.MOVIE_COLUMN_RATING),
                        resultSet.getString(DBConst.MOVIE_COLUMN_GENRE)
                );
                displayMovies.add(movie);
            }
        } catch (SQLException throwables) {
            System.out.println(query);
            throwables.printStackTrace();
        }

        return displayMovies;
    }
}
