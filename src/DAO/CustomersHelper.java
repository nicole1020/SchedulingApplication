package DAO;

import model.Country;
import model.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

import static DAO.DBConnection.connection;

//Initializing CustomersHelper
public class CustomersHelper {

    //retrieves getAllCustomers from database
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


    //create new customer
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
    //updates customer in database

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
    //deletes customer from database
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
    //retrieves getAllCountries from database
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
    //retrieves getAllAppointmentCustomerIDs from database
    public static ObservableList<Customers> getAllAppointmentCustomerIDs() {
        ObservableList<Customers> appointmentCustomerIDs = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT Customer_ID FROM customers";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                int Customer_ID = cBResult.getInt("Customer_ID");
                Customers cC = new Customers(Customer_ID);
                appointmentCustomerIDs.add(cC);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentCustomerIDs;
    }


}