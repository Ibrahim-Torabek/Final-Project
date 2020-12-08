package Panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import pojo.CompanyList;
import tables.CompanyListTable;
import tabs.AddMovieTab;
import tabs.CompanyListTab;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class extends HBox class to add a movie company to the database. This class is used by AddMovieTab class.</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see HBox
 * @see AddMovieTab
 */
public class AddCompany extends HBox {
    public AddCompany() {
        Text companyName = new Text("Company Name:");
        TextField company = new TextField();

        Button addButton = new Button("Add Company");
        addButton.setOnAction(e -> {
            CompanyList companyList = new CompanyList(
                    0,
                    company.getText()
            );

            CompanyListTable table = new CompanyListTable();
            table.insertCompany(companyList);
            CompanyListTab.getInstance().refreshTable();
            AddMovieTab.getInstance().refreshCompany();
        });

        this.getChildren().addAll(companyName,company,addButton);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPadding(new Insets(20));
    }
}
