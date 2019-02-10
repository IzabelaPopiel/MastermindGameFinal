/**
 * Class launching application.
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Displays new stage with user interface defined in fxml file.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gameChooser.fxml"));
        primaryStage.setTitle("Mastermind game");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    /**
     * Launches application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
