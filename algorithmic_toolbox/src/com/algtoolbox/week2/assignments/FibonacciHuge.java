package com.algtoolbox.week2.assignments;

import java.util.Scanner;

public class FibonacciHuge {
    public static long getFibonacciHugeNaive(long n, long m){
        if(n <= 1) return n;

        long previous = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long temp_previous = previous;
            previous = current;
            current = temp_previous+previous;
            //System.out.println(String.format("temp_previous: %d\tprevious: %d\tcurrent: %d", temp_previous, previous, current));
        }

        return current % m;
    }

    public static long getFibonacciHuge(long n, long m){
        if(n <= 1) return n;

        long pisano = pisano(m);

        long eq = n%pisano;
        //System.out.println("eq: " + eq);

        if(eq <= 1)
            return eq;

        long prev = 0;
        long current = 1;

        for (long l = 2; l <= eq; l++) {
            long temp_prev = prev;
            prev = current;
            current = (temp_prev + prev)%m;

            //System.out.println(String.format("temp_previous: %d\tprevious: %d\tcurrent: %d", temp_prev, prev, current));

        }

        return current;
    }

    private static long pisano(long m) {

        long prev = 0;
        long current = 1;
        long res = 1;

        for (long l = 0; l < m * m; l++) {
            long temp_prev = prev;
            prev = current;
            current = (temp_prev + prev)%m;
            if (prev == 0 && current == 1){
                break;
            }
            res++;
        }
        //System.out.println("length: " + res);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}
