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
 2/24 attempted to go to LiS for help with combo boxes - country and division in add customer.
2/26 appointment with Mr. Kinkead for assistance with combo boxes and add customer. he spent almost an hour fixing my code. He noted next time to come an hour late to live instructor support so the line is shorter.
He fixed my code in my main screen - add customer because I had new customer pointing to a button instead of checking existance of customerID.
3/2 working on update customer- having issues populating table to form
 3/4 appointment with Mr. Ruiz, but 10 minutes before I realized it is much like the modify product-associated parts screen and I figured it out.
 will work on user login controller next. He helped me with confirming user login information in the DAO file.
 He also helped me with appointments table getting the date time in separate boxes.
 He also helped me with how I would go about deciding if someone was french or english speaking in the user login form

 next time I will work on moving the appointments to another screen. creating forms for add/update appointments. setting user login errors and labels to show proper language if french or english speaking.
 3/5 worked on making proper screens for add/update appointments/customers
 3/7 worked on add/update customer. will work on delete and appointments next.
 3/15 I was trying to delete customer and figured out i needed to pass in the instance of customer and getCustomerID into the deleteCustomer method in the DAO file
I also had been attempting to delete the division ID which was unnecessary.
 3.24 will meet with Mr. Wabara for help with combo box for update customer- the combo box isnt auto filling with chosen customer country/division.
 4/4 will work on clear buttons on updatecustomer form.
 4/9 working on update  and add appointment and update appointment screens. set up so initial load goes to customer screen for easier navigation for now.
 got main appointmentwindow working. just need to add button and report functionality
 4/13 will continue to work on appointments functionality.
 4/14 from appointments screen add appointment was not working. I realized the code to load the add new appointment screen in the appointment controller was not
 properly coded. Added code to clear button on addappointmentcontroller. working on adding new appointment-save button.
 next i will properly set up combo boxes in the addnewappointment fxml and controller.
 4/19 worked on combo boxes in add appointments controller and helper files. Will work on time/date combo box creation next using the webinar as source.
 4/20 and 4/21 worked on combo boxes for appointments and setting localdatetime for value from DB.
 I will work on proper time conversion and appointments java file still.
4/21 debugged my code. still need to work on time classes in All appointment files for cohesiveness.
 5/13 cloned application from my github-saved. had to remove javafx versions from fxml code so it would stop throwing errors.
 using this format - xmlns="http://javafx.com/javafx" xmlns:fx="http://javafx.com/fxml"
 5/14 studying time formatting so i can properly set up appointments screen.
 5/16 working on add appointment screen- making it possible to save new appointment.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("/View/UserLoginScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/View/CustomerScreen.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("/View/AppointmentsScreen.fxml"));

        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


}


    public static void main(String[] args) {


        DBConnection.openConnection();
        launch(args);
        DBConnection.closeConnection();
    }
}
