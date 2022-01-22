package Controller;

import Model.UserLogin;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Instant now = Instant.now();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(now,
                ZoneId.systemDefault());

        System.out.println( "Date: " + zdt  );
        userLocationLabel.setText("Date: " + zdt);

    }

    public void onLogin(ActionEvent actionEvent) {
    }

    public void onCancel(ActionEvent actionEvent) {
    }

    public void onPassword(ActionEvent actionEvent) {
    }

    public void onUserNameField(ActionEvent actionEvent) {
    }
}
