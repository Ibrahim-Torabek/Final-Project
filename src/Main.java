import Panes.TabPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();

        root.setCenter(new TabPane());
        Scene scene = new Scene(root,Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);

        stage.setScene(scene);
        stage.show();
    }
}
