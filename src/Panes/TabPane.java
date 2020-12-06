package Panes;

import javafx.scene.control.Tab;
import pojo.User;
import tabs.*;

import java.util.ArrayList;

public class TabPane extends javafx.scene.control.TabPane {

    private static TabPane pane;

    private TabPane() {
        this.getTabs().addAll(MovieListTab.getInstance());
    }

     public static TabPane getInstance(){
        if(pane == null){
            pane = new TabPane();
        }
        return pane;
     }

     public void refreshTabs(){
         ArrayList<Tab> tabToRemove = new ArrayList<>();

         tabToRemove.add(AddMovieTab.getInstance());
         tabToRemove.add(CompanyListTab.getInstance());
         tabToRemove.add(ManageUser.getInstance());
         tabToRemove.add(WatchedListTab.getInstance());
         tabToRemove.add(WishListTab.getInstance());
         tabToRemove.add(WatchedStatsTab.getInstance());

        if (User.getInstance() == null){

            for (Tab tab :
                    tabToRemove) {
                if (this.getTabs().contains(tab))
                    this.getTabs().remove(tab);
            }
        } else if(!User.getInstance().isAdmin()){
            for (Tab tab :
                    tabToRemove) {
                if (this.getTabs().contains(tab))
                    this.getTabs().remove(tab);

            }
        }
     }
}
