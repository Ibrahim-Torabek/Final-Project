import Panes.TabPane;
import database.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main  extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        //root.setCenter(TabPane.getInstance());
        Scene scene = new Scene(root,Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);
        stage.setTitle("Movie Tracker");
        stage.setScene(scene);
        stage.show();
        Database db = Database.getInstance();
    }
}
