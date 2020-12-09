package daos;

import pojo.WatchedList;
import pojo.WishList;

import java.util.ArrayList;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This is an interface for WishListTable</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see tables.WishListTable
 *
 */
public interface WishListDAO {
    public ArrayList<WishList> getAllWishMovies();
    public WishList getWishMovie();
    public void insertWishMovie(WishList wishList);
    public void deleteWishMovie(int id);
}
