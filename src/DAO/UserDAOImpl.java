package DAO;

import Model.UserLogin;
import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl {

    public static ObservableList<UserLogin> getAllUsers() {
        ObservableList<UserLogin> userList = FXCollections.observableArrayList();
        try {
            String sqlInquiry = "SELECT User_ID, User_Name, Password FROM users";

            PreparedStatement preps = DBConnection.getConnection().prepareStatement(sqlInquiry);
            ResultSet result = preps.executeQuery();
            while(result.next()){
                int User_ID = result.getInt("User_ID");
                String User_Name = result.getString("User_Name");
                String Password = result.getString("Password");
                UserLogin U = new UserLogin(User_ID, User_Name, Password);
                userList.add(U);

            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }
}
