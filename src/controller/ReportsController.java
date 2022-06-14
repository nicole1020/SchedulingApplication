package controller;

import DAO.AppointmentsHelper;
import DAO.ReportsHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Country;
import model.Reports;
import model.Appointments;

import java.net.URL;
import java.sql.SQLException;
import java.time.Month;
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
    public ComboBox<Month> monthComboBox;
    public ComboBox<String> typeComboBox;
    public Label resultsLBLAppointments;
    public Button runButton;

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

        typeComboBox.setItems(ReportsHelper.getReportsDataSortByType());

        monthComboBox.setItems(ReportsHelper.getReportsDataSortByMonth());

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
        System.out.println("Appointment IDs:");
        for (int i = 0; i < AppointmentsHelper.getAllAppointments().size(); i++) {
            System.out.println(AppointmentsHelper.getAllAppointments()
                    .get(i).getAppointmentID());

        }
        System.out.println("");
        resultsLBL.setText("Report: " + AppointmentsHelper.getAllAppointments().size() + " Appointments on File");


    }


    public void onCurrentWeekRadioButton(ActionEvent actionEvent) {
     /*   if (currentWeekRadioButton.isSelected()) {
            System.out.println("Current Week's Appointments Displayed");
            appointmentsTable.setItems(AppointmentsHelper.getCurrentWeekAppointments());
            for (int i = 0; i < AppointmentsHelper.getCurrentWeekAppointments().size(); i++) {
                System.out.println(AppointmentsHelper.getCurrentWeekAppointments()
                        .get(i).getAppointmentID());
            }
            System.out.println("");
            resultsLBL.setText("Report: " + AppointmentsHelper.getCurrentWeekAppointments().size() + " Appointments on File");
        }**/
    }

    public void onCurrentMonthRadioButton(ActionEvent actionEvent) {
      /*   if (currentMonthRadioButton.isSelected()) {
            appointmentsTable.setItems(AppointmentsHelper.getCurrentMonthAppointmentsRadio());
            //  System.out.println("Current Month's Appointments Displayed");
            for (int i = 0; i < AppointmentsHelper.getCurrentMonthAppointmentsRadio().size(); i++) {
                System.out.println(AppointmentsHelper.getCurrentMonthAppointmentsRadio()
                        .get(i).getAppointmentID());
            }
            System.out.println("");
            // resultsLBL.setText("Report: " + AppointmentsHelper.getCurrentMonthAppointmentsRadio().size() + " Appointments on File");

        }**/
    }


    public void onAllSortRadioButton(ActionEvent actionEvent) {
       /*if (allSortRadioButton.isSelected()) {
            //  System.out.println("All Appointments Displayed");
            appointmentsTable.setItems(AppointmentsHelper.getAllAppointments());
            for (int i = 0; i < AppointmentsHelper.getAllAppointments().size(); i++) {
                System.out.println(AppointmentsHelper.getAllAppointments()
                        .get(i).getAppointmentID());
            }
            //  System.out.println("");
            resultsLBL.setText("Report: " + AppointmentsHelper.getAllAppointments().size() + " Appointments on File");
        }**/
    }

    public void appointmentsIsSelected(MouseEvent mouseEvent) {
    }

    public void onTypeComboBox(ActionEvent actionEvent) {

       /* if (typeComboBox.isPressed()) {

            appointmentsTable.setItems(ReportsHelper.getReportsDataSortByType());
           // System.out.println("Current Month's Appointments Displayed");
            for (int i = 0; i < ReportsHelper.getReportsDataSortByType().size(); i++) {
                System.out.println(ReportsHelper.getReportsDataSortByType()
                        .get(i));
            }
            //System.out.println("");
            resultsLBL.setText("Report: " + ReportsHelper.getReportsDataSortByType().size() + " Appointments on File");

        }**/
    }

    public void onMonthComboBox(ActionEvent actionEvent) {

        //   if (monthComboBox.isPressed()) {

        //    appointmentsTable.setItems(ReportsHelper.getReportsDataSortByMonth());
        //  System.out.println("Current Month's Appointments Displayed");
        //  for (int i = 0; i < ReportsHelper.getReportsDataSortByMonth().size(); i++) {
        //     System.out.println(ReportsHelper.getReportsDataSortByMonth()
        //             .get(i).getAppointmentID());
        // }
        //  System.out.println("");
        //   resultsLBL.setText("Report: " + ReportsHelper.getReportsDataSortByMonth().size() + " Appointments on File");

    }


    public void onExitButton(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void onReportsComboBox(ActionEvent actionEvent) throws SQLException {
        /*if (typeComboBox.isPressed() && monthComboBox.isPressed()) {
            String typeValue = typeComboBox.getValue();
            Month monthValue = monthComboBox.getValue();
            int sizeT = typeComboBox.getVisibleRowCount();
            int sizeM = monthComboBox.getVisibleRowCount();
            if (typeValue == null || monthValue == null) {
                System.out.println("select value from each combo box");
                return;
            }
            else{
                ReportsHelper.getDataSortByMonthAndType(typeValue, monthValue).size();

                    System.out.println("month size "+sizeM);
                    resultsLBL.setText("Report (A.3.f) : " + ReportsHelper.getDataSortByMonthAndType(typeValue, monthValue).size() + " Appointments on File");

}
            }**/
        }


    public void onRunButton(ActionEvent actionEvent) throws SQLException {

            String typeValue = typeComboBox.getValue();
            Month monthValue = monthComboBox.getValue();
            int sizeT = typeComboBox.getVisibleRowCount();
            int sizeM = monthComboBox.getVisibleRowCount();
            if (typeValue == null || monthValue == null) {
                System.out.println("select value from each combo box");
                return;
            }
            else{
                int sizeOfReport = (ReportsHelper.getDataSortByMonthAndType(typeValue, monthValue)).size();

                System.out.println("month size "+ sizeOfReport);
                resultsLBL.setText("Report (A.3.f) : " + sizeOfReport + " Appointments on File");


            }

}
}
