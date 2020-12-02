package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import tabs.AddMovieTab;

public class InsertMenu extends Menu {
    // Menu items
    private MenuItem insertMovie;

    public InsertMenu() {
        super("Insert");
        this.setDisable(true);


        insertMovie = new MenuItem("Insert Movie");
        insertMovie.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(AddMovieTab.getInstance());
            tabPane.getSelectionModel().select(AddMovieTab.getInstance());

        });


        this.getItems().addAll(insertMovie);
    }
}
