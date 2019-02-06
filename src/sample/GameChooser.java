package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameChooser {

    private ResourceBundle resourceBundle;
    private Locale locale;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView plLang;

    @FXML
    private ImageView enLang;

    @FXML
    private Label lblChoosePlayer;

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
        plLang.setImage((new Image(new File("pl_flag.png").toURI().toString())));
        enLang.setImage((new Image(new File("en_flag.png").toURI().toString())));
    }

    @FXML
    void btnCompPressed(ActionEvent event) {
        showNewStage("computerPlayer.fxml");
    }

    @FXML
    void btnHumanPressed(ActionEvent event) {
        showNewStage("humanPlayer.fxml");

    }

    private void showNewStage(String fxml) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            primaryStage.setTitle("Mastermind game");
            primaryStage.setScene(new Scene(root, 300, 550));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Stage) btnHuman.getScene().getWindow()).close();

    }

    @FXML
    void enPressed(MouseEvent event) {
        changeLanguage("en");
    }

    @FXML
    void plPressed(MouseEvent event) { changeLanguage("pl"); }

    private void changeLanguage(String language) {
        locale = new Locale(language);
        resourceBundle = ResourceBundle.getBundle("sample.language", locale);
        lblChoosePlayer.setText(resourceBundle.getString("lblChoosePlayer"));
        btnComp.setText(resourceBundle.getString("btnComp"));
        btnHuman.setText(resourceBundle.getString("btnHum"));
    }


}
