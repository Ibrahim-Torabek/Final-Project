package buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pojo.DisplayMovie;
import pojo.User;
import pojo.WatchedList;
import pojo.WishList;
import tables.WatchedListTable;
import tables.WishListTable;
import tabs.MovieListTab;
import tabs.WatchedListTab;
import tabs.WishListTab;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class designed for adding a movie to the wish list table. It extends Button class</br>
 * This class' object will use in MovieListTab and WatchedListTab, because these two tabs need to add
 * a selected movie into the wish list.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see Button
 * @see MovieListTab
 * @see WatchedListTab
 *
 */
public class AddToWishList extends Button {
    private static AddToWishList button;
    private TableView tableView;

    public AddToWishList(TableView tableView){
        super("Add to Wish List");

        this.tableView = tableView;
        this.setOnAction(e -> {
            DisplayMovie movie = (DisplayMovie) tableView.getSelectionModel().getSelectedItem();

            if( movie != null) {
                WishList wishMovie = new WishList(
                        0,
                        User.getInstance().getUserId(),
                        movie.getId()
                );
                WishListTable wishListTable = new WishListTable();
                wishListTable.insertWishMovie(wishMovie);
                WishListTab.getInstance().refreshTable();
                System.out.println(movie.getMovieTitle());
            }
        });
    }

    public AddToWishList() {
        super("Add to Wish List");


    }

    public static AddToWishList getInstance(){
        if(button == null){
            button = new AddToWishList();
        }

        return button;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }
}
