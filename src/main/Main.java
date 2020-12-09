package main;

import database.LogIntoDatabase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import menus.MainMenu;

import java.security.PublicKey;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>The system allows managing movies’ information, specifically,
 * add information about a new movie, store information related to a movie,
 * update information related to a movie, retrieve it upon request,
 * search it by keywords, correct it and delete as well as to visualize data in graphs and charts.</p>
 * <p>The system has two type of user, admin and regular. When any user not logged in, the user can only
 * see the movie list. If an admin logged in, the user can insert movie and production company to
 * the system. If a regular user logged into the system, the user can add movie into watched list or wish list.
 * can open their watched movies statistics.</p>
 *
 * This class is main entrance of the program. The start method will create a scene for the stage
 * attach a borderPane to the scene. Also create the main menu.
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see BorderPane
 * @see Scene
 * @see Panes.TabPane
 * @see MainMenu
 *
 */
public class Main  extends Application {

    public static LogIntoDatabase loginDB;


    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        MainMenu menu = MainMenu.getInstance();
        root.setTop(menu);

        root.setCenter(Panes.TabPane.getInstance());
        Scene scene = new Scene(root, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Movie Tracer");
        stage.show();


    }
}
