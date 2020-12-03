package Panes;

import buttons.AddToWatchedList;
import buttons.AddToWishList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import pojo.User;

public class BottomPane extends HBox {

    AddToWatchedList addToWatchedList;// = new AddToWatchedList(tableView);
    AddToWishList addToWishList;// = new AddToWishList(tableView);

    public BottomPane(TableView tableView) {

        addToWatchedList = new AddToWatchedList(tableView);
        addToWishList = new AddToWishList(tableView);

        this.getChildren().addAll(addToWatchedList,addToWishList);
        this.setSpacing(40);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);

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
