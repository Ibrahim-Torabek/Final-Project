package buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pojo.DisplayMovie;
import tables.WatchedListTable;
import tabs.WatchedListTab;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class designed for deleting a movie from watched list table. It extends Button class</br>
 * This class' object will use in WatchedListTab, because this tab needs to delete
 * a selected movie from the watched list.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see Button
 * @see WatchedListTab
 *
 */
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
