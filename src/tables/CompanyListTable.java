package tables;

import daos.CompanyListDAO;
import database.DBConst;
import database.Database;
import pojo.CompanyList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is an implemented class from CompanyListDAO interface. This class
 * maintain the CRUD operations of company_list table.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see daos.CompanyListDAO
 * @see Database
 * @see Statement
 * @see ResultSet
 * @see CompanyList
 *
 */
public class CompanyListTable implements CompanyListDAO {
    Database db = Database.getInstance();
    ArrayList<CompanyList> companies;

    @Override
    public ArrayList<CompanyList> getAllCompanies() {
        String query = "SELECT * FROM " + DBConst.TABLE_COMPANY;
        companies = new ArrayList<>();

        try {
            Statement getCompanies =
                    db.getConnection().createStatement();
            ResultSet resultSet = getCompanies.executeQuery(query);
            while (resultSet.next()){
                CompanyList company = new CompanyList(resultSet.getInt(DBConst.COMPANY_COLUMN_ID),
                        resultSet.getString(DBConst.COMPANY_COLUMN_NAME));
                companies.add(company);
                System.out.println(company);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return companies;
    }

    @Override
    public CompanyList getCompany(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_COMPANY +
                " WHERE " + DBConst.COMPANY_COLUMN_ID + " = " + id;

        try {
            Statement getCompanies =
                    db.getConnection().createStatement();
            ResultSet resultSet = getCompanies.executeQuery(query);
            if (resultSet.next()){
                CompanyList company = new CompanyList(resultSet.getInt(DBConst.COMPANY_COLUMN_ID),
                        resultSet.getString(DBConst.COMPANY_COLUMN_NAME));

                System.out.println(company);
                return company;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

    @Override
    public void insertCompany(CompanyList company) {
        String query = "INSERT INTO " + DBConst.TABLE_COMPANY +
                " VALUES (0, '" +
                company.getCompanyName() + "')";

        //query = "INSERT INTO company_list VALUES (NULL, 'Hello')";

        try{
            db.getConnection().createStatement().execute(query);
        } catch (SQLException throwable) {
            System.out.println(query);
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(int id) {
        String query = "DELETE FROM " + DBConst.TABLE_COMPANY + " WHERE " +
                DBConst.COMPANY_COLUMN_ID + " = " + id;

        try{
            db.getConnection().createStatement().execute(query);
        } catch (SQLException throwable) {
            System.out.println(query);
            throwable.printStackTrace();
        }
    }
}
