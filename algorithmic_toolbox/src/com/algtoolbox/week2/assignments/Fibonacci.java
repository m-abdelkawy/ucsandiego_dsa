package com.algtoolbox.week2.assignments;

import java.util.Scanner;

public class Fibonacci {

    public static long calc_fib_naive(int n){
        if(n<=1) return n;
        return calc_fib(n-1) + calc_fib(n-2);
    }

    public static long calc_fib(int n){
        if(n <= 1) return n;
        long[] fib = new long[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calc_fib(n));
    }
}
