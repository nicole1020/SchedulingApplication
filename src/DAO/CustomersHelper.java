package DAO;

import model.Country;
import model.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

import static DAO.DBConnection.connection;
/**
 * @author Nicole Mau
 *  Initializing CustomersHelper
 */

public class CustomersHelper {
    /**
     *
     * @return returns  all customerList from database
     */

    public static ObservableList<Customers> getAllCustomers() {
        ObservableList<Customers> customerList = FXCollections.observableArrayList();
        try {
            String sqlInquiryC = "SELECT Customer_Name, Address, Postal_Code, Phone, Customer_ID, Country, Division FROM customers, " +
                    "first_level_divisions, countries WHERE customers.Division_ID = first_level_divisions.Division_ID AND first_level_divisions.Country_ID = countries.Country_ID ";

            PreparedStatement prepC = connection.prepareStatement(sqlInquiryC);
            ResultSet cResult = prepC.executeQuery();
            while (cResult.next()) {
                String Customer_Name = cResult.getString("Customer_Name");
                String Address = cResult.getString("Address");
                String Postal_Code = cResult.getString("Postal_Code");
                String Phone = cResult.getString("Phone");
                int Customer_ID = cResult.getInt("Customer_ID");
                String Country = cResult.getString("Country");
                String Division = cResult.getString("Division");

                Customers cu = new Customers(Customer_Name, Address, Postal_Code, Phone, Customer_ID, Country, Division);
                customerList.add(cu);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerList;
    }

    /**
     *
     * @param name new customer's name added to database
     * @param address new customer's address added to database
     * @param postalcode new customer's postalcode added to database
     * @param phone new customer's phone added to database
     * @param division new customer's division added to database
     */
    public static void createCustomer(String name, String address, String postalcode, String phone, Integer division) {
        try {
            String sqlc = " INSERT INTO customers VALUES (NULL, ?,?,?,?,now(),'nm',now(),'nm',?)";
            PreparedStatement psCreate = connection.prepareStatement(sqlc);
            psCreate.setString(1, String.valueOf(name));
            psCreate.setString(2, String.valueOf(address));
            psCreate.setString(3, String.valueOf(postalcode));
            psCreate.setString(4, String.valueOf(phone));
            psCreate.setInt(5, division);
            psCreate.execute();

        } catch (Exception e) {
            e.printStackTrace();//print stack trace

        }

    }


    /**
     *
     * @param name customer's name updated in database
     * @param address customer's address updated in database
     * @param postalcode customer's postalcode updated in database
     * @param phone customer's phone updated in database
     * @param division customer's division updated in database
     * @param customerID customer's customerID updated in database
     */
    public static void updateCustomer(  String name, String address,
                                      String postalcode, String phone, int division,int customerID) {
        try {
            String sqlc3 = " UPDATE  customers set Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? WHERE Customer_ID = ? ";
            PreparedStatement psCreate3 = connection.prepareStatement(sqlc3);

            psCreate3.setString(1, String.valueOf(name));
            psCreate3.setString(2, String.valueOf(address));
            psCreate3.setString(3, String.valueOf(postalcode));
            psCreate3.setString(4, String.valueOf(phone));
            psCreate3.setInt(5, division);
            psCreate3.setInt(6, customerID);
            psCreate3.execute();

        } catch (Exception e) {
            e.printStackTrace();//print stack trace

        }
    }


    /**
     *
     * @param customer_ID    deletes customer from database by customer ID
     */
    public static void deleteCustomer(int customer_ID) {
        try{

            String sqlDC = "delete from  appointments WHERE Customer_ID = ?" ;
            PreparedStatement psDC = connection.prepareStatement(sqlDC);
            psDC.setInt(1, customer_ID);
            psDC.execute();

            String sqlDC2 = "delete from  customers WHERE Customer_ID = ?" ;
            PreparedStatement psDC2 = connection.prepareStatement(sqlDC2);
            psDC2.setInt(1, customer_ID);
            psDC2.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @return returns all countryList from database
     */

    public static ObservableList<Country> getAllCountries() {
        ObservableList<Country> countryList = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT Country_ID, Country FROM countries";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                Integer Country_ID = cBResult.getInt("Country_ID");
                String Country = cBResult.getString("Country");
                Country cL = new Country(Country_ID, Country);

                countryList.add(cL);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryList;
    }

    /**
     *
     * @return customerIDs of customers who have appointments from database
     */

    public static ObservableList<Customers> getAllAppointmentCustomerIDs() {
        ObservableList<Customers> appointmentCustomerIDs = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT Customer_ID, Customer_Name FROM customers";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                int Customer_ID = cBResult.getInt("Customer_ID");
                String Customer_Name = cBResult.getString("Customer_Name");
                Customers cC = new Customers(Customer_ID, Customer_Name);
                appointmentCustomerIDs.add(cC);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentCustomerIDs;
    }


}