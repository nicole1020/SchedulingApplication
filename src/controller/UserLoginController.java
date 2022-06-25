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
// Initializing UserLoginController
public class UserLoginController implements Initializable {

    public Button login;
    public Button cancel;
    public TextField userName;
    public TextField password;
    public Label userNameLabel;
    public Label passwordLabel;
    public Label userLocationLabel;
    private static User loggedUser;
    private ResourceBundle resourceB = ResourceBundle.getBundle("language", Locale.getDefault());
    private static Appointments currentUser;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userLocationLabel.setText(ZoneId.systemDefault().toString());
        passwordLabel.setText(resourceB.getString("password"));
        userNameLabel.setText(resourceB.getString("username"));
        userName.setPromptText(resourceB.getString("enter_username"));
        password.setPromptText(resourceB.getString("enter_password"));

    }

    public void onLogin(ActionEvent actionEvent) throws IOException {


        String userName = this.userName.getText();
        String passwordEntry = password.getText();
        if (userName == null) {

            return;


        }
        if (passwordEntry == null) {
            return;

        }


        loggedUser = UserHelper.validateUser(userName, passwordEntry);
        if (loggedUser != null) {
            currentUser = AppointmentsHelper.getAppointmentsSoon(loggedUser.getUserID());


            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        new File("login_activity.txt"),
                        true));
                  pw.append("Valid Login by user" + this.userName.getText() + " " + "at " + LocalDateTime.now()+ "\n");
                pw.flush();
                pw.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            if (currentUser == null) {
                System.out.println("you dont have an appointment");
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("You dont have an appointment soon *" + this.userName.getText());
                alert2.setContentText("You dont have an appointment soon *" + this.userName.getText());
                alert2.showAndWait();

            }


            else {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Appointment soon for " + this.userName.getText());
                alert2.setContentText("Appointment soon for user " + this.userName.getText() + " #" + currentUser.getAppointmentID() + " at " + currentUser.getStartDateTime());
                alert2.showAndWait();
                System.out.println("Appointment soon for " + this.userName.getText());
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
        //bad case
        else {

            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        new File("login_activity.txt"),
                        true /* append = true */));
                pw.append("Invalid Login by user" + this.userName.getText() + " " + "at " + LocalDateTime.now() + "\n");
                pw.flush();
                pw.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            System.out.println("Attempted Login by user: " + this.userName.getText());
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle(resourceB.getString("Error"));
            alert2.setContentText(resourceB.getString("EnterValidInputs"));
            alert2.showAndWait();

            return;
        }
    }


    public void onCancel(ActionEvent actionEvent) {
        Stage stage = (Stage)this.cancel.getScene().getWindow();
        stage.close();
    }


   /* public void  printLog() {
        PrintWriter fw = null;
        try {
            fw = new PrintWriter("utilities.login_activity.txt");
            BufferedWriter bufferedW = new BufferedWriter(fw);
            bufferedW.write(this.userName.getText());
            bufferedW.write(String.valueOf(LocalDateTime.now()));
            bufferedW.write(ZoneId.systemDefault().toString());
            bufferedW.newLine();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
**/
    @FXML
    private boolean onPassword() {
        password.textProperty().addListener((observable, oldValue, newValue) ->
                System.out.println("password Text Changed (newValue: " + newValue + ")\n"));
        return false;
    }
    @FXML
    private void onUserNameField() {
        userName.textProperty().addListener((observable, oldValue, newValue) ->
                System.out.println(("userName Text Changed (newValue: " + newValue + ")\n")));

    }

    public <E> void writeLoginActivity(SetChangeListener.Change<? extends E> change) {

    }
}
