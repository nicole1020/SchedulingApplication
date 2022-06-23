package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import model.Reports;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.Month;


import static DAO.DBConnection.connection;


public class ReportsHelper {


    public static ObservableList<String> getReportsDataSortByType() {
        ObservableList<String> reportsDataSortByTypeList = FXCollections.observableArrayList();
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
                LocalDateTime Start = aResult.getTimestamp( "Start").toLocalDateTime();
                LocalDateTime End = aResult.getTimestamp("End").toLocalDateTime();
                int Customer_ID = aResult.getInt("Customer_ID");
                int User_ID = aResult.getInt("User_ID");
                    reportsDataSortByTypeList.add(Type);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByTypeList;
    }

    public static <Alert> ObservableList<Appointments> getReportsDataSortByMonth() {

        ObservableList<Appointments> reportsDataSortByMonthList = FXCollections.observableArrayList();

        try {
            String sqlInquiryA = "SELECT  DISTINCT appointments.Appointment_ID, Title, Description, Location, Type, Start, End, customers.Customer_ID, users.User_ID, contacts.Contact_ID FROM customers, appointments, contacts, users WHERE customers.Customer_ID = appointments.Customer_ID" +
                    " AND appointments.User_ID = users.User_ID AND appointments.Contact_ID = contacts.Contact_ID  ORDER BY MONTH(Start)";
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
                System.out.println("THIS HERE");

                Appointments aM = new Appointments(Appointment_ID, Title, Description, Location, Contact_ID, Type, Start, End, Customer_ID, User_ID);
                reportsDataSortByMonthList.add(aM);
                // System.out.println(ap);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByMonthList;
    }


    public static int getAppointmentCountByMonthAndType(String month, String type) throws SQLException {
        int count = 0;
        String sqlInquiryA = "SELECT COUNT(*) as cnt FROM appointments WHERE monthName(Start)= ? AND type=?";
        PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
        prepA.setString(1, month);
        prepA.setString(2, type);
        ResultSet aResult = prepA.executeQuery();
        while (aResult.next()) {
            count = aResult.getInt("cnt");
        }
        return count;
    }
}
