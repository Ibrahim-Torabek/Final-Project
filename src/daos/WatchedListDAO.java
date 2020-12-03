package daos;

import pojo.WatchedList;

import java.util.ArrayList;

public interface WatchedListDAO {
    public ArrayList<WatchedList> getAllWatchedMovies();
    public WatchedList getWatchedMovie();
    public void insertWatchedMovie(WatchedList watchedMovie);
    public void deleteWatchedMovie(int watchedId);
}
