/**
 * Controller window with player choose options.
 */
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


    /**
     *Represents ImageView with polish flag.
     */
    @FXML
    private ImageView plLang;
    /**
     *Represents ImageView with british flag.
     */
    @FXML
    private ImageView enLang;
    /**
     *Represents Label choose player.
     */
    @FXML
    private Label lblChoosePlayer;
    /**
     *Represents button choose human player.
     */
    @FXML
    private Button btnHuman;
    /**
     *Represents button choose computer player.
     */
    @FXML
    private Button btnComp;
    /**
     *Represents ImageView with computer image.
     */
    @FXML
    private ImageView imageViewComp;
    /**
     *Represents ImageView with human image.
     */
    @FXML
    private ImageView imageViewHuman;

    /**
     *Initialize method. Sets flag images in language change places. Sets images of computer and human in  proper places.
     */
    public void initialize() {
        imageViewComp.setImage(new Image(new File("computer.png").toURI().toString()));
        imageViewHuman.setImage(new Image(new File("human.png").toURI().toString()));
        plLang.setImage((new Image(new File("pl_flag.png").toURI().toString())));
        enLang.setImage((new Image(new File("en_flag.png").toURI().toString())));
    }

    /**
     *Shows new stage with computer player game version.
     */
    @FXML
    void btnCompPressed(ActionEvent event) {
        showNewStage("computerPlayer.fxml");
    }
    /**
     *Shows new stage with human player game version.
     */
    @FXML
    void btnHumanPressed(ActionEvent event) {
        showNewStage("humanPlayer.fxml");

    }
    /**
     *Shows new stage for input fxml file and closes current stage.
     * @param fxml fxml file source
     */
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

    /**
     *Changes language to english.
     */
    @FXML
    void enPressed(MouseEvent event) {
        changeLanguage("en");
    }
    /**
     *Changes language to polish.
     */
    @FXML
    void plPressed(MouseEvent event) {
        changeLanguage("pl");
    }

    /**
     *Changes language to chosen one. Sets all texts in application window on Strings from resource file.
     * @param language chosen language
     */
    private void changeLanguage(String language) {
        Locale locale = new Locale(language);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("sample.language", locale);
        lblChoosePlayer.setText(resourceBundle.getString("lblChoosePlayer"));
        btnComp.setText(resourceBundle.getString("btnComp"));
        btnHuman.setText(resourceBundle.getString("btnHum"));
    }
}
