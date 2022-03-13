package Controller;

import DAO.AddressDAOImpl;
import DAO.AppointmentsDAOImpl;
import DAO.CustomersDAOImpl;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    public TableView customersTable;
    public TableColumn customersTableCustomerNameCol;
    public TableColumn customersTableAddressCol;
    public TableColumn customersTablePostalCodeCol;
    public TableColumn customersTablePhoneCol;
    public TableColumn customersTableCustomerID;
    public TableColumn customersTableCountry;
    public TableColumn customersTableDivision;
    public Button deleteCustomer;
    public TextField customerTextField;
    public TableView appointmentsTable;
    public TableColumn appointmentsIDCol;
    public TableColumn appointmentsTitleCol;
    public TableColumn appointmentsDescriptionCol;
    public TableColumn appointmentsLocationCol;
    public TableColumn appointmentsContactCol;
    public TableColumn appointmentsTypeCol;
    public TableColumn appointmentsStartDateTimeCol;
    public TableColumn appointmentsEndDateTimeCol;
    public TableColumn appointmentsCustomerIDCol;
    public TableColumn appointmentsUserIDCol;
    public Button deleteAppointment;
    public Label resultsLBL;
    public TextField appointmentsTextField;
    public Label resultsLBLAppointments;
    public Button exitButton;
    public TextField customerName;
    public TextField customerAddress;

    public ComboBox<Country> customerCountryCombo;
    public ComboBox<Address> customerDivisionCombo;
    public TextField postalCode;
    public ToggleGroup appointmentsToggle;
    public DatePicker appointmentStart;
    public TextField appointmentID;
    public TextField appointmentTitle;
    public TextField appointmentDescription;
    public TextField appointmentLocation;
    public ComboBox<String> appointmentContact;
    public ComboBox<String> appointmentType;
    public DatePicker appointmentEnd;
    public ComboBox<Integer> appointmentCustomerID;
    public ComboBox<Integer> appointmentUserID;
    public Button saveCustomer;
    public Button saveAppointment;
    public Button customerSearch;
    public Button appointmentsSearch;
    public TextField customerPhone;
    public Label customerIDLabel;
    public Button clearCustomer;
    public Button clearAppointment;
    private  Integer customerID = 0;
    public Customers selectedCustomer = null;
    private Customers uc = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Customers Table Initialized
        customersTable.setItems(CustomersDAOImpl.getAllCustomers());

        customersTableCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customersTableAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customersTablePostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        customersTablePhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        customersTableCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        customersTableCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        customersTableDivision.setCellValueFactory(new PropertyValueFactory<>("Division"));

        //Appointments Table Initialized
        appointmentsTable.setItems(AppointmentsDAOImpl.getAllAppointments());

        appointmentsIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentsTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentsDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentsLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentsContactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        appointmentsTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentsStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        appointmentsEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        appointmentsCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appointmentsUserIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        System.out.println("Customer IDs:");
        for (int i = 0; i < CustomersDAOImpl.getAllCustomers().size(); i++) {
            System.out.println(CustomersDAOImpl.getAllCustomers()
                    .get(i).getCustomerID());

        }
        System.out.println("");
        resultsLBL.setText("Report: " + CustomersDAOImpl.getAllCustomers().size() + " Customers on File");


        System.out.println("Appointment IDs:");
        for (int i = 0; i < AppointmentsDAOImpl.getAllAppointments().size(); i++) {
            System.out.println(AppointmentsDAOImpl.getAllAppointments()
                    .get(i).getAppointmentID());

        }
        System.out.println("");
        resultsLBLAppointments.setText("Report: " + AppointmentsDAOImpl.getAllAppointments().size() + " Appointments on File");
//combobox customerCountry
        customerCountryCombo.setItems(CustomersDAOImpl.getAllCountries());

    }

    public void lookupCustomer(KeyEvent keyEvent) {
    }


    public void onDeleteCustomer(ActionEvent actionEvent) {
       // CustomersDAOImpl.deleteCustomer();
    }

    public void customerIsSelected(MouseEvent mouseEvent) {
    }

    public void appointmentsIsSelected(MouseEvent mouseEvent) {
    }


    public void onUpdateAppointment(ActionEvent actionEvent) {
    }

    public void onDeleteAppointment(ActionEvent actionEvent) {
    }

    public void onAppointmentTextField(KeyEvent keyEvent) {
    }

    public void onExitButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void onCustomerTextField(ActionEvent actionEvent) {
    }

    public void onAppointmentsTextField(ActionEvent actionEvent) {
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
        customersTable.setItems(CustomersDAOImpl.getAllCustomers());
    }


    public void onSaveAppointment(ActionEvent actionEvent) {
    }

    public void onCustomerSearch(ActionEvent actionEvent) {
    }

    public void onAppointmentsSearch(ActionEvent actionEvent) {
    }

    //Selection block for customerDivision ComboBox
    public void onCustomerDivision(ActionEvent actionEvent) {
        System.out.println(customerDivisionCombo.getValue());
    }

    //Selection block for customerCountry ComboBox which on selection triggers customerDivisionCombo
    public void onCustomerCountry(ActionEvent actionEvent) {

        Country c = customerCountryCombo.getValue();
        customerDivisionCombo.setItems(AddressDAOImpl.getAllAddresses(c.getCountryID()));

    System.out.println(customerCountryCombo.getValue());
        System.out.println(customerDivisionCombo.getValue());
    }

    public void onClearCustomer(ActionEvent actionEvent) {
    }

    public void onClearAppointment(ActionEvent actionEvent) {
    }


    

    public void onEditAppointment(ActionEvent actionEvent) {
    }
    public void onEditCustomer(ActionEvent actionEvent) {
        //editedCustomer(  this.selectedCustomer = ((Customers)this.customersTable.getSelectionModel().getSelectedItem()));

   }
    public void editedCustomer(Customers theCustomer) {
     /*  this.selectedCustomer = theCustomer;
        this.customerName.setText(String.valueOf(this.selectedCustomer.getCustomerName()));
        this.customerAddress.setText(String.valueOf(this.selectedCustomer.getCustomerAddress()));
        this.postalCode.setText(String.valueOf(this.selectedCustomer.getPostalCode()));
        this.customerPhone.setText(String.valueOf(this.selectedCustomer.getPhone()));
        this.customerIDLabel.setText(String.valueOf(this.selectedCustomer.getCustomerID()));
        this.customerCountryCombo.getEditor().setText(selectedCustomer.getCountry());
        this.customerDivisionCombo.getEditor().setText(selectedCustomer.getDivision());**/
    }


}
