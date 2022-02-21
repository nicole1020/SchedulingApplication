package DAO;

import Model.Address;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.DBConnection.connection;

public class AddressDAOImpl {public static ObservableList<Address> getAllAddresses() {
    ObservableList<Address> addressList = FXCollections.observableArrayList();
    try {
        String sqlInquiryAd = "SELECT Address from customers AND first_level_divisions.Division_ID, first_level_divisions.Division, Country_ID, countries.Country  from first_level_divisions where first_level_divisions.Country_ID = countries.Country_ID ";

        PreparedStatement prepAd = connection.prepareStatement(sqlInquiryAd);
        ResultSet adResult = prepAd.executeQuery();
        while(adResult.next()){
            String Address = adResult.getString("Address");
            int Division_ID= adResult.getInt("Division_ID");
            String Division = adResult.getString("Division");
            int Country_ID= adResult.getInt("Country_ID");
            String  Country = adResult.getString("Country");

            Model.Address ad = new Address( Address, Division_ID, Division, Country_ID, Country );
            addressList.add(ad);

        }

    }
    catch (SQLException ex) {
        ex.printStackTrace();
    }
    return addressList;
}
    //Selection block for Country ComboBox
    public static ObservableList<Address> countryComboBox(){
        ObservableList<Address> countryList = FXCollections.observableArrayList();

        try{
            String sqlcB="SELECT * Country from FROM countries";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            try {

                String Country = cBResult.getString("Country");
                Model.Address cL = new Address(Country);
                countryList.add(cL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();//print stack trace

        }

        return countryList;
    }
}
