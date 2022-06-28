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
import java.time.chrono.ChronoLocalDate;
import java.util.ResourceBundle;


/**
 * @author Nicole Mau
 * Initializing UpdateAppointmentController class
 */

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
    public Label appointmentIDLabel;
    public Button back;
    private Appointments loggedAppointment;
    int countingClicks = 0;

    /**
     *
     * @param theAppointment this brings the information from the selection in the appointment screen to the update screen.
     */

    public void editedAppointment(Appointments theAppointment) {

        this.selectedAppointment = theAppointment;
        this.appointmentTitle.setText(String.valueOf(this.selectedAppointment.getTitle()));
        this.appointmentDescription.setText(String.valueOf(this.selectedAppointment.getDescription()));
        this.appointmentLocation.setText(String.valueOf(this.selectedAppointment.getLocation()));
        this.appointmentIDLabel.setText(String.valueOf(this.selectedAppointment.getAppointmentID()));
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

    }

    /**
     *
     * @param actionEvent     this reacts when user presses save button and sends alert if information is invalid or blank
     * @throws SQLException alerts if invalid entries are entered/selected
     * @throws IOException if unable to save it pops up a window
     */

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
        LocalDateTime end = LocalDateTime.of(date, endTime);
        int appointmentid = Integer.parseInt(appointmentIDLabel.getText());
        Customers customerID = appointmentCustomerID.getValue();
        User user = appointmentUserID.getValue();

        loggedAppointment = AppointmentsHelper.validateAppointmentTimes(start, end, appointmentid);

        if (date.isBefore(LocalDate.now()) || title.isEmpty() || contact.toString().isEmpty() || description.isEmpty() || location.isEmpty() || user.toString().isEmpty() || customerID.toString().isEmpty() || type == null) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Enter Valid Inputs");
            alert2.setContentText("Enter Valid Inputs ");
            alert2.showAndWait();
            System.out.println("Enter Valid Inputs");
            return;
        }
        if (loggedAppointment != null) {
            System.out.println("Appointment time not available");
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Appointment time not available");
            alert1.setContentText("Please select a different time-Appointment time not available");
            alert1.showAndWait();

            return;
        }
        if (!startTime.isBefore(endTime)) {
            System.out.println("enter proper times");
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Start time must be before end time");
            alert1.setContentText("Start time must be before end time");
            alert1.showAndWait();
            System.out.println("Start time must be before end time");
            return;
        }

        if (appointmentid != 0) {

            try {
                AppointmentsHelper.updateAppointment(title, description, location, type, start,
                        end, customerID.getCustomerID(), user.getUserID(), contact.getContactID(),
                        appointmentid);

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Enter Valid Inputs");
                alert2.setContentText("Enter Valid Inputs ");
                alert2.showAndWait();
                System.out.println("Enter Valid Inputs");
            }
        }

        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Appointments Scheduler and Reports");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Enter Valid Inputs");
            alert2.setContentText("Enter Valid Inputs ");
            alert2.showAndWait();
            System.out.println("Enter Valid Inputs");


        }
    }
    /*    loggedAppointment = AppointmentsHelper.validateAppointmentTimes(start, end);
        if (title.isEmpty() || description.isEmpty() || location.isEmpty() || user.toString().isEmpty() || customerID.toString().isEmpty()|| contact.toString().isEmpty() || type == null) {
            System.out.println("enter proper data");
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Enter Valid Inputs");
            alert2.setContentText("Enter Valid Inputs ");
            alert2.showAndWait();
            System.out.println("Enter Valid Inputs");
            return;
        }

        if (!start.isBefore(end)) {
            System.out.println("enter proper times");
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Start time must be before end time");
            alert1.setContentText("Start time must be before end time");
            alert1.showAndWait();
            System.out.println("Start time must be before end time");
            return;
        } else {

            AppointmentsHelper.updateAppointment( title, description, location, type, start, end, customerID.getCustomerID(), user.getUserID(), contact.getContactID(), appointmentid);
        }
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Appointments Scheduler and Reports");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }*/


    /**
     *
     * @param actionEvent this reacts when user presses clear button
     */
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

    /**
     *
     * @param url this initializes the text/combo boxes and date picker  also the Lambda expression when exit button is pressed, count clicks on exit button, and print exit program
     * @param resourceBundle  resources for override
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exitButton.setOnAction(e ->{
            countingClicks++;
            System.out.println(countingClicks);
            System.out.println("Exit Button Pressed");
            System.exit(0);
        });
        appointmentContact.setItems(AppointmentsHelper.getAllAppointmentContacts());
        appointmentType.setItems(AppointmentsHelper.getAllAppointmentTypes());
        appointmentCustomerID.setItems(CustomersHelper.getAllAppointmentCustomerIDs());
        appointmentUserID.setItems(UserHelper.getAllUsers());
        DatePicker adate = appointmentDate;
        appointmentStart.setItems(AppointmentTimes.getAllAppointmentTimes(true));
    }

    /**
     *
     * @param actionEvent this reacts when user selects start time to show end times that begin 15 minutes after start time
     */

    public void onAppointmentStart(ActionEvent actionEvent) {
        LocalTime start = appointmentStart.getValue();

        appointmentEnd.setItems(AppointmentTimes.getAllAppointmentTimes(false));
    }

    /**
     *
     * @param actionEvent this reacts when user pushes back button
     */

    public void onBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Appointments Scheduler and Reports");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }
}
