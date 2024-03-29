package utilities;

import DAO.DBConnection;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;


/**
 JavaDoc is in folder C:\Users\LabUser\IdeaProjects\SchedulingApplication > index
  @author Nicole Mau
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
 fixed start date column in appointments so it would properly load data.
 worked on trying to get "to String" to work in add appointments screen. Might need to make a new java class.
 5/17 using course material to get french language to populate in user login screen based on user's location.
Went to live support and course instructor Mr. Wabara helped me with resource bundle in userlogin and main controllers.
 5/18 debugging appointments controller- my sql was wrong in the get all contacts and end time/date columns still need to work on to string. Will continue to work on add appointment controller and go to live support again tonight.
 5/20 working on populating combo box options properly- will make java classes for each combo box. successfully used existing contacts class to load contactID to combo box in add appointments.
 also fixed type combo box by properly setting up the type variable- String toString was not working because I never properly declared type.
-need to fix code to make sure appointments and customerID populating in the helper file- which is why theyre not populating in the combo box.
 5/21- fixed customerID combo box in appointments by updating combo box<CustomerIDsAppointments>  instead of <Appointments>
 5/23 fixing start and end classes in Appointments java and helper files to be LocalDateTime designated instead of strings.
 so far I have it set up I need to work on appointment scheduling breakdown.
 5/23 fixing onsave code for addappointment. working on sql and java files using key to keys as a guide.
5/24 met with Mr wabara in live instructor support to help with creating appointment times, and sql code in appointments.
 6/1 met with mr ruiz live instructor support- he helped me navigate my program with properly setting up appointment availability.
 6/3 debugging code so it complies to instructor suggestions- changed "type" combo box to string from appointment class. changed customerID to customers from appointments,
 and changed start and end times to LocalTimes from appointment classes. Will work on setting appointment times and combo boxes for start times and end times.
 successfully updated each  corresponding java files to reflect proper "toString" commands on combo box items.
will fix java code for combo box appointment times and proper sql code for save appointments tomorrow.
 6/6 fixed an issue with customerID not populating into the appointments table properly- i somehow deleted the getter for customerID in appointments java class. I fixed it by adding the getter

 working on null pointer exception for saving appointment.
 6/8 went to live support met with mr ruiz for help with resource bundles, setting appointment times.
6/9 went to live support and met with Mr Kinkead, he helped with save appointment and appointment time set up and creation. I learned about
 converting date and localtime to localdatetime by passing in the locally stored dates and times.
 I also learned how to properly use time offset from EST to user's localtime.

 will work on updateappointment controller and making sure the combo boxes properly populate with the right data.
 6/10 working on listeners on date picker and combo boxes(if necessary)
 emailed Mr. kinkead and he helped me understand where I'm having trouble with updatecontroller. he suggested i breakup localdatetime into local date and local time for the proper combo boxes and set it up accordingly.
 fixed the issues. working on delete appointment next.
 added delete appointment.
 working on radio buttons to sort by week, month, all.- so far onaction is not working;
 6/11 working on radio buttons, emailed Mr. Kinkead for advice. He is checking my sql in next interaction.
figured out how to get radio buttons to work. also Mr. Kinkead fixed a mistake I repeated on accident in my sql with timestamp.
 I also figured out how to retrieve current week and current month data in sql function to properly sort appointments with radio buttons.
current week was not properly working because I had the table information populating after the loop. It needed to be before the loop that counted
 quantity of appointments in the table.
 next I will work on writing login activity to read only file login_activity.txt
 I realized i need to set up a resource bundle and hopefully set up a lambda expression for login activity
6/12 spoke with Ms Sunitha at LIS, she was not 195 instructor but she helped me understand where my bug was. My bug was in my getter for the "Month" property
 I will work on retrieving info from the list tomorrow and making it properly populate into the list.
 fixed layout of reports screen. removed some anchor panes.
 6/13 emailed support and mr kinkead for help with type and month combo boxes.
 6/14 still having issues. will work on more.
 6/16 Mr kinkeads email helped me realize i needed to make sure i was pulling more information from each combo box class.
 I'll pull month by number from each, type, appointment id, instead of just pulling type from one and month from another.
will pull more data from type and month dao helper files next time.
 6/17 working on javadoc and error warnings until i can figure out the report issue.
 6/22 will work on javadoc comments and error warnings and got to LIS to help with combo boxes.
 I am missing a key component to the logic and i havent figured it out yet.
 meeting with Mr Ruiz Shortly in LIS to get help with combo boxes.
 6/23- met with miss sunitha, she helped me fix my sql so my reports generator works! yayyy!
 worked on lambda expression to make exit button count clicks, exit, and print a message notifying of closure

 also worked on error coding updating the resource bundle to properly show error in french and english.
6/24 figured out error coding in appointmentTimes for 15 minute warning - but it's not working so i emailed
  mr kinkead. Also worked on javadoc comments and second lambda expression.
 6/25 Mr kinkead replied I realized I was not properly using sql to get a 15 minute warning. I needed to use logged user to
 check their appointments in the database and then see if they have appointments in the next 15 minutes.
 he helped me create the report for contactID, and debug code for logging.
 I emailed him later and was able to have him help fix my code for deleting appointment before customer from database.
 i was able to execute appointment delete based on customer id before customer based on customer id.
 also my program stopped running so i had to build> rebuild to get it to work.
 mr kinkead helped me figure out why update appointment and customer was not saving right. I had the wrong value for appointment and customer id saving to the database.
 I fixed it and it works!

 I also had issues somehow deleting all appointments from database, I figured out how to add them by making type box in add and update appointments editable.

 Cleaned up code to make it ready for submission, generated javadoc and will zip to submit
 6.28 received feedback after submission, added proper language settings on login form, error checking on login, save/update appointment is functional, combo box-for contacts now shows contact name,
 appointment ID and type now displaying upon deletion. added appointment overlap confirmation in validationAppointments method,
 also  set combo box to show no upcoming appointments soon.
 went to live support because the combo box is throwing an error when i save it in db. I can add 2 values to the customer combo box in appointments without issue.
 I cant figure out the bug. I believe the error lies in the VM
 6.29 mr kinkead emailed saying to make all combo boxes not editable. removing that in add appointment and submitting.
 */


public class Main extends Application {

    @Override

    public void start(Stage primaryStage) throws Exception {

         //Locale.setDefault(new Locale("fr","FR"));

       Parent root = FXMLLoader.load(getClass().getResource("/View/UserLoginScreen.fxml") );
        //Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("/View/CustomerScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/View/AppointmentsScreen.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/View/ReportsScreen.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 /**
  *
  * @param args launches program
  *
  */
    public static void main(String[] args) {

        DBConnection.openConnection();

        launch(args);
        DBConnection.closeConnection();
    }
}

