package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import tabs.AddMovieTab;
import tabs.MovieList;
import tabs.WatchedList;
import tabs.WishList;

public class TabsMenu extends Menu {
    private MenuItem watchedListMenu;
    private MenuItem wishListMenu;
    private MenuItem movieList;

    public TabsMenu() {
        super("Tabs");

        watchedListMenu = new MenuItem("Watched list");
        wishListMenu = new MenuItem("Wish list");
        movieList = new MenuItem("Movie List");



        movieList.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(MovieList.getInstance());
            tabPane.getSelectionModel().select(MovieList.getInstance());
        });

        watchedListMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(WatchedList.getInstance());
            tabPane.getSelectionModel().select(WatchedList.getInstance());
        });
        wishListMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(WishList.getInstance());
            tabPane.getSelectionModel().select(WishList.getInstance());
        });

        this.getItems().addAll(movieList,watchedListMenu, wishListMenu);


    }
}
