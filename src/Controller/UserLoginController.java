package Controller;

import Model.UserLogin;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.xml.stream.Location;
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
    private int newUserID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Instant now = Instant.now();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(now,
                ZoneId.of(ZoneId.systemDefault().toString()));
        System.out.println("Date/Time/Division " + zdt);
        userLocationLabel.setText("Date/Time/Division " + zdt);

        int uniqueUserID = 0;
      //  newUserID = UserDAO.generateUserID(uniqueUserID);
       System.out.println("User ID Generated: " + newUserID);
    }

    public void onLogin(ActionEvent actionEvent) throws IOException{
        if (!onPassword() || !onUserNameField()) {
            System.out.println("Error- invalid username and/or password");
            userLocationLabel.setText("Please enter valid username and password");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter valid userName and Password",
                    new ButtonType[0]);
            alert.showAndWait();
        } else if (onPassword() && onUserNameField()) {
            {
                System.out.println("to Main Screen");
            }
            try {

               // UserLogin newUser = new UserLogin(newUserID, "", "", "");
               // newUser.setUserName(userNameField.getText());
                //newUser.setPassword(password.getText());
               // newUser.setUserLocation(userLocationLabel.getText());
              //  Users.addUser(newUser);
                userLocationLabel.setText("Login Successful");

                Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
                Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600.0D, 610.0D);
                stage.setTitle("Home Page");
                stage.setScene(scene);
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
        if (password.getText().equals("test")) {
            System.out.println("valid password proceed");
            return true;
        } else {
            return false;
        }
    }

    @FXML
    private boolean onUserNameField() {
        if (userNameField.getText().equals("test")) {
            System.out.println("valid username proceed");
            return true;
        } else {
            return false;
        }
    }
}
