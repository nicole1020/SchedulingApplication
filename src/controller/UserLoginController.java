package controller;

import DAO.UserHelper;
import javafx.collections.SetChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.*;

public class UserLoginController implements Initializable {
    private static Logger logger = Logger.getLogger("ErrorChangeLogging");
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler("login_activity.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Button login;
    public Button cancel;
    public TextField userName;
    public TextField password;
    public Label userNameLabel;
    public Label passwordLabel;
    public Label userLocationLabel;
    private static User loggedUser;
    private ResourceBundle resourceB = ResourceBundle.getBundle("language", Locale.getDefault());



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        userLocationLabel.setText(ZoneId.systemDefault().toString());
        passwordLabel.setText(resourceB.getString("password"));
        userNameLabel.setText(resourceB.getString("username"));
        userName.setPromptText(resourceB.getString("enter_username"));
        password.setPromptText(resourceB.getString("enter_password"));

    }

    public void onLogin(ActionEvent actionEvent) throws IOException{


        String userName = this.userName.getText();
        String passwordEntry = password.getText();
        if (userName == null) {
            return;
            
            
        }
        if (passwordEntry == null) {
            return;
        }

         else {

            loggedUser = UserHelper.validateUser(userName, passwordEntry);

             logger.addHandler(fh);
            logger.setLevel(Level.ALL);

            if(loggedUser == null){

                logger.info(("User with UserName:"+  " '" + this.userName.getText()+  "' " +    "had invalid login at " + LocalDateTime.now()+ " " + ZoneId.systemDefault()));

                System.out.println("Attempted Login by user: " + this.userName.getText() );
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setContentText("Enter valid inputs");
                alert.showAndWait();

            return;

            }
        try {
            System.out.println("Successful Login by user: " + this.userName.getText() );
            logger.info( "User with UserName: " +  "'" + this.userName.getText()+  "' " + "had valid login at " + LocalDateTime.now()+ " " + ZoneId.systemDefault());


            userLocationLabel.setText("Login Successful");
                Locale.setDefault(new Locale("en","US"));
                Parent root = FXMLLoader.load(getClass().getResource("/View/CustomerScreen.fxml"));
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
            logger.fine("complete");

        }
        }
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
        userName.textProperty().addListener((observable, oldValue, newValue) ->
                System.out.println(("userName Text Changed (newValue: " + newValue + ")\n")));

    }

    public <E> void writeLoginActivity(SetChangeListener.Change<? extends E> change) {
        PrintWriter fw = null;
        try {
            fw = new PrintWriter("login_activity.txt");
            BufferedWriter bufferedW = new BufferedWriter(fw);
            bufferedW.write("User with UserName:"+  " '" +this.userName.getText()+ "' "  +    "had invalid login at " + LocalDateTime.now()+ " " + ZoneId.systemDefault());
            bufferedW.newLine();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
