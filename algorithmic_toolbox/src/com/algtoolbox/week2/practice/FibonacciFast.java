package com.algtoolbox.week2.practice;

import java.util.Scanner;

/**
 * calc fibonacci number using O(n) algorithm
 */
public class FibonacciFast {
    private static long calc_fib(int n){
        if(n <= 1) return n;
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n+1; i++) {
            arr[i] =arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calc_fib(n));
    }
}
