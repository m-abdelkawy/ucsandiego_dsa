package com.algtoolbox.week2.assignments;

import java.util.Scanner;

public class FibonacciSumLastDigit {
    public static long getFibonacciSumLastDigitNaive(long n) {
        if (n <= 1)
            return n;

        long temp_previous = 0;
        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long l = 2; l <= n; l++) {
            temp_previous = previous;
            previous = current;
            current = temp_previous + previous;
            sum += current;
        }

        return sum % 10;
    }

    public static long getFibonacciSumLastDigit(long n) {
        if (n <= 1)
            return n;

        int temp_previous = 0;
        int previous = 0;
        int current = 1;
        int sum = 1;

        for (long l = 2; l <= n; l++) {
            temp_previous = previous;
            previous = current;
            current = (temp_previous + previous) % 10;
            sum += current;
            sum %= 10;
        }

        return sum;
    }

    public static long getFibonacciSumLastDigitFast(long n){
        if(n <= 1)
            return n;

        long pisano10Length = pisano(10); //60
        long rem60 = n % pisano10Length;

        if(rem60 <= 1)
            return rem60;

        int temp_previous = 0;
        int previous = 0;
        int current = 1;
        long sum = 1;

        for (long l = 2; l <= rem60; l++) {
            temp_previous = previous;
            previous = current;
            current = (temp_previous + previous)%10;

            sum += current;
            sum%=10;
        }
        return sum;
    }

    private static long pisano(long m){

        long temp_previous = 0;
        long previous = 0;
        long current = 1;

        long res = 1;
        for (long l = 0; l < m*m; l++) {
            temp_previous = previous;
            previous = current;
            current = (temp_previous + previous)%m;
            if(previous == 0 && current == 1){
                break;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //System.out.println(getFibonacciSumLastDigitNaive(n));
        //System.out.println(getFibonacciSumLastDigit(n));
        System.out.println(getFibonacciSumLastDigitFast(n));
    }
}
