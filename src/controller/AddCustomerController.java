package controller;

import DAO.AddressHelper;
import DAO.CustomersHelper;
import javafx.scene.control.*;
import model.Address;
import model.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
// Initializes AddCustomersController
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
    public Button back;
    private  Integer customerID = 0;
    int countingClicks = 0;

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
        if (name == null || address == null || postalcode == null || phone == null ) {
            System.out.println("enter proper data");
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Enter Valid Inputs");
            alert2.setContentText("Enter Valid Inputs ");
            alert2.showAndWait();

            return;
        }
        if (division == null) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Select a Division");
            alert2.setContentText("Select a Division");
            alert2.showAndWait();
            return;
        }
        if (customerID == 0) {
            CustomersHelper.createCustomer(name, address, postalcode, phone, division.getDivisionID());
        } else {
            CustomersHelper.updateCustomer( customerID, name, address, postalcode,phone , division.getDivisionID()
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerCountryCombo.setItems(CustomersHelper.getAllCountries());

        exitButton.setOnAction(e ->{
            countingClicks++;
            System.out.println(countingClicks);
            System.out.println("Exit Button Pressed");
            System.exit(0);
        });
    }

    public void onBackButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CustomerScreen.fxml"));
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
