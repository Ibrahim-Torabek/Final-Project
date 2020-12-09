package pojo;

import main.FileIO;
import tabs.LoginDBTab;
import tabs.MovieListTab;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is a Plain Old Java Object class to deal with Company Table in the database.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see tables.CompanyListTable
 *
 */
public class CompanyList {
    private int companyId;
    private String  companyName;

    public CompanyList(int companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    @Override
    public String toString() {
        return this.companyName;
    }
}
