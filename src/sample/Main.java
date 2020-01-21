package sample;

import org.graalvm.compiler.phases.common.NodeCounterPhase.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application
{
    @Override
    public void start(Stage login)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
            login.setTitle("Optimal Lift");
            Scene scene = new Scene(root, 400,400);
            scene.getStylesheets().add(getClass().getResource("sample.fxml").toExternalForm());
            login.setScene(scene);
            login.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

