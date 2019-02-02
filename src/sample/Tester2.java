package sample;

import java.util.Arrays;

public class Tester2 {
    public static void main(String[] args) {
        AllPossibleSolutions possibleSolutions = new AllPossibleSolutions();
        Object[] elements = new Object[]{Colour.YELLOW, Colour.ORANGE, Colour.PURPLE, Colour.BLUE, Colour.RED, Colour.GREEN};
        possibleSolutions.heapPermutation(elements, elements.length, 4);

        Object[] answerLine = new Object[]{Colour.ORANGE, Colour.PURPLE, Colour.GREEN, Colour.BLUE};
        Guess guess = new Guess(answerLine);

        boolean end = false;
        int counter = 0;

        while (!end) {
            Object[] randomGuess = possibleSolutions.randomGuess();
            System.out.println("New random guess: " + Arrays.asList(randomGuess));

            counter++;
            if (Arrays.asList(randomGuess).equals(Arrays.asList(answerLine))) {
                end = true;
                continue;
            }
            guess.setResult(randomGuess);

            System.out.println("Poporawne kolory: " + guess.getRightColours());
            System.out.println("Poporawne pozycje: " + Arrays.asList(guess.getRightPosition()));
            System.out.println("Niepoporawne pozycje: " + Arrays.asList(guess.getWrongPosition()));
            System.out.println("Niepoporawne kolory: " + guess.getWrongColours());

            possibleSolutions.update(guess.getRightColours(), guess.getRightPosition(), guess.getWrongPosition(), guess.getWrongColours(), randomGuess);

            System.out.println("Pozostałe możliwości");
            possibleSolutions.getSolutions().forEach(System.out::println);

        }
        System.out.println("YAY WIN!!!");
        System.out.println("Ilosc prob: " + counter);

    }
}
