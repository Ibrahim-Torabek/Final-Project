package pojo;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is a Plain Old Java Object class to deal with WatchedList Table in the database.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see tables.WatchedListTable
 *
 */
public class WatchedList {
    private int watchedId;
    private int userId;
    private int movieId;

    public WatchedList(int watchedId, int userId, int movieId) {
        this.watchedId = watchedId;
        this.userId = userId;
        this.movieId = movieId;
    }

    public int getWatchedId() {
        return watchedId;
    }

    public void setWatchedId(int watchedId) {
        this.watchedId = watchedId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String toString(){ return this.movieId + " "; }
}
