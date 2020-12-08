package menus;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.io.Serializable;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class extends Menu class to display file menu. It has exit MenuItem</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Menu
 * @see MenuItem
 */
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
