package menus;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import pojo.User;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class extends MenuBar class to manipulate menus . It has file, insert, tabs and login menus.
 *
 * This class also has refresh method to determine which menu should be disabled or enabled..</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see MenuBar
 * @see FileMenu
 * @see InsertMenu
 * @see TabsMenu
 * @see LoginMenu
 */
public class MainMenu extends MenuBar {
    private static MainMenu menu;

    // Menus
    private FileMenu fileMenu;
    private InsertMenu insertMenu;
    private TabsMenu tabsMenu;
    private LoginMenu loginMenu;

    private MainMenu()  {
        // Initial Menus
        fileMenu = new FileMenu();
        insertMenu = new InsertMenu();
        tabsMenu = new TabsMenu();
        loginMenu = new LoginMenu();


        this.getMenus().addAll(fileMenu,insertMenu,tabsMenu, loginMenu);

    }

    public static MainMenu getInstance(){
        if(menu == null){
            menu = new MainMenu();
        }

        return menu;
    }

    public void refreshMenus(){
        if(User.getInstance() != null) {
            tabsMenu.getWatchedListMenu().setDisable(false);
            tabsMenu.getWishListMenu().setDisable(false);
            tabsMenu.getCompanyStats().setDisable(false);
            tabsMenu.getWatchedStats().setDisable(false);
            tabsMenu.getWatchedStats().setDisable(false);

            if (User.getInstance().isAdmin()) {
                insertMenu.setDisable(false);
            } else {
                insertMenu.setDisable(true);

            }
        } else {
            insertMenu.setDisable(true);
            tabsMenu.getWatchedListMenu().setDisable(true);
            tabsMenu.getWishListMenu().setDisable(true);
            tabsMenu.getWatchedStats().setDisable(true);
        }

        loginMenu.refreshMenu();
    }

    public Menu getInsertMenu() {
        return insertMenu;
    }

    public TabsMenu getTabsMenu() {
        return tabsMenu;
    }

    public LoginMenu getLoginMenu() {
        return loginMenu;
    }
}
