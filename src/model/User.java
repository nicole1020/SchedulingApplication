package model;

import javafx.collections.SetChangeListener;

import java.util.logging.LogRecord;
/**
 *
 * @author Nicole Mau
 *  Initializing User Class
 */

public class User {

    private int userID;
    private String userName;
    private String password;
private LogRecord loginRecord;

    /**
     *
     * @param userID  userid  user
     * @param userName username of user
     * @param password  password of user
     */
    public User(int userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;


    }

    /**
     *
     * @return userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @return username of user
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @return password of user
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return userName to populate as a string instead of database location
     */
    public String toString(){
        return String.valueOf((userName));
}



}