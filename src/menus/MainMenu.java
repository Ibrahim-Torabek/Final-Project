package menus;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MainMenu extends MenuBar {
    private static MainMenu menu;

    // Menus
    private Menu fileMenu;
    private Menu insertMenu;

    // MenuItems
    private MenuItem insertMovie;
    private MenuItem exit;

    private MainMenu()  {
        // Initial Menus
        fileMenu = new Menu("File");
        insertMenu = new Menu("Insert");
        insertMenu.setDisable(true);


        // Initial Menu Items
        exit = new MenuItem("Exit");
        insertMovie = new MenuItem("Insert Movie");

        // Functionality Menu Items
        exit.setOnAction( e -> {
            System.exit(0);
        });

        fileMenu.getItems().addAll(exit);
        insertMenu.getItems().addAll(insertMovie);
        this.getMenus().addAll(fileMenu,insertMenu);

    }

    public static MainMenu getInstance(){
        if(menu == null){
            menu = new MainMenu();
        }

        return menu;
    }

    public Menu getInsertMenu() {
        return insertMenu;
    }
}
