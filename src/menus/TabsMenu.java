package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import tabs.MovieListTab;
import tabs.WatchedListTab;
import tabs.WishListTab;

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
            tabPane.getTabs().add(MovieListTab.getInstance());
            tabPane.getSelectionModel().select(MovieListTab.getInstance());
        });

        watchedListMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(WatchedListTab.getInstance());
            tabPane.getSelectionModel().select(WatchedListTab.getInstance());
        });
        wishListMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            tabPane.getTabs().add(WishListTab.getInstance());
            tabPane.getSelectionModel().select(WishListTab.getInstance());
        });

        this.getItems().addAll(movieList,watchedListMenu, wishListMenu);


    }
}
