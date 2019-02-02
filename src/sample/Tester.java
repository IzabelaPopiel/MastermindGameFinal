package sample;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void main(String[] args) {

        AllPossibleSolutions possibleSolutions = new AllPossibleSolutions();
        Object[] elements = new Object[]{Colour.YELLOW, Colour.ORANGE, Colour.PURPLE, Colour.BLUE, Colour.RED, Colour.GREEN};
        possibleSolutions.heapPermutation(elements, elements.length, 4);

        System.out.println(possibleSolutions.getSolutions().size());
        List<Object> mustColours = new ArrayList<>();
        mustColours.add(Colour.RED);
        mustColours.add(Colour.BLUE);
        mustColours.add(Colour.GREEN);
       // mustColours.add(Colour.YELLOW);

        System.out.println(mustColours);


        Object[] mustPosition = new Object[4];
        mustPosition[1] = Colour.RED;
        System.out.println(Arrays.asList(mustPosition));

        List<Object> wrongColours = new ArrayList<>();

        wrongColours.add(Colour.ORANGE);

       // possibleSolutions.update(mustColours, mustPosition, wrongColours);
        System.out.println(possibleSolutions.getSolutions().size());
        possibleSolutions.getSolutions().forEach(System.out::println);
    }
}
