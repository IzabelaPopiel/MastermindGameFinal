package sample;

import org.junit.jupiter.api.*;

import java.util.Arrays;

public class GuessTest {

    private Guess guess;

    @BeforeAll
    static void init() {
        System.out.println("Witamy w testach");
    }

    @BeforeEach
    void beforeTest() {
        System.out.println("Zaraz uruchomi sie kolejny test...");
    }

    @Test
    @DisplayName("Test ustawiania wyniku proby")
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
