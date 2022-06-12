package com.algtoolbox.week5.assignments;

import java.util.Scanner;

public class LCS3 {
    private static int lcs3(int[] a, int[] b, int[] c) {
        int dim1 = a.length + 1;
        int dim2 = b.length + 1;
        int dim3 = c.length + 1;

        int[][][] lcs = new int[dim1][dim2][dim3];

        for (int i = 1; i < dim1; i++) {
            for (int j = 1; j < dim2; j++) {
                for (int k = 1; k < dim3; k++) {
                    if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1]) {
                        lcs[i][j][k] = lcs[i - 1][j - 1][k - 1]+1;
                    } else {
                        lcs[i][j][k] = Math.max(lcs[i - 1][j][k], Math.max(lcs[i][j - 1][k], lcs[i][j][k - 1]));
                    }
                }
            }
        }

        return lcs[dim1 - 1][dim2 - 1][dim3 - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}
