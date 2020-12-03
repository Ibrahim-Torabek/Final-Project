package pojo;

public class WishList {
    private int Id;
    private int userId;
    private int movieId;

    public WishList(int id, int userId, int movieId) {
        Id = id;
        this.userId = userId;
        this.movieId = movieId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
}
