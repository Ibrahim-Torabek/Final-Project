package tabs;

import Panes.AddCompany;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import tables.CompanyListTable;
import tables.MovieTable;

public class CompanyList extends Tab {
    private static CompanyList tab;
    public TableView tableView;

    private CompanyList() {
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
        deleteCompany.setOnAction(e -> {
            System.out.println("Delete");
        });
        root.setCenter(tableView);
        root.setTop(new AddCompany());
        root.setBottom(deleteCompany);
        root.setAlignment(deleteCompany, Pos.CENTER);

        this.setContent(root);

    }

    public static CompanyList getInstance(){
        if(tab == null){
            tab = new CompanyList();
        }

        return tab;
    }

    public void refreshTable(){
        CompanyListTable movieTable = new CompanyListTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(movieTable.getAllCompanies());
    }
}
