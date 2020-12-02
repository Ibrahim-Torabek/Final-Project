package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import tabs.AddMovieTab;
import tabs.CompanyListTab;

public class InsertMenu extends Menu {
    // Menu items
    //private MenuItem insertMovie;

    public InsertMenu() {
        super("Insert");
        this.setDisable(true);


        MenuItem insertMovie = new MenuItem("Insert Movie");
        insertMovie.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(AddMovieTab.getInstance());
            tabPane.getSelectionModel().select(AddMovieTab.getInstance());

        });

        MenuItem insertCompany = new MenuItem("Insert Company");
        insertCompany.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(CompanyListTab.getInstance());
            tabPane.getSelectionModel().select(CompanyListTab.getInstance());

        });


        this.getItems().addAll(insertMovie,insertCompany);
    }
}
