package com.algtoolbox.week2.assignments;

import java.util.Scanner;

public class FibonacciLastDigit {
    public static int getFibonacciLastDigit(int n){
        if(n <= 1) return n;
        int[] fibLastDigit = new int[n+1];

        fibLastDigit[0] = 0;
        fibLastDigit[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibLastDigit[i] = (fibLastDigit[i-1] + fibLastDigit[i-2])%10;
        }
        return fibLastDigit[n];
    }

    public static int getFibonacciLastDigit_Naive(int n){
        if(n<=1) return n;

        int previous = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            int temp_previous = previous;
            previous = current;
            current = temp_previous + previous;
        }

        return current % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getFibonacciLastDigit(n));
    }
}
