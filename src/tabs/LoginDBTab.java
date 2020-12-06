package tabs;

import Panes.TabPane;
import database.LogIntoDatabase;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.FileIO;
import main.Main;
import menus.LoginMenu;
import menus.MainMenu;


public class LoginDBTab extends Tab {

    private static LoginDBTab tab;
    private VBox root = new VBox();

    // Declared all input fields as attributes for refresh.
    private TextField dbName = new TextField(LogIntoDatabase.DB_NAME);
    private TextField dbUser = new TextField(LogIntoDatabase.DB_USER);
    private TextField dbPassword = new TextField(LogIntoDatabase.DB_PASSWORD);
    private TextField dbLocation = new TextField("jdbc:mysql://localhost/");


    private LoginDBTab() {
        this.setText("Set Up Database");
        MainMenu.getInstance().getLoginMenu().setDisable(true);
        MainMenu.getInstance().getTabsMenu().setDisable(true);

        HBox hBox = new HBox();
        Font font = Font.font("Times New Roman",20);

        GridPane gridPane = new GridPane();

        // Initial all labels
        Text dbLocationText = new Text("Database Location:");
        Text dbNameText = new Text("Database Name:");
        Text dbUserText = new Text("Database User:");
        Text dbPasswordText = new Text("Database Password:");

        gridPane.add(dbLocationText,0,0);
        gridPane.add(dbNameText,0,1);
        gridPane.add(dbUserText,0,2);
        gridPane.add(dbPasswordText,0,3);


        // Initial all data fields

        gridPane.add(dbLocation,1,0);
        gridPane.add(dbName,1,1);
        gridPane.add(dbUser,1,2);
        gridPane.add(dbPassword,1,3);


        Button addButton = new Button("Set Up Database");
        addButton.setOnAction(e -> {
            LogIntoDatabase logIntoDatabase = new LogIntoDatabase(
                    dbLocation.getText(),
                    dbName.getText(),
                    dbUser.getText(),
                    dbPassword.getText()
            );
            FileIO.writeObject(logIntoDatabase);
            Main.loginDB = logIntoDatabase;
            //TabPane.clearInstance();
            TabPane tabPane = TabPane.getInstance();
            if(!tabPane.getTabs().contains(MovieListTab.getInstance()))
                tabPane.getTabs().add(MovieListTab.getInstance());
            tabPane.getSelectionModel().select(MovieListTab.getInstance());
            tabPane.getTabs().remove(LoginDBTab.getInstance());
            MainMenu.getInstance().getLoginMenu().setDisable(false);
            MainMenu.getInstance().getTabsMenu().setDisable(false);

        });
        gridPane.add(addButton,1,7);


        gridPane.setHgap(10);
        gridPane.setVgap(15);
        hBox.getChildren().add(gridPane);
        hBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(hBox);
        root.setAlignment(Pos.CENTER);

        this.setContent(root);

    }

    public static LoginDBTab getInstance() {
        if (tab == null) {
            tab = new LoginDBTab();
        }
        return tab;
    }

}
