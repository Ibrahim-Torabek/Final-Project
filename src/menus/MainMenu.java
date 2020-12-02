package menus;


import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import pojo.User;
import tabs.AddMovieTab;

public class MainMenu extends MenuBar {
    private static MainMenu menu;

    // Menus
    private FileMenu fileMenu;
    private InsertMenu insertMenu;
    private LoginMenu loginMenu;

    private MainMenu()  {
        // Initial Menus
        fileMenu = new FileMenu();
        insertMenu = new InsertMenu();
        loginMenu = new LoginMenu();


        this.getMenus().addAll(fileMenu,insertMenu,loginMenu);

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
            }
        } else {
            insertMenu.setDisable(true);
        }

        loginMenu.refreshMenu();
    }

    public Menu getInsertMenu() {
        return insertMenu;
    }
}
