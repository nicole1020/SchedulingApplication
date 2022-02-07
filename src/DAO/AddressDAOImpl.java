package DAO;

import Model.Address;
import Model.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAOImpl {public static ObservableList getAllAddresses() {
    ObservableList<Address> addressList = FXCollections.observableArrayList();
    try {
        String sqlInquiryAd = "SELECT first_level_divisions.Division_ID, first_level_divisions.Division, Country_ID, countries.Country  from first_level_divisions where first_level_divisions.Country_ID = countries.Country_ID ";

        PreparedStatement prepAd = DriverManager.getConnection("","","").prepareStatement(sqlInquiryAd);
        ResultSet adResult = prepAd.executeQuery();
        while(adResult.next()){
            int Division_ID= adResult.getInt("Division_ID");
            String Division = adResult.getString("Division");
            int Country_ID= adResult.getInt("Country_ID");
            String  Country = adResult.getString("Country");

            Model.Address ad = new Address( Division_ID, Division, Country_ID, Country );
            addressList.add(ad);

        }

    }
    catch (SQLException ex) {
        ex.printStackTrace();
    }
    return addressList;
}
}
