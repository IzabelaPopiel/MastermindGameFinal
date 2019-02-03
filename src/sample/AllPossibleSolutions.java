package sample;

import java.util.*;

// Java program to print all permutations using
// Heap's algorithm
class AllPossibleSolutions {
    //Prints the array

    Set<List<Object>> solutions = new HashSet<>();

    public Set<List<Object>> getSolutions() {
        return solutions;
    }

    public void printArr(Object elements[], int n) {
        List<Object> newElement = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newElement.add(elements[i]);
        }
        solutions.add(newElement);
    }

    //Generating permutation using Heap Algorithm
    void heapPermutation(Object[] elements, int size, int n) {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            printArr(elements, n);

        for (int i = 0; i < size; i++) {
            heapPermutation(elements, size - 1, n);

            // if size is odd, swap first and last
            // element
            if (size % 2 == 1) {
                Object temp = elements[0];
                elements[0] = elements[size - 1];
                elements[size - 1] = temp;
            }

            // If size is even, swap ith and last
            // element
            else {
                Object temp = elements[i];
                elements[i] = elements[size - 1];
                elements[size - 1] = temp;
            }
        }
    }

    // Driver code
//    public static void main(String args[]) {
//        AllPossibleSolutions obj = new AllPossibleSolutions();
//        Object[] elements = new Object[]{Colour.YELLOW, Colour.ORANGE, Colour.PURPLE, Colour.BLUE, Colour.RED, Colour.GREEN};
//        System.out.println(Arrays.toString(elements));
//
//        obj.heapPermutation(elements, elements.length, 4);
//        System.out.println(obj.getSolutions().size());
//
//        System.out.println(obj.getSolutions());
//    }

    public void update(List<Object> rightColours, Object[] rightPositions, Object[] wrongPositions, List<Object> wrongColours, Object[] randomGuess) {

        for (int i = 0; i < rightColours.size(); i++) {
            Object c1 = rightColours.get(i);
            solutions.removeIf((List<Object> o) -> !o.contains(c1));
        }

        for (int i = 0; i < wrongColours.size(); i++) {
            Object c1 = wrongColours.get(i);
            solutions.removeIf((List<Object> o) -> o.contains(c1));
        }

        for (int i = 0; i < rightPositions.length; i++) {
            if (rightPositions[i] != null) {
                Object c1 = rightPositions[i];
                int j = i;
                solutions.removeIf((List<Object> o) -> !o.get(j).equals(c1));
            }
        }
        for (int i = 0; i < wrongPositions.length; i++) {
            if (wrongPositions[i] != null) {
                Object c1 = wrongPositions[i];
                int j = i;
                solutions.removeIf((List<Object> o) -> o.get(j).equals(c1));
            }
        }
        solutions.removeIf((List<Object> o) -> o.equals(Arrays.asList(randomGuess)));
    }

    public Object[] randomGuess() {
        return solutions.iterator().next().toArray();
    }
}