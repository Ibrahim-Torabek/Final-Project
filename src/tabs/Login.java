package tabs;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Login extends Tab {
    private static Login tab;

    private Login() {
        super("Login");


        VBox root = new VBox();
        HBox hBox = new HBox();
        Font font = Font.font("Times New Roman",30);

        GridPane gridPane = new GridPane();
        Label userNameLabel = new Label("User Name:");
        userNameLabel.setFont(font);
        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(font);

        TextField userName = new TextField();
        userName.setFont(font);
        PasswordField password = new PasswordField();
        password.setFont(font);

        gridPane.add(userNameLabel, 0 ,0);
        gridPane.add(userName, 1,0);
        gridPane.add(passwordLabel, 0,1);
        gridPane.add(password, 1,1);

        gridPane.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.setVgap(15);
        gridPane.setHgap(5);

        Button loginButton = new Button("Login");
        loginButton.setFont(font);
        gridPane.add(loginButton, 1,2);

        hBox.getChildren().add(gridPane);
        hBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(hBox);
        root.setAlignment(Pos.CENTER);

        this.setContent(root);

    }

    public static Login getInstance(){
        if(tab == null){
            tab = new Login();
        }

        return tab;
    }
}
