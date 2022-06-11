package model;

import javafx.collections.SetChangeListener;

import java.util.logging.LogRecord;

public class User {

    private int userID;
    private String userName;
    private String password;
private LogRecord loginRecord;


    public User(int userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;


    }

    public User(LogRecord loginRecord) {
        this.loginRecord= loginRecord;
    }

    public int getUserID() {
        return userID;
    }

    public LogRecord getLoginRecord() {
        return loginRecord;

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

public String toString(){
        return String.valueOf((userName));
}



}