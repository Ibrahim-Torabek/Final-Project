package daos;

import javafx.scene.control.Button;
import pojo.CompanyList;
import tabs.WishListTab;

import java.util.ArrayList;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This is an interface for CompanyListTable</p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see tables.CompanyListTable
 *
 */
public interface CompanyListDAO {
    public ArrayList<CompanyList> getAllCompanies();
    public CompanyList getCompany(int id);
    public void insertCompany(CompanyList company);
    public void deleteCompany(int id);
}
