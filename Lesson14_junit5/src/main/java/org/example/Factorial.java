package org.example;

public class Factorial {
    public static int factorial(int a) throws MyFactorialException {

        int result = 1;
        if (a < 0) {
            throw new MyFactorialException("Number must be non-negative.");
        } else if (a >= 20) {
            throw new MyFactorialException("Number must be less than 20.");
        }
        for (int i = 2; i <= a; i++) {
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) throws MyFactorialException {

            System.out.println(factorial(10));
    }
}