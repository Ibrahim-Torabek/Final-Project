package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import tabs.MovieListTab;
import tabs.StatsTab;
import tabs.WatchedListTab;
import tabs.WishListTab;

public class TabsMenu extends Menu {
    private MenuItem watchedListMenu;
    private MenuItem wishListMenu;
    private MenuItem movieList;
    private MenuItem stats;

    public TabsMenu() {
        super("Tabs");

        watchedListMenu = new MenuItem("Watched list");
        wishListMenu = new MenuItem("Wish list");
        movieList = new MenuItem("Movie List");
        stats = new MenuItem("Statistics");



        movieList.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            if(!tabPane.getTabs().contains(MovieListTab.getInstance()))
                tabPane.getTabs().add(MovieListTab.getInstance());
            tabPane.getSelectionModel().select(MovieListTab.getInstance());
        });

        watchedListMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            if(!tabPane.getTabs().contains(WatchedListTab.getInstance()))
                tabPane.getTabs().add(WatchedListTab.getInstance());
            tabPane.getSelectionModel().select(WatchedListTab.getInstance());
        });
        wishListMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            if(!tabPane.getTabs().contains(WishListTab.getInstance()))
                tabPane.getTabs().add(WishListTab.getInstance());
            tabPane.getSelectionModel().select(WishListTab.getInstance());
        });
        stats.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            if(!tabPane.getTabs().contains(StatsTab.getInstance()))
                tabPane.getTabs().add(StatsTab.getInstance());
            tabPane.getSelectionModel().select(StatsTab.getInstance());
        });

        this.getItems().addAll(movieList,watchedListMenu, wishListMenu, stats);

    }

    public MenuItem getWatchedListMenu() {
        return watchedListMenu;
    }

    public MenuItem getWishListMenu() {
        return wishListMenu;
    }

    public MenuItem getStats() {
        return stats;
    }
}
