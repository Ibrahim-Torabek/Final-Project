package daos;

import pojo.WatchedList;

import java.util.ArrayList;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This is an interface for WatchedListTable</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see tables.WatchedListTable
 *
 */
public interface WatchedListDAO {
    public ArrayList<WatchedList> getAllWatchedMovies();
    public WatchedList getWatchedMovie();
    public void insertWatchedMovie(WatchedList watchedMovie);
    public void deleteWatchedMovie(int watchedId);
}
