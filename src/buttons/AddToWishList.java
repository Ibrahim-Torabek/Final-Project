package buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pojo.DisplayMovie;
import pojo.User;
import pojo.WatchedList;
import pojo.WishList;
import tables.WatchedListTable;
import tables.WishListTable;
import tabs.WatchedListTab;
import tabs.WishListTab;

public class AddToWishList extends Button {
    private static AddToWishList button;
    private TableView tableView;

    public AddToWishList(TableView tableView){
        super("Add to Wish List");

        this.tableView = tableView;
        this.setOnAction(e -> {
            DisplayMovie movie = (DisplayMovie) tableView.getSelectionModel().getSelectedItem();
            WishList wishMovie = new WishList(
                    0,
                    User.getInstance().getUserId(),
                    movie.getId()
            );
            WishListTable wishListTable = new WishListTable();
            wishListTable.insertWishMovie(wishMovie);
            WishListTab.getInstance().refreshTable();
            System.out.println(movie.getMovieTitle());
        });
    }

    public AddToWishList() {
        super("Add to Wish List");


    }

    public static AddToWishList getInstance(){
        if(button == null){
            button = new AddToWishList();
        }

        return button;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }
}
