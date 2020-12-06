package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import tabs.*;

public class TabsMenu extends Menu {
    private MenuItem watchedListMenu;
    private MenuItem wishListMenu;
    private MenuItem movieList;
    private MenuItem companyStats;
    private MenuItem watchedStats;

    public TabsMenu() {
        super("Tabs");

        watchedListMenu = new MenuItem("Watched list");
        wishListMenu = new MenuItem("Wish list");
        movieList = new MenuItem("Movie List");
        companyStats = new MenuItem("Movie Company Statistics");
        watchedStats = new MenuItem("Watched Movie Statistics");


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
        companyStats.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            if(!tabPane.getTabs().contains(CompanyStatsTab.getInstance()))
                tabPane.getTabs().add(CompanyStatsTab.getInstance());
            tabPane.getSelectionModel().select(CompanyStatsTab.getInstance());
        });
        watchedStats.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            if(!tabPane.getTabs().contains(WatchedStatsTab.getInstance()))
                tabPane.getTabs().add(WatchedStatsTab.getInstance());
            tabPane.getSelectionModel().select(WatchedStatsTab.getInstance());
        });

        this.getItems().addAll(movieList,watchedListMenu, wishListMenu,
                companyStats, watchedStats);

    }

    public MenuItem getWatchedListMenu() {
        return watchedListMenu;
    }

    public MenuItem getWishListMenu() {
        return wishListMenu;
    }

    public MenuItem getCompanyStats() {
        return companyStats;
    }

    public MenuItem getWatchedStats() { return watchedStats; }
}
