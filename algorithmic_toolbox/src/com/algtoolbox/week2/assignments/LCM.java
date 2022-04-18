package com.algtoolbox.week2.assignments;

import java.util.Scanner;

/**
 * Least Common Multiple
 */
public class LCM {
    private static long lcm_naive(int a, int b){
        for (long l = 1; l < (long) a*b; l++) {
            if(l%a == 0 && l %b ==0) return l;
        }
        return a*b;
    }

    public static long lcm_naive2(int a, int b){
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        for (long i = max; i < max * min; i+=max) {
            if(i % min == 0) return i;
        }
        return max * min;
    }

    public static long lcm(int a, int b){
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        long lcm = (max*min)/gcd(max, min);

        return lcm;
    }

    private static long gcd(long a, long b){
        if(b == 0) return a;
        long r = a % b;
        return gcd(b, r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(lcm(a, b));
    }
}
