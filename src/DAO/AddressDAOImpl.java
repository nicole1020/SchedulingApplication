package DAO;

import Model.Address;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.DBConnection.connection;

public class AddressDAOImpl {
    public static ObservableList<Address> getAllAddresses() {
        ObservableList<Address> addressList = FXCollections.observableArrayList();
        try {
            String sqlInquiryAd = "SELECT  first_level_divisions.Division_ID, first_level_divisions.Division from first_level_divisions where first_level_divisions.Country_ID = countries.Country_ID ";

            PreparedStatement prepAd = connection.prepareStatement(sqlInquiryAd);
            ResultSet adResult = prepAd.executeQuery();
            while (adResult.next()) {

                int Division_ID = adResult.getInt("Division_ID");
                String Division = adResult.getString("Division");


                Model.Address ad = new Address( Division_ID, Division);
                addressList.add(ad);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return addressList;
    }




}
