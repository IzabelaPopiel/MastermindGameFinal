package sample;

import org.junit.jupiter.api.*;

import java.util.Arrays;

public class GuessTest {

    private Guess guess;

    @BeforeAll
    static void init() {
        System.out.println("Welcome to tests");
    }

    @BeforeEach
    void beforeTest() {
        System.out.println("Next test is going to launch...");
    }

    @Test
    @DisplayName("Setting attempt result test")
    void setResults() {
        Integer[] arr = new Integer[]{1, 2, 3};
        guess = new Guess(arr);
        Integer[] arr2 = new Integer[]{1, 4, 2};
        guess.setResult(arr2);
        Assertions.assertEquals(guess.getRightColours(), Arrays.asList(new Integer[]{1, 2}));
        Assertions.assertEquals(guess.getWrongColours(), Arrays.asList(new Integer[]{4}));
        Assertions.assertEquals(Arrays.asList(guess.getRightPosition()), Arrays.asList(new Integer[]{1, null, null}));
        Assertions.assertEquals(Arrays.asList(guess.getWrongPosition()), Arrays.asList(new Integer[]{null, 4, 2}));
    }
}
