package controller;

import DAO.AddressHelper;
import DAO.AppointmentsHelper;
import DAO.CustomersHelper;
import DAO.UserHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.*;
import java.util.ResourceBundle;

public class UpdateAppointmentController implements Initializable {
    public ComboBox <LocalTime>appointmentStart;
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
    public Appointments selectedAppointment = null;
    public DatePicker appointmentDate;
    public ComboBox <LocalTime>appointmentEnd;
    private  Integer appointmentid = 0;

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

        LocalDateTime start = theAppointment.getStartDateTime();
        LocalDate date = start.toLocalDate();
        this.appointmentDate.setValue(date);

        LocalTime startTime  = start.toLocalTime();
        this.appointmentStart.setValue(startTime);

        LocalDateTime end = theAppointment.getEndDateTime();
        LocalTime endTime = end.toLocalTime();
        this.appointmentEnd.setValue(endTime);


        for (Customers customerID : appointmentCustomerID.getItems()) {
            if (customerID.getCustomerID() ==(theAppointment.getCustomerID())) {
                appointmentCustomerID.getSelectionModel().select(customerID);
                break;
            }
        }

        for (User userID : appointmentUserID.getItems()) {
            if (userID.getUserID() ==(theAppointment.getUserID())) {
                appointmentUserID.getSelectionModel().select(userID);
                break;
            }
        }
        for(Contacts contact : appointmentContact.getItems()){
            if(contact.getContact() == (theAppointment.getContact())){
                appointmentContact.getSelectionModel().select(contact);
            }
        }

    }

    public void onExitButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void onSaveAppointment(ActionEvent actionEvent) throws SQLException, IOException {
        String title = appointmentTitle.getText();
        String description = appointmentDescription.getText();
        String location = appointmentLocation.getText();
        Contacts contact = appointmentContact.getValue();
        String type = appointmentType.getValue();
        LocalDate date = appointmentDate.getValue();
        LocalTime startTime = appointmentStart.getValue();
        LocalTime endTime = appointmentEnd.getValue();
        LocalDateTime start = LocalDateTime.of(date, startTime);
        LocalDateTime end   = LocalDateTime.of(date, endTime);

        Customers customerID = appointmentCustomerID.getValue();
        User user = appointmentUserID.getValue();
        if (user == null || date == null || startTime == null || endTime == null || customerID == null || contact == null || type == null) {
            System.out.println("enter proper data");
            return;
        }

        if (!start.isBefore(end)) {
            System.out.println("enter proper times");
            return;
        }

        if (appointmentid == 0) {
            AppointmentsHelper.createAppointment(title, description, location, type, start, end, customerID.getCustomerID(), user.getUserID(), contact.getContactID());
        }

        else {
            AppointmentsHelper.updateAppointment(appointmentid, title, description, location, type, start, end, customerID.getCustomerID(), user.getUserID(), contact.getContactID());
        }
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
        Parent root = (Parent)loader.load();
        Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Appointments Scheduler and Reports");
        stage.setScene(scene);
        stage.show();
    }


    public void onClearAppointment(ActionEvent actionEvent) {
        appointmentTitle.clear();
        appointmentDescription.clear();
        appointmentLocation.clear();
        appointmentContact.getSelectionModel().clearSelection();
        appointmentType.getSelectionModel().clearSelection();
        appointmentDate.getEditor().clear();
        appointmentStart.getSelectionModel().clearSelection();
        appointmentEnd.getSelectionModel().clearSelection();
        appointmentCustomerID.getSelectionModel().clearSelection();
        appointmentUserID.getSelectionModel().clearSelection();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentContact.setItems(AppointmentsHelper.getAllAppointmentContacts());
        appointmentType.setItems(AppointmentsHelper.getAllAppointmentTypes());
        appointmentCustomerID.setItems(CustomersHelper.getAllAppointmentCustomerIDs());
        appointmentUserID.setItems(UserHelper.getAllUsers());
        DatePicker adate = appointmentDate;
        appointmentStart.setItems(AppointmentTimes.getAllAppointmentTimes(true));
    }


    public void onAppointmentStart(ActionEvent actionEvent) {
        LocalTime start = appointmentStart.getValue();

        appointmentEnd.setItems(AppointmentTimes.getAllAppointmentTimes(false));
    }

    public void onBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Appointments Scheduler and Reports");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }
}
