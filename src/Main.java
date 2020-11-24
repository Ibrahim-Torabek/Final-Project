import database.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tabs.AddMovieTab;
import tabs.DeleteMovieTab;
import tabs.StatsTab;


public class Main  extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        //add a MenuBar
//        MenuBar menu = new MenuBar();
//        Menu fileMenu = new Menu("File");
//        Menu creditsMenu = new Menu("Credits");
//
//        //add menu items
//        MenuItem exit = new MenuItem("Exit");
//        exit.setOnAction(e->{
//            System.exit(0);
//        });
//
//        //add menu items to the menu bar
//        fileMenu.getItems().add(exit);
//        menu.getMenus().addAll(fileMenu, creditsMenu);
//
//        //add TabPane
//        TabPane tabPane = new TabPane();
//        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
//
//        //add Tabs
//        AddMovieTab addMovieTab = AddMovieTab.getInstance();
//        DeleteMovieTab deleteMovieTab = DeleteMovieTab.getInstance();
//        StatsTab statsTab = StatsTab.getInstance();
//
//        //add tabs to the TabPane
//        tabPane.getTabs().addAll(addMovieTab, deleteMovieTab, statsTab);
//
//        //create a BorderPane
        BorderPane root = new BorderPane();
//        root.setTop(menu);
//        root.setCenter(tabPane);
        //root.setCenter(TabPane.getInstance());
        Scene scene = new Scene(root,Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Movie Tracker");
        stage.show();
        Database db = Database.getInstance();
    }
}
