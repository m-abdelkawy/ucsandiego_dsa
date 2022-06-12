package com.algtoolbox.week5.assignments;

import java.util.Scanner;

public class LCS2 {
    private static int lcs2(int[] a, int[] b) {
        int row = a.length + 1;
        int col = b.length + 1;
        int[][] lcs = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (a[i-1] == b[j-1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
        return lcs[row - 1][col - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int j = 0; j < n; j++) {
            b[j] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}
