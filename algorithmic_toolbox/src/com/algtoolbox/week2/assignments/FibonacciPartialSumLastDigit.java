package com.algtoolbox.week2.assignments;

import java.util.Scanner;

public class FibonacciPartialSumLastDigit {
    public static long getFibonacciPartialSumLastDigitNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next = 1;

        for (long l = 0; l <= to; l++) {
            if (l >= from) {
                sum += current;
            }
            long tempCurrent = next;
            next = (current + next) % 10;
            current = tempCurrent;
            sum %= 10;
        }
        return sum % 10;
    }

    public static long getFibonacciPartialSumLastDigitFast(long from, long to) {
        int res = 0;
        long pisano10 = pisano(10);
        //System.out.println("Pisano 10: " + pisano10);

        long rem_from = from % pisano10;
        long rem_to = to % pisano10;

        if(rem_to < rem_from) rem_to += pisano10;

        int tempPrevious = 0;
        int previous = 0;
        int current = 1;
        for (long l = 0; l < rem_from - 1; l++) {
            tempPrevious = previous;
            previous = current;
            current = (tempPrevious + previous) % 10;
            //System.out.println("current: " + current);
        }


        //System.out.println("------------------------");
        for (long l = rem_from; l <= rem_to; l++) {
            if (rem_from == 0){
                res += previous;
            }else{
                res += current;
            }
            tempPrevious = previous;
            previous = current;
            current = (tempPrevious + previous) % 10;
            res %= 10;
        }

        return res;
    }

    private static long pisano(int m) {
        long length = 1;

        int tempPrevious = 0;
        int previous = 0;
        int current = 1;

        for (long l = 0; l < m * m; l++) {
            tempPrevious = previous;
            previous = current;
            current = (tempPrevious + current) % m;

            if (previous == 0 && current == 1) {
                break;
            }
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        //System.out.println(getFibonacciPartialSumLastDigitNaive(from, to));
        System.out.println(getFibonacciPartialSumLastDigitFast(from, to));
    }
}
