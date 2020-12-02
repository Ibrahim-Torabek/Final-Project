package menus;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class FileMenu extends Menu {
    // Menu items
    private MenuItem exit;

    public FileMenu() {
        super("File");

        exit = new MenuItem("Exit");
        exit.setOnAction( e -> {
            System.exit(0);
        });

        this.getItems().addAll(exit);
    }
}
