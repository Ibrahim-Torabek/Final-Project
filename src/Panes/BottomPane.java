package Panes;

import buttons.AddToWatchedList;
import buttons.AddToWishList;
import buttons.RemoveFromWatchedList;
import buttons.RemoveFromWishList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import pojo.User;
import tabs.*;

import java.util.ArrayList;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class extends HBox class to display buttons in the bottom of a tab
 * . This class is used by MovieListTab, WatchedListTab and WishListTab classes.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see HBox
 * @see Button
 * @see MovieListTab
 * @see WatchedListTab
 * @see WishListTab
 */
public class BottomPane extends HBox {
    public static final int BUTTON_REMOVE_FROM_WATCHED_LIST = 0;
    public static final int BUTTON_REMOVE_FROM_WISH_LIST = 1;
    public static final int BUTTON_ADD_TO_WATCHED_LIST = 2;
    public static final int BUTTON_ADD_TO_WISH_LIST = 3;
    public static final int BUTTON_DELETE_MOVIE = 4;

    AddToWatchedList addToWatchedList;// = new AddToWatchedList(tableView);
    AddToWishList addToWishList;// = new AddToWishList(tableView);

    private ArrayList<Button> buttons = new ArrayList<>();

    public BottomPane(TableView tableView) {

        addToWatchedList = new AddToWatchedList(tableView);
        addToWishList = new AddToWishList(tableView);
        buttons.add(new RemoveFromWatchedList(tableView));
        buttons.add(new RemoveFromWishList(tableView));
        buttons.add(addToWatchedList);
        buttons.add(addToWishList);


        //this.getChildren().addAll(addToWatchedList,addToWishList);
        this.setSpacing(40);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);

    }

    public void addButton(int button){
        this.getChildren().add(buttons.get(button));
    }

    public void refresh(){
        if(User.getInstance() != null){
            addToWatchedList.setDisable(false);
            addToWishList.setDisable(false);
        } else {
            addToWatchedList.setDisable(true);
            addToWishList.setDisable(true);
        }
    }
}
