package daos;

import pojo.WatchedList;
import pojo.WishList;

import java.util.ArrayList;

public interface WishListDAO {
    public ArrayList<WishList> getAllWishMovies();
    public WishList getWishMovie();
    public void insertWishMovie(WishList wishList);
    public void deleteWishMovie(int id);
}
