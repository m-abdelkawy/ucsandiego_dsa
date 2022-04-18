package com.algtoolbox.week2.practice;

import java.util.Scanner;

public class FibonacciRecursiveNaive {
    private static long calc_fib(int n){
        if(n <= 1) return n;
        return calc_fib(n-1) + calc_fib(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calc_fib(n));
    }
}
