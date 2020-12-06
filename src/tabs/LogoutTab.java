package tabs;

import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class LogoutTab extends Tab {

    public static LogoutTab tab;

    private LogoutTab() {
        super("Logout");

        TextField logoutMessage = new TextField("You successfully logged out of the software. " +
                "Go to Login Tab to log in.");
        logoutMessage.setFont(Font.font("Times New Roman", 28));
    }

    public static LogoutTab getInstance(){
        if(tab == null){
            tab = new LogoutTab();
        }
        return tab;
    }

}
