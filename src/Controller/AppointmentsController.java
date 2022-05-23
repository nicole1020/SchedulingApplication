package Controller;

import DAO.AppointmentsHelperFile;
import Model.Appointments;
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
import java.util.Objects;
import java.util.ResourceBundle;

public class AppointmentsController implements Initializable {
    public Label resultsLBL;
    public ToggleGroup appointmentsToggle;
    public Button exitButton;
    public Button saveAppointment;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Appointments Table Initialized
        appointmentsTable.setItems(AppointmentsHelperFile.getAllAppointments());

        appointmentsIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentsTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentsDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentsLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentsContactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        appointmentsTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentsStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        appointmentsEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        appointmentsCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appointmentsUserIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        System.out.println("Appointment IDs:");
        for (int i = 0; i < AppointmentsHelperFile.getAllAppointments().size(); i++) {
            System.out.println(AppointmentsHelperFile.getAllAppointments()
                    .get(i).getAppointmentID());

        }
        System.out.println("");
        resultsLBLAppointments.setText("Report: " + AppointmentsHelperFile.getAllAppointments().size() + " Appointments on File");


    }

    public void onExitButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void onAddAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/AddNewAppointment.fxml")));
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void appointmentsIsSelected(MouseEvent mouseEvent) {
    }

    public void onDeleteAppointment(ActionEvent actionEvent) {
    }

    public void onAppointmentsSearch(ActionEvent actionEvent) {
    }

    public void onEditAppointment(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/UpdateAppointmentScreen.fxml"));
            Parent UpdateAppointmentScreen = loader.load();
            UpdateAppointmentController controller = loader.getController();
            controller.editedAppointment((Appointments)this.appointmentsTable.getSelectionModel().getSelectedItem());
            System.out.println("Update Appointment Clicked");
            Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(UpdateAppointmentScreen);
            stage.setTitle("Update Appointment Record");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    public void onAppointmentsTextField(ActionEvent actionEvent) {
    }

    public void onAppointmentTextField(KeyEvent keyEvent) {
    }

    public void onToCustomersScreen(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/CustomerScreen.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Customer Screen");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }
}
