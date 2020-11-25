package tabs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pojo.CompanyList;
import tables.CompanyListTable;

public class MovieList extends Tab {
    private static MovieList tab;


    private MovieList() {
        super("Movie List");

    }

    public static MovieList getInstance(){
        if(tab == null){
            tab = new MovieList();
        }

        return tab;
    }

}
