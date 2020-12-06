package daos;

import pojo.Movie;

import java.util.ArrayList;

public interface UserDAO {
    public ArrayList<Movie> getAllUsers();
    public Movie getUser(int id);
    public void insertUser(Movie movie);

}
