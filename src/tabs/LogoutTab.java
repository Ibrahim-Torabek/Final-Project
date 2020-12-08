package tabs;

import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import menus.MainMenu;
import pojo.User;
import tables.LoginTable;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an extended class from Tab class to display a message to confirm that the user successfully
 * logged out the system.
 *
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Tab
 * @see BorderPane
 * @see HBox
 *
 */
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
