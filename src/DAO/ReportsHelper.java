package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.DBConnection.connection;
/**
 * @author Nicole Mau
 *  Initializing ReportsHelper
 */

public class ReportsHelper {
    /**
     *
     * @return returns unique types of appointments from database
     */

    public static ObservableList<String> getReportsDataSortByType() {
        ObservableList<String> reportsDataSortByTypeList = FXCollections.observableArrayList();
        try {
            String sqlInquiryA = "SELECT DISTINCT Type from appointments ";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);
            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {



                String Type = aResult.getString("Type");

                    reportsDataSortByTypeList.add(Type);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByTypeList;
    }

    /**
     *
     * @return returns unique month of appointments from database
     */

    public static ObservableList<String> getReportsDataSortByMonth() {

        ObservableList<String> reportsDataSortByMonthList = FXCollections.observableArrayList();

        try {
            String sqlInquiryA = "SELECT  DISTINCT MONTHNAME(Start) as monthname from appointments ";
            PreparedStatement prepA = connection.prepareStatement(sqlInquiryA);

            ResultSet aResult = prepA.executeQuery();
            while (aResult.next()) {

                String startMonth = aResult.getString("monthname");


                     reportsDataSortByMonthList.add(startMonth);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reportsDataSortByMonthList;
    }

    /**
     *
     * @param month selected month
     * @param type selected type
     * @return returns appointment count by month and type selections
     * @throws SQLException if unable to retrieve a count it throws error
     */

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
