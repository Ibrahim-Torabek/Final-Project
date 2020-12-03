package tabs;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import menus.MainMenu;
import pojo.DisplayMovie;
import pojo.User;
import pojo.WatchedList;
import tables.MovieTable;
import tables.WatchedListTable;

public class MovieListTab extends Tab {
    private static MovieListTab tab;
    private String userName = "";
    private TextField tabTitle;

    private TableView tableView = new TableView();

    Button addWatchedButton = new Button("Add to Watched List");
    Button addWishButton = new Button("Add to Wish List");

    private MovieListTab() {
        super("Movie List");

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
        tableView.getItems().addAll(new MovieTable().prettyDisplayAll());


        tabTitle = new TextField("Welcome to Movie Tab...");
        tabTitle.setFont(Font.font("Times New Roman", 30));

        // Show a title in border top
        root.setTop(tabTitle);

        // Show Table view in the border center
        root.setCenter(tableView);

        // Show "Add to Wishlist" and "Add to Watched List" buttons in the bottom of border pane


        addWatchedButton.setOnAction(e -> {
            DisplayMovie movie = (DisplayMovie) tableView.getSelectionModel().getSelectedItem();
            WatchedList watchedMovie = new WatchedList(
                    0,
                    User.getInstance().getUserId(),
                    movie.getId()
            );
            WatchedListTable watchedListTable = new WatchedListTable();
            watchedListTable.insertWatchedMovie(watchedMovie);
            WatchedListTab.getInstance().refreshTable();
        });

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(addWishButton, addWatchedButton);
        buttonBox.setSpacing(40);
        buttonBox.setPadding(new Insets(20));
        buttonBox.setAlignment(Pos.CENTER);
        root.setBottom(buttonBox);


        this.setContent(root);

        refreshButtons();
        MainMenu.getInstance().refreshMenus();

    }

    public static MovieListTab getInstance(){
        if(tab == null){
            tab = new MovieListTab();
        }

        return tab;
    }

    public void refreshUserName(){
        if(User.getInstance() != null){
            userName = User.getInstance().getFullName();
            tabTitle.setText(userName + " you can manage movies now.");
        }
    }

    public void refreshTable(){
        MovieTable movieTable = new MovieTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(movieTable.prettyDisplayAll());
    }

    public void refreshButtons(){
        if(User.getInstance() != null){
            addWatchedButton.setDisable(false);
            addWishButton.setDisable(false);
        } else {
            addWatchedButton.setDisable(true);
            addWishButton.setDisable(true);
        }
    }
}
