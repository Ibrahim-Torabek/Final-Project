package tabs;

import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LogoutTab extends Tab {

    public static LogoutTab tab;

    private LogoutTab() {
        super("Logout");

        Text logoutMessage = new Text ("You successfully logged out of the software.\n " +
                "Go to Login Tab to log in.");
        logoutMessage.setFont(Font.font("Times New Roman", 28));


        HBox hBox = new HBox();
        hBox.getChildren().add(logoutMessage);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(hBox);
        this.setContent(borderPane);
    }

    public static LogoutTab getInstance(){
        if(tab == null){
            tab = new LogoutTab();
        }
        return tab;
    }

}
