package Panes;

import database.LogIntoDatabase;
import javafx.scene.control.Tab;
import main.FileIO;
import main.Main;
import pojo.User;
import tabs.*;

import java.io.File;
import java.util.ArrayList;

public class TabPane extends javafx.scene.control.TabPane {

    private static TabPane pane;

    private TabPane() {
        //Main.loginDB = new LogIntoDatabase();

        if(!FileIO.isFileExist()){
            System.out.println("File not exist");
            this.getTabs().addAll(LoginDBTab.getInstance());
        }
        else {
            System.out.println("File Exist");
            Main.loginDB = FileIO.readObject();

            this.getTabs().addAll(MovieListTab.getInstance());
        }

        //
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

     public static void clearInstance(){
        pane = null;
     }
}
