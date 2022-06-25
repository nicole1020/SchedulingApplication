package controller;

import DAO.AppointmentsHelper;
import DAO.ReportsHelper;
import javafx.collections.ObservableList;
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
import model.Contacts;

import javax.sql.rowset.Predicate;
import java.net.URL;
import java.sql.SQLException;
import java.time.Month;
import java.util.Locale;
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
    public ComboBox<String> monthComboBox;
    public ComboBox<String> typeComboBox;
    public Label resultsLBLAppointments;
    public Button runButton;
    public Button clearButton;
    public ComboBox<Contacts> contactCombo;
    int countingClicks = 0;

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
//Lambda expression: on exit button

    public void initialize(URL url, ResourceBundle resourceBundle) {
        contactCombo.setItems(AppointmentsHelper.getAllAppointmentContacts());

        typeComboBox.setItems(ReportsHelper.getReportsDataSortByType());

        monthComboBox.setItems(ReportsHelper.getReportsDataSortByMonth());

        exitButton.setOnAction(e -> {
            countingClicks++;
            System.out.println(countingClicks);
            System.out.println("Exit Button Pressed");
            System.exit(0);
        });


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


    }


    public void onExitButton() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();

    }

    public void onReportsComboBox(ActionEvent actionEvent) throws SQLException {

    }

    public void onRunButton(ActionEvent actionEvent) throws SQLException {

        String type = typeComboBox.getValue();
        String month = monthComboBox.getValue();

        if (type == null || month == null) {

            System.out.println("select value from each combo box");
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error");
            alert2.setContentText("Please select both Type and Month");
            alert2.showAndWait();
        } else {
            int sizeOfReport = ReportsHelper.getAppointmentCountByMonthAndType(month, type);
            System.out.println("Report (A.3.f) : *" + sizeOfReport + "* Appointments in database with " + "Type: *" + type + "* in Month: *" + month + "*");
            resultsLBL.setText("Report: *" + sizeOfReport + "* Appointments in database with " + "Type: *" + type + "* in Month: *" + month + "*");


        }

    }

    public void onClearButton(ActionEvent actionEvent) {

        typeComboBox.getSelectionModel().clearSelection();
        monthComboBox.getSelectionModel().clearSelection();
        runButton.setText("Submit");
        resultsLBL.setText("");


    }
    //Lambda here filtering appointments based on contactID
    public void onContactCombo(ActionEvent actionEvent) {

        int cid = contactCombo.getValue().getContactID();
        ObservableList<Appointments> allAppointments = AppointmentsHelper.getAllAppointments();
        ObservableList<Appointments> contactAppointments = allAppointments.filtered(a->{
            if(cid == a.getContact()){
                return true;
            }
            return false;
        });
        appointmentsTable.setItems(contactAppointments);


    }
}
