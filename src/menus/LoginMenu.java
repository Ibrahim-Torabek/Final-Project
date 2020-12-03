package menus;

import Panes.TabPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import pojo.User;
import tabs.LoginTab;


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
            tabPane.getTabs().add(LoginTab.getInstance());
            tabPane.getSelectionModel().select(LoginTab.getInstance());
        });

        logoutMenu.setOnAction(e -> {
            User.getInstance().logout();
            MainMenu.getInstance().refreshMenus();
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
