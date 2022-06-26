package controller;

import DAO.AppointmentsHelper;
import DAO.CustomersHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import model.Appointments;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;
import java.util.ResourceBundle;
/**
 * @author Nicole Mau
 * Initializes AppointmentsController class
  */

public class AppointmentsController implements Initializable {
    public Label resultsLBL;
    public ToggleGroup appointmentsToggle;
    public Button exitButton;
    public TableView <Appointments> appointmentsTable;
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
    public Label resultsLBLAppointments;
    public Button editAppointment;
    public Button toCustomersScreen;
    public Button addAppointment;
    public RadioButton currentWeekRadioButton;
    public RadioButton currentMonthRadioButton;
    public RadioButton allSortRadioButton;
    public Button generateReportsButton;
    int countingClicks = 0;

    /**
     *
     * @param url Appointments Table Initialized with additional Report: counting all appointments in database also Lambda expression to exit, count clicks on exit button, and print exit program
     * @param resourceBundle resources for override
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exitButton.setOnAction(e ->{
            countingClicks++;
            System.out.println(countingClicks);
            System.out.println("Exit Button Pressed");
            System.exit(0);
        });


        System.out.println("All Appointments Displaying");
        appointmentsTable.setItems(AppointmentsHelper.getAllAppointments());

        appointmentsIDCol.setCellValueFactory( new PropertyValueFactory<>("appointmentID"));
        appointmentsTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentsDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentsLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentsContactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        appointmentsTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentsStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        appointmentsEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        appointmentsCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appointmentsUserIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        System.out.println("Appointment IDs:");
        for (int i = 0; i < AppointmentsHelper.getAllAppointments().size(); i++) {
            System.out.println(AppointmentsHelper.getAllAppointments()
                    .get(i).getAppointmentID());

        }
        System.out.println("");
        resultsLBLAppointments.setText("Report: " + AppointmentsHelper.getAllAppointments().size() + " Appointments in database");


    }


    public void onExitButtonPressed(ActionEvent actionEvent) {

    }

    /**
     *
     * @param actionEvent this reacts when user presses add appointment button
     * @throws IOException if unable to load prints stack trace
     */

    public void onAddAppointment(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/AddNewAppointment.fxml")));
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Home Page");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void appointmentsIsSelected(MouseEvent mouseEvent) {
    }

    /**
     *
     * @param actionEvent this reacts when user presses delete appointment button if user hasnt selected an appointment to delete it pops up a alert box
     */
    public void onDeleteAppointment(ActionEvent actionEvent) {
        try{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Delete Appointment Warning");
        alert.setContentText( "Appointment is being deleted from database.");
        alert.showAndWait();
        Appointments ap = (Appointments) this.appointmentsTable.getSelectionModel().getSelectedItem();
        AppointmentsHelper.deleteAppointment(ap.getAppointmentID());
    } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please select an appointment to delete");
            alert.setContentText( "Please select an appointment to delete");
            alert.showAndWait();

        }
    }

    /**
     *
     * @param actionEvent     this reacts when user presses edit appointment button and pops up an alert box if nothing is selected
     */


    public void onEditAppointment(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/UpdateAppointmentScreen.fxml"));
            Parent UpdateAppointmentScreen = loader.load();
            UpdateAppointmentController controller = loader.getController();
            controller.editedAppointment((Appointments) this.appointmentsTable.getSelectionModel().getSelectedItem());
            System.out.println("Update Appointment Clicked");
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(UpdateAppointmentScreen);
            stage.setTitle("Update Appointment Record");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var7) {
            var7.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please select an appointment to update");
            alert.setContentText( "Please select an appointment to update");
            alert.showAndWait();
        }
    }

    /**
     *
     * @param actionEvent this reacts when user presses back to customers screen button
     * @throws IOException prints stack trace if unable to load character screen
     */
    public void onToCustomersScreen(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/CustomerScreen.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Customer Screen");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    /**
     *
     * @param actionEvent this reacts when user presses current week radio button
     */


    public void onCurrentWeekRadioButton(ActionEvent actionEvent) {
        if (currentWeekRadioButton.isSelected()) {
            System.out.println("Current Week's Appointments Displayed");
            appointmentsTable.setItems(AppointmentsHelper.getCurrentWeekAppointments());
            for (int i = 0; i < AppointmentsHelper.getCurrentWeekAppointments().size(); i++) {
                System.out.println(AppointmentsHelper.getCurrentWeekAppointments()
                        .get(i).getAppointmentID());
            }
            System.out.println("");
            resultsLBLAppointments.setText("Report: " + AppointmentsHelper.getCurrentWeekAppointments().size() + " Appointments in database");
        }
    }
    /**
     *
     * @param actionEvent this reacts when user presses current month radio button
     */

    public void onCurrentMonthRadioButton(ActionEvent actionEvent) {
        if (currentMonthRadioButton.isSelected()) {
            appointmentsTable.setItems(AppointmentsHelper.getCurrentMonthAppointmentsRadio());
            System.out.println("Current Month's Appointments Displayed");
            for (int i = 0; i < AppointmentsHelper.getCurrentMonthAppointmentsRadio().size(); i++) {
                System.out.println(AppointmentsHelper.getCurrentMonthAppointmentsRadio()
                        .get(i).getAppointmentID());
            }
            System.out.println("");
            resultsLBLAppointments.setText("Report: " + AppointmentsHelper.getCurrentMonthAppointmentsRadio().size() + " Appointments in database");

        }
    }

    /**
     *
     * @param actionEvent this reacts when user presses all appointments radio button
     */

    public void onAllSortRadioButton(ActionEvent actionEvent) {
        if (allSortRadioButton.isSelected()) {
            System.out.println("All Appointments Displayed");
            appointmentsTable.setItems(AppointmentsHelper.getAllAppointments());
            for (int i = 0; i < AppointmentsHelper.getAllAppointments().size(); i++) {
                System.out.println(AppointmentsHelper.getAllAppointments()
                        .get(i).getAppointmentID());
            }
            System.out.println("");
            resultsLBLAppointments.setText("Report: " + AppointmentsHelper.getAllAppointments().size() + " Appointments in database");
        }
    }

    /**
     *
     * @param actionEvent this reacts when user presses generate reports button
     */

    public void onGenerateReports(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/ReportsScreen.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Reports Screen");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }
    @FXML
    void mouseOverTable(MouseEvent event) {


    }
    }
