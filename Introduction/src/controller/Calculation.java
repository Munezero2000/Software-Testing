package controller;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    public int addNumber(int a, int b) {
        return a + b;
    }

    public int getMaxNumber(int[] numbers) {
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public int getStudentAge(int birthYear) {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - birthYear;
    }

    public static String displayBeforeAllTest() {
        return "Welcome to software Testing";
    }

    public String displayBeforeEveryTest() {
        return "diplay before every test";
    }

    public String displayAfterEveryTest() {
        return "Display after every test";
    }

    public static String displayAfterAllTest() {
        return "Display after all test";
    }

    public List<String> getAllCourses(String academicYear) {
        List<String> courses = new ArrayList<>();
        if (academicYear != null) {
            courses.add("Mathemics");
            courses.add("Web Technologies");
            return courses;
        } else {
            return null;
        }
    }

    // Write a method that get a string  as param then check whether that string is even or odd
    //  if that word is even it will return even numbers else return odd number
}
