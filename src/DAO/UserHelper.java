package DAO;

import model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

import static DAO.DBConnection.*;
/**
 * @author Nicole Mau
 *  Initializing UserHelperclass
 */

public class UserHelper {
    /**
     *
     * @return returns all userList from database
     */

    public static ObservableList<User> getAllUsers() {
        ObservableList<User> userList = FXCollections.observableArrayList();
        try {
            String sqlInquiry = "SELECT User_ID, User_Name, Password FROM users";

            PreparedStatement preps = connection.prepareStatement(sqlInquiry);
            ResultSet result = preps.executeQuery();
            while (result.next()) {
                int User_ID = result.getInt("User_ID");
                String User_Name = result.getString("User_Name");
                String Password = result.getString("Password");
                User ul = new User(User_ID, User_Name, Password);
                userList.add(ul);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    /**
     *
     * @param userName username entered for validation by database
     * @param passwordEntry username entered for validation by database
     * @return if username and password are in system it validates otherwise it prints stacktrace
     */

    public static User validateUser(String userName, String passwordEntry) {
        try{
        String sqlInquiry = "SELECT User_ID, User_Name FROM users WHERE User_Name = ? AND password = ?";

        PreparedStatement preps = connection.prepareStatement(sqlInquiry);
        preps.setString(1,userName);
        preps.setString(2, passwordEntry);
        ResultSet result = preps.executeQuery();
            while (result.next()) {
                int User_ID = result.getInt("User_ID");
                String User_Name = result.getString("User_Name");
                User ul = new User(User_ID, User_Name,"");
                return ul;
            }

    } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
