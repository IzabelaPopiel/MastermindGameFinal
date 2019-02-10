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

public class HumanPlayer {

    /**
     * Represents ResourceBundle which contains locale-specific resource with english language version as default.
     */
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("sample.language", new Locale("en"));
    /**
     * Represents Locale class object.
     */
    private Locale locale;

    /**
     * Represents HashMap of buttons used in application.
     */
    private HashMap<String, Button[]> btnMap = new HashMap<>();

    /**
     * Represents HashMap of buttons with hidden row.
     */
    private HashMap<Integer, Button> hiddenBtnMap = new HashMap<>();
    /**
     *Represents number of attempts.
     */
    private int attemptsNumber;
    /**
     *Represents object of class AllPossible solutions.
     */
    private AllPossibleSolutions possibleSolutions;
    /**
     *Represents array of all colours used in game.
     */
    private Colour[] colours = Colour.class.getEnumConstants();
    /**
     *Represents array containing answer line.
     */
    private Object[] answerLine;

    @FXML
    private ImageView plLang;
    /**
     *Represents ImageView with british flag.
     */
    @FXML
    private ImageView enLang;
    /**
     *Represents label 'Hidden row'.
     */
    @FXML
    private Label lblHiddenRow;
    /**
     *Represents label 'Your answer'.
     */
    @FXML
    private Label lblYourAnswer;
    /**
     *Represents button Check.
     */
    @FXML
    private Button btnCheck;
    /**
     *Represents help button.
     */
    @FXML
    private Button btnHelp;
    /**
     *Represents play again button.
     */
    @FXML
    private Button btnAgain;
    /**
     *Represents 1st hidden button
     */
    @FXML
    private Button btnHid1;
    /**
     *Represents 2nd hidden button
     */
    @FXML
    private Button btnHid2;
    /**
     *Represents 3rd hidden button
     */
    @FXML
    private Button btnHid3;
    /**
     *Represents 4th hidden button
     */
    @FXML
    private Button btnHid4;

    /**
     *Represents 1st button in answer.
     */
    @FXML
    private Button btnAns1;
    /**
     *Represents colour of 1st button in answer.
     */
    private Colour btnAns1Col;
    /**
     *Represents 2nd button in answer.
     */
    @FXML
    private Button btnAns2;
    /**
     *Represents colour of 2nd button in answer.
     */
    private Colour btnAns2Col;
    /**
     *Represents 3rd button in answer.
     */
    @FXML
    private Button btnAns3;
    /**
     *Represents colour of 3rd button in answer.
     */
    private Colour btnAns3Col;
    /**
     *Represents 4th button in answer.
     */
    @FXML
    private Button btnAns4;
    /**
     *Represents colour of 4th button in answer.
     */
    private Colour btnAns4Col;

    /**
     *Represents label 'Answers'.
     */
    @FXML
    private Label lblAnswers;


    /**
     *Represents 1st button in answer in 1st attempt.
     */
    @FXML
    private Button btnAtt11;
    /**
     *Represents 2nd button in answer in 1st attempt.
     */
    @FXML
    private Button btnAtt12;
    /**
     *Represents 3rd button in answer in 1st attempt.
     */
    @FXML
    private Button btnAtt13;
    /**
     *Represents 4th button in answer in 1st attempt.
     */
    @FXML
    private Button btnAtt14;
    /**
     *Represents 1st feedback button in answer in 1st attempt.
     */
    @FXML
    private Button btnFeedBack11;
    /**
     *Represents 3rd feedback button in answer in 1st attempt.
     */
    @FXML
    private Button btnFeedBack13;
    /**
     *Represents 2nd feedback button in answer in 1st attempt.
     */
    @FXML
    private Button btnFeedBack12;
    /**
     *Represents 4th feedback button in answer in 1st attempt.
     */
    @FXML
    private Button btnFeedBack14;
    /**
     *Represents 1st feedback button in answer in 2nd attempt.
     */
    @FXML
    private Button btnFeedBack21;
    /**
     *Represents 3rd feedback button in answer in 2nd attempt.
     */
    @FXML
    private Button btnFeedBack23;
    /**
     *Represents 2nd feedback button in answer in 2nd attempt.
     */
    @FXML
    private Button btnFeedBack22;
    /**
     *Represents 4th feedback button in answer in 2nd attempt.
     */
    @FXML
    private Button btnFeedBack24;
    /**
     *Represents 1st feedback button in answer in 3rd attempt.
     */
    @FXML
    private Button btnFeedBack31;
    /**
     *Represents 3rd feedback button in answer in 3rd attempt.
     */
    @FXML
    private Button btnFeedBack33;
    /**
     *Represents 2nd feedback button in answer in 3rd attempt.
     */
    @FXML
    private Button btnFeedBack32;
    /**
     *Represents 4th feedback button in answer in 3rd attempt.
     */
    @FXML
    private Button btnFeedBack34;
    /**
     *Represents 1st feedback button in answer in 4th attempt.
     */
    @FXML
    private Button btnFeedBack41;
    /**
     *Represents 3rd feedback button in answer in 4th attempt.
     */
    @FXML
    private Button btnFeedBack43;
    /**
     *Represents 2nd feedback button in answer in 4th attempt.
     */
    @FXML
    private Button btnFeedBack42;
    /**
     *Represents 4th feedback button in answer in 4th attempt.
     */
    @FXML
    private Button btnFeedBack44;
    /**
     *Represents 1st feedback button in answer in 5th attempt.
     */
    @FXML
    private Button btnFeedBack51;
    /**
     *Represents 3rd feedback button in answer in 5th attempt.
     */
    @FXML
    private Button btnFeedBack53;
    /**
     *Represents 2nd feedback button in answer in 5th attempt.
     */
    @FXML
    private Button btnFeedBack52;
    /**
     *Represents 4th feedback button in answer in 5th attempt.
     */
    @FXML
    private Button btnFeedBack54;
    /**
     *Represents 1st feedback button in answer in 6th attempt.
     */
    @FXML
    private Button btnFeedBack61;
    /**
     *Represents 3rd feedback button in answer in 6th attempt.
     */
    @FXML
    private Button btnFeedBack63;
    /**
     *Represents 2nd feedback button in answer in 6th attempt.
     */
    @FXML
    private Button btnFeedBack62;
    /**
     *Represents 4th feedback button in answer in 6th attempt.
     */
    @FXML
    private Button btnFeedBack64;
    /**
     *Represents 1st button in answer in 2nd attempt.
     */
    @FXML
    private Button btnAtt21;
    /**
     *Represents 2nd button in answer in 2nd attempt.
     */
    @FXML
    private Button btnAtt22;
    /**
     *Represents 3rd button in answer in 2nd attempt.
     */
    @FXML
    private Button btnAtt23;
    /**
     *Represents 4th button in answer in 2nd attempt.
     */
    @FXML
    private Button btnAtt24;
    /**
     *Represents 1st button in answer in 3rd attempt.
     */
    @FXML
    private Button btnAtt31;
    /**
     *Represents 2nd button in answer in 3rd attempt.
     */
    @FXML
    private Button btnAtt32;
    /**
     *Represents 3rd button in answer in 3rd attempt.
     */
    @FXML
    private Button btnAtt33;
    /**
     *Represents 4th button in answer in 3rd attempt.
     */
    @FXML
    private Button btnAtt34;
    /**
     *Represents 1st button in answer in 4th attempt.
     */
    @FXML
    private Button btnAtt41;
    /**
     *Represents 2nd button in answer in 4th attempt.
     */
    @FXML
    private Button btnAtt42;
    /**
     *Represents 3rd button in answer in 4th attempt.
     */
    @FXML
    private Button btnAtt43;
    /**
     *Represents 4th button in answer in 4th attempt.
     */
    @FXML
    private Button btnAtt44;
    /**
     *Represents 1st button in answer in 5th attempt.
     */
    @FXML
    private Button btnAtt51;
    /**
     *Represents 2nd button in answer in 5th attempt.
     */
    @FXML
    private Button btnAtt52;
    /**
     *Represents 3rd button in answer in 5th attempt.
     */
    @FXML
    private Button btnAtt53;
    /**
     *Represents 4th button in answer in 5th attempt.
     */
    @FXML
    private Button btnAtt54;
    /**
     *Represents 1st button in answer in 6th attempt.
     */
    @FXML
    private Button btnAtt61;
    /**
     *Represents 2nd button in answer in 6th attempt.
     */
    @FXML
    private Button btnAtt62;
    /**
     *Represents 3rd button in answer in 6th attempt.
     */
    @FXML
    private Button btnAtt63;
    /**
     *Represents 4th button in answer in 6th attempt.
     */
    @FXML
    private Button btnAtt64;


    /**
     *Sets colour of 1st button in answer.
     */
    public void setBtnAns1Col(Colour btnAns1Col) {
        this.btnAns1Col = btnAns1Col;
    }
    /**
     *Sets colour of 2nd button in answer.
     */
    public void setBtnAns2Col(Colour btnAns2Col) {
        this.btnAns2Col = btnAns2Col;
    }
    /**
     *Sets colour of 3rd button in answer.
     */
    public void setBtnAns3Col(Colour btnAns3Col) {
        this.btnAns3Col = btnAns3Col;
    }
    /**
     *Sets colour of 4th button in answer.
     */
    public void setBtnAns4Col(Colour btnAns4Col) {
        this.btnAns4Col = btnAns4Col;
    }
    /**
     *Gets colour of 1st button in answer.
     */
    public Colour getBtnAns1Col() {
        return btnAns1Col;
    }
    /**
     *Gets colour of 2nd button in answer.
     */
    public Colour getBtnAns2Col() {
        return btnAns2Col;
    }
    /**
     *Gets colour of 3rd button in answer.
     */
    public Colour getBtnAns3Col() {
        return btnAns3Col;
    }
    /**
     *Gets colour of 4th button in answer.
     */
    public Colour getBtnAns4Col() {
        return btnAns4Col;
    }

    /**
     *Initialize method. Sets flag images in  language change places. Creates new AllPossibleSolutions object, call method heapPermutation() to create new set of all solutions. Sets number of attempts on zero. Puts buttons into HashMap. Makes all answer history and feedback buttons transparent. Hides buttons in hidden row.
     */
    public void initialize() {

        plLang.setImage((new Image(new File("pl_flag.png").toURI().toString())));
        enLang.setImage((new Image(new File("en_flag.png").toURI().toString())));

        possibleSolutions = new AllPossibleSolutions();
        possibleSolutions.heapPermutation(colours, colours.length, 4);
        attemptsNumber = 0;

        btnAns1.setMouseTransparent(false);
        btnAns2.setMouseTransparent(false);
        btnAns3.setMouseTransparent(false);
        btnAns4.setMouseTransparent(false);

        lblAnswers.setVisible(false);

        hiddenBtnMap.put(1, btnHid1);
        hiddenBtnMap.put(2, btnHid2);
        hiddenBtnMap.put(3, btnHid3);
        hiddenBtnMap.put(4, btnHid4);

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

        btnHid1.setMouseTransparent(true);
        btnHid2.setMouseTransparent(true);
        btnHid3.setMouseTransparent(true);
        btnHid4.setMouseTransparent(true);


        for (Map.Entry<String, Button[]> entry : btnMap.entrySet()) {
            for (Button button : entry.getValue()) {
                button.setMouseTransparent(true);
                button.setStyle("-fx-background-color: transparent");
            }
        }
        answerLine = possibleSolutions.randomSolution();

        for (int i = 1; i <= hiddenBtnMap.size(); i++) {
            hiddenBtnMap.get(i).setStyle("-fx-background-color: #939393");
        }
    }

    /**
     *Recall colour changing method on 1st button in answer click.
     */
    @FXML
    void btnAns1Pressed(ActionEvent event) {
        setBtnAns1Col(changeColour(btnAns1, btnAns1Col));
    }
    /**
     *Recall colour changing method on 2nd button in answer click.
     */
    @FXML
    void btnAns2Pressed(ActionEvent event) {
        setBtnAns2Col(changeColour(btnAns2, btnAns2Col));
    }
    /**
     *Recall colour changing method on 3rd button in answer click.
     */
    @FXML
    void btnAns3Pressed(ActionEvent event) {
        setBtnAns3Col(changeColour(btnAns3, btnAns3Col));
    }
    /**
     *Recall colour changing method on 4th button in answer click.
     */
    @FXML
    void btnAns4Pressed(ActionEvent event) {
        setBtnAns4Col(changeColour(btnAns4, btnAns4Col));
    }

    /**
     *Method recalled on button Check click. If colours in answer are duplicated new info Popup appears. If it is 6 attempt and its not correct new Popup with loose info appears. Attempt is compared to hidden row. New guess in history and feedback buttons appear in window. If new guess and answer are the same then new Popup with win info appears.
     */
    @FXML
    void btnCheckPressed(ActionEvent event) {

        if (attemptsNumber == 0) lblAnswers.setVisible(true);

        Object[] guessLine = new Object[]{getBtnAns1Col(), getBtnAns2Col(), getBtnAns3Col(), getBtnAns4Col()};

        if (duplicateCheck(guessLine)) {
            Popup duplicatePopup = new Popup(resourceBundle.getString("strDuplicate"));
            return;
        }
        attemptsNumber++;
        if (attemptsNumber > 6) {
            Popup loosePopup = new Popup(resourceBundle.getString("strOver"));
            return;
        }
        Guess guess = new Guess(answerLine);
        guess.setResult(guessLine);
        System.out.println("Attempt: " + attemptsNumber + " " + Arrays.asList(guessLine));

        Button[] feedBackButtons = btnMap.get("FeedBack" + attemptsNumber);

        for (int i = 0; i < feedBackButtons.length; i++) {
            if (guess.getRightColours().contains(guessLine[i]))
                feedBackButtons[i].setStyle("-fx-border-color: #000000; -fx-background-color: #ffffff");
            else feedBackButtons[i].setStyle("-fx-background-color: #939393");

            if (guess.getRightPosition()[i] != null) feedBackButtons[i].setStyle("-fx-background-color: #000000");
        }

        if (Arrays.asList(guessLine).equals(Arrays.asList(answerLine))) {
            showHiddenRow();
            System.out.println("YAY!");
            btnCheck.setDisable(true);
            Popup winPopup = new Popup(resourceBundle.getString("strWin"));
        }

        Button[] attemptButtons = btnMap.get("Attempt" + attemptsNumber);
        for (int i = 0; i < attemptButtons.length; i++) disp(attemptButtons[i], (Colour) guessLine[i]);
    }

    /**
     * Atfer pressing help button appears new Popup with help information.
     */
    @FXML
    void btnHelpPressed(ActionEvent event) {
        Popup helpPopup = new Popup(resourceBundle.getString("strInstructionsHum"));
    }

    /**
     * Initialize contoller one more time. Enables Check button.
     */
    @FXML
    void btnAgainPressed(ActionEvent event) {
        initialize();
        btnCheck.setDisable(false);
    }

    /**
     * Changes colour of button.
     *
     * @param btn    button
     * @param btnCol colour of button
     * @return newColour - new colour of button
     */
    private Colour changeColour(Button btn, Colour btnCol) {

        int index = Arrays.asList(colours).indexOf(btnCol);
        if (index == colours.length - 1) index = 0;
        else index++;

        Colour newColour = colours[index];
        disp(btn, newColour);
        return newColour;
    }

    /**
     * Displays new button colour.
     */
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

    /**
     * Checks if colours in array are duplicated.
     *
     * @return false if colours are unique
     */
    private boolean duplicateCheck(Object[] colours) {
        Set<Object> set = new HashSet<>(Arrays.asList(colours));
        if (set.size() != colours.length || set.contains(null)) return true;
        else return false;
    }

    /**
     * Shows colours of hidden row
     */
    private void showHiddenRow() {
        for (int i = 1; i <= answerLine.length; i++) {
            disp(hiddenBtnMap.get(i), (Colour) answerLine[i - 1]);
        }
    }

    /**
     * Changes language to english.
     */
    @FXML
    void enPressed(MouseEvent event) {
        changeLanguage("en");
    }

    /**
     * Changes language to polish.
     */
    @FXML
    void plPressed(MouseEvent event) {
        changeLanguage("pl");
    }

    /**
     * Changes language to chosen one. Sets all texts in application window on Strings from resource file.
     *
     * @param language chosen language
     */
    private void changeLanguage(String language) {
        locale = new Locale(language);
        resourceBundle = ResourceBundle.getBundle("sample.language", locale);
        lblHiddenRow.setText(resourceBundle.getString("lblHidRow"));
        lblYourAnswer.setText(resourceBundle.getString("lblYourAnsRow"));
        lblAnswers.setText(resourceBundle.getString("lblAnsHis"));
        btnCheck.setText(resourceBundle.getString("btnCheck"));
        btnHelp.setText(resourceBundle.getString("btnHelp"));
        btnAgain.setText(resourceBundle.getString("btnAgain"));
    }
}


