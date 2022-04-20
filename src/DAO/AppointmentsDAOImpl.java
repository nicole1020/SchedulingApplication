package DAO;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;

import static DAO.DBConnection.connection;

public class AppointmentsDAOImpl {
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
                String Start = aResult.getString("Start");
                String End = aResult.getString("End");
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
    //create new appointment


    public static void createAppointment(String title, String description, String location, String type, String date, String startTime, String endTime, int customerid, int user, int contact) {
        try {
            String sqlc = " INSERT INTO appointments VALUES (NULL, ?,?,?,?,?,?,now(),'nm',now(),'nm',?,?,?)";
            PreparedStatement psCreate = connection.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
            psCreate.setString(1, String.valueOf(title));
            psCreate.setString(2, String.valueOf(description));
            psCreate.setString(3, String.valueOf(location));
            psCreate.setString(4, String.valueOf(type));
            psCreate.setString(5, String.valueOf(date));
            psCreate.setString(6, String.valueOf(startTime));
            psCreate.setString(7, String.valueOf(endTime));
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
        psCreate.setString(6, String.valueOf(date));
        psCreate.setString(7, String.valueOf(startTime));
        psCreate.setString(8, String.valueOf(endTime));
        psCreate.setInt(9, customerID);
        psCreate.setInt(10, user);
        psCreate.setInt(11, contact);
        psCreate.execute();

    }
    public static ObservableList<Appointments> getAllAppointmentCustomerIDs() {
        ObservableList<Appointments> appointmentCustomerIDs = FXCollections.observableArrayList();
        try {
            String sqlcB = "SELECT * FROM appointments";
            PreparedStatement prepcB = connection.prepareStatement(sqlcB);
            ResultSet cBResult = prepcB.executeQuery();
            while (cBResult.next()) {
                Integer Customer_ID = cBResult.getInt("Customer_ID");
                Appointments aID = new Appointments(Customer_ID);

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
            String sqlAC = "SELECT Contact_ID, Contact_Name, email FROM contacts WHERE Contact_ID.contacts = Contact_ID.appointments";
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
}

