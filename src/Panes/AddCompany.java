package Panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import pojo.CompanyList;
import tables.CompanyListTable;
import tabs.AddMovieTab;
import tabs.CompanyListTab;


public class AddCompany extends HBox {
    public AddCompany() {
        Text companyName = new Text("Company Name:");
        TextField comapny = new TextField();

        Button addButton = new Button("Add Company");
        addButton.setOnAction(e -> {
            CompanyList companyList = new CompanyList(
                    0,
                    comapny.getText()
            );

            CompanyListTable table = new CompanyListTable();
            table.insertCompany(companyList);
            CompanyListTab.getInstance().refreshTable();
            AddMovieTab.getInstance().refreshCompany();
        });

        this.getChildren().addAll(companyName,comapny,addButton);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPadding(new Insets(20));
    }
}
