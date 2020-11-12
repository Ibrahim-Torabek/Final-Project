package tabs;

import javafx.scene.control.Tab;

public class WatchedList extends Tab {
    private static WatchedList tab;

    private WatchedList() {
        super("Watched List");
    }

    public static WatchedList getInstance(){
        if(tab == null){
            tab = new WatchedList();
        }

        return tab;
    }
}
