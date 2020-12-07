package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import pojo.User;
import tabs.AddMovieTab;
import tabs.LoginTab;
import tabs.LogoutTab;


public class LoginMenu extends Menu {
    private MenuItem loginMenu;
    private MenuItem logoutMenu;

    public LoginMenu() {
        super("Log in/out");

        loginMenu = new MenuItem("Login");
        logoutMenu = new MenuItem("Logout");

        logoutMenu.setDisable(true);

//        TextField logoutTitle = new TextField("Thank you for using the Movie Tracker software.");
//        logoutTitle.setFont(Font.font("Times New Roman", 28));

        loginMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            if (!tabPane.getTabs().contains(LoginTab.getInstance())){
                tabPane.getTabs().add(LoginTab.getInstance());
            }
            tabPane.getSelectionModel().select(LoginTab.getInstance());
        });

        logoutMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            User.getInstance().logout();
            MainMenu.getInstance().refreshMenus();
            TabPane.getInstance().refreshTabs();
            if (!tabPane.getTabs().contains(LogoutTab.getInstance())){
                tabPane.getTabs().add(LogoutTab.getInstance());
            }
            tabPane.getSelectionModel().select(LogoutTab.getInstance());


        });

        this.getItems().addAll(loginMenu,logoutMenu);

//        this.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Clicked");
//            }
//        });

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> System.out.println("Clicked 2"));

        //this.addEventHandler();
    }

    public void refreshMenu(){

        if(User.getInstance() != null){
            loginMenu.setDisable(true);
            logoutMenu.setDisable((false));
        } else {
            loginMenu.setDisable(false);
            logoutMenu.setDisable(true);
        }
    }
}
