package DAO;

import javafx.scene.control.DatePicker;
import model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static DAO.DBConnection.connection;

public class AppointmentsHelper {

    private static Object LocalDateTime;
    private static Calendar calendar;
    private static String Start;

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
                aResult.getTimestamp("Start").toLocalDateTime();
                LocalDateTime Start = (java.time.LocalDateTime) aResult.getObject("Start");
                aResult.getTimestamp("End").toLocalDateTime();
                LocalDateTime End = (java.time.LocalDateTime) aResult.getObject("End");
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

    private static Map<String, Class<?>> getEndTime() {
        return null;
    }

    private static Map<String, Class<?>> getStartTime() {
        return null;
    }

    private static Map<String, Class<?>> setStartTime() {
        return null;
    }
    //create new appointment


   /*public static void createAppointment(String title, String description, String location, String type, LocalDateTime date,Timestamp Start, LocalDateTime startTime, LocalDateTime endTime, int customerid, int user, int contact) {
        try {

            String sqlc = " INSERT INTO appointments VALUES (NULL, ?,?,?,?,?,?,?,now(),'nm',now(),'nm',?,?,?)";
            PreparedStatement psCreate = connection.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
            psCreate.setString(1, String.valueOf(title));
            psCreate.setString(2, String.valueOf(description));
            psCreate.setString(3, String.valueOf(location));
            psCreate.setString(4, String.valueOf(type));
            psCreate.setTimestamp(Timestamp.valueOf(Start));
            psCreate.setObject(6, startTime);
            psCreate.setObject(7, endTime);

          //  psCreate.setInt(8, customerid);
         //   psCreate.setInt(9, user);
          //  psCreate.setInt(10, contact);

            psCreate.execute();

        } catch (Exception e) {
            e.printStackTrace();//print stack trace

        }
    }

    public static void updateAppointment(Integer appointmentid, String title, String description, String location, String type, String startTime, String endTime,  int customerID, int user, int contact) throws SQLException {

    }
**/
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
    public static ObservableList<Date> getAllAppointmentDates(DatePicker appointmentDate) {
        ObservableList<Date> appointmentDates = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT * FROM appointments";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                Date date = cBResult.getDate("date");


                appointmentDates.add(date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentDates;
    }

    public static ObservableList<Timestamp> getAllAppointmentStartTimes() {
        ObservableList<Timestamp> appointmentStartTimes = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT Start FROM appointments";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                Timestamp Start = cBResult.getTimestamp("Start");

                appointmentStartTimes.add(Start);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentStartTimes;
    }
    public static ObservableList<LocalTime> getAllAppointmentEndTimes() {
        ObservableList<LocalTime> appointmentEndTimes = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT End FROM appointments";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                cBResult.getTimestamp("End").toLocalDateTime();
                LocalDateTime End = (java.time.LocalDateTime) cBResult.getObject("End");
                appointmentEndTimes.add(LocalTime.from(End));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentEndTimes;
    }


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

    public static void updateAppointment(Integer appointmentid, String title, String description, String location, String type,  LocalDateTime start, LocalDateTime end, int customerID, int user, int contact) throws SQLException {
        String sqlc = " UPDATE  appointments set ( appointmentid = ?, title = ?,description = ?,location = ?, type = ?, date = ?, startTime = ?, endTime = ?,now(),'nm',now(),'nm',customerid =?, userid = ?, contact =?)";
        PreparedStatement psCreate = connection.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
        psCreate.setInt(1, appointmentid);
        psCreate.setString(2, String.valueOf(title));
        psCreate.setString(3, String.valueOf(description));
        psCreate.setString(4, String.valueOf(location));
        psCreate.setString(5, String.valueOf(type));
        psCreate.setTimestamp(6, Timestamp.valueOf(start));
        psCreate.setTimestamp(6, Timestamp.valueOf(end));
        psCreate.setInt(9, customerID);
        psCreate.setInt(10, user);
        psCreate.setInt(11, contact);
        psCreate.execute();

    }
}



