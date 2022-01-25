package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.security.SecureRandom;

public class Users {

    private static ObservableList<UserLogin> allUsers = FXCollections.observableArrayList();
    public static int uniqueUserID;


    public static int generateUserID(int uniqueUserID) {
        Users.uniqueUserID = uniqueUserID;
        uniqueUserID = (new SecureRandom().nextInt(9999999));
        return uniqueUserID;
    }

    public static void addUser(UserLogin newUser) {
        allUsers.add(newUser);
    }
}
