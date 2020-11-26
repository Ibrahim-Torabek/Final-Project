package tables;

import com.mysql.cj.xdevapi.DbDoc;
import daos.MovieDAO;
import database.DBConst;
import database.Database;
import pojo.CompanyList;
import pojo.DisplayMovie;
import pojo.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieTable implements MovieDAO {
    Database db = Database.getInstance();
    ArrayList<Movie> movies;
    @Override
    public ArrayList<Movie> getAllMovies() {
        String query = "SELECT * FROM " + DBConst.TABLE_MOVIE;
        movies = new ArrayList<>();

        try {
            Statement getCompanies =
                    db.getConnection().createStatement();
            ResultSet resultSet = getCompanies.executeQuery(query);
            while (resultSet.next()){
                Movie movie = new Movie(
                        resultSet.getInt(DBConst.MOVIE_COLUMN_ID),
                        resultSet.getString(DBConst.MOVIE_COLUMN_TITLE),
                        resultSet.getString(DBConst.MOVIE_COLUMN_DIRECTOR),
                        resultSet.getInt(DBConst.MOVIE_PRODUCTION_COMPANY),
                        resultSet.getInt(DBConst.MOVIE_RELEASE_YEAR),
                        resultSet.getInt(DBConst.MOVIE_LENGTH_MINUTES),
                        resultSet.getString(DBConst.MOVIE_COLUMN_RATING),
                        resultSet.getString(DBConst.MOVIE_COLUMN_GENRE)
                );
                movies.add(movie);
                System.out.println(movie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return movies;
    }

    @Override
    public Movie getMovie(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_MOVIE +
                " WHERE " + DBConst.MOVIE_COLUMN_ID + " = " + id;

        try {
            Statement getCompanies =
                    db.getConnection().createStatement();
            ResultSet resultSet = getCompanies.executeQuery(query);
            if (resultSet.next()){
                Movie movie = new Movie(
                        resultSet.getInt(DBConst.MOVIE_COLUMN_ID),
                        resultSet.getString(DBConst.MOVIE_COLUMN_TITLE),
                        resultSet.getString(DBConst.MOVIE_COLUMN_DIRECTOR),
                        resultSet.getInt(DBConst.MOVIE_PRODUCTION_COMPANY),
                        resultSet.getInt(DBConst.MOVIE_RELEASE_YEAR),
                        resultSet.getInt(DBConst.MOVIE_LENGTH_MINUTES),
                        resultSet.getString(DBConst.MOVIE_COLUMN_RATING),
                        resultSet.getString(DBConst.MOVIE_COLUMN_GENRE)
                );

                System.out.println(movie);
                return movie;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void insertMovie(Movie movie) {
        String query = "INSERT INTO " + DBConst.TABLE_MOVIE +" VALUES (0, '" +
                movie.getMovieTitle() + "', '" +
                movie.getDirector() + "', " +
                movie.getProductionCompany() + ", " +
                movie.getReleaseYear() + ", " +
                movie.getLengthMinutes() + ", '" +
                movie.getRating() + "', '" +
                movie.getGenre() + "')";

        System.out.println(query);
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<DisplayMovie> prettyDisplayAll(){
        ArrayList<DisplayMovie> displayMovies = new ArrayList<>();

        String query = "SELECT movie.movie_id, movie.movie_title, movie.director, " +
                "company_list.company_name, movie.release_year, movie.length_minutes, " +
                "movie.rating, movie.genre FROM movie " +
                "JOIN company_list ON company_list.company_id = movie.production_company";

        try {
            Statement getCompanies =
                    db.getConnection().createStatement();
            ResultSet resultSet = getCompanies.executeQuery(query);
            while (resultSet.next()){
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
                System.out.println(movie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return displayMovies;
    }
}
