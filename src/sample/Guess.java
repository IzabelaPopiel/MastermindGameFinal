package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guess {

    private Object[] answerLine;
    private Object[] rightPosition = new Object[4];
    private Object[] wrongPosition = new Object[4];
    private List<Object> rightColours = new ArrayList<>();
    private List<Object> wrongColours = new ArrayList<>();

    public Guess(Object[] answerLine) {
        this.answerLine = answerLine;
    }

    public Object[] getRightPosition() {
        return rightPosition;
    }

    public Object[] getWrongPosition() {
        return wrongPosition;
    }

    public List<Object> getRightColours() {
        return rightColours;
    }

    public List<Object> getWrongColours() {
        return wrongColours;
    }

    public void setResult(Object[] guessLine) {

        for (int i = 0; i < answerLine.length; i++) {
            if(guessLine[i].equals(answerLine[i])){
                rightPosition[i] = guessLine[i];
            }

            if(!guessLine[i].equals(answerLine[i])){
                wrongPosition[i] = guessLine[i];
            }
            if(Arrays.asList(answerLine).contains(guessLine[i])){
                if(!rightColours.contains(guessLine[i]))
                rightColours.add(guessLine[i]);
            }
            else {
                if(!wrongColours.contains(guessLine[i]))
                    wrongColours.add(guessLine[i]);
            }
        }
    }
}
