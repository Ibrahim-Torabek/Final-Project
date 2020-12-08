package buttons;

import database.LogIntoDatabase;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pojo.DisplayMovie;
import pojo.User;
import pojo.WatchedList;
import tables.WatchedListTable;
import tabs.MovieListTab;
import tabs.WatchedListTab;
import tabs.WishListTab;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class designed for adding a movie to the watched list. It extends Button class</br>
 * This class' object will use in MovieListTab and WishListTab, because these two tabs need to add
 * a selected movie into watched list.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see Button
 * @see MovieListTab
 * @see WishListTab
 *
 */
public class AddToWatchedList extends Button {
    //private static AddToWatchedList button;
    private TableView tableView;

    public AddToWatchedList(TableView tableView){
        super("Add to Watched List");

        this.tableView = tableView;
        this.setOnAction(e -> {
            DisplayMovie movie = (DisplayMovie) tableView.getSelectionModel().getSelectedItem();
            // if the user selected a movie
            if(movie != null) {
                WatchedList watchedMovie = new WatchedList(
                        0,
                        User.getInstance().getUserId(),
                        movie.getId()
                );

                WatchedListTable watchedListTable = new WatchedListTable();
                watchedListTable.insertWatchedMovie(watchedMovie);
                WatchedListTab.getInstance().refreshTable();
                System.out.println(movie.getMovieTitle());
            }
        });
    }

}
