package Controller;

import DAO.CustomersDAOImpl;
import DAO.UserDAOImpl;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class UserLoginController implements Initializable {
    public Button login;
    public Button cancel;
    public TextField userNameField;
    public TextField password;
    public Label userNameLabel;
    public Label passwordLabel;
    public Label userLocationLabel;
    private static User loggedUser;
    private static ResourceBundle french;
    private static ResourceBundle everywhereElse;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Instant now = Instant.now();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(now,
                ZoneId.of(ZoneId.systemDefault().toString()));
        System.out.println("Date/Time Zone " + zdt);
        userLocationLabel.setText(ZoneId.systemDefault().toString());


       }

    public void onLogin(ActionEvent actionEvent) throws IOException{
        String userName = userNameField.getText();
        String passwordEntry = password.getText();
        if (userName == null) {
            return;
        }
        if (passwordEntry == null) {
            return;
        }

         else {
            loggedUser = UserDAOImpl.validateUser(userName, passwordEntry);
            if(loggedUser == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setContentText("Enter valid inputs");
                alert.showAndWait();
            return;
            }
        try {

                userLocationLabel.setText("Login Successful");

                Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
                Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("Home Page");
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            } catch (Exception var7) {
                var7.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setContentText("Enter valid inputs");
                alert.showAndWait();
            }
         }
        }


    public void onCancel(ActionEvent actionEvent) {
        Stage stage = (Stage)this.cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private boolean onPassword() {

            return false;
        }


    @FXML
    private boolean onUserNameField() {

            return false;
    }
}
