package controller;

import DAO.AppointmentsHelper;
import DAO.UserHelper;
import javafx.collections.SetChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.AppointmentTimes;
import model.Appointments;
import model.User;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Nicole Mau
 *  Initializing UserLoginController class
 */

public class UserLoginController implements Initializable {

    public Button login;
    public Button cancel;
    public TextField userNameField;
    public TextField password;
    public Label userNameLabel;
    public Label passwordLabel;
    public Label userLocationLabel;
    private static User loggedUser;
    public Label label;
    private ResourceBundle resourceB = ResourceBundle.getBundle("language", Locale.getDefault());
    private static Appointments currentUser;


    /**
     *
     * @param url this initializes the labels and text fields with the resourcebundle resourceB and also the Lambda expression when exit button is pressed, count clicks on exit button, and print exit program
     * @param resourceBundle resources for Override
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userLocationLabel.setText(ZoneId.systemDefault().toString());
        passwordLabel.setText(resourceB.getString("password"));
        userNameLabel.setText(resourceB.getString("username"));
        userNameField.setPromptText(resourceB.getString("enter_username"));
        password.setPromptText(resourceB.getString("enter_password"));
        login.setText(resourceB.getString("login"));
        cancel.setText(resourceB.getString("cancel"));
        label.setText(resourceB.getString("label"));

    }

    /**
     *
     * @param actionEvent checks to make sure username and password exist in tandem in database
     * @throws IOException will pop up a window if invalid entries or if username and password do not exist in database
     */
    public void onLogin(ActionEvent actionEvent) throws IOException {


        String userName = userNameField.getText();
        String passwordEntry = password.getText();
        loggedUser = UserHelper.validateUser(userName, passwordEntry);

        if (userName == null || passwordEntry == null){
            System.out.println("Attempted Login by user: " + userName);
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle(resourceB.getString("Error"));
            alert2.setContentText(resourceB.getString("EnterValidInputs"));
            alert2.showAndWait();

            return;
        }
        if(loggedUser == null ) {

            System.out.println("Attempted Login by user: " + userName);
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle(resourceB.getString("Error"));
            alert2.setContentText(resourceB.getString("EnterValidInputs"));
            alert2.showAndWait();


               PrintWriter pw = new PrintWriter(new FileOutputStream(
                       new File("login_activity.txt"),
                       true /* append = true */));
               pw.append("Invalid Login by user" + userNameField.getText() + " " + "at " + LocalDateTime.now() + "\n");
               pw.flush();
               pw.close();
               return;
           }

         if(loggedUser != null) {

             currentUser = AppointmentsHelper.getAppointmentsSoon(loggedUser.getUserID());

            PrintWriter pw = new PrintWriter(new FileOutputStream(
                    new File("login_activity.txt"),
                    true));
            pw.append("Valid Login by user" + userNameField.getText() + " " + "at " + LocalDateTime.now() + "\n");
            pw.flush();
            pw.close();

        }
        else{

                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle(resourceB.getString("Error"));
                alert2.setContentText(resourceB.getString("EnterValidInputs"));
                alert2.showAndWait();
                return;


        }


            if (currentUser != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Appointment soon for " + userNameField.getText());
                alert.setContentText("Appointment soon for user " + userNameField.getText() + " #" + currentUser.getAppointmentID() + " at " + currentUser.getStartDateTime());
                alert.showAndWait();
                System.out.println("Appointment soon for " + userNameField.getText());
            } else {
                System.out.println("You dont have an appointment soon");
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("You dont have an appointment soon *" + userNameField.getText());
                alert2.setContentText("You dont have an appointment soon *" + userNameField.getText());
                alert2.showAndWait();



        }
            userLocationLabel.setText("Login Successful");
            Locale.setDefault(new Locale("en", "US"));
            Parent root = FXMLLoader.load(getClass().getResource("/View/CustomerScreen.fxml"));
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Home Page");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }



    /**
     *
     * @param actionEvent reacts when user presses cancel
     */
    public void onCancel(ActionEvent actionEvent) {
        Stage stage = (Stage)this.cancel.getScene().getWindow();
        stage.close();
    }



    @FXML
    private boolean onPassword() {
        password.textProperty().addListener((observable, oldValue, newValue) ->
                System.out.println("password Text Changed (newValue: " + newValue + ")\n"));
        return false;
    }
    @FXML
    private void onUserNameField() {
        userNameField.textProperty().addListener((observable, oldValue, newValue) ->
                System.out.println(("userName Text Changed (newValue: " + newValue + ")\n")));

    }


}
