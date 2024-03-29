package tabs;

import database.DBConst;
import database.LogIntoDatabase;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.FileIO;
import menus.MainMenu;
import pojo.Login;
import pojo.User;
import tables.LoginTable;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an extended class from Tab class to login the system.
 * If a user logged in the system successfully, this tab will set the User as logged in and refresh all buttons,
 * tabs and menus.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Tab
 * @see GridPane
 * @see LoginTable
 * @see User
 * @see MovieListTab
 * @see MainMenu
 *
 */
public class LoginTab extends Tab {
    private static LoginTab tab;

    private TextField userName;
    private PasswordField password;
    public Text errorMsg;

    private LoginTab() {
        super("Login");

        VBox root = new VBox();
        HBox hBox = new HBox();
        Font font = Font.font("Times New Roman",20);

        GridPane gridPane = new GridPane();
        Label userNameLabel = new Label("User Name:");
        userNameLabel.setFont(font);
        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(font);

        userName = new TextField();
        userName.setFont(font);
        password = new PasswordField();
        password.setFont(font);

        //the title
        TextField loginTitle = new TextField("Log into Movie Tracer");
        loginTitle.setFont(Font.font("Times New Roman", 30));
        loginTitle.setAlignment(Pos.CENTER);

        errorMsg = new Text("");

        gridPane.add(loginTitle, 0, 0, 2, 1);
        gridPane.add(userNameLabel, 0,1);
        gridPane.add(userName, 1,1);
        gridPane.add(passwordLabel, 0,2);
        gridPane.add(password,1,2);
        gridPane.add(errorMsg,1,4, 2, 1);

        gridPane.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.setVgap(15);
        gridPane.setHgap(5);

        Button loginButton = new Button("Login");
        loginButton.setFont(font);
        gridPane.add(loginButton, 1,3);

        loginButton.setOnAction( e -> {
            LoginTable loginTable = new LoginTable();
            int loginId = loginTable.login(userName.getText(),password.getText());
            if(loginId == 0){
                errorMsg.setFill(Color.RED);
                errorMsg.setText("Cannot Login...");
            } else {
                User.login(loginId);
                User user = User.getInstance();
                errorMsg.setFill(Color.BLUE);
                errorMsg.setText("Welcome " + user.getFullName() + ".\n Go to the Movie List tab.");
                errorMsg.setFont(Font.font("Times New Roman", 30));

                // Refreshes
                MovieListTab.getInstance().refreshUserName();
                MovieListTab.getInstance().refreshButtons();
                MainMenu.getInstance().refreshMenus();

            }
        });


        hBox.getChildren().add(gridPane);
        hBox.setAlignment(Pos.CENTER);
        root.getChildren().add(hBox);
        root.setAlignment(Pos.CENTER);
        this.setContent(root);
    }

    public static LoginTab getInstance(){
        if(tab == null){
            tab = new LoginTab();
        }
        return tab;
    }
    //clear userName field, password field and welcoming message after login
    public void clearTab() {
        userName.clear();
        password.clear();
        errorMsg.setText(" ");
    }
}
