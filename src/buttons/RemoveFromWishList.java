package buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pojo.DisplayMovie;
import tables.WishListTable;
import tabs.WatchedListTab;
import tabs.WishListTab;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class designed for deleting a movie from wish list table. It extends Button class</br>
 * This class' object will use in WishedListTab, because this tab needs to delete
 * a selected movie from the wish list.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see Button
 * @see WishListTab
 *
 */
public class RemoveFromWishList extends Button {
    //private static AddToWatchedList button;
    private TableView tableView;

    public RemoveFromWishList(TableView tableView) {
        super("Remove Movie");

        this.tableView = tableView;
        this.setOnAction(e -> {
            DisplayMovie movie = (DisplayMovie) tableView.getSelectionModel().getSelectedItem();

            if(movie != null) {
                WishListTable wishListTable = new WishListTable();
                wishListTable.deleteWishMovie(movie.getId());

                WishListTab.getInstance().refreshTable();
                System.out.println(movie.getMovieTitle());
            }
        });
    }
}
