package tabs;

import javafx.scene.control.Tab;

public class WishListTab extends Tab {
    private static WishListTab tab;

    private WishListTab() {
        super("Wish List");
    }

    public static WishListTab getInstance(){
        if(tab == null){
            tab = new WishListTab();
        }

        return tab;
    }
}
