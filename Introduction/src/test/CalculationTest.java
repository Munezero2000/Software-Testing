package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.Calculation;

public class CalculationTest {

    @Test
    public void test() {
        Calculation cal = new Calculation();
        int addition = cal.addNumber(4, 8);
        assertEquals(12, addition);
    }

    @Test
    public void testGetMaxNumber() {
        Calculation cal = new Calculation();
        int[] numbers = { 1, 3, 5, 2, 4 };
        int max = cal.getMaxNumber(numbers);
        assertEquals(5, max);
    }

}
