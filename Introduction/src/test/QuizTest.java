package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import controller.Quiz;

public class QuizTest {
    @Test
    public void testCheckString() {
        Quiz quiz = new Quiz();

        assertEquals(Integer.valueOf(2), quiz.checkString("even"));
        assertEquals(Integer.valueOf(3), quiz.checkString("odd"));
    }

    @Test
    public void testCheckArrayParity() {
        Quiz quiz = new Quiz();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Test for even numbers
        List<Integer> expectedEven = Arrays.asList(2, 4, 6);
        assertArrayEquals(expectedEven.toArray(), quiz.checkArrayParity("even", numbers).toArray());

        // Test for odd numbers
        List<Integer> expectedOdd = Arrays.asList(1, 3, 5);
        assertArrayEquals(expectedOdd.toArray(), quiz.checkArrayParity("odd", numbers).toArray());
    }

}
