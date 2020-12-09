package tabs;

import Panes.BottomPane;
import buttons.AddToWatchedList;
import buttons.AddToWishList;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import pojo.DisplayMovie;
import pojo.User;
import tables.WatchedListTable;
import tables.WishListTable;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an extended class from Tab class to display the wish list in the database.
 * This tab displays movies to want to watch in a tableView by prettyDisplay, and the logged user can add any
 * selected movie to the watched list or delete it. All buttons to be displayed in a bottomPane object.
 *
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Tab
 * @see BorderPane
 * @see MovieListTab
 * @see TableView
 * @see TableColumn
 * @see BottomPane
 * @see DisplayMovie
 * @see WishListTable
 */
public class WishListTab extends Tab {
    private static WishListTab tab;
    private TableView tableView = new TableView();
    private BottomPane bottomPane;

    private WishListTab() {
        super("Wish List");

        // Declare root pane
        BorderPane root = new BorderPane();


        // Set up Table Columns
        TableColumn<DisplayMovie, String> columnMovieTitle = new TableColumn<>("Movie Title");
        columnMovieTitle.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getMovieTitle())
        );

        TableColumn<DisplayMovie, String> columnDirector = new TableColumn<>("Director");
        columnDirector.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getDirector())
        );

        TableColumn<DisplayMovie, String> columnCompany = new TableColumn<>("Production Company");
        columnCompany.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getProductionCompany())
        );

        TableColumn<DisplayMovie, String> columnYear = new TableColumn<>("Release Year");
        columnYear.setCellValueFactory(
                e -> new SimpleStringProperty(String.valueOf(e.getValue().getReleaseYear()))
        );

        TableColumn<DisplayMovie, String> columnLength = new TableColumn<>("Length Minutes");
        columnLength.setCellValueFactory(
                e -> new SimpleStringProperty(String.valueOf(e.getValue().getLengthMinutes()))
        );

        TableColumn<DisplayMovie, String> columnRating = new TableColumn<>("Rating");
        columnRating.setCellValueFactory(
                e -> new SimpleStringProperty(String.valueOf(e.getValue().getRating()))
        );

        TableColumn<DisplayMovie, String> columnGenre = new TableColumn<>("Genre");
        columnGenre.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getGenre())
        );

        // Set up Columns and Data
        tableView.getColumns().addAll(columnMovieTitle,columnDirector, columnCompany,columnYear,columnLength,columnRating,columnGenre);
        if(User.getInstance() != null)
            tableView.getItems().addAll(new WishListTable().prettyDisplay(User.getInstance().getUserId()));

        root.setCenter(tableView);

        bottomPane = new BottomPane(tableView);
        bottomPane.addButton(BottomPane.BUTTON_REMOVE_FROM_WISH_LIST);
        bottomPane.addButton(BottomPane.BUTTON_ADD_TO_WATCHED_LIST);
        root.setBottom(bottomPane);

        this.setContent(root);
    }

    public static WishListTab getInstance(){
        if(tab == null){
            tab = new WishListTab();
        }

        return tab;
    }

    public void refreshTable(){
        WishListTable movieTable = new WishListTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(movieTable.prettyDisplay(User.getInstance().getUserId()));
    }


}
