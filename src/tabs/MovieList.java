package tabs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import pojo.CompanyList;
import pojo.DisplayMovie;
import pojo.Movie;
import tables.CompanyListTable;
import tables.MovieTable;

public class MovieList extends Tab {
    private static MovieList tab;


    private MovieList() {
        super("Movie List");
        BorderPane root = new BorderPane();

        TableView tableView = new TableView();

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






        tableView.getColumns().addAll(columnMovieTitle,columnDirector, columnCompany,columnYear,columnLength,columnRating,columnGenre);
        tableView.getItems().addAll(new MovieTable().prettyDisplayAll());


        TextField tabTitle = new TextField("Welcome to Movie Tab...");
        tabTitle.setFont(Font.font("Times New Roman", 30));

        root.setTop(tabTitle);
        root.setCenter(tableView);

        this.setContent(root);

    }

    public static MovieList getInstance(){
        if(tab == null){
            tab = new MovieList();
        }

        return tab;
    }

}
