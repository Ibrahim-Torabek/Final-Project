package tabs;

import Panes.BottomPane;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import menus.MainMenu;
import pojo.CompanyList;
import pojo.DisplayMovie;
import pojo.Movie;
import pojo.User;
import tables.MovieTable;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an extended class from Tab class to display the list of movies in the database.
 * This tab displays movies in a tableView by prettyDisplay, and the logged user can add any selected movie to the
 * watched list or wish list. All buttons to be displayed in a bottomPane object.
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
 * @see MovieTable
 */
public class MovieListTab extends Tab {
    private static MovieListTab tab;
    private String userName = "";
    private TextField tabTitle;

    private TableView tableView = new TableView();
    private BottomPane bottomPane;


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


        tabTitle = new TextField("Welcome to Movie Tracer. " +
                "Go to the Log in/out tab above to log in and manage the movies.");
        tabTitle.setFont(Font.font("Times New Roman", 26));

        // Show a title in border top
        root.setTop(tabTitle);

        // Show Table view in the border center
        root.setCenter(tableView);

        bottomPane = new BottomPane(tableView);
        bottomPane.addButton(BottomPane.BUTTON_ADD_TO_WATCHED_LIST);
        bottomPane.addButton(BottomPane.BUTTON_ADD_TO_WISH_LIST);
        //bottomPane.addButton());
        root.setBottom(bottomPane);

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
            tabTitle.setText(userName + " you can manage movies now. Go to Tabs Menu " +
                    "to see a table or statistics.");
        }
    }

    public void refreshTable(){
        MovieTable movieTable = new MovieTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(movieTable.prettyDisplayAll());
    }

    public void refreshButtons(){
        bottomPane.refresh();
    }
}
