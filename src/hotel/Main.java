package hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws IOException {

        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../viewFX/checkin.fxml"));
        primaryStage.setScene(new Scene(root,1000,600));
        primaryStage.setTitle("Hotel");
        primaryStage.show();



    }
}
