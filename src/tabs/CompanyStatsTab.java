package tabs;

import Panes.AddCompany;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import pojo.CompanyList;
import tables.CompanyListTable;
import tables.MovieTable;
import tables.WatchedListTable;

import java.util.ArrayList;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an extended class from Tab class to show statistics of movie companies. This tab used Pie Chart
 * to display statistics on the center of the borderPane.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Tab
 * @see BorderPane
 * @see PieChart
 * @see MovieTable
 * @see CompanyListTable
 *
 */
public class CompanyStatsTab extends Tab {

    private static CompanyStatsTab tab;
    private PieChart pieChart;

    private CompanyStatsTab() {
        this.setText("Movie Company Statistics");
        BorderPane pane = new BorderPane();
        //pie chart for movie companies
        pieChart = new PieChart();
        pieChart.setTitle("Movie Companies");
        pieChart.setLabelsVisible(true);
        makePieChart();
        //set pieCharts to the pane
        pane.setCenter(pieChart);
        this.setContent(pane);
    }

    //make movie companies pieChart
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
        }
        //place ArrayList in the ObservableList to read
        ObservableList<PieChart.Data> chartData =
                FXCollections.observableArrayList(pieChartData);
        //Populate the chart
        pieChart.setData(chartData);
    }

    public static CompanyStatsTab getInstance() {
        if (tab == null) {
            tab = new CompanyStatsTab();
        }
        return tab;
    }
}
