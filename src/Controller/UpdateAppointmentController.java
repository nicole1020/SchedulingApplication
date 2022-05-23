package Controller;

import DAO.AddressHelperFile;
import Model.Address;
import Model.Appointments;
import Model.Country;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateAppointmentController {
    public ComboBox appointmentStart;
    public TextField appointmentID;
    public TextField appointmentTitle;
    public TextField appointmentDescription;
    public TextField appointmentLocation;
    public ComboBox appointmentContact;
    public ComboBox appointmentType;
    public ComboBox appointmentCustomerID;
    public ComboBox appointmentUserID;
    public Button exitButton;
    public Button saveAppointment;
    public Button clearAppointment;
    public ComboBox appointmentType1;
    public ComboBox appointmentType11;
    public Appointments selectedAppointment = null;
    public DatePicker appointmentDate;
    public ComboBox appointmentEnd;


    public void editedAppointment(Appointments theAppointment) {

        this.selectedAppointment = theAppointment;
        this.appointmentTitle.setText(String.valueOf(this.selectedAppointment.getTitle()));
        this.appointmentDescription.setText(String.valueOf(this.selectedAppointment.getDescription()));
        this.appointmentLocation.setText(String.valueOf(this.selectedAppointment.getLocation()));
        this.appointmentContact.setText(String.valueOf(this.selectedAppointment.getContact()));
        this.appointmentType.setText(String.valueOf(this.selectedAppointment.getType()));
        this.appointmentDate.setText(String.valueOf(this.selectedAppointment.getDate()));
        this.appointmentStart.setText(String.valueOf(this.selectedAppointment.getStartTime()));
        this.appointmentEnd.setText(String.valueOf(this.selectedAppointment.getEndTime()));

        int countryID = 0;

        for (Country C : customerCountryCombo.getItems()) {
            if (C.getCountryName().equals(theCustomer.getCountry())) {
                customerCountryCombo.getSelectionModel().select(C);
                countryID = C.getCountryID();
                break;
            }
        }
        customerDivisionCombo.setItems(AddressHelperFile.getAllAddresses(countryID));
        for (Address D : customerDivisionCombo.getItems()) {
            if (D.getDivision().equals(theCustomer.getDivision())) {
                customerDivisionCombo.getSelectionModel().select(D);
                break;
            }
        }
    }

    public void onExitButtonPressed(ActionEvent actionEvent) {
    }

    public void onSaveAppointment(ActionEvent actionEvent) {
    }

    public void onClearAppointment(ActionEvent actionEvent) {
        appointmentTitle.clear();
        appointmentDescription.clear();
        appointmentLocation.clear();
        appointmentContact.getSelectionModel().clearSelection();
        appointmentType.getSelectionModel().clearSelection();
        appointmentCustomerID.getSelectionModel().clearSelection();
        appointmentUserID.getSelectionModel().clearSelection();

    }
}
