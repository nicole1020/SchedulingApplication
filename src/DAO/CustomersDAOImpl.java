package DAO;

import Model.Customers;
import Model.UserLogin;
import com.mysql.cj.xdevapi.Result;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.*;

import static DAO.DBConnection.connection;

public class CustomersDAOImpl {

    private static int customer_ID;

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
    public static void createCustomer(TextField customerName, TextField customerAddress, TextField postalCode, String customerPhone, int parseInt, ComboBox customerCountry, ComboBox customerDivision) {
            try {
                String sqlc1= " INSERT INTO customers VALUES (NULL, ?,?,?,?,?,?,?,?,?)" ;
                PreparedStatement psCreate = connection.prepareStatement(sqlc1, Statement.RETURN_GENERATED_KEYS);
                psCreate.setString(1, String.valueOf(customerName));
                psCreate.setString(2, String.valueOf(customerAddress));
                psCreate.setString(3, String.valueOf(postalCode));
                psCreate.setInt(4, Integer.parseInt(customerPhone));
                psCreate.setString(5, String.valueOf(customerCountry));
                psCreate.setString(6, String.valueOf(customerDivision));
                psCreate.executeQuery();

                ResultSet resultcC = psCreate.getGeneratedKeys();
                resultcC.next();
                int Customer_ID = resultcC.getInt(1);


            } catch (Exception e) {
                e.printStackTrace();//print stack trace
            }


        }
    }
