package DAO;

import model.Address;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.DBConnection.connection;
/**
 * @author Nicole Mau
 *  Initializing AddressHelper class
 *
 */


public class AddressHelper {
    /**
     *
     * @param countryID passes countryID into all addresses
     * @return address list based on country id
     */
    public static ObservableList<Address> getAllAddresses(Integer countryID) {
        ObservableList<Address> addressList = FXCollections.observableArrayList();
        try {
            String sqlInquiryAd = "SELECT  first_level_divisions.Division_ID, first_level_divisions.Division from first_level_divisions, countries where first_level_divisions.Country_ID = countries.Country_ID AND first_level_divisions.Country_ID = ?";
            PreparedStatement prepAd = connection.prepareStatement(sqlInquiryAd);
            prepAd.setInt(1, countryID);
            ResultSet adResult = prepAd.executeQuery();
            while (adResult.next()) {

                int Division_ID = adResult.getInt("Division_ID");
                String Division = adResult.getString("Division");


                Address ad = new Address( Division_ID, Division);
                addressList.add(ad);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return addressList;
    }




}
