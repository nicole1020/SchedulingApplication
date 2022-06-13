package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import model.Contacts;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static DAO.DBConnection.connection;

public class AppointmentsHelper {


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


    public static ObservableList<LocalDateTime> getAllAppointmentStartTimes() {
        ObservableList<LocalDateTime> appointmentStartTimes = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT Start FROM appointments; " ;


            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                LocalDateTime Start = cBResult.getTimestamp("Start").toLocalDateTime();

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
                LocalDateTime End = cBResult.getTimestamp("End").toLocalDateTime();
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

    public static void updateAppointment(Integer appointmentid, String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, int customerID, int user, int contact) throws SQLException {
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


    public static ObservableList<Appointments> getReportsDataSortByType(boolean contains) {
        ObservableList<Appointments> reportsDataSortByMonthAndTypeList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, Start, End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID ";
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
                reportsDataSortByMonthAndTypeList.add(ap);
                //System.out.println(ap);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByMonthAndTypeList;
    }

    public static ObservableList<Appointments> getReportsDataSortByMonth() {

        ObservableList<Appointments> reportsDataSortByMonthList = FXCollections.observableArrayList();
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
                System.out.println("THIS HERE"+ap);
                reportsDataSortByMonthList.add(ap);
               // System.out.println(ap);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByMonthList;
    }

}





