package Controller;

import DAO.AppointmentsDAOImpl;
import DAO.CustomersDAOImpl;
import Model.Address;
import Model.Appointments;
import Model.Customers;
import Model.User;
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
    public ComboBox appointmentContact;
    public ComboBox appointmentType;
    public ComboBox appointmentCustomerID;
    public ComboBox appointmentUserID;
    public Button clearAppointment;
    public Button backButton;
    public DatePicker appointmentDate;
    public ComboBox appointmentStartTime;
    public ComboBox appointmentEndTime;

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
        //Appointments Table Initialized
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
        Appointments contact = (Appointments) appointmentContact.getValue();
        Appointments type = (Appointments) appointmentType.getValue();
        LocalDate date = appointmentDate.getValue();
        Appointments startTime = (Appointments) appointmentStartTime.getValue();
        Appointments endTime = (Appointments) appointmentEndTime.getValue();
        Customers customerid = (Customers) appointmentCustomerID.getValue();
        User user = (User) appointmentUserID.getValue();
        if (user == null || contact == null || startTime == null || endTime == null || customerid==null ||contact ==null || type == null || date == null) {
            return;
        }

        if (appointmentid == 0) {
            AppointmentsDAOImpl.createAppointment(name, address, postalcode, phone, division.getDivisionID());
        } else {
            CustomersDAOImpl.updateAppointment( customerID, name, address, postalcode,phone , division.getDivisionID()
            );
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
