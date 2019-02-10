package sample;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class AllPossibleSolutionsTest {


    private AllPossibleSolutions allPossibleSolutions;

    @BeforeAll
    static void init() {
        System.out.println("Welcome to tests");
    }

    @BeforeEach
    void beforeTest() {
        System.out.println("Next test is going to launch...");
    }

    @Test
    @DisplayName("Creating permutation test")
    void permute() {
        allPossibleSolutions = new AllPossibleSolutions();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        allPossibleSolutions.heapPermutation(arr, arr.length, 3);
        Integer[] arr2 = new Integer[]{1, 2, 3};
        Assertions.assertTrue(allPossibleSolutions.getSolutions().contains(Arrays.asList(arr2)));
    }

    @Test
    @DisplayName("Creating permutation without duplicates test")
    void noDuplicate() {
        allPossibleSolutions = new AllPossibleSolutions();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        allPossibleSolutions.heapPermutation(arr, arr.length, 3);
        Integer[] arr2 = new Integer[]{1, 2, 3};
        allPossibleSolutions.getSolutions().remove(Arrays.asList(arr2));
        Assertions.assertFalse(allPossibleSolutions.getSolutions().contains(Arrays.asList(arr2)));
    }

    @Test
    @DisplayName("Updating solution set test")
    void update() {
        allPossibleSolutions = new AllPossibleSolutions();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        allPossibleSolutions.heapPermutation(arr, arr.length, 3);

        Integer[] rightCol = new Integer[]{2, 3};
        Integer[] wrongCol = new Integer[]{1};
        Integer[] rightPos = new Integer[]{null, 3, null};
        Integer[] wrongPos = new Integer[]{2, null, 1};
        Integer[] random = new Integer[]{2, 3, 1};

        allPossibleSolutions.update(Arrays.asList(rightCol), rightPos, wrongPos, Arrays.asList(wrongCol), random);

        Assertions.assertFalse(allPossibleSolutions.getSolutions().contains(Arrays.asList(random)));
        allPossibleSolutions.getSolutions().forEach((List<Object> o) -> Assertions.assertFalse(o.contains(1)));
        allPossibleSolutions.getSolutions().forEach((List<Object> o) -> Assertions.assertTrue(o.contains(2) || o.contains(3)));
        allPossibleSolutions.getSolutions().forEach((List<Object> o) -> Assertions.assertEquals(3, o.get(1)));
        allPossibleSolutions.getSolutions().forEach((List<Object> o) -> Assertions.assertNotEquals(2, o.get(0)));
        allPossibleSolutions.getSolutions().forEach((List<Object> o) -> Assertions.assertNotEquals(1, o.get(2)));

    }
}
