package com.algtoolbox.week2.assignments;

import java.util.Scanner;

public class FibonacciSumSquares {
    public static long getFibonacciSumSquaresLastDigitNaive(long n) {
        if (n <= 1)
            return n;

        long tempPrevious = 0;
        long previous = 0;
        long current = 1;
        long sum = 1;
        for (long l = 2; l <= n; l++) {
            tempPrevious = previous;
            previous = current;
            current = (tempPrevious + previous) % 10;
            sum += Math.pow(current, 2);
            sum %= 10;
        }
        return sum;
    }

    public static long getFibonacciSumSquaresLastDigitFast(long n) {
        //calculate pisano periodic length for m == 10
        long pisano10 = pisano(10);

        //calculate the equivalent of n within the pisano period above
        long rem_n_10 = n % pisano10;

        if(rem_n_10<=1) return rem_n_10;

        //loop and calculate sum of squares mod 10
        int tempPrevious = 0;
        int previous = 0;
        int current = 1;
        int squareSumLastDigit = 1;
        for (long l = 2; l <= rem_n_10; l++) {
            tempPrevious = previous;
            previous = current;
            current = (tempPrevious + previous) % 10;
            squareSumLastDigit += Math.pow(current, 2)%10;
            squareSumLastDigit%=10;
        }
        return squareSumLastDigit;
    }

    /**
     * calculates the length of pisano period in fibonacci sequence
     *
     * @param m number to calculate pisano period length for
     * @return length of pisano perion for number m
     */
    private static long pisano(long m) {
        long length = 1;

        long tempPrevious = 0;
        long previous = 0;
        long current = 1;

        for (long l = 0; l < m * m; l++) {
            tempPrevious = previous;
            previous = current;
            current = (tempPrevious + previous) % m;
            if (previous == 0 && current == 1) {
                break;
            }
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //System.out.println(getFibonacciSumSquaresLastDigitNaive(n));
        System.out.println(getFibonacciSumSquaresLastDigitFast(n));
    }
}
