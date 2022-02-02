package Controller;

import DAO.CustomersDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    public TextField AppointmentsTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customersTable.setItems(CustomersDAOImpl.getAllCustomers());

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
}
