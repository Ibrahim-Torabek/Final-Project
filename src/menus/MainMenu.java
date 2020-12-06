package menus;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import pojo.User;

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
            if (User.getInstance().isAdmin()) {
                insertMenu.setDisable(false);
            } else {
                insertMenu.setDisable(true);
                tabsMenu.getWatchedListMenu().setDisable(false);
                tabsMenu.getWishListMenu().setDisable(false);
                tabsMenu.getCompanyStats().setDisable(false);
                tabsMenu.getWatchedStats().setDisable(false);
            }
        } else {
            insertMenu.setDisable(true);
            tabsMenu.getWatchedListMenu().setDisable(true);
            tabsMenu.getWishListMenu().setDisable(true);
        }

        loginMenu.refreshMenu();
    }

    public Menu getInsertMenu() {
        return insertMenu;
    }
}
