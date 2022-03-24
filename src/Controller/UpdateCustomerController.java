package Controller;

import DAO.AddressDAOImpl;
import DAO.CustomersDAOImpl;
import Model.Address;
import Model.Country;
import Model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
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
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
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
            CustomersDAOImpl.updateCustomer(customerID, name, address, postalcode, phone, division.getDivisionID()
            );
        }

    }
    public void editedCustomer(Customers theCustomer) {

        this.selectedCustomer = theCustomer;
        this.customerName.setText(String.valueOf(this.selectedCustomer.getCustomerName()));
        this.customerAddress.setText(String.valueOf(this.selectedCustomer.getCustomerAddress()));
        this.postalCode.setText(String.valueOf(this.selectedCustomer.getPostalCode()));
        this.customerPhone.setText(String.valueOf(this.selectedCustomer.getPhone()));
        this.customerIDLabel.setText(String.valueOf(this.selectedCustomer.getCustomerID()));
        int countryToChoose = -1;
       /* try{
            countryToChoose = Integer.parseInt(String.valueOf(customerCountryCombo.getValue()));
            if(countryToChoose <=0 ||countryToChoose > customerID)
                return;
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
        int countryID = 0;

        for (Country C : customerCountryCombo.getItems()) {
        if (C.getCountryName().equals(theCustomer.getCountry())){
            customerCountryCombo.getSelectionModel().select(C);
            countryID = C.getCountryID();
            break;
          /* if (Objects.equals(selectedCustomer.getCountry(), C.getCountry())) {
                customerCountryCombo.setValue(C);


            }
            int divisionToChoose = -1;
            try{
                divisionToChoose = Integer.parseInt(String.valueOf(customerDivisionCombo.getValue()));
                if(divisionToChoose <=0 ||divisionToChoose > divisionID )
                    return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            for (Address A : customerDivisionCombo.getItems()) {
                if (Objects.equals(selectedCustomer.getDivision(), A.getDivision())) {
                    customerDivisionCombo.setValue(A);
                    break;
                }**/
                // this.customerCountryCombo.getEditor().setText(selectedCustomer.getCountry());}
                // this.customerDivisionCombo.getEditor().setText(selectedCustomer.getDivision());

            }
            //Country c = customerCountryCombo.getSelectionModel().getSelectedItem();
          //  System.out.println(c.getCountryID()+ "****");



        }
        customerDivisionCombo.setItems(AddressDAOImpl.getAllAddresses(countryID));
        for(Address D:customerDivisionCombo.getItems()){
            if(D.getDivision().equals(theCustomer.getDivision())){
                customerDivisionCombo.getSelectionModel().select(D);
                break;
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerCountryCombo.setItems(CustomersDAOImpl.getAllCountries());
        //customerDivisionCombo.setItems(AddressDAOImpl.getAllAddresses(1));

    }
}
