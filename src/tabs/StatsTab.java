package tabs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import pojo.CompanyList;
import tables.CompanyListTable;
import tables.MovieTable;

import java.util.ArrayList;

public class StatsTab extends Tab {

    private static StatsTab tab;
    private PieChart pieChart;


    private StatsTab() {
        this.setText("Statistics");
        BorderPane pane = new BorderPane();
        pieChart = new PieChart();
        pieChart.setTitle("Movie Companies");
        pieChart.setLabelsVisible(true);
        makePieChart();
        pane.setCenter(pieChart);
        this.setContent(pane); //pieChart to the center
    }

    public void makePieChart(){
       //access the database
        MovieTable movieTable = new MovieTable();
        CompanyListTable companyList = new CompanyListTable();
        //take watched movies from the list
        ArrayList<CompanyList> companies = companyList.getAllCompanies();
        if (companies.isEmpty()) {
            System.out.println("CompanyList is empty.");
        }
        //delete all data in the pieChart
        pieChart.getData().clear();
        //create the pieChart data
        ArrayList<PieChart.Data> pieChartData = new ArrayList<>();

        for (CompanyList company : companies) {
            //add a record if there are companies in the table
            if(movieTable.getMovieAmount(company.getCompanyId()) > 0) {
                pieChartData.add(new PieChart.Data(company.getCompanyName(),
                        movieTable.getMovieAmount(company.getCompanyId())));

            }
            System.out.println("movies are not here!");
        }
        //place ArrayList in the ObservableList to read
        ObservableList<PieChart.Data> chartData =
                FXCollections.observableArrayList(pieChartData);
        //Populate the chart
        pieChart.setData(chartData);
    }
    public static StatsTab getInstance() {
        if (tab == null) {
            tab = new StatsTab();
        }
        return tab;
    }
}
