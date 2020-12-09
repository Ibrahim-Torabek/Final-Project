package daos;

import pojo.Movie;

import java.util.ArrayList;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This is an interface for MovieTable</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see tables.MovieTable
 *
 */
public interface MovieDAO {
    public ArrayList<Movie> getAllMovies();
    public Movie getMovie(int id);
    public void insertMovie(Movie movie);
    public void deleteMovie(Movie movie);
    public void createMovie(Movie movie);
}
