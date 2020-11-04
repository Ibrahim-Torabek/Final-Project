package Panes;

import tabs.*;

public class TabPane extends javafx.scene.control.TabPane {
    public TabPane() {
        this.getTabs().addAll(new MovieList(),new WishList(),new WatchedList(),new CompanyList(),new Login());
    }
}
