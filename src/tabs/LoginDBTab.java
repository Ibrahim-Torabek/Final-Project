package tabs;

import Panes.TabPane;
import database.LogIntoDatabase;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.FileIO;
import main.Main;
import menus.LoginMenu;
import menus.MainMenu;
import pojo.Login;
import pojo.User;
import tables.LoginTable;
import tables.MovieTable;
import tables.UserTable;
import tables.WatchedListTable;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an extended class from Tab class to setup database and set up an admin user.
 * When the operator set up the the database, the system will create a LogIntoDatabase object and write it
 * into login.dat file with FileIO class' static method.
 * The operator only can set up an admin user after the connection of the database.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Tab
 * @see BorderPane
 * @see LogIntoDatabase
 * @see User
 * @see Login
 * @see FileIO
 *
 */
public class LoginDBTab extends Tab {

    private static LoginDBTab tab;
    private VBox root = new VBox();

    private LoginDBTab() {
        this.setText("Set Up Database");
        MainMenu.getInstance().getLoginMenu().setDisable(true);
        MainMenu.getInstance().getTabsMenu().setDisable(true);

        HBox hBox = new HBox();
        Font font = Font.font("Times New Roman",20);

        GridPane databaseField = new GridPane();

        //  +++++++++++++++++++++++++  Database setup  ++++++++++++++++++++++++++++++++++++++
        // Initial all labels
        Text setupDatabase = new Text("Please Setup your database Information:");
        Text dbLocationText = new Text("Database Location:");
        Text dbNameText = new Text("Database Name:");
        Text dbUserText = new Text("Database User:");
        Text dbPasswordText = new Text("Database Password:");

        // Stylize labels
        setupDatabase.setFill(Color.BLUE);
        setupDatabase.setFont(font);

        databaseField.add(setupDatabase,0,0,2,1);
        databaseField.add(dbLocationText,0,1);
        databaseField.add(dbNameText,0,2);
        databaseField.add(dbUserText,0,3);
        databaseField.add(dbPasswordText,0,4);


        // Initial all data fields
        TextField dbName = new TextField();
        TextField dbUser = new TextField();
        TextField dbPassword = new TextField();
        TextField dbLocation = new TextField("jdbc:mysql://localhost/");


        databaseField.add(dbLocation,1,1);
        databaseField.add(dbName,1,2);
        databaseField.add(dbUser,1,3);
        databaseField.add(dbPassword,1,4);


        Button setDatabaseButton = new Button("Set Up Database");
        databaseField.add(setDatabaseButton,1,7);


        //  +++++++++++++++++++++++++ Admin User setup  ++++++++++++++++++++++++++++++++++
        GridPane userField = new GridPane();
        // Initial all labels
        Text setupUser = new Text("Please setup admin user:");
        Text userNameLabel = new Text("User Name:");
        Text passwordLabel = new Text("Password:");
        Text firstNameLabel = new Text("First Name:");
        Text lastNameLabel = new Text("Last Name:");


        // Stylize
        setupUser.setFill(Color.GRAY);
        setupUser.setFont(font);

        userField.add(setupUser,2,0,2,1);
        userField.add(userNameLabel,2,1);
        userField.add(passwordLabel,2,2);
        userField.add(firstNameLabel,2,3);
        userField.add(lastNameLabel,2,4);

        // Initialize all data fields
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        userField.add(username,3,1);
        userField.add(password,3,2);
        userField.add(firstName,3,3);
        userField.add(lastName,3,4);


        Button setUserButton = new Button("Setup User");
        setUserButton.setDisable(true);
        userField.add(setUserButton,3,7);

        databaseField.setHgap(10);
        databaseField.setVgap(15);
        userField.setHgap(10);
        userField.setVgap(15);
        hBox.getChildren().addAll(databaseField,userField);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(150);

        root.getChildren().addAll(hBox);
        root.setAlignment(Pos.CENTER);

        this.setContent(root);

        // Set Actions
        setDatabaseButton.setOnAction(e -> {
            LogIntoDatabase logIntoDatabase = new LogIntoDatabase(
                    dbLocation.getText(),
                    dbName.getText(),
                    dbUser.getText(),
                    dbPassword.getText()
            );
            FileIO.writeObject(logIntoDatabase);
            Main.loginDB = logIntoDatabase;
            //TabPane.clearInstance();
            setupUser.setFill(Color.BLUE);
            setUserButton.setDisable(false);

        });

        setUserButton.setOnAction(e -> {
            Login login = new Login(0, username.getText(),password.getText());
            LoginTable loginTable = new LoginTable();
            loginTable.insert(login);
            int loginId = loginTable.login(login.getLoginName(),login.getPassword());
            if(loginId != 0){
                User user = new User(0, loginId,firstName.getText(),lastName.getText(),true);
                UserTable userTable = new UserTable();
                userTable.insertUser(user);
                User.login(loginId);
            }

            TabPane tabPane = TabPane.getInstance();
            if(!tabPane.getTabs().contains(MovieListTab.getInstance()))
                tabPane.getTabs().add(MovieListTab.getInstance());
            tabPane.getSelectionModel().select(MovieListTab.getInstance());
            tabPane.getTabs().remove(LoginDBTab.getInstance());
            MainMenu.getInstance().getLoginMenu().setDisable(false);
            MainMenu.getInstance().getTabsMenu().setDisable(false);
        });

    }

    public static LoginDBTab getInstance() {
        if (tab == null) {
            tab = new LoginDBTab();
        }
        return tab;
    }

}
