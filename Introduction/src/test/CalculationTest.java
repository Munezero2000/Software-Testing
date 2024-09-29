package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Calculation;

public class CalculationTest {

    Calculation cal = new Calculation();

    // Before all for Junit 5
    @BeforeClass
    public static void testDisplayBeforeAll() {
        // Calculation cal = new Calculation();
        System.out.println(Calculation.displayBeforeAllTest());
    }

    @AfterClass
    public static void testDisplayAfterAll() {
        // Calculation cal = new Calculation();
        System.out.println(Calculation.displayAfterAllTest());
    }

    @Before
    public void testDisplayBeforeEachTest() {
        System.out.println(cal.displayBeforeEveryTest());
    }

    @After
    public void testDisplayAfterEachTest() {
        System.out.println(cal.displayAfterEveryTest());
    }

    @Test
    public void test() {

        int addition = cal.addNumber(4, 8);
        assertEquals(12, addition);
    }

    @Test
    public void testGetMaxNumber() {
        int[] numbers = { 1, 3, 5, 2, 4 };
        int max = cal.getMaxNumber(numbers);
        assertEquals(5, max);
    }

    @Test
    public void testListOfCourses() {
        String academicYear = null;
        assertNull(cal.getAllCourses(academicYear));
    }

    public void testListOfCourseAvailable() {
        String academicYear = "2024";
        List<String> availableCourses = new ArrayList<>();
        availableCourses.add("Mathematics");
        availableCourses.add("Web Teck");
        assertArrayEquals(availableCourses.toArray(), cal.getAllCourses(academicYear).toArray());
    }
}
