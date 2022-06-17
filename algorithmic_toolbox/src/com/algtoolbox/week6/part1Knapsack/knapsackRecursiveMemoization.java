package com.algtoolbox.week6.part1Knapsack;

import java.util.Hashtable;
import java.util.Map;

public class knapsackRecursiveMemoization {
    private final static Map<Integer, Integer> map = new Hashtable<>();

    /**
     * returns the maximum value of items fitted in a knapsack
     * recursively with memoization, i.e, storing calculated values
     * to return later and prevent recomputing them again
     *
     * @param W the capacity of the knapsack
     * @param v array of values of items
     * @param w array of weights
     * @return the maximum value of items fitted in a knapsack
     */
    private static int knapsack(int W, int[] v, int[] w) {
        // base case
        if (map.containsKey(W)) {
            return map.get(W);
        }

        int valToInsert = 0;
        for (int i = 0; i < v.length; i++) {
            if (w[i] <= W) {
                int val = knapsack(W - w[i], v, w) + v[i];
                if (val > valToInsert) {
                    valToInsert = val;
                }
            }
        }
        map.put(W, valToInsert);
        return map.get(W);
    }

    private static int knapsack2(int W, int[] v, int[] w) {
        if (W == 0) {
            return 0;
        }
        int valToInsert = 0;
        for (int i = 0; i < v.length; i++) {
            if (w[i] <= W) {
                int val = knapsack2(W - w[i], v, w) + v[i];
                if (val > valToInsert) {
                    valToInsert = val;
                }
            }
        }
        return valToInsert;
    }

    public static void main(String[] args) {
        int capacity = 10;
        int[] v = {30, 14, 16, 9};
        int[] w = {6, 3, 4, 2};

        System.out.println(knapsack(capacity, v, w));
        System.out.println(knapsack2(capacity, v, w));
    }
}
