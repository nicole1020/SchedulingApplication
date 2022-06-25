package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import model.Contacts;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static DAO.DBConnection.connection;
//Initializing AppointmentsHelper
public class AppointmentsHelper {

//retrieves getAllAppointments from database
    public static ObservableList<Appointments> getAllAppointments() {
        ObservableList<Appointments> appointmentsList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, Start, End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {
                int Appointment_ID = aResult.getInt("Appointment_ID");
                String Title = aResult.getString("Title");
                String Description = aResult.getString("Description");
                String Location = aResult.getString("Location");
                int Contact_ID = aResult.getInt("Contact_ID");
                String Type = aResult.getString("Type");
                LocalDateTime Start = aResult.getTimestamp("Start").toLocalDateTime();
                LocalDateTime End = aResult.getTimestamp("End").toLocalDateTime();
                int Customer_ID = aResult.getInt("Customer_ID");
                int User_ID = aResult.getInt("User_ID");

                Appointments ap = new Appointments(Appointment_ID, Title, Description, Location, Contact_ID, Type, Start, End, Customer_ID, User_ID);
                appointmentsList.add(ap);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentsList;
    }

    //retrieves getAllAppointmentTypes from database
    public static ObservableList<String> getAllAppointmentTypes() {
        ObservableList<String> appointmentTypes = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT type FROM appointments";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                String type = cBResult.getString("type");
                appointmentTypes.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentTypes;
    }

    //retrieves getAllAppointmentContacts from database
    public static ObservableList<Contacts> getAllAppointmentContacts() {
        ObservableList<Contacts> appointmentContacts = FXCollections.observableArrayList();
        try {
            String sqlAC = "SELECT Contact_ID, Contact_Name, Email FROM contacts";
            PreparedStatement prepAC = connection.prepareStatement(sqlAC);
            ResultSet ACResult = prepAC.executeQuery();
            while (ACResult.next()) {
                Integer Contact_ID = ACResult.getInt("Contact_ID");
                String Contact_Name = ACResult.getString("Contact_Name");
                String Email = ACResult.getString("Email");
                Contacts aC = new Contacts(Contact_ID, Contact_Name, Email);


                appointmentContacts.add(aC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentContacts;
    }

    //retrieves getCurrentWeekAppointments from database
    public static ObservableList<Appointments> getCurrentWeekAppointments() {
        ObservableList<Appointments> currentWeekAppointmentsList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, Start, End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID AND  week(Start)=week(now())";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {
                int Appointment_ID = aResult.getInt("Appointment_ID");
                String Title = aResult.getString("Title");
                String Description = aResult.getString("Description");
                String Location = aResult.getString("Location");
                int Contact_ID = aResult.getInt("Contact_ID");
                String Type = aResult.getString("Type");
                LocalDateTime Start = aResult.getTimestamp("Start").toLocalDateTime();
                LocalDateTime End = aResult.getTimestamp("End").toLocalDateTime();
                int Customer_ID = aResult.getInt("Customer_ID");
                int User_ID = aResult.getInt("User_ID");

                Appointments ap = new Appointments(Appointment_ID, Title, Description, Location, Contact_ID, Type, Start, End, Customer_ID, User_ID);
                currentWeekAppointmentsList.add(ap);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentWeekAppointmentsList;
    }
    //retrieves getCurrentMonthAppointmentsRadio from database
    public static ObservableList<Appointments> getCurrentMonthAppointmentsRadio() {
        ObservableList<Appointments> currentMonthAppointmentsRadioList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, Start, End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID AND  MONTH(Start) = MONTH(NOW()) and YEAR(Start) = YEAR(NOW());";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {
                int Appointment_ID = aResult.getInt("Appointment_ID");
                String Title = aResult.getString("Title");
                String Description = aResult.getString("Description");
                String Location = aResult.getString("Location");
                int Contact_ID = aResult.getInt("Contact_ID");
                String Type = aResult.getString("Type");
                LocalDateTime Start = aResult.getTimestamp("Start").toLocalDateTime();
                LocalDateTime End = aResult.getTimestamp("End").toLocalDateTime();
                int Customer_ID = aResult.getInt("Customer_ID");
                int User_ID = aResult.getInt("User_ID");

                Appointments ap = new Appointments(Appointment_ID, Title, Description, Location, Contact_ID, Type, Start, End, Customer_ID, User_ID);
                currentMonthAppointmentsRadioList.add(ap);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentMonthAppointmentsRadioList;
    }
    //creates appointment in database
    public static void createAppointment(String title, String description, String location, String type, LocalDateTime Start, LocalDateTime endTime, int customerID, int userID, int contact) {
        try {
            String sqlc4 = " INSERT INTO appointments VALUES (NULL, ?,?,?,?,?,?,now(),'nm',now(),'nm',?,?,?)";

            PreparedStatement psCreate4 = connection.prepareStatement(sqlc4);
            psCreate4.setString(1, String.valueOf(title));
            psCreate4.setString(2, String.valueOf(description));
            psCreate4.setString(3, String.valueOf(location));
            psCreate4.setString(4, String.valueOf(type));
            psCreate4.setTimestamp(5, Timestamp.valueOf(Start));
            psCreate4.setTimestamp(6, Timestamp.valueOf(endTime));
            psCreate4.setInt(7, customerID);
            psCreate4.setInt(8, userID);
            psCreate4.setInt(9, contact);


            psCreate4.execute();


        } catch (Exception e) {
            e.printStackTrace();//print stack trace

        }
    }
    //updates appointment in database
    public static void updateAppointment(String title,
                                         String description, String location, String type,
                                         LocalDateTime start, LocalDateTime end,
                                         int customerID, int user, int contact,int appointmentid) {
        try {

            String sqlc = " UPDATE  appointments set  Title = ?, Description = ?,Location = ?, Type = ?, Start = ?, End = ?, Customer_ID = ?, User_ID = ?, Contact_ID =? WHERE Appointment_ID = ?";
            PreparedStatement psCreate = connection.prepareStatement(sqlc);

            psCreate.setString(1, String.valueOf(title));
            psCreate.setString(2, String.valueOf(description));
            psCreate.setString(3, String.valueOf(location));
            psCreate.setString(4, String.valueOf(type));
            psCreate.setTimestamp(5, Timestamp.valueOf(start));
            psCreate.setTimestamp(6, Timestamp.valueOf(end));
            psCreate.setInt(7, customerID);
            psCreate.setInt(8, user);
            psCreate.setInt(9, contact);
            psCreate.setInt(10, appointmentid);
            psCreate.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //deletes appointment in database
    public static void deleteAppointment(int appointmentID) {
        try {
            String sqlDC = "Delete FROM appointments WHERE Appointment_ID = ?";
            PreparedStatement psDC = connection.prepareStatement(sqlDC);
            psDC.setInt(1, appointmentID);
            psDC.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //checks for appointments in database if current user has an appointment within 15 minutes of logging in
    public static Appointments getAppointmentsSoon(Integer userID) {
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, " +
                    "Start, End, Customer_ID, User_ID, " +
                    "Contact_ID FROM  appointments  WHERE  Start > ? AND Start < ?  AND User_ID = ?";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            prepA.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            prepA.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now().plusMinutes(15)));
            prepA.setInt(3, userID);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {

                int Appointment_ID = aResult.getInt("Appointment_ID");
                String Title = aResult.getString("Title");
                String Description = aResult.getString("Description");
                String Location = aResult.getString("Location");
                int Contact_ID = aResult.getInt("Contact_ID");
                String Type = aResult.getString("Type");
                LocalDateTime Start = aResult.getTimestamp("Start").toLocalDateTime();
                LocalDateTime End = aResult.getTimestamp("End").toLocalDateTime();
                int Customer_ID = aResult.getInt("Customer_ID");
                int User_ID = aResult.getInt("User_ID");
                Appointments ap = new Appointments(Appointment_ID, Title, Description, Location, Contact_ID, Type, Start, End, Customer_ID, User_ID);
                return ap;
                //System.out.println(ap);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }


    //replaced by lambda expression loaded all appointments by selected contact

    public static ObservableList<Appointments> getAllAppointmentsByContact(int cid) {

        ObservableList<Appointments> appointmentsList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, " +
                    "Description, Location, Type, Start, End, " +
                    "Customer_ID, User_ID, Contact_ID FROM appointments WHERE  "+
                    "  appointments.Contact_ID = ? ";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            prepA.setInt(1, cid);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {
                int Appointment_ID = aResult.getInt("Appointment_ID");
                String Title = aResult.getString("Title");
                String Description = aResult.getString("Description");
                String Location = aResult.getString("Location");
                int Contact_ID = aResult.getInt("Contact_ID");
                String Type = aResult.getString("Type");
                LocalDateTime Start = aResult.getTimestamp("Start").toLocalDateTime();
                LocalDateTime End = aResult.getTimestamp("End").toLocalDateTime();
                int Customer_ID = aResult.getInt("Customer_ID");
                int User_ID = aResult.getInt("User_ID");

                Appointments ap = new Appointments(Appointment_ID, Title, Description, Location, Contact_ID, Type, Start, End, Customer_ID, User_ID);
                appointmentsList.add(ap);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentsList;

    }
}





