package pojo;

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
