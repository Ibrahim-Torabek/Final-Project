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
        tableView.getItems().addAll(new WishListTable().prettyDisplay(User.getInstance().getUserId()));

        root.setCenter(tableView);

        bottomPane = new BottomPane(tableView);
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
