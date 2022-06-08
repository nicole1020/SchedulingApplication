package Controller;

import DAO.AppointmentsHelper;
import DAO.CustomersHelper;
import Model.*;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.TimeZone;

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
    //set to business hours 8 AM to 10 PM EST
    public ComboBox<LocalTime> appointmentStartTime;
    public ComboBox<LocalTime> appointmentEndTime;

    private  Integer appointmentid = 0;
    private CharSequence date = null;



    public void onExitButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void appointmentsIsSelected(MouseEvent mouseEvent) {
    }

    public void onDeleteAppointment(ActionEvent actionEvent) {
    }

    public void onAppointmentsSearch(ActionEvent actionEvent) {
    }

    public void onEditAppointment(ActionEvent actionEvent) {

    }

    public void onAppointmentsTextField(ActionEvent actionEvent) {
    }

    public void onAppointmentTextField(KeyEvent keyEvent) {
    }

    public void onToCustomersScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CustomerScreen.fxml"));
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Appointments
        String cid = appointmentID.getText();
        DatePicker aDate = appointmentDate;
        appointmentCustomerID.setItems(CustomersHelper.getAllAppointmentCustomerIDs());
        appointmentType.setItems(AppointmentsHelper.getAllAppointmentTypes());
        appointmentDate.getEditor();
        appointmentUserName.setItems(AppointmentsHelper.getAllAppointmentUserNames());
        appointmentContact.setItems(AppointmentsHelper.getAllAppointmentContacts());
        ObservableList<LocalTime> startTime = FXCollections.observableArrayList();
           TimeZone timezone = TimeZone.getDefault();
          String offsetId = timezone.toZoneId().getRules().getStandardOffset(Instant.now()).getId();
        //     hoursDifference = UTC to EST - 8 AM EST is 12:00 noon UTC, 10PM EST is 2 AM UST

        LocalTime start = LocalTime.of(0,0);
        for(int i = 0; i<24 ; i++){

            startTime.add(LocalTime.of(i, 0 ));
            startTime.add(LocalTime.of(i, 15));
            startTime.add(LocalTime.of(i, 30));
            startTime.add(LocalTime.of(i, 45));
            if(i == 23) startTime.add(LocalTime.of(0,0));
            startTime.add(LocalTime.of(i, 0 ));
            startTime.add(LocalTime.of(i, 15));
            startTime.add(LocalTime.of(i, 30));
            startTime.add(LocalTime.of(i, 45));
            // System.out.println(LocalTime.of(i,0));

        }
        for(LocalTime st: startTime)
            System.out.println(st);
        appointmentStartTime.setItems( startTime);
        ObservableList<LocalTime> endTime = FXCollections.observableArrayList();
        LocalTime end = LocalTime.of(0,0);
        for(int i = 0; i<24 ; i++){

            endTime.add(LocalTime.of(i, 0));
            endTime.add(LocalTime.of(i, 15));
            endTime.add(LocalTime.of(i, 30));
            endTime.add(LocalTime.of(i, 45));
            if(i == 23) endTime.add(LocalTime.of(0,0));
            endTime.add(LocalTime.of(i, 0 ));
            endTime.add(LocalTime.of(i, 15));
            endTime.add(LocalTime.of(i, 30));
            endTime.add(LocalTime.of(i, 45));
            // System.out.println(LocalTime.of(i,0));

        }
        for(LocalTime et: endTime)
            System.out.println(et);

        appointmentEndTime.setItems(endTime);

    }

    public void onAddAppointment(ActionEvent actionEvent) {
    }

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

    public void onSaveAppointment(ActionEvent actionEvent) throws SQLException {
        String title = appointmentTitle.getText();
        String description = appointmentDescription.getText();
        String location = appointmentLocation.getText();
        Contacts contact = appointmentContact.getValue();
        String type = appointmentType.getValue();
       // LocalDateTime Start = LocalDateTime.from(appointmentDate.getValue());

        LocalDateTime Start =  LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss"));

        LocalTime startTime = appointmentStartTime.getValue();
        LocalTime endTime = appointmentEndTime.getValue();
        Customers customerID = appointmentCustomerID.getValue();
        User user = appointmentUserName.getValue();
        if (user == null || startTime == null || endTime == null || customerID == null || contact == null || type == null) {
            return;
        }

        if (appointmentid == 0) {
            AppointmentsHelper.createAppointment(title, description, location, type, Start, endTime, customerID.getCustomerID(),user.getUserID(), contact.getContact());
        } else {
            AppointmentsHelper.updateAppointment( appointmentid,title, description, location , type , Start.toString() , startTime.toString(), endTime.toString(), customerID.getCustomerID(),user.getUserID(), contact.getContact());
        }


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

    public void onAppointmentDate(ActionEvent actionEvent) {
    }
}
