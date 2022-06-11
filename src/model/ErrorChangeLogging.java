package model;

import controller.UserLoginController;
import javafx.collections.SetChangeListener;

public class ErrorChangeLogging<E> implements SetChangeListener<E> {

private UserLoginController validateUserLog;
public ErrorChangeLogging(UserLoginController validateUserLog){
    super();
    this.validateUserLog = validateUserLog;
}

    @Override
    public void onChanged(Change<? extends E> change) {
        try {
            this.validateUserLog.UserLoginController(change);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}