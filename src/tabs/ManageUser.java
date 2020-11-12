package tabs;

import javafx.scene.control.Tab;

public class ManageUser extends Tab {
    private static ManageUser tab;

    private ManageUser() {
        super("Manage Users");
    }

    public static ManageUser getInstance(){
        if(tab == null){
            tab = new ManageUser();
        }

        return tab;
    }
}
