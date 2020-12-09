package tabs;

import Panes.AddCompany;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pojo.CompanyList;
import pojo.Movie;
import tables.CompanyListTable;
import tables.MovieTable;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an extended class from Tab class to show a tab. In this tab, the admin user
 * can list movie companies form the database, or add a movie company to the database.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see Tab
 * @see BorderPane
 * @see AddCompany
 * @see CompanyList
 * @see CompanyListTable
 *
 */
public class CompanyListTab extends Tab {
    private static CompanyListTab tab;
    public TableView tableView;

    private CompanyListTab() {
        super("Movie Companies List");


        // Company List
        CompanyListTable companyListTable = new CompanyListTable();
        BorderPane root = new BorderPane();

        tableView = new TableView();

        TableColumn<pojo.CompanyList, String> columnId = new TableColumn<>("Company ID");
        columnId.setCellValueFactory(
                e -> new SimpleStringProperty(String.valueOf(e.getValue().getCompanyId()))
        );

        TableColumn<pojo.CompanyList, String> columnCompanyName = new TableColumn<>("Company Name");
        columnCompanyName.setCellValueFactory(
                e -> new SimpleStringProperty(e.getValue().getCompanyName())
        );

        tableView.getColumns().addAll(columnId,columnCompanyName);
        tableView.getItems().addAll(companyListTable.getAllCompanies());

        // Delete Company Button
        Button deleteCompany = new Button("Delete Company");
        //deleteCompany.s(new Insets(40));
        deleteCompany.setOnAction(e -> {
            CompanyList company = (CompanyList) tableView.getSelectionModel().getSelectedItem();
            companyListTable.deleteCompany(company.getCompanyId());
            refreshTable();
            AddMovieTab.getInstance().refreshCompany();
        });
        root.setCenter(tableView);
        root.setTop(new AddCompany());
        root.setBottom(deleteCompany);
        root.setAlignment(deleteCompany, Pos.CENTER);
        BorderPane.setMargin(deleteCompany,new Insets(20));

        this.setContent(root);

    }

    public static CompanyListTab getInstance(){
        if(tab == null){
            tab = new CompanyListTab();
        }

        return tab;
    }

    public void refreshTable(){
        CompanyListTable movieTable = new CompanyListTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(movieTable.getAllCompanies());
    }
}
