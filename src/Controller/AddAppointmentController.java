package Controller;

import DAO.AppointmentsDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAppointmentController implements Initializable {
    public Button saveAppointment;
    public Button exitButton;
    public ToggleGroup appointmentsToggle;
    public Label resultsLBL;
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
    public Button deleteAppointment;
    public TextField appointmentsTextField;
    public Label resultsLBLAppointments;
    public Button appointmentsSearch;
    public Button editAppointment;
    public Button deleteAppointment1;
    public Button toCustomersScreen;
    public Button addAppointment;
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
    public ComboBox appointmentType1;
    public ComboBox appointmentType11;
    public Button backButton;


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
    }

    public void onSaveAppointment(ActionEvent actionEvent) {
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
