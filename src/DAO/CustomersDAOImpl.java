package DAO;

import Controller.MainScreenController;
import Model.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.*;

import static DAO.DBConnection.connection;

public class CustomersDAOImpl {

    private static TextField customerID;

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



    //Selection block for Division ComboBox





    public static Object getCustomerID() {

        return null;
    }
    //create new customer
    public static void createCustomer(String name, String address, String postalcode, String phone, Object customerID, String country, String division) {
        try {

            String sqlc1="INSERT INTO countries VALUES (?,?)";
            PreparedStatement psCreate1 = connection.prepareStatement(sqlc1);
            psCreate1.setString(1, String.valueOf(country));

            psCreate1.executeQuery();

            String sqlc2="INSERT INTO first_level_divisions VALUES(?,?,?)";
            PreparedStatement psCreate2 = connection.prepareStatement(sqlc2);
            psCreate2.setString(1, String.valueOf(division));

            psCreate2.executeQuery();

            String sqlc3= " INSERT INTO customers VALUES (NULL, ?,?,?,?,?,?)" ;
            PreparedStatement psCreate3 = connection.prepareStatement(sqlc3, Statement.RETURN_GENERATED_KEYS);
            psCreate3.setString(1, String.valueOf(name));
            psCreate3.setString(2, String.valueOf(address));
            psCreate3.setString(3, String.valueOf(postalcode));
            psCreate3.setString(4, String.valueOf(phone));

            psCreate3.executeQuery();

            ResultSet resultcC = psCreate3.getGeneratedKeys();
            resultcC.next();
            int Customer_ID = resultcC.getInt(1);

            String sqlc4= " INSERT INTO customers VALUES (?)" ;
            PreparedStatement psCreate4= connection.prepareStatement(sqlc4, Statement.RETURN_GENERATED_KEYS);
            psCreate4.setInt(1, Customer_ID);
            psCreate4.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();//print stack trace

        }

    }
}
