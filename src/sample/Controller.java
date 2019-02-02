package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Arrays;

public class Controller {

    private AllPossibleSolutions possibleSolutions ;
  private   Object[] elements ;

    private Colour[] colurs = new Colour[]{Colour.RED, Colour.ORANGE, Colour.YELLOW, Colour.GREEN, Colour.BLUE, Colour.PURPLE};

    Object[] answerLine;

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
    private Button btnOK;


    public void initialize() {
         possibleSolutions = new AllPossibleSolutions();
        elements = new Object[]{Colour.YELLOW, Colour.ORANGE, Colour.PURPLE, Colour.BLUE, Colour.RED, Colour.GREEN};
        possibleSolutions.heapPermutation(elements, elements.length, 4);

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
        Guess guess = new Guess(answerLine);
        Object[] randomGuess = possibleSolutions.randomGuess();



    }

    @FXML
    void btnOKPressed(ActionEvent event) {
        answerLine = new Object[]{getBtnAns1Col(), getBtnAns2Col(), getBtnAns3Col(), getBtnAns4Col()};

    }

    public Colour changeColour(Button btn, Colour btnCol) {

        int index = Arrays.asList(colurs).indexOf(btnCol);
        if (index == colurs.length - 1) index = 0;
        else index++;

        Colour newColour = colurs[index];

        disp(btn, newColour);

        return newColour;
    }

    void disp(Button btn, Colour newCol){
        switch (newCol) {
            case RED:
                btn.setStyle("-fx-background-color: red");
                break;
            case ORANGE:
                btn.setStyle("-fx-background-color: orange");
                break;
            case YELLOW:
                btn.setStyle("-fx-background-color: yellow");
                break;
            case GREEN:
                btn.setStyle("-fx-background-color: green");
                break;
            case BLUE:
                btn.setStyle("-fx-background-color: blue");
                break;

            case PURPLE:
                btn.setStyle("-fx-background-color: purple");
                break;
        }

    }
}


