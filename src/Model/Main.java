package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
public Main(){}
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = (Parent)FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/View.sample.fxml")));
        primaryStage.setTitle(" ");
        primaryStage.setScene(new Scene(root, 800, 1275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
