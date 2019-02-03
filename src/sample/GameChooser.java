package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class GameChooser {


    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnHuman;

    @FXML
    private Button btnComp;

    @FXML
    private ImageView imageViewComp;

    @FXML
    private ImageView imageViewHuman;

    public void initialize() {
        imageViewComp.setImage(new Image(new File("computer.png").toURI().toString()));
        imageViewHuman.setImage(new Image(new File("human.png").toURI().toString()));

    }

    @FXML
    void btnCompPressed(ActionEvent event) {
       showNewStage("computerPlayer.fxml");
    }

    @FXML
    void btnHumanPressed(ActionEvent event) {
        showNewStage("humanPlayer.fxml");

    }

    private void showNewStage(String fxml){
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("humanPlayer.fxml"));
            primaryStage.setTitle("Mastermind game");
            primaryStage.setScene(new Scene(root, 300, 550));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Stage) btnHuman.getScene().getWindow()).close();

    }

}
