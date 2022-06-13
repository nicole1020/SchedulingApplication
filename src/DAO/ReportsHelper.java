package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;

import static DAO.DBConnection.connection;

public class ReportsHelper {

    public static ObservableList<String> getReportsDataSortByType(Month m) {
        ObservableList<String> reportsDataSortByMonthAndTypeList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, monthname(Start), End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID  ORDER by monthname(Start)";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            prepA.setTimestamp(1, Timestamp.from(Instant.from(m)));
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
               reportsDataSortByMonthAndTypeList.add(Type);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByMonthAndTypeList;
    }

    public static ObservableList<Appointments> getReportsDataSortByMonth() {

        ObservableList<Appointments> reportsDataSortByMonthList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT appointments.Appointment_ID, Title, Description, Location, Type, month(Start), End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID GROUP BY month(Start) ORDER BY month(Start)";
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
