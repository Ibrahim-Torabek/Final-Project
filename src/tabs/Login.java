package tabs;

import javafx.scene.control.Tab;

public class Login extends Tab {
    private static Login tab;

    private Login() {
        super("Login");
    }

    public static Login getInstance(){
        if(tab == null){
            tab = new Login();
        }

        return tab;
    }
}
