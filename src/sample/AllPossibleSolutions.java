/**
 * Class containing all possible solutions of game.
 */
package sample;

import java.util.*;

class AllPossibleSolutions {

    /**
     * Represents HashSet of all solutions.
     */
    private Set<List<Object>> solutions = new HashSet<>();

    /**
     * Gets HashSet of all solutions.
     * @return all solutions
     */
    public Set<List<Object>> getSolutions() {
        return solutions;
    }

    /**
     * Adds new solution to HashSet
     * @param elements array of elements
     * @param n required length of added solution
     */
    private void addToSet(Object elements[], int n) {
        List<Object> newElement = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newElement.add(elements[i]);
        }
        solutions.add(newElement);
    }

    /**
     * Generates permutation of input elements using Heap Algorithm.
     * @param elements array of elements
     * @param size size of array
     * @param n required length of added solution
     */
    public void heapPermutation(Object[] elements, int size, int n) {
        //source : https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
        if (size == 1)
            addToSet(elements, n);

        for (int i = 0; i < size; i++) {
            heapPermutation(elements, size - 1, n);

            if (size % 2 == 1) {
                Object temp = elements[0];
                elements[0] = elements[size - 1];
                elements[size - 1] = temp;
            }

            else {
                Object temp = elements[i];
                elements[i] = elements[size - 1];
                elements[size - 1] = temp;
            }
        }
    }

    /**
     * Updates HashSet of all solutions removing all incorrect options.
     * @param rightColours list of correct colours
     * @param rightPositions array of correct postions - contains name of colour on correct postions
     * @param wrongColours array of incorrect postions - contains name of colour on incorrect postions
     * @param wrongPositions list of incorrect colours
     * @param randomGuess array containing current incorrect guess
     */
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

    /**
     * Returns random solution from HashSet
     * @return randomSolution
     */
    public Object[] randomSolution() {
        return solutions.iterator().next().toArray();
    }
}