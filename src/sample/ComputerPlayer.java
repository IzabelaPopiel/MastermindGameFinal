package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.util.*;

public class ComputerPlayer {

    private ResourceBundle resourceBundle  = ResourceBundle.getBundle("sample.language", new Locale("en"));
    private Locale locale;

    private HashMap<String, Button[]> btnMap = new HashMap<>();
    private int attemptsNumber;
    private AllPossibleSolutions possibleSolutions;
    private Colour[] colours = Colour.class.getEnumConstants();
    private Object[] answerLine;


    @FXML
    private ImageView plLang;

    @FXML
    private ImageView enLang;

    @FXML
    private Label lblHiddenRow;

    @FXML
    private Label lblAnswers;

    @FXML
    private Button btnGuess;

    @FXML
    private Button btnAns1;
    private Colour btnAns1Col;

    @FXML
    private Button btnAns2;
    private Colour btnAns2Col;

    @FXML
    private Button btnAns3;
    private Colour btnAns3Col;

    @FXML
    private Button btnAns4;
    private Colour btnAns4Col;

    @FXML
    private Button btnAtt11;

    @FXML
    private Button btnAtt12;

    @FXML
    private Button btnAtt13;

    @FXML
    private Button btnAtt14;

    @FXML
    private Button btnFeedBack11;

    @FXML
    private Button btnFeedBack13;

    @FXML
    private Button btnFeedBack12;

    @FXML
    private Button btnFeedBack14;

    @FXML
    private Button btnFeedBack21;

    @FXML
    private Button btnFeedBack23;

    @FXML
    private Button btnFeedBack22;

    @FXML
    private Button btnFeedBack24;

    @FXML
    private Button btnFeedBack31;

    @FXML
    private Button btnFeedBack33;

    @FXML
    private Button btnFeedBack32;

    @FXML
    private Button btnFeedBack34;

    @FXML
    private Button btnFeedBack41;

    @FXML
    private Button btnFeedBack43;

    @FXML
    private Button btnFeedBack42;

    @FXML
    private Button btnFeedBack44;

    @FXML
    private Button btnFeedBack51;

    @FXML
    private Button btnFeedBack53;

    @FXML
    private Button btnFeedBack52;

    @FXML
    private Button btnFeedBack54;

    @FXML
    private Button btnFeedBack61;

    @FXML
    private Button btnFeedBack63;

    @FXML
    private Button btnFeedBack62;

    @FXML
    private Button btnFeedBack64;

    @FXML
    private Button btnAtt21;

    @FXML
    private Button btnAtt22;

    @FXML
    private Button btnAtt23;

    @FXML
    private Button btnAtt24;

    @FXML
    private Button btnAtt31;

    @FXML
    private Button btnAtt32;

    @FXML
    private Button btnAtt33;

    @FXML
    private Button btnAtt34;

    @FXML
    private Button btnAtt41;

    @FXML
    private Button btnAtt42;

    @FXML
    private Button btnAtt43;

    @FXML
    private Button btnAtt44;

    @FXML
    private Button btnAtt51;

    @FXML
    private Button btnAtt52;

    @FXML
    private Button btnAtt53;

    @FXML
    private Button btnAtt54;

    @FXML
    private Button btnAtt61;

    @FXML
    private Button btnAtt62;

    @FXML
    private Button btnAtt63;

    @FXML
    private Button btnAtt64;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnAgain;


    public void initialize() {

        plLang.setImage((new Image(new File("pl_flag.png").toURI().toString())));
        enLang.setImage((new Image(new File("en_flag.png").toURI().toString())));

        possibleSolutions = new AllPossibleSolutions();
        possibleSolutions.heapPermutation(colours, colours.length, 4);
        attemptsNumber = 0;

        btnMap.put("Attempt1", new Button[]{btnAtt11, btnAtt12, btnAtt13, btnAtt14});
        btnMap.put("FeedBack1", new Button[]{btnFeedBack11, btnFeedBack12, btnFeedBack13, btnFeedBack14});
        btnMap.put("Attempt2", new Button[]{btnAtt21, btnAtt22, btnAtt23, btnAtt24});
        btnMap.put("FeedBack2", new Button[]{btnFeedBack21, btnFeedBack22, btnFeedBack23, btnFeedBack24});
        btnMap.put("Attempt3", new Button[]{btnAtt31, btnAtt32, btnAtt33, btnAtt34});
        btnMap.put("FeedBack3", new Button[]{btnFeedBack31, btnFeedBack32, btnFeedBack33, btnFeedBack34});
        btnMap.put("Attempt4", new Button[]{btnAtt41, btnAtt42, btnAtt43, btnAtt44});
        btnMap.put("FeedBack4", new Button[]{btnFeedBack41, btnFeedBack42, btnFeedBack43, btnFeedBack44});
        btnMap.put("Attempt5", new Button[]{btnAtt51, btnAtt52, btnAtt53, btnAtt54});
        btnMap.put("FeedBack5", new Button[]{btnFeedBack51, btnFeedBack52, btnFeedBack53, btnFeedBack54});
        btnMap.put("Attempt6", new Button[]{btnAtt61, btnAtt62, btnAtt63, btnAtt64});
        btnMap.put("FeedBack6", new Button[]{btnFeedBack61, btnFeedBack62, btnFeedBack63, btnFeedBack64});

        for (Map.Entry<String, Button[]> entry : btnMap.entrySet()) {
            for (Button button : entry.getValue()) {
                button.setStyle("-fx-background-color: transparent;");
                button.setMouseTransparent(false);
            }
        }

        lblAnswers.setVisible(false);
    }

    public void setBtnAns1Col(Colour btnAns1Col) {
        this.btnAns1Col = btnAns1Col;
    }

    public void setBtnAns2Col(Colour btnAns2Col) {
        this.btnAns2Col = btnAns2Col;
    }

    public void setBtnAns3Col(Colour btnAns3Col) {
        this.btnAns3Col = btnAns3Col;
    }

    public void setBtnAns4Col(Colour btnAns4Col) {
        this.btnAns4Col = btnAns4Col;
    }

    public Colour getBtnAns1Col() {
        return btnAns1Col;
    }

    public Colour getBtnAns2Col() {
        return btnAns2Col;
    }

    public Colour getBtnAns3Col() {
        return btnAns3Col;
    }

    public Colour getBtnAns4Col() {
        return btnAns4Col;
    }

    @FXML
    void btnAns1Pressed(ActionEvent event) {
        setBtnAns1Col(changeColour(btnAns1, btnAns1Col));
    }

    @FXML
    void btnAns2Pressed(ActionEvent event) {
        setBtnAns2Col(changeColour(btnAns2, btnAns2Col));
    }

    @FXML
    void btnAns3Pressed(ActionEvent event) {
        setBtnAns3Col(changeColour(btnAns3, btnAns3Col));
    }

    @FXML
    void btnAns4Pressed(ActionEvent event) {
        setBtnAns4Col(changeColour(btnAns4, btnAns4Col));
    }

    @FXML
    void btnGuessPressed(ActionEvent event) {

        if (attemptsNumber == 0) {
            answerLine = new Object[]{getBtnAns1Col(), getBtnAns2Col(), getBtnAns3Col(), getBtnAns4Col()};
            if (duplicateCheck(answerLine)) {
                Popup duplicatePopup = new Popup(resourceBundle.getString("strDuplicate"));
                return;
            } else {
                btnAns1.setMouseTransparent(true);
                btnAns2.setMouseTransparent(true);
                btnAns3.setMouseTransparent(true);
                btnAns4.setMouseTransparent(true);
            }
        }

        lblAnswers.setVisible(true);
        attemptsNumber++;
        Guess guess = new Guess(answerLine);
        Object[] randomGuess = possibleSolutions.randomSolution();
        guess.setResult(randomGuess);
        System.out.println("Attempt: " + attemptsNumber + " " + Arrays.asList(randomGuess));

        Button[] attemptButtons = btnMap.get("Attempt" + attemptsNumber);
        Button[] feedBackButtons = btnMap.get("FeedBack" + attemptsNumber);

        for (int i = 0; i < attemptButtons.length; i++) disp(attemptButtons[i], (Colour) randomGuess[i]);

        for (int i = 0; i < feedBackButtons.length; i++) {
            if (guess.getRightColours().contains(randomGuess[i]))
                feedBackButtons[i].setStyle("-fx-border-color: #000000; -fx-background-color: #ffffff");
            else feedBackButtons[i].setStyle("-fx-background-color: #939393");

            if (guess.getRightPosition()[i] != null) feedBackButtons[i].setStyle("-fx-background-color: #000000");
        }

        if (Arrays.asList(randomGuess).equals(Arrays.asList(answerLine))) {
            System.out.println("YAY!");
            btnGuess.setDisable(true);
            Popup winPopup = new Popup(resourceBundle.getString("strWin"));

        } else
            possibleSolutions.update(guess.getRightColours(), guess.getRightPosition(), guess.getWrongPosition(), guess.getWrongColours(), randomGuess);

    }

    @FXML
    void btnHelpPressed(ActionEvent event) { Popup helpPopup = new Popup(resourceBundle.getString("strInstructionsComp")); }

    @FXML
    void btnAgainPressed(ActionEvent event) {
        initialize();
        btnGuess.setDisable(false);
        btnAns1.setMouseTransparent(false);
        btnAns2.setMouseTransparent(false);
        btnAns3.setMouseTransparent(false);
        btnAns4.setMouseTransparent(false);
    }

    private Colour changeColour(Button btn, Object btnCol) {

        int index = Arrays.asList(colours).indexOf(btnCol);
        if (index == colours.length - 1) index = 0;
        else index++;

        Colour newColour = colours[index];
        disp(btn, newColour);
        return newColour;
    }

    private void disp(Button btn, Colour newCol) {
        switch (newCol) {
            case RED:
                btn.setStyle("-fx-background-color: #e23838");
                break;
            case ORANGE:
                btn.setStyle("-fx-background-color: #f79800");
                break;
            case YELLOW:
                btn.setStyle("-fx-background-color: #ffe500");
                break;
            case GREEN:
                btn.setStyle("-fx-background-color: #5ebd3e");
                break;
            case BLUE:
                btn.setStyle("-fx-background-color: #009cdf");
                break;
            case PURPLE:
                btn.setStyle("-fx-background-color: #973999");
                break;
        }
    }

    private boolean duplicateCheck(Object[] colours) {
        Set<Object> set = new HashSet<>(Arrays.asList(colours));
        if (set.size() != colours.length || set.contains(null)) return true;
        else return false;
    }


    @FXML
    void enPressed(MouseEvent event) { changeLanguage("en"); }

    @FXML
    void plPressed(MouseEvent event) { changeLanguage("pl"); }


    private void changeLanguage(String language) {
        locale = new Locale(language);
        resourceBundle = ResourceBundle.getBundle("sample.language", locale);
        lblHiddenRow.setText(resourceBundle.getString("lblHidRow"));
        lblAnswers.setText(resourceBundle.getString("lblAnsRow"));
        btnGuess.setText(resourceBundle.getString("btnGuess"));
        btnHelp.setText(resourceBundle.getString("btnHelp"));
        btnAgain.setText(resourceBundle.getString("btnAgain"));
    }
}


