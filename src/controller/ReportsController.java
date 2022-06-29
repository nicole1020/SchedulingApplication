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
import model.Contact;

import javax.sql.rowset.Predicate;
import java.net.URL;
import java.sql.SQLException;
import java.time.Month;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Nicole Mau
 * this initializes reports controller class
 */
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
    public ComboBox<Contact> contactCombo;
    public Label resultsLBLContacts;
    int countingClicks = 0;

    /**
     *
     * @param actionEvent this is what happens when back button is selected
     */
    public void onBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Appointments Scheduler and Reports");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    /**
     *
     * @param url This initializes combo boxes,labels, components of the appointments table, and also the Lambda expression when exit button is pressed, count clicks on exit button, and print exit program
     * @param resourceBundle resources for initialize.
     */



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
        resultsLBL.setText("Report: " + AppointmentsHelper.getAllAppointments().size() + " Appointments in database");


    }

    public void onExitButton() {

    }

    public void onReportsComboBox(ActionEvent actionEvent) throws SQLException {

    }

    /**
     *
     * @param actionEvent this reacts when user presses submit button to run counter for Reports requirement. this counts appointments by type and month
     *
     * @throws SQLException if one or both combo boxes arent selected, it pops up an error
     */
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
            System.out.println("Report (A.3.f) : " + sizeOfReport + " Appointments in database with " + "Type: " + type + " in Month: " + month + "");
            resultsLBL.setText("Report: " + sizeOfReport + " Appointments in database with " + "Type: " + type + " in Month: " + month + "");


        }

    }

    /**
     *
     * @param actionEvent this reacts when user presses clear button
     */

    public void onClearButton(ActionEvent actionEvent) {

        typeComboBox.getSelectionModel().clearSelection();
        monthComboBox.getSelectionModel().clearSelection();
        runButton.setText("Submit");
        resultsLBL.setText("");


    }

    /**
     *
     * @param actionEvent Lambda here: filtering appointments based on contactID for report requirement to count appointments based on contactID and said appointments in table
     *
     */
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

          resultsLBLContacts.setText("Report: " + contactAppointments.size() + " Appointments in database with " + "ContactID: " + cid );



      }
}
