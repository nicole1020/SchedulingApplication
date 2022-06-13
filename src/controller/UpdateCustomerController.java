package controller;

import DAO.AddressHelper;
import DAO.CustomersHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.Address;
import model.Country;
import model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCustomerController implements Initializable {
    public Button clearCustomer;
    public TextField customerName;
    public TextField customerPhone;
    public ComboBox<Country> customerCountryCombo;
    public ComboBox<Address> customerDivisionCombo;
    public TextField postalCode;
    public Button exitButton;
    public Button saveCustomer;
    public TextField customerAddress;
    public Label customerIDLabel;
    public Customers selectedCustomer = null;
    private  Integer customerID = 0;
    private Integer divisionID = 0;
    public void onClearCustomer(ActionEvent actionEvent) {
        customerName.clear();
        customerAddress.clear();
        customerPhone.clear();
        postalCode.clear();
        customerCountryCombo.getSelectionModel().clearSelection();
        customerDivisionCombo.getSelectionModel().clearSelection();


    }

    public void onCustomerCountry(ActionEvent actionEvent) {
        Country c = customerCountryCombo.getValue();
        customerDivisionCombo.setItems(AddressHelper.getAllAddresses(c.getCountryID()));

        System.out.println(customerCountryCombo.getValue());
        System.out.println(customerDivisionCombo.getValue());
    }


    public void onCustomerDivision(ActionEvent actionEvent) {
        System.out.println(customerDivisionCombo.getValue());
    }

    public void onExitButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void onSaveCustomer(ActionEvent actionEvent) throws IOException {
        String name = customerName.getText();
        String address = customerAddress.getText();
        String postalcode = postalCode.getText();
        String phone = customerPhone.getText();
        Address division = customerDivisionCombo.getValue();

        if (division == null) {
            return;
        }
        if (customerID == 0) {
            CustomersHelper.createCustomer(name, address, postalcode, phone, division.getDivisionID());
        } else {
            CustomersHelper.updateCustomer(customerID, name, address, postalcode, phone, division.getDivisionID()
            );
        }
        Parent root = FXMLLoader.load(getClass().getResource("/View/CustomerScreen.fxml"));
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public void editedCustomer(Customers theCustomer) {

        this.selectedCustomer = theCustomer;
        this.customerName.setText(String.valueOf(this.selectedCustomer.getCustomerName()));
        this.customerAddress.setText(String.valueOf(this.selectedCustomer.getCustomerAddress()));
        this.postalCode.setText(String.valueOf(this.selectedCustomer.getPostalCode()));
        this.customerPhone.setText(String.valueOf(this.selectedCustomer.getPhone()));
        this.customerIDLabel.setText(String.valueOf(this.selectedCustomer.getCustomerID()));
        int countryID = 0;

        for (Country C : customerCountryCombo.getItems()) {
            if (C.getCountryName().equals(theCustomer.getCountry())) {
                customerCountryCombo.getSelectionModel().select(C);
                countryID = C.getCountryID();
                break;
            }
        }
        customerDivisionCombo.setItems(AddressHelper.getAllAddresses(countryID));
        for (Address D : customerDivisionCombo.getItems()) {
            if (D.getDivision().equals(theCustomer.getDivision())) {
                customerDivisionCombo.getSelectionModel().select(D);
                break;
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerCountryCombo.setItems(CustomersHelper.getAllCountries());
    }
}
