package com.algtoolbox.week5.assignments;

import java.util.Scanner;

public class ChangeDp {
    private static int getChange(int m){
        int n = m+1;
        int[] minNumCoins = new int[n];
        minNumCoins[0]=0;
        int[] coins = {1,3,4};

        for (int i = 1; i < n; i++) {
            minNumCoins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i>=coins[j]){
                    minNumCoins[i] = Math.min(minNumCoins[i], minNumCoins[i - coins[j]]+1);
                }
            }
        }
        return minNumCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
