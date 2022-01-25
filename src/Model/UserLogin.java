package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.ZoneId;

public class UserLogin {

    private int userID;
    private String userName;
    private String password;
    private ZoneId userLocation;


    public UserLogin(int userID, String userName, String password, ZoneId userLocation) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.userLocation =userLocation;

    }


    public int getUserID() {
        return userID;
    }


    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ZoneId getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(ZoneId userLocation) {
        this.userLocation = userLocation;
    }
}