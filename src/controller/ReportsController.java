package controller;

import DAO.AppointmentsHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Appointments;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {

    public Label resultsLBL;
    public ToggleGroup appointmentsToggle;
    public Button exitButton;
    public TableView<Appointments> appointmentsTable;
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
    public RadioButton currentWeekRadioButton;
    public RadioButton currentMonthRadioButton;
    public RadioButton allSortRadioButton;
    public Button backButton;
    public ComboBox<Appointments> monthComboBox;
    public ComboBox<Appointments> typeComboBox;

    public void onExitButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void onBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Appointments Scheduler and Reports");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println(AppointmentsHelper.getReportsDataSortByMonth());
        typeComboBox.setItems(AppointmentsHelper.getReportsDataSortByType());

        monthComboBox.setItems(AppointmentsHelper.getReportsDataSortByMonth());

        //Appointments Table Initialized

        System.out.println("All Appointments Displaying");
        appointmentsTable.setItems(AppointmentsHelper.getAllAppointments());

        appointmentsIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentsTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentsDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentsLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentsContactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        appointmentsTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentsStartDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        appointmentsEndDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        appointmentsCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appointmentsUserIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
       // System.out.println("Appointment IDs:");
        for (int i = 0; i < AppointmentsHelper.getAllAppointments().size(); i++) {
            System.out.println(AppointmentsHelper.getAllAppointments()
                    .get(i).getAppointmentID());

        }
        System.out.println("");
       // resultsLBL.setText("Report: " + AppointmentsHelper.getAllAppointments().size() + " Appointments on File");


    }


    public void onCurrentWeekRadioButton(ActionEvent actionEvent) {
        if (currentWeekRadioButton.isSelected()) {
            System.out.println("Current Week's Appointments Displayed");
            appointmentsTable.setItems(AppointmentsHelper.getCurrentWeekAppointments());
            for (int i = 0; i < AppointmentsHelper.getCurrentWeekAppointments().size(); i++) {
                System.out.println(AppointmentsHelper.getCurrentWeekAppointments()
                        .get(i).getAppointmentID());
            }
            System.out.println("");
            resultsLBL.setText("Report: " + AppointmentsHelper.getCurrentWeekAppointments().size() + " Appointments on File");
        }
    }

    public void onCurrentMonthRadioButton(ActionEvent actionEvent) {
        if (currentMonthRadioButton.isSelected()) {
            appointmentsTable.setItems(AppointmentsHelper.getCurrentMonthAppointmentsRadio());
          //  System.out.println("Current Month's Appointments Displayed");
            for (int i = 0; i < AppointmentsHelper.getCurrentMonthAppointmentsRadio().size(); i++) {
                System.out.println(AppointmentsHelper.getCurrentMonthAppointmentsRadio()
                        .get(i).getAppointmentID());
            }
            System.out.println("");
           // resultsLBL.setText("Report: " + AppointmentsHelper.getCurrentMonthAppointmentsRadio().size() + " Appointments on File");

        }
    }


    public void onAllSortRadioButton(ActionEvent actionEvent) {
        if (allSortRadioButton.isSelected()) {
          //  System.out.println("All Appointments Displayed");
            appointmentsTable.setItems(AppointmentsHelper.getAllAppointments());
            for (int i = 0; i < AppointmentsHelper.getAllAppointments().size(); i++) {
                System.out.println(AppointmentsHelper.getAllAppointments()
                        .get(i).getAppointmentID());
            }
          //  System.out.println("");
            resultsLBL.setText("Report: " + AppointmentsHelper.getAllAppointments().size() + " Appointments on File");
        }
    }

    public void appointmentsIsSelected(MouseEvent mouseEvent) {
    }

    public void onTypeComboBox(ActionEvent actionEvent) {
        if (typeComboBox.isPressed()) {

            appointmentsTable.setItems(AppointmentsHelper.getReportsDataSortByType());
           // System.out.println("Current Month's Appointments Displayed");
            for (int i = 0; i < AppointmentsHelper.getReportsDataSortByType().size(); i++) {
                System.out.println(AppointmentsHelper.getReportsDataSortByType()
                        .get(i));
            }
            //System.out.println("");
            resultsLBL.setText("Report: " + AppointmentsHelper.getReportsDataSortByType().size() + " Appointments on File");

        }
    }

    public void onMonthComboBox(ActionEvent actionEvent) {
        if (monthComboBox.isPressed()) {

            appointmentsTable.setItems(AppointmentsHelper.getReportsDataSortByMonth());
          //  System.out.println("Current Month's Appointments Displayed");
            for (int i = 0; i < AppointmentsHelper.getReportsDataSortByMonth().size(); i++) {
                System.out.println(AppointmentsHelper.getReportsDataSortByMonth()
                        .get(i).getAppointmentID());
            }
          //  System.out.println("");
            resultsLBL.setText("Report: " + AppointmentsHelper.getReportsDataSortByMonth().size() + " Appointments on File");

        }
    }

}