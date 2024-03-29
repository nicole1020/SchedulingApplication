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

/**
 * @author nicole mau
 *  Initializing UpdateCustomerController class
 */

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
    public Button backButton;

    int countingClicks = 0;

    /**
     *
     * @param actionEvent  this reacts when user pushes clear button
     */

    public void onClearCustomer(ActionEvent actionEvent) {
        customerName.clear();
        customerAddress.clear();
        customerPhone.clear();
        postalCode.clear();
        customerCountryCombo.getSelectionModel().clearSelection();
        customerDivisionCombo.getSelectionModel().clearSelection();


    }

    /**
     *
     * @param actionEvent this initializes country combo box ensuring division populates based on country
     */

    public void onCustomerCountry(ActionEvent actionEvent) {
        Country c = customerCountryCombo.getValue();
        customerDivisionCombo.setItems(AddressHelper.getAllAddresses(c.getCountryID()));

        System.out.println(customerCountryCombo.getValue());
        System.out.println(customerDivisionCombo.getValue());
    }

    /**
     *
     * @param actionEvent this makes sure customer division combo box is working
     */

    public void onCustomerDivision(ActionEvent actionEvent) {
        System.out.println(customerDivisionCombo.getValue());
    }

    public void onExitButtonPressed(ActionEvent actionEvent) {

    }

    /**
     *
     * @param actionEvent this reacts when user presses save button and sends alert if information is invalid or blank
     *
     * @throws IOException if save is not completed it pops up an alert
     */
    public void onSaveCustomer(ActionEvent actionEvent) throws IOException {
        String name = customerName.getText();
        String address = customerAddress.getText();
        String postalcode = postalCode.getText();
        String phone = customerPhone.getText();
        Address division = customerDivisionCombo.getValue();
        int customerID = Integer.parseInt(customerIDLabel.getText());
        if (name.isEmpty() || address.isEmpty() || postalcode.isEmpty() || phone.isEmpty()) {
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
        else {
            CustomersHelper.updateCustomer(  name, address, postalcode, phone , division.getDivisionID(), customerID
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

    /**
     *
     * @param theCustomer this brings the information from the selection in table to the update window.
     */

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

    /**
     *
     * @param url //this initializes the combo box and also the Lambda expression when exit button is pressed, count clicks on exit button, and print exit program
     * @param resourceBundle resources for override
     */

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

    /**
     *
     * @param actionEvent this reacts when user pushes back button
     */

    public void onBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/CustomerScreen.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Customer Screen");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }
}
