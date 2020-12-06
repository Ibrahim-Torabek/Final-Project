package buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pojo.DisplayMovie;
import pojo.User;
import pojo.WishList;
import tables.WatchedListTable;
import tables.WishListTable;
import tabs.WatchedListTab;
import tabs.WishListTab;

public class RemoveFromWatchedList extends Button {
    //private static AddToWatchedList button;
    private TableView tableView;

    public RemoveFromWatchedList(TableView tableView) {
        super("Remove Movie");

        this.tableView = tableView;
        this.setOnAction(e -> {
            DisplayMovie movie = (DisplayMovie) tableView.getSelectionModel().getSelectedItem();
            WatchedListTable watchedListTable = new WatchedListTable();
            watchedListTable.deleteWatchedMovie(movie.getId());

            WatchedListTab.getInstance().refreshTable();
            System.out.println(movie.getMovieTitle());
        });
    }
}
