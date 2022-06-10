package controller;

import DAO.AppointmentsHelper;
import DAO.CustomersHelper;
import DAO.UserHelper;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.Appointments;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Contacts;
import model.Customers;
import model.User;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class UpdateAppointmentController implements Initializable {
    public ComboBox <LocalDateTime>appointmentStart;
    public TextField appointmentID;
    public TextField appointmentTitle;
    public TextField appointmentDescription;
    public TextField appointmentLocation;
    public ComboBox <Contacts>appointmentContact;
    public ComboBox <String>appointmentType;
    public ComboBox<Customers> appointmentCustomerID;
    public ComboBox <User>appointmentUserID;
    public Button exitButton;
    public Button saveAppointment;
    public Button clearAppointment;
    public ComboBox appointmentType1;
    public ComboBox appointmentType11;
    public Appointments selectedAppointment = null;
    public DatePicker appointmentDate;
    public ComboBox <LocalDateTime>appointmentEnd;


    public void editedAppointment(Appointments theAppointment) {

        this.selectedAppointment = theAppointment;
        this.appointmentTitle.setText(String.valueOf(this.selectedAppointment.getTitle()));
        this.appointmentDescription.setText(String.valueOf(this.selectedAppointment.getDescription()));
        this.appointmentLocation.setText(String.valueOf(this.selectedAppointment.getLocation()));
        for (Contacts con : appointmentContact.getItems()) {
            if (con.getContactID() == (theAppointment.getContact())) {
                appointmentContact.getSelectionModel().select(con);
                break;
            }
        }
        for(String type : appointmentType.getItems()){
            if(type.equals(theAppointment.getType())){
                appointmentType.getSelectionModel().select(type);
                break;
            }
        }
       this.appointmentDate.getValue();

        for (LocalDateTime start : appointmentStart.getItems()) {
            if (start == (theAppointment.getStartTime())) {
                appointmentStart.getEditor().setText(String.valueOf(start));
                break;
            }
        }
       // this.appointmentDate.getDayCellFactory();
      this.appointmentStart.equals(theAppointment.getStartTime());

        this.appointmentEnd.equals(theAppointment.getEndTime());


        }




    public void onExitButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentContact.setItems(AppointmentsHelper.getAllAppointmentContacts());
        appointmentType.setItems(AppointmentsHelper.getAllAppointmentTypes());
        appointmentCustomerID.setItems(CustomersHelper.getAllAppointmentCustomerIDs());
        appointmentUserID.setItems(UserHelper.getAllUsers());
    }
}
