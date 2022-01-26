package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.security.SecureRandom;

public class Users {

    public static int uniqueUserID;


    public static int generateUserID() {
        Users.uniqueUserID = uniqueUserID;
        uniqueUserID = (new SecureRandom().nextInt(9999999));
        return uniqueUserID;
    }


}
