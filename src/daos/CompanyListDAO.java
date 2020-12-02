package daos;

import pojo.CompanyList;

import java.util.ArrayList;

public interface CompanyListDAO {
    public ArrayList<CompanyList> getAllCompanies();
    public CompanyList getCompany(int id);
    public void insertCompany(CompanyList company);
}
