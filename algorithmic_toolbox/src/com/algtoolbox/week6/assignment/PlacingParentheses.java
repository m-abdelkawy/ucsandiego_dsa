package com.algtoolbox.week6.assignment;

import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int n = (exp.length() + 1) / 2;
        long[][] minArr = new long[n][n];
        long[][] maxArr = new long[n][n];
        // set the diagonal elements as the single digits
        for (int i = 0; i < n; i++) {
            minArr[i][i] = exp.charAt(2 * i) - '0';
            maxArr[i][i] = exp.charAt(2 * i) - '0';
        }

        for (int s = 0; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                minMax(minArr, maxArr, i, j, exp);
            }
        }
        return maxArr[0][n - 1];
    }

    private static void minMax(long[][] minArr, long[][] maxArr, int i, int j, String expression) {
        if (i == j) {
            return;
        }

        long minVal = Long.MAX_VALUE;
        long maxVal = Long.MIN_VALUE;


        for (int k = i; k < j; k++) {
            char operator = expression.charAt(2 * k + 1);
            long a = eval(minArr[i][k], minArr[k + 1][j], operator);
            long b = eval(maxArr[i][k], maxArr[k + 1][j], operator);
            long c = eval(minArr[i][k], maxArr[k + 1][j], operator);
            long d = eval(maxArr[i][k], minArr[k + 1][j], operator);

            minVal = Math.min(minVal, Math.min(a, Math.min(b, Math.min(c, d))));
            maxVal = Math.max(maxVal, Math.max(a, Math.max(b, Math.max(c, d))));
        }

        minArr[i][j] = minVal;
        maxArr[i][j] = maxVal;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
