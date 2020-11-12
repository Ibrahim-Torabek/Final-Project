package tabs;

import javafx.scene.control.Tab;

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
