package model;

import controller.UserLoginController;
import javafx.collections.SetChangeListener;

public class ErrorChangeLogging<E> implements SetChangeListener<E> {
    private UserLoginController writeLoginActivity;
public ErrorChangeLogging(UserLoginController validateUserLog){
    super();

}

    @Override
    public void onChanged(Change<? extends E> change) {
        try {
            this.writeLoginActivity.writeLoginActivity(change);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}