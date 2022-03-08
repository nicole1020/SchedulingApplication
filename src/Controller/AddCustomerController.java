package Controller;

import DAO.AddressDAOImpl;
import DAO.CustomersDAOImpl;
import Model.Address;
import Model.Country;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable {
    public TextField customerName;
    public TextField customerPhone;
    public ComboBox<Country> customerCountryCombo;
    public ComboBox<Address> customerDivisionCombo;
    public Button clearCustomer;
    public TextField postalCode;
    public Button exitButton;
    public Button saveCustomer;
    public TextField customerAddress;
    public Label customerIDLabel;
    private  Integer customerID = 0;
    public void onClearCustomer(ActionEvent actionEvent) {
    }

    public void onCustomerCountry(ActionEvent actionEvent) {
        Country c = customerCountryCombo.getValue();
        customerDivisionCombo.setItems(AddressDAOImpl.getAllAddresses(c.getCountryID()));

        System.out.println(customerCountryCombo.getValue());
        System.out.println(customerDivisionCombo.getValue());

    }

    public void onCustomerDivision(ActionEvent actionEvent) {
        System.out.println(customerDivisionCombo.getValue());
    }

    public void onExitButtonPressed(ActionEvent actionEvent) {
    }

    public void onSaveCustomer(ActionEvent actionEvent) {
        String name = customerName.getText();
        String address = customerAddress.getText();
        String postalcode = postalCode.getText();
        String phone = customerPhone.getText();
        Address division = customerDivisionCombo.getValue();

        if (division == null) {
            return;
        }
        if (customerID == 0) {
            CustomersDAOImpl.createCustomer(name, address, postalcode, phone, division.getDivisionID());
        } else {
            CustomersDAOImpl.updateCustomer( customerID, name, address, postalcode,phone , division.getDivisionID()
            );
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerCountryCombo.setItems(CustomersDAOImpl.getAllCountries());
    }
}
