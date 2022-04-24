package com.algtoolbox.week3.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0, 04/20/2022
 *
 * Calculates the maximum value possible
 * by adding fractions of items into knapsack of certain size
 * Running time O(n^2)
 * can be optimized by sorting by (v/w) in decreasing order, O(n)
 *
 * Greedy Algorithm design approach
 * Safe move: fit first the item that has the maximum value per unit
 * the remaining weight is (W-wi), this reduces the problem to a subproblem of smaller size
 * iterate until there is no space left
 */
public class FractionalKnapsack {
    /**
     *
     * @param capacity capacity of the knapsack
     * @param w array of weights
     * @param v array of values
     * @return max. value and weight share of every item in time O(n^2)
     */
    static Map<Integer, int[]> knapsack(int capacity, int[] w, int[] v){
        int[] wCopy = Arrays.copyOf(w, w.length);
        int n = wCopy.length;
        int vTotal = 0;
        int[] q = new int[n];
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        while(capacity > 0){
            int vPerUnitMax = 0;
            int indexPerUnitMax = 0;

            for (int i = 0; i < n; i++) {
                if(wCopy[i] > 0 && v[i]/wCopy[i] > vPerUnitMax){
                    vPerUnitMax = v[i]/wCopy[i];
                    indexPerUnitMax = i;
                }
            }

            int amountTaken = Math.min(capacity, wCopy[indexPerUnitMax]);

            vTotal+=amountTaken*(v[indexPerUnitMax]/wCopy[indexPerUnitMax]);
            q[indexPerUnitMax] = amountTaken;
            wCopy[indexPerUnitMax] -= amountTaken;
            capacity-=amountTaken;
        }
        map.put(vTotal, q);
        return map;
    }

    /**
     *
     * @param capacity capacity of the knapsack
     * @param w array of weights
     * @param v array of values
     * @return max. value and weight share of every item in time O(n)
     */
    static Map<Integer, int[]> knapsackSorted(int capacity, int[] w, int[] v){
        Map<Integer, int[]> res = new HashMap<>();

        int n = w.length;

        int vTotal = 0;
        int[] q = new int[n];

        for (int i = 0; i < n; i++) {
            int amountTaken = Math.min(capacity, w[i]);
            vTotal+=amountTaken*(v[i]/w[i]);
            q[i] = amountTaken;
            capacity-=amountTaken;
            if(capacity<=0)
                break;
        }

        res.put(vTotal, q);
        return res;
    }

    /*
     * sample input for testing
     * Capacity: 7
     * numItems: 3
     * W: 4 3 2
     * v: 20 18 14
     * Expected: [2]-2, [1]-3, [0]-2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        int n = scanner.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }

        Map<Integer, int[]> resKnapsack = knapsack(capacity, w, v);
        for (Integer key: resKnapsack.keySet()) {
            System.out.println(String.format("%d$ %s", key, Arrays.toString(resKnapsack.get(key))));
        }

        Map<Integer, int[]> resKnapsackSorted = knapsackSorted(capacity, w, v);
        for (Integer key: resKnapsackSorted.keySet()) {
            System.out.println(String.format("%d$ %s", key, Arrays.toString(resKnapsackSorted.get(key))));
        }
    }
}
