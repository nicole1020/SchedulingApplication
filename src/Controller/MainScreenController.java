package Controller;

import DAO.AppointmentsDAOImpl;
import DAO.CustomersDAOImpl;
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
    public Button addCustomer;
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
    public Button addAppointment;
    public Button updateAppointment;
    public Button deleteAppointment;
    public Label resultsLBL;
    public TextField appointmentsTextField;
    public Label resultsLBLAppointments;
    public Button exitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Customers Table Initialized
        customersTable.setItems(CustomersDAOImpl.getAllCustomers());
        customersTableCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Customer Name"));
        customersTableAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        customersTablePostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("Postal Code"));
        customersTablePhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        appointmentsCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        customersTableCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        customersTableDivision.setCellValueFactory(new PropertyValueFactory<>("Division"));

        //Appointments Table Initialized
        appointmentsTable.setItems(AppointmentsDAOImpl.getAllAppointments());

        appointmentsIDCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        appointmentsTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        appointmentsDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        appointmentsLocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
        appointmentsContactCol.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        appointmentsTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        appointmentsStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
        appointmentsEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("End"));
        appointmentsCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        appointmentsUserIDCol.setCellValueFactory(new PropertyValueFactory<>("UserID"));


    }

    public void lookupCustomer(KeyEvent keyEvent) {
    }

    public void onAddCustomer(ActionEvent actionEvent) {
    }

    public void onUpdateCustomer(ActionEvent actionEvent) {
    }

    public void onDeleteCustomer(ActionEvent actionEvent) {
    }

    public void customerIsSelected(MouseEvent mouseEvent) {
    }

    public void appointmentsIsSelected(MouseEvent mouseEvent) {
    }

    public void onAddAppointment(ActionEvent actionEvent) {
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
}
