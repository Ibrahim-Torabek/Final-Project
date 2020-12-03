package tabs;

import javafx.scene.control.Tab;

public class WatchedListTab extends Tab {
    private static WatchedListTab tab;

    private WatchedListTab() {
        super("Watched List");
    }

    public static WatchedListTab getInstance(){
        if(tab == null){
            tab = new WatchedListTab();
        }

        return tab;
    }
}
