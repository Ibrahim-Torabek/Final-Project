package Panes;

import database.LogIntoDatabase;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import main.FileIO;
import main.Main;
import pojo.User;
import tabs.*;

import java.io.File;
import java.util.ArrayList;



/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class extends TabPane of JavaFX class to display all tabs in the system. It means, this class is the main pain
 * of the system.<br/>
 *     In this class system will check if a database information file is exist.
 *     If the file is not exist, will display LoginDBTab class to let user connect a database
 *     and create the first admin user. If the file is exist, the TabPane will display
 *     MovieListTab class to display movies.<br/>
 *     This class also has refresh method to determine which tabs should be displayed. If the user logged out,
 *     all tabs will be closed except movie list tab.
 *     If the admin user logged in, all tabs enabled.
 *
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see javafx.scene.control.TabPane
 * @see LoginDBTab
 * @see MovieListTab
 * @see FileIO
 *
 */
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

    /**
     *
     */
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
