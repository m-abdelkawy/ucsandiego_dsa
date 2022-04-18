package com.algtoolbox.week2.assignments;

import java.util.Scanner;

public class GCD {
    public static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                current_gcd = i;
            }
        }
        return current_gcd;
    }

    public static int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        if (y == 0) return a;
        int r = x % y;
        return gcd(y, r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcd(a, b));
    }
}
