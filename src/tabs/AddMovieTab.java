package tabs;

import Panes.TabPane;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pojo.CompanyList;
import pojo.Movie;
import tables.CompanyListTable;
import tables.MovieTable;

public class AddMovieTab extends Tab {

    private static AddMovieTab tab;
    private VBox root = new VBox();

    // Declared all input fields as attributes for refresh.
    private TextField title = new TextField();
    private TextField director = new TextField();
    private ComboBox<CompanyList> companyComnbo = new ComboBox<>();
    private TextField year = new TextField();
    private TextField length = new TextField();
    private TextField rating = new TextField();
    private TextField genre = new TextField();

    private AddMovieTab() {
        this.setText("Add Movie");




        HBox hBox = new HBox();
        Font font = Font.font("Times New Roman",20);

        GridPane gridPane = new GridPane();

        // Initial all labels
        Text movieTitle = new Text("Movie Title:");
        Text directorLabel = new Text("Director");
        Text productionCompany = new Text("Production Company:");
        Text releaseYear = new Text("Release Year:");
        Text lengthMinutes = new Text("Length (Minutes):");
        Text ratinglabel = new Text("Rating:");
        Text genreLabel = new Text("Genre:");
        gridPane.add(movieTitle,0,0);
        gridPane.add(directorLabel,0,1);
        gridPane.add(productionCompany,0,2);
        gridPane.add(releaseYear,0,3);
        gridPane.add(lengthMinutes,0,4);
        gridPane.add(ratinglabel,0,5);
        gridPane.add(genreLabel,0,6);


        // Initial all data fields
        refreshTab();

        gridPane.add(title,1,0);
        gridPane.add(director,1,1);
        gridPane.add(companyComnbo,1,2);
        gridPane.add(year,1,3);
        gridPane.add(length,1,4);
        gridPane.add(rating,1,5);
        gridPane.add(genre,1,6);

        Button addButton = new Button("Add Movie");
        addButton.setOnAction(e -> {
            Movie movie = new Movie(0,
                    title.getText(),
                    director.getText(),
                    companyComnbo.getSelectionModel().getSelectedItem().getCompanyId(),
                    Integer.parseInt(year.getText()),
                    Integer.parseInt(length.getText()),
                    rating.getText(),
                    genre.getText()
            );
            MovieTable movieTable = new MovieTable();
            movieTable.insertMovie(movie);
            MovieListTab.getInstance().refreshTable();
            refreshTab();



        });
        gridPane.add(addButton,1,7);

        // Add Company List if does not exist
        Button addCompany = new Button("Add Company");
        addCompany.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(CompanyListTab.getInstance());
            tabPane.getSelectionModel().select(CompanyListTab.getInstance());
        });
        gridPane.add(addCompany,2,2);

        gridPane.setHgap(10);
        gridPane.setVgap(15);
        hBox.getChildren().add(gridPane);
        hBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(hBox);
        root.setAlignment(Pos.CENTER);

        this.setContent(root);

    }

    public static AddMovieTab getInstance() {
        if (tab == null) {
            tab = new AddMovieTab();
        }
        return tab;
    }

    private void refreshTab(){
//        tab = new AddMovieTab();
//        this.setContent(root);
        CompanyListTable companyTable = new CompanyListTable();

        title.setText("");
        director.setText("");
        companyComnbo.setItems(null);
        year.setText("");
        length.setText("");
        rating.setText("");
        genre.setText("");
        companyComnbo.setItems(
                FXCollections.observableArrayList(companyTable.getAllCompanies())
        );
    }

    public void refreshCompany(){
        CompanyListTable companyTable = new CompanyListTable();

        companyComnbo.setItems(
                FXCollections.observableArrayList(companyTable.getAllCompanies())
        );

        System.out.println("Refreshed");
    }
}
