package main;

import database.LogIntoDatabase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import menus.MainMenu;

import java.security.PublicKey;


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
