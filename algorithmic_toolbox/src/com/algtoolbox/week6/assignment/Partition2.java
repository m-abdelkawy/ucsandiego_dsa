//package com.algtoolbox.week6.assignment;

import java.util.Arrays;

public class Partition2 {
    private static boolean canPartition(int[] nums) {
        /*int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0 || n < 2){
            return false;
        }

        int row = n + 1;
        int col = sum / 2;

        boolean[][] partition = new boolean[row][col];

        for(int i = 0; i < row; i++){
            partition[i][0] = true;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                partition[i][j] = partition[i-1][j];
                if(j >= nums[i-1]){
                    partition[i][j] = partition[i][j] || partition[i-1][j-nums[i-1]];
                }
            }
        }

        return partition[row-1][col-1];*/


        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        // target sum of each subset
        int target = sum/3;

        int[] dp = new int[1<<15];
        for (int i = 0; i < (1<<n); i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int mask = 0; mask < (1<<n); mask++) {
            if(dp[mask] == -1)
                continue;

            for (int i = 0; i < n; i++) {
                if(((mask & (1<<i)) == 0) && (dp[mask] + nums[i] <= target)){
                    dp[mask | (1<<i)] = (dp[mask] + nums[i]) % target;
                }
            }
        }

        if(dp[(1<<n) - 1] == 0){
            return true;
        }

        return false;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,5};
        System.out.println(canPartition(nums));
    }
}
