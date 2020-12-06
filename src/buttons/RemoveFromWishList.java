package buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pojo.DisplayMovie;
import tables.WatchedListTable;
import tables.WishListTable;
import tabs.WatchedListTab;
import tabs.WishListTab;

public class RemoveFromWishList extends Button {
    //private static AddToWatchedList button;
    private TableView tableView;

    public RemoveFromWishList(TableView tableView) {
        super("Remove Movie");

        this.tableView = tableView;
        this.setOnAction(e -> {
            DisplayMovie movie = (DisplayMovie) tableView.getSelectionModel().getSelectedItem();
            WishListTable wishListTable = new WishListTable();
            wishListTable.deleteWishMovie(movie.getId());

            WishListTab.getInstance().refreshTable();
            System.out.println(movie.getMovieTitle());
        });
    }
}
