package tabs;

import javafx.scene.control.Tab;

public class DeleteMovieTab extends Tab {

    private static DeleteMovieTab tab;

    private DeleteMovieTab() {
        this.setText("Remove Movie");
    }

    public static DeleteMovieTab getInstance() {
        if (tab == null) {
            tab = new DeleteMovieTab();
        }
        return tab;
    }
}
