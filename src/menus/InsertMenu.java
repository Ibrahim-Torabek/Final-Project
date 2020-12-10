package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import tabs.AddMovieTab;
import tabs.CompanyListTab;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class extends Menu class to display file menu. It has insertMovie and insert Company MenuItems.
 * This menu is only available admin user.</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Menu
 * @see MenuItem
 */
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

        MenuItem insertCompany = new MenuItem("Insert  Company");
        insertCompany.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(CompanyListTab.getInstance());
            tabPane.getSelectionModel().select(CompanyListTab.getInstance());

        });


        this.getItems().addAll(insertMovie,insertCompany);
    }
}
