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
2/2/2022 worked on functionality of user DAO file and added customer model java class. I was able to connect my user and customer DB pages to the database.
 Next I will work on confirmation when user logs into server.
 2/3 worked on appointments model and dao files. will work on user login next.
 Fixed slow IntelliJ by following course chatter to load JDK 11 project on JDK 17 VM with updated libraries. It fixed several buggy errors too.
 Working on main screen in scene builder and the controller file to test functionality. was able to open MainScreen.fxml in IJ without bugging by using "compare with editor" option.
 Next time I will continue working on main screen controller.
 2/4 cleaning up code and watching key to keys webinar.
 2/7 from key to keys- toy and toy ID are comparable to customer and address. Also divisionID is comparable to locationID.
 I will model my dao implementation files and model files after these.
2/8 Working on getting my sql code today and debugging.
 2/9 working on customers table- data is not populating. i fixed my sql command in my dao file.
 fixed datatype for phone number from int to string in customers.java so data populated properly  into table.
 fixed column names in the main controller file so customer name, address and postal code properly loaded data.
 into customer table.
 2/11 fixed appointmentsDAO and model files to properly load DB data into appointments table. also set up forms for adding/modifying customers
 and appointments. Will work on coding those next.

 worked on customersDAO adding customer to db. still having issues with properly coding to add new customer will work on that next.
 2/15 will work on add customers dao file and java file (customers dao file.)

 2/16 will work on properly joining information for appointments table display in main Dao file. Will work on creating customer in the java file and dao.
 also will work on user loginDao to check db for values.
-- figured out why my data wasnt loading right into "start" and "end" on appointment table- it needed to be string type not date or time.
 working on adding values to combo box from db. will work on that later too
 2/18 continue working on add customer form-combo boxes and all.
 2/21 working on combo boxes
 2/24 went to LiS for help with combo boxes - country and division in add customer.


 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("/View/UserLoginScreen.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 1230,630));
        primaryStage.show();


}


    public static void main(String[] args) {


        DBConnection.openConnection();
        launch(args);
        DBConnection.closeConnection();
    }
}
