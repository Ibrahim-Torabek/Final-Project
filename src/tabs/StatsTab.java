package tabs;

import javafx.scene.control.Tab;

public class StatsTab extends Tab {

    private static StatsTab tab;

    private StatsTab() {
        this.setText("Statistics");

    }

    public static StatsTab getInstance() {
        if (tab == null) {
            tab = new StatsTab();
        }
        return tab;
    }
}
