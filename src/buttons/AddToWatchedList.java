package buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pojo.DisplayMovie;
import pojo.User;
import pojo.WatchedList;
import tables.WatchedListTable;
import tabs.WatchedListTab;

public class AddToWatchedList extends Button {
    //private static AddToWatchedList button;
    private TableView tableView;

    public AddToWatchedList(TableView tableView){
        super("Add to Watched List");

        this.tableView = tableView;
        this.setOnAction(e -> {
            DisplayMovie movie = (DisplayMovie) tableView.getSelectionModel().getSelectedItem();
            WatchedList watchedMovie = new WatchedList(
                    0,
                    User.getInstance().getUserId(),
                    movie.getId()
            );
            WatchedListTable watchedListTable = new WatchedListTable();
            watchedListTable.insertWatchedMovie(watchedMovie);
            WatchedListTab.getInstance().refreshTable();
            System.out.println(movie.getMovieTitle());
        });
    }

}
