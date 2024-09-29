package controller;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public Integer checkString(String input) {
        if (input.equalsIgnoreCase("even")) {
            return 2;
        } else if (input.equalsIgnoreCase("odd")) {
            return 3;
        } else {
            return null;
        }
    }

    // Write a method that accept two parameters this array should be any size the
    // if the string parameter is "even" you will array return even number in that
    // array else return odd numbers of that array

    public List<Integer> checkArrayParity(String input, List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (input.equalsIgnoreCase("even") && number % 2 == 0) {
                result.add(number);
            } else if (input.equalsIgnoreCase("odd") && number % 2 != 0) {
                result.add(number);
            }
        }
        return result;
    }
}
