package com.algtoolbox.week6.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Partition3 {
    private static int partition3(int[] a) {
        /*int n = a.length;
        int sum = 0;

        sum = Arrays.stream(a).sum();

        if (sum % 3 != 0 || a.length < 3)
            return 0;

        int row = n + 1;
        int col = sum / 3 + 1;
        boolean[][] partition = new boolean[row][col];

        //initialize first row as false except 0
        for (int j = 1; j < col; j++) {
            partition[0][j] = false;
        }

        for (int i = 0; i < row; i++) {
            partition[i][0] = true;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                partition[i][j] = partition[i - 1][j];
                if(j >= a[i-1]){
                    partition[i][j] = partition[i][j] ||partition[i - 1][j - a[i - 1]];
                }
            }
        }
        return partition[row - 1][col - 1] ? 1 : 0;*/

        int n = a.length;
        int sum = Arrays.stream(a).sum();

        // target sum of each subset
        int target = sum/3;

        if (sum % 3 != 0 || a.length < 3)
            return 0;

        int[] dp = new int[1<<15];
        for (int i = 0; i < (1<<n); i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int mask = 0; mask < (1<<n); mask++) {
            if(dp[mask] == -1)
                continue;

            for (int i = 0; i < n; i++) {
                if(((mask & (1<<i)) == 0) && (dp[mask] + a[i] <= target)){
                    dp[mask | (1<<i)] = (dp[mask] + a[i]) % target;
                }
            }
        }

        if(dp[(1<<n) - 1] == 0){
            return 1;
        }

        return 0;
    }
//    private static int partition3old(int[] A) {
//        int n = A.length;
//        int sum = 0;
//        int i, j;
//
//        // Calculate sum of all elements
//        for (i = 0; i < n; i++)
//            sum += A[i];
//
//        if (sum%3 != 0)
//            return 0;
//
//        boolean part[][]=new boolean[sum/3+1][n+1];
//
//        // initialize top row as true
//        for (i = 0; i <= n; i++)
//            part[0][i] = true;
//
//        // initialize leftmost column, except part[0][0], as 0
//        for (i = 1; i <= sum/3; i++)
//            part[i][0] = false;
//
//        // Fill the partition table in bottom up manner
//        for (i = 1; i <= sum/3; i++)
//        {
//            for (j = 1; j <= n; j++) {
//                part[i][j] = part[i][j-1];
//                if (i >= A[j-1])
//                    part[i][j] = part[i][j] ||
//                            part[i - A[j-1]][j-1];
//            }
//        }
//
//        return part[sum/3][n]==true?1:0;
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}
