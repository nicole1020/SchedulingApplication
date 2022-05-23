package DAO;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Map;

import static DAO.DBConnection.connection;

public class AppointmentsHelperFile {

    private static Object LocalDateTime;
    private static Calendar calendar;

    public static ObservableList<Appointments> getAllAppointments() {
        ObservableList<Appointments> appointmentsList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT Appointment_ID, Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID\n" +
                    "FROM appointments";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {
                int Appointment_ID = aResult.getInt("Appointment_ID");
                String Title = aResult.getString("Title");
                String Description = aResult.getString("Description");
                String Location = aResult.getString("Location");
                int Contact_ID = aResult.getInt("Contact_ID");
                String Type = aResult.getString("Type");
                LocalDateTime Start = (java.time.LocalDateTime) aResult.getObject("Start");
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


    public static void createAppointment(String title, String description, String location, String type, LocalDateTime date, LocalDateTime startTime, LocalDateTime endTime, int customerid, int user, int contact) {
        try {
            String sqlc = " INSERT INTO appointments VALUES (NULL, ?,?,?,?,?,?,now(),'nm',now(),'nm',?,?,?)";
            PreparedStatement psCreate = connection.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
            psCreate.setString(1, String.valueOf(title));
            psCreate.setString(2, String.valueOf(description));
            psCreate.setString(3, String.valueOf(location));
            psCreate.setString(4, String.valueOf(type));
            psCreate.setDate(5, Date.valueOf(String.valueOf(date)), calendar);
            psCreate.setObject(6, startTime);
            psCreate.setObject(7, endTime);
            psCreate.setInt(8, customerid);
            psCreate.setInt(9, user);
            psCreate.setInt(10, contact);

            psCreate.execute();

        } catch (Exception e) {
            e.printStackTrace();//print stack trace

        }
    }

    public static void updateAppointment(Integer appointmentid, String title, String description, String location, Appointments type, String date, String startTime, String endTime, int customerID, int user, int contact) throws SQLException {
        String sqlc = " UPDATE  appointments set ( appointmentid = ?, title = ?,description = ?,location = ?, type = ?, date = ?, startTime = ?, endTime = ?,now(),'nm',now(),'nm',customerid =?, userid = ?, contact =?)";
        PreparedStatement psCreate = connection.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
        psCreate.setInt(1, appointmentid);
        psCreate.setString(2, String.valueOf(title));
        psCreate.setString(3, String.valueOf(description));
        psCreate.setString(4, String.valueOf(location));
        psCreate.setString(5, String.valueOf(type));
        psCreate.setDate(6, Date.valueOf(String.valueOf(date)));
        psCreate.setObject(7, String.valueOf(startTime));
        psCreate.setObject(8, String.valueOf(endTime));
        psCreate.setInt(9, customerID);
        psCreate.setInt(10, user);
        psCreate.setInt(11, contact);
        psCreate.execute();

    }
    public static ObservableList<CustomerIDsAppointments> getAllAppointmentCustomerIDs() {
        ObservableList<CustomerIDsAppointments> appointmentCustomerIDs = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT * FROM customers";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                Integer Customer_ID = cBResult.getInt("Customer_ID");
                CustomerIDsAppointments aID = new CustomerIDsAppointments(Customer_ID);

                appointmentCustomerIDs.add(aID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentCustomerIDs;
    }
    public static ObservableList<Appointments> getAllAppointmentTypes() {
        ObservableList<Appointments> appointmentTypes = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT * FROM appointments";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                String type = cBResult.getString("type");
                Appointments aT = new Appointments(type);

                appointmentTypes.add(aT);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentTypes;
    }
    public static ObservableList<Appointments> getAllAppointmentDates() {
        ObservableList<Appointments> appointmentDates = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT * FROM appointments";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                String date = cBResult.getString("date");
                Appointments aD = new Appointments(date);

                appointmentDates.add(aD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentDates;
    }

    public static ObservableList<User> getAllAppointmentUserIds() {
        ObservableList<User> appointmentUserID = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT * FROM appointments";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                Integer User_ID = cBResult.getInt("User_ID");
                User aU = new User(User_ID);

                appointmentUserID.add(aU);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentUserID;
    }


    public static ObservableList<Contacts> getAllAppointmentContacts() {
        ObservableList<Contacts> appointmentContacts = FXCollections.observableArrayList();
        try {
            String sqlAC = "SELECT * FROM contacts";
            PreparedStatement prepAC = connection.prepareStatement(sqlAC);
            ResultSet ACResult = prepAC.executeQuery();
            while (ACResult.next()) {
                Integer Contact_ID = ACResult.getInt("Contact_ID");
                String Contact_Name = ACResult.getString("Contact_Name");
                String email = ACResult.getString("email");
                Contacts aC = new Contacts(Contact_ID,Contact_Name, email);


                appointmentContacts.add(aC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentContacts;
    }

    public static ObservableList<Appointments> getAllAppointmentStartTimes() {
        ObservableList<Appointments> appointmentStartTimes = FXCollections.observableArrayList();
        try {
            String sqlAST = "SELECT * from appointments";
            PreparedStatement prepAST = connection.prepareStatement(sqlAST);
            ResultSet ASTResult = prepAST.executeQuery();
            while (ASTResult.next()) {
                String start = ASTResult.getString("start");


                Appointments aC = new Appointments(start);


                appointmentStartTimes.add(aC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentStartTimes;
    }

    public static ObservableList<Appointments> getAllAppointmentEndTimes() {

            ObservableList<Appointments> appointmentEndTimes = FXCollections.observableArrayList();
            try {
                String sqlAE = "SELECT * from appointments";
                PreparedStatement prepAE = connection.prepareStatement(sqlAE);
                ResultSet AEResult = prepAE.executeQuery();
                while (AEResult.next()) {
                    String end = AEResult.getString("End");
                    Appointments aE = new Appointments(end);
                    appointmentEndTimes.add(aE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return appointmentEndTimes;
        }


}


