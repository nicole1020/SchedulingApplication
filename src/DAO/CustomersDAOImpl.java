package DAO;

import Model.Customers;
import Model.UserLogin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.DBConnection.connection;

public class CustomersDAOImpl {

    public static ObservableList <Customers> getAllCustomers() {
        ObservableList<Customers> customerList = FXCollections.observableArrayList();
        try {
            String sqlInquiryC = "SELECT Customer_Name, Address, Postal_Code, Phone, Customer_ID, Division_ID FROM customers ";

            PreparedStatement prepC = connection.prepareStatement(sqlInquiryC);
            ResultSet cResult = prepC.executeQuery();
            while(cResult.next()){
                String  Customer_Name = cResult.getString("Customer_Name");
                String Address = cResult.getString("Address");
                String Postal_Code = cResult.getString("Postal_Code");
                int Phone = cResult.getInt("Phone");

                int Customer_ID  = cResult.getInt("Customer_ID");
                int Division_ID= cResult.getInt("Division_ID");
                Customers cu = new Customers( Customer_Name, Address, Postal_Code, Phone,Customer_ID, Division_ID );
                customerList.add(cu);

            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerList;
    }
}
