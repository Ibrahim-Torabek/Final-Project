package tabs;

import javafx.scene.control.Tab;

public class WishList extends Tab {
    private static WishList tab;

    private WishList() {
        super("Wish List");
    }

    public static WishList getInstance(){
        if(tab == null){
            tab = new WishList();
        }

        return tab;
    }
}
