package Model;

import java.time.ZoneId;

public class User {
    private int userID;
    private String userName;
    private String password;
    private ZoneId userLocation;

    public User(int userID, String userName, String password, ZoneId userLocation) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.userLocation =userLocation;

    }
}