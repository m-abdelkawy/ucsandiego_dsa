package com.algtoolbox.week5.part1ChangeProblem;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        // 01. Recursive Approach
        // return recursiveChange(coins, amount);

        // 02. Dynamic Programming approach
        return dbChange(coins, amount);
    }

    /**
     * recursive approach fails as it works in 2^n time!
     * Steps:
     * We call the method recursively with amount = amount = coin[i]
     * as we considered taking the coin[i] as the first coin in the coins returned
     * we take the minimum resulting from those recursive calls
     *
     *i.e,let amount = 9, coins ={6, 5, 1}
     * minCount[9] = min{
     *     minCount[3] + 1
     *     minCount[4] + 1
     *     minCount[8] + 1
     * }
     *
     * @param coins  array of coins available
     * @param amount the sum of money
     * @return minimum number of coins in the amount if possible, otherwise -1
     */
    private int recursiveChange(int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;
        int minCount = Integer.MAX_VALUE;
        int N = coins.length;
        for (int i = 0; i < N; i++) {
            if (amount >= coins[i]) {
                int count = recursiveChange(coins, amount - coins[i]) + 1;
                if (count < minCount) {
                    minCount = count;
                }
            }
        }
        return minCount;
    }

    /**
     * Dynamic Programming approach
     * we create an array with indexes equal to the amounts of money 0 --> amount
     * put the minNumCoins[0] = 0
     * loop over sums of money and for each m:
     *     put the minNumCount[m] = Max Integer Value
     *     loop over coins in the coins[]:
     *         if m >= coins[i]:// then we can have one coin of that value, so we add one to the following
     *                          //and subtract the value of the coin to go to the previous multiplication of it
     *             count <- minNumCount[m - coins[i]] + 1
     * then return minNumCount[amount]
     *
     * Running time: O(m * n)
     *
     * @param coins
     * @param amount
     * @return
     */
    private int dbChange(int[] coins, int amount) {
        int[] minNumCoins = new int[amount + 1];
        minNumCoins[0] = 0;
        for (int m = 1; m <= amount; m++) {
            minNumCoins[m] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (m >= coins[j]) {
                    minNumCoins[m] = Math.min(minNumCoins[m], minNumCoins[m - coins[j]] + 1);
                }
            }
        }
        return minNumCoins[amount];
    }


    public static void main(String[] args) {
//        int[] coins = {186, 419, 83, 408};
//        int amount = 6249;

        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinChange c = new CoinChange();

        System.out.println(c.coinChange(coins, amount));
    }
}
