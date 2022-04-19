package Controller;

import DAO.AddressDAOImpl;
import DAO.AppointmentsDAOImpl;
import DAO.CustomersDAOImpl;
import DAO.UserDAOImpl;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddAppointmentController implements Initializable {
    public Button saveAppointment;
    public Button exitButton;
    public DatePicker appointmentStart;
    public TextField appointmentID;
    public TextField appointmentTitle;
    public TextField appointmentDescription;
    public TextField appointmentLocation;
    public ComboBox <Appointments> appointmentContact;
    public ComboBox <Appointments>appointmentType;
    public ComboBox<Appointments> appointmentCustomerID;
    public ComboBox<Appointments> appointmentUserID;
    public Button clearAppointment;
    public Button backButton;
    public DatePicker appointmentDate;
    public ComboBox<Appointments> appointmentStartTime;
    public ComboBox<Appointments> appointmentEndTime;

    private  Integer appointmentid = 0;
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
        appointmentCustomerID.setItems(AppointmentsDAOImpl.getAllAppointmentCustomerIDs());
        appointmentType.setItems(AppointmentsDAOImpl.getAllAppointmentTypes());
        appointmentDate.setItems(AppointmentsDAOImpl.getAllAppointmentDates());


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
        appointmentUserID.getSelectionModel().clearSelection();
    }

    public void onSaveAppointment(ActionEvent actionEvent) {
        String title = appointmentTitle.getText();
        String description = appointmentDescription.getText();
        String location = appointmentLocation.getText();
        Appointments contact = appointmentContact.getValue();
        Appointments type = appointmentType.getValue();
        LocalDate date = appointmentDate.getValue();
        Appointments startTime = appointmentStartTime.getValue();
        Appointments endTime = appointmentEndTime.getValue();
        Appointments customerid = appointmentCustomerID.getValue();
        Appointments user = appointmentUserID.getValue();
        if (user == null  || startTime == null || endTime == null || customerid==null ||contact ==null || type == null || date == null) {
            return;
        }

        if (appointmentid == 0) {
            AppointmentsDAOImpl.createAppointment(title, description, location,type,date, startTime, endTime, customerid.getCustomerID(),user.getUserID(), contact.getContact());
        } else {
            AppointmentsDAOImpl.updateAppointment( appointmentid,title, description, location,type,date, startTime, endTime, customerid.getCustomerID(),user.getUserID(), contact.getContact());
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
}
