package Model;

public class User {

    private int userID;
    private String userName;
    private String password;



    public User(int userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;


    }

    public User(String  user_name) {
        this.userName= user_name;
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

public String toString(){
        return String.valueOf((userName));
}


}