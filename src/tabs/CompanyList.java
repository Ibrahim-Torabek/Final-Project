package tabs;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import tables.CompanyListTable;

public class CompanyList extends Tab {
    private static CompanyList tab;
    public TableView tableView;

    private CompanyList() {
        super("Movie Companies List");


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
        root.setCenter(tableView);

        this.setContent(root);

    }

    public static CompanyList getInstance(){
        if(tab == null){
            tab = new CompanyList();
        }

        return tab;
    }
}
