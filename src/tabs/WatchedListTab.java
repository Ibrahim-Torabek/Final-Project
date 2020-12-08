package tabs;

import Panes.BottomPane;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import pojo.DisplayMovie;
import pojo.User;
import tables.MovieTable;
import tables.WatchedListTable;

import java.util.function.BinaryOperator;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an extended class from Tab class to display the watched list in the database.
 * This tab displays watched movies in a tableView by prettyDisplay, and the logged user can add any
 * selected movie to the wish list or delete it. All buttons to be displayed in a bottomPane object.
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
 * @see WatchedListTable
 */
public class WatchedListTab extends Tab {
    private static WatchedListTab tab;
    private TableView tableView = new TableView();
    private BottomPane bottomPane;

    private WatchedListTab() {
        super("Watched List");


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
            tableView.getItems().addAll(new WatchedListTable().prettyDisplay(User.getInstance().getUserId()));



        // Show a title in border top
        //root.setTop(tabTitle);

        // Show Table view in the border center
        root.setCenter(tableView);

        bottomPane = new BottomPane(tableView);
        bottomPane.addButton(BottomPane.BUTTON_REMOVE_FROM_WATCHED_LIST);
        bottomPane.addButton(BottomPane.BUTTON_ADD_TO_WISH_LIST);
        root.setBottom(bottomPane);

        this.setContent(root);
    }

    public static WatchedListTab getInstance(){
        if(tab == null){
            tab = new WatchedListTab();
        }

        return tab;
    }

    public void refreshTable(){
        WatchedListTable movieTable = new WatchedListTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(movieTable.prettyDisplay(User.getInstance().getUserId()));
        WatchedStatsTab.getInstance().makeWatchedPie();
    }
}
