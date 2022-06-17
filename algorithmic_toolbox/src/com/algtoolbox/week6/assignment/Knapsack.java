package com.algtoolbox.week6.assignment;

import java.util.Scanner;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int m = w.length+1;
        int n = W + 1;
        int[][] maxWeights = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxWeights[i][j] = maxWeights[i-1][j];
                if (j >= w[i - 1]) {
                    int val = maxWeights[i - 1][j - w[i - 1]] + w[i - 1];
                    maxWeights[i][j] = Math.max(maxWeights[i][j], val);
                }
            }
        }

        return maxWeights[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
