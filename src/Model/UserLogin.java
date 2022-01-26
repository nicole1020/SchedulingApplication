package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.ZoneId;

public class UserLogin {

    private int userID;
    private String userName;
    private String password;



    public UserLogin(int userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;


    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }




}