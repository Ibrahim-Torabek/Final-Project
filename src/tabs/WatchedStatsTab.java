package tabs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import pojo.User;
import tables.MovieTable;
import tables.WatchedListTable;

import java.util.ArrayList;

public class WatchedStatsTab extends Tab {

    private static WatchedStatsTab tab;
    private PieChart watchedPie;

    private WatchedStatsTab() {
        this.setText("Watched Movie Statistics");
        BorderPane pane = new BorderPane();

        //pie chart for watched movies
        watchedPie = new PieChart();
        watchedPie.setTitle("Watched Movies");
        watchedPie.setLabelsVisible(true);
        //watchedPie.set
        makeWatchedPie();

        //set pieCharts to the pane
        pane.setCenter(watchedPie);
        this.setContent(pane);
    }

    //make watched movies pieChart
    public void makeWatchedPie(){
        //access the database
        MovieTable movieTable = new MovieTable();
        WatchedListTable watchedListTable = new WatchedListTable();

        //delete all data in the pieChart
        watchedPie.getData().clear();
        //create the pieChart data
        ArrayList<PieChart.Data> watchedPieData = new ArrayList<>();
        int movieAmout = movieTable.getMovieAmount("1");
        int watchedMovieAmout = 0;
        if(User.getInstance() != null)
            watchedMovieAmout = watchedListTable.getWatchedAmount(User.getInstance().getUserId());
        watchedPieData.add(new PieChart.Data("All Movies", movieAmout - watchedMovieAmout));
        watchedPieData.add(new PieChart.Data("Watched Movies",
                watchedMovieAmout));

        //place ArrayList in the ObservableList to read
        ObservableList<PieChart.Data> watchedChartData =
                FXCollections.observableArrayList(watchedPieData);
        //Populate the chart
        watchedPie.setData(watchedChartData);
    }
    public static WatchedStatsTab getInstance() {
        if (tab == null) {
            tab = new WatchedStatsTab();
        }
        return tab;
    }

}
