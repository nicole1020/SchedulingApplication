package Model;

import DAO.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 1/24/2022 I asked for help through email on user login screen. I was having trouble validating the inputs.
 I received email back from Miss Carolyn asking if it was my inputs I was comparing or comparing themselves to strings.
 that was my problem. I added Users class and a method to add a user to an observable array list allUsers. I also added a generateUserID method
 because we will need to access this information later in scheduling.

 Next I will work on changing the language of the login screen based on geographic location of the user.
2/2/2022 worked on fuctionality of user DAO file and added customer model java class. I was able to connect my user and customer DB pages to the database.
 Next I will work on confirmation when user logs into server.
 2/3 worked on appointments model and dao files. will work on user login next
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("/View/UserLoginScreen.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 800,600));
        primaryStage.show();


}


    public static void main(String[] args) {
        launch(args);
        Users.generateUserID();
        DBConnection.openConnection();
        DBConnection.closeConnection();
    }
}
