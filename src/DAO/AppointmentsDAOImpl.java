package DAO;

import Model.Appointments;
import Model.Customers;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;

import static DAO.DBConnection.connection;

public class AppointmentsDAOImpl {
    public static ObservableList <Appointments> getAllAppointments() {
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


    public static void createAppointment(String title, String description, String location, Appointments contact, Appointments type, LocalDate date, Appointments startTime, Appointments endTime, Customers customerid, User user) {
        try {
            String sqlc = " INSERT INTO appointments VALUES (NULL, ?,?,?,?,now(),'nm',now(),'nm',?)";
            PreparedStatement psCreate = connection.prepareStatement(sqlc, Statement.RETURN_GENERATED_KEYS);
            psCreate.setString(1, String.valueOf(title));
            psCreate.setString(2, String.valueOf(description));
            psCreate.setString(3, String.valueOf(location));
            psCreate.setString(4, String.valueOf(contact));
            psCreate.setInt(5, division);

            psCreate.execute();

        } catch (Exception e) {
            e.printStackTrace();//print stack trace

        }
    }
}