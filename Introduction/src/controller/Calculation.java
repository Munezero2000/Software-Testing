package controller;

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

    // public getStudentAge(){

    // }
}
