package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import pojo.Login;
import pojo.User;
import tabs.AddMovieTab;
import tabs.LoginTab;
import tabs.LogoutTab;

import java.util.Objects;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class extends Menu class to login or logout a user. It has login and logout MenuItems.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Menu
 * @see MenuItem
 */
public class LoginMenu extends Menu {
    private MenuItem loginMenu;
    private MenuItem logoutMenu;

    public LoginMenu() {
        super("Log in/out");

        loginMenu = new MenuItem("Login");
        logoutMenu = new MenuItem("Logout");

        logoutMenu.setDisable(true);

        loginMenu.setOnAction(e -> {
            TabPane tabPane = TabPane.getInstance();
            if (!tabPane.getTabs().contains(LoginTab.getInstance())){
                tabPane.getTabs().add(LoginTab.getInstance());
            }
            tabPane.getSelectionModel().select(LoginTab.getInstance());
            //close logout tab when user goes to login tab
            TabPane.getInstance().getTabs().remove(tabs.LogoutTab.getInstance());
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
            //remove login tab after login
            TabPane.getInstance().getTabs().remove(LoginTab.getInstance());
            //clear login tab after login
            LoginTab.getInstance().clearTab();
        } else {
            loginMenu.setDisable(false);
            logoutMenu.setDisable(true);
        }
    }
}
