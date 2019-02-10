/**
 * Class comparing guess to answer and creating feedback information.
 */
package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guess {
    /**
     * Represents Object array with answer line.
     */
    private Object[] answerLine;
    /**
     * Represents Object array with colours on correct positions.
     */
    private Object[] rightPosition;
    /**
     * Represents Object array with colours on incorrect positions.
     */
    private Object[] wrongPosition;
    /**
     * Represents Object List with correct colours.
     */
    private List<Object> rightColours = new ArrayList<>();
    /**
     * Represents Object List with incorrect colours.
     */
    private List<Object> wrongColours = new ArrayList<>();

    /**
     * Creates new object of class Guess.
     * @param answerLine
     */
    public Guess(Object[] answerLine) {
        this.answerLine = answerLine;
        rightPosition = new Object[answerLine.length];
        wrongPosition = new Object[answerLine.length];
    }
    /**
     * Gets array with correct positions.
     */
    public Object[] getRightPosition() { return rightPosition; }
    /**
     * Gets array with incorrect positions.
     */
    public Object[] getWrongPosition() { return wrongPosition; }
    /**
     * Gets List with correct colours.
     */
    public List<Object> getRightColours() {
        return rightColours;
    }
    /**
     * Gets List with incorrect colours.
     */
    public List<Object> getWrongColours() {
        return wrongColours;
    }
    /**
     * Sets arrays and lists with results comparing guess line to answer line.
     */
    public void setResult(Object[] guessLine) {

        for (int i = 0; i < answerLine.length; i++) {
            if (guessLine[i].equals(answerLine[i])) {
                rightPosition[i] = guessLine[i];
            }

            if (!guessLine[i].equals(answerLine[i])) {
                wrongPosition[i] = guessLine[i];
            }
            if (Arrays.asList(answerLine).contains(guessLine[i])) {
                if (!rightColours.contains(guessLine[i]))
                    rightColours.add(guessLine[i]);
            } else {
                if (!wrongColours.contains(guessLine[i]))
                    wrongColours.add(guessLine[i]);
            }
        }
    }
}
