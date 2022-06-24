package controller;

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
import model.User;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserLoginController implements Initializable {
    private static Logger logger = Logger.getLogger("NewLogger");
   /***/ private static FileHandler fh;

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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(resourceB.getString("Error"));
        alert.setContentText(resourceB.getString("EnterValidInputs"));
        Optional<ButtonType> result = alert.showAndWait();
        alert.showAndWait();
         if  (result.get() == ButtonType.OK) {

            loggedUser = UserHelper.validateUser(userName, passwordEntry);

             logger.addHandler(fh);
            logger.setLevel(Level.ALL);

            if(loggedUser == null){

                logger.info(("User with UserName:"+  " '" + this.userName.getText()+  "' " +    "had an invalid login at " + LocalDateTime.now()+ " " + ZoneId.systemDefault()));
                logger.log(Level.WARNING,("User with UserName:"+  " '" + this.userName.getText()+  "' " +    "had an invalid login at " + LocalDateTime.now()+ " " + ZoneId.systemDefault()));

                System.out.println("Attempted Login by user: " + this.userName.getText() );
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle(resourceB.getString("Error"));
                alert2.setContentText(resourceB.getString("EnterValidInputs"));
                alert2.showAndWait();

            return;

            }
        try {
            System.out.println("Successful Login by user: " + this.userName.getText() );
            logger.info( "User with UserName: " +  "'" + this.userName.getText()+  "' " + "had a valid login at " + LocalDateTime.now()+ " " + ZoneId.systemDefault());


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
                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert3.setTitle(resourceB.getString("Error"));
                alert3.setContentText(resourceB.getString("Valid Inputs"));
                alert3.showAndWait();
            }
            logger.fine("complete");

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
