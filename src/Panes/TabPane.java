package Panes;

import tabs.*;

public class TabPane extends javafx.scene.control.TabPane {

    private static TabPane pane;

    private TabPane() {
        this.getTabs().addAll(MovieListTab.getInstance(), WishListTab.getInstance());
    }

     public static TabPane getInstance(){
        if(pane == null){
            pane = new TabPane();
        }
        return pane;
     }
}
