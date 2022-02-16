package Controller;

import DAO.AddressDAOImpl;
import DAO.AppointmentsDAOImpl;
import DAO.CustomersDAOImpl;
import Model.Address;
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

    public Button updateCustomer;
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

    public Button updateAppointment;
    public Button deleteAppointment;
    public Label resultsLBL;
    public TextField appointmentsTextField;
    public Label resultsLBLAppointments;
    public Button exitButton;
    public TextField customerName;
    public TextField customerAddress;

    public ComboBox<String> customerCountry;
    public ComboBox<String> customerDivision;
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
        for(int i = 0; i < CustomersDAOImpl.getAllCustomers().size(); i++) {
            System.out.println(CustomersDAOImpl.getAllCustomers()
                    .get(i).getCustomerID());

        }
        System.out.println("");
        resultsLBL.setText(CustomersDAOImpl.getAllCustomers().size() + " Customers on File");


        System.out.println("Appointment IDs:");
        for(int i = 0; i < AppointmentsDAOImpl.getAllAppointments().size(); i++) {
            System.out.println(AppointmentsDAOImpl.getAllAppointments()
                    .get(i).getAppointmentID());

        }
        System.out.println("");
        resultsLBLAppointments.setText(AppointmentsDAOImpl.getAllAppointments().size() + " Appointments on File");
//combobox customerCountry
       // customerCountry.getItems().addAll(String.valueOf(AddressDAOImpl.getAllAddresses()));

//combobox customerDivision
//customerDivision.getItems().addAll(String.valueOf(AddressDAOImpl.getAllAddresses()));
    }

    public void lookupCustomer(KeyEvent keyEvent) {
    }



    public void onUpdateCustomer(ActionEvent actionEvent) {
    }

    public void onDeleteCustomer(ActionEvent actionEvent) {
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
        CustomersDAOImpl.createCustomer( customerName, customerAddress,postalCode, customerPhone, customerCountry, customerDivision);
    }



    public void onSaveAppointment(ActionEvent actionEvent) {
    }

    public void onCustomerSearch(ActionEvent actionEvent) {
    }

    public void onAppointmentsSearch(ActionEvent actionEvent) {
    }

    public void onCustomerCountry(ActionEvent actionEvent) {
        System.out.println(customerCountry.getValue());
    }

    public void onCustomerDivision(ActionEvent actionEvent) {
        System.out.println(customerDivision.getValue());
    }
}
