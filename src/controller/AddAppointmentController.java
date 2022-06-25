package controller;

import DAO.AppointmentsHelper;
import DAO.CustomersHelper;
import DAO.UserHelper;
import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
// Initializes AddAppointmentsController
public class AddAppointmentController implements Initializable {

    public Button saveAppointment;
    public Button exitButton;
    public DatePicker appointmentStart;
    public TextField appointmentID;
    public TextField appointmentTitle;
    public TextField appointmentDescription;
    public TextField appointmentLocation;
    public ComboBox <Contacts> appointmentContact;
    public ComboBox <String>appointmentType;
    public ComboBox<Customers> appointmentCustomerID;
    public ComboBox<User> appointmentUserName;
    public Button clearAppointment;
    public Button backButton;
    public DatePicker appointmentDate;

    public ComboBox<LocalTime> appointmentStartTime;
    public ComboBox<LocalTime> appointmentEndTime;

    private  Integer appointmentid = 0;
    private CharSequence date = null;
    int countingClicks = 0;


    public void onExitButtonPressed(ActionEvent actionEvent) {

    }
    // this initializes  text/combo boxes for add appointment screen also the Lambda expression when exit button is pressed, count clicks on exit button, and print exit program
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Appointments
        String cid = appointmentID.getText();
        DatePicker aDate = appointmentDate;
        appointmentCustomerID.setItems(CustomersHelper.getAllAppointmentCustomerIDs());
        appointmentType.setItems(AppointmentsHelper.getAllAppointmentTypes());
        appointmentDate.getEditor();
        appointmentUserName.setItems(UserHelper.getAllUsers());
        appointmentContact.setItems(AppointmentsHelper.getAllAppointmentContacts());
        exitButton.setOnAction(e ->{
            countingClicks++;
            System.out.println(countingClicks);
            System.out.println("Exit Button Pressed");
            System.exit(0);
        });

        appointmentStartTime.setItems(AppointmentTimes.getAllAppointmentTimes(true));

    }

    // this reacts when user presses clear button
    public void onClearAppointment(ActionEvent actionEvent) {
        appointmentTitle.clear();
        appointmentDescription.clear();
        appointmentLocation.clear();
        appointmentContact.getSelectionModel().clearSelection();
        appointmentType.getSelectionModel().clearSelection();
        appointmentDate.getEditor().clear();
        appointmentStartTime.getSelectionModel().clearSelection();
        appointmentEndTime.getSelectionModel().clearSelection();
        appointmentCustomerID.getSelectionModel().clearSelection();
        appointmentUserName.getSelectionModel().clearSelection();
    }
    // this reacts when user presses save button and sends alert if information is invalid or blank
    public void onSaveAppointment(ActionEvent actionEvent) throws SQLException, IOException {
        String title = appointmentTitle.getText();
        String description = appointmentDescription.getText();
        String location = appointmentLocation.getText();
        Contacts contact = appointmentContact.getValue();
        String type = appointmentType.getValue();
        LocalDate date = appointmentDate.getValue();
        LocalTime startTime = appointmentStartTime.getValue();
        LocalTime endTime = appointmentEndTime.getValue();
        LocalDateTime start = LocalDateTime.of(date, startTime);
        LocalDateTime end   = LocalDateTime.of(date, endTime);
        Customers customerID = appointmentCustomerID.getValue();
        User user = appointmentUserName.getValue();

        if (user == null || customerID == null || contact == null || type == null) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Enter Valid Inputs");
            alert2.setContentText("Enter Valid Inputs ");
            alert2.showAndWait();
            System.out.println("Enter Valid Inputs");
            return;
        }
        if(!startTime.isBefore(endTime)){
            System.out.println("enter proper times");
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Start time must be before end time");
            alert1.setContentText("Start time must be before end time");
            alert1.showAndWait();
            System.out.println("Start time must be before end time");
            return;
        }

        if (appointmentid == 0) {

            AppointmentsHelper.createAppointment(title, description, location, type, start, end, customerID.getCustomerID(),user.getUserID(), contact.getContactID());

        } else {
            AppointmentsHelper.updateAppointment( title, description, location , type , start, end, customerID.getCustomerID(),user.getUserID(), contact.getContactID(), appointmentid);
        }

         FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
        Parent root = (Parent)loader.load();
        Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Appointments Scheduler and Reports");
        stage.setScene(scene);
        stage.show();

    }

    // this reacts when user presses back button
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

// this initializes start times to make sure end times are 15 minutes after start.
    public void onAppointmentStartTime(ActionEvent actionEvent) {
        LocalTime start = appointmentStartTime.getValue();

        appointmentEndTime.setItems(AppointmentTimes.getAllAppointmentTimes(false));
    }
//this sets appointments dates for today or later
    public void onAppointmentDate(ActionEvent actionEvent) {
        appointmentDate.setPromptText(String.valueOf(LocalDate.now()));
    }
}
