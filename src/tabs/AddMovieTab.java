package tabs;

import javafx.scene.control.Tab;

public class AddMovieTab extends Tab {

    private static AddMovieTab tab;

    private AddMovieTab() {
        this.setText("Add Movie");
    }

    public static AddMovieTab getInstance() {
        if (tab == null) {
            tab = new AddMovieTab();
        }
        return tab;
    }
}
