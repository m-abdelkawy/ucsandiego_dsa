package com.algtoolbox.week6.part1Knapsack;

import java.util.*;

/**
 * provides an optimal value for filling a knapsack of size W with items that have values v and weights w
 * maxmizing the value the knapsack can fit
 * The greedy approach fails for the discrete version of the knapsack
 * introduced the dynamic programming approach for the knapsack problem
 * with and without repetition allowed
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 12.06.2022
 */
public class Knapsack {
    /**
     * calculates the maximum value of items of weights w and values v, to fill a knapsack of size W
     * in time O(n.W)
     *
     * @param W size of the knapsack
     * @param v array of values
     * @param w array of weights
     * @return the maximum value of items whose weight does not exceed W, repetition allowed
     */
    private static int knapsackRepetition(int W, int[] v, int[] w) {
        int n = v.length;
        int[] value = new int[W + 1];
        for (int i = 1; i <= W; i++) {
            value[i] = 0;
            for (int j = 0; j < n; j++) {
                if (w[j] <= i)
                    value[i] = Math.max(value[i], value[i - w[j]] + v[j]);
            }
        }
        System.out.println("Sequence: " + printKnapsackWithRepetition(value, v, w));
        return value[W];
    }


    /**
     * calculates the maximum value of items of weights w and values v, to fill a knapsack of size W
     * in time O(n.W)
     *
     * @param W size of the knapsack
     * @param v array of values
     * @param w array of weights
     * @return the maximum value of items whose weight does not exceed W, repetition not allowed
     */
    private static int knapsackWithoutRepetition(int W, int[] v, int[] w) {
        int row = v.length + 1;
        int col = W + 1;

        int[][] val = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // value considering the i-1 element not included
                val[i][j] = val[i - 1][j];
                if (w[i - 1] <= j) {
                    // value including the i-1 element
                    int value = val[i - 1][j - w[i - 1]] + v[i - 1];
                    val[i][j] = Math.max(val[i][j], value);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] seq = printKnapsackWithoutRepetition(val, v, w);
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == 1 && i < seq.length - 1) {
                sb.append(v[i]+ "/"+w[i]+ ", ");
            } else if (seq[i] == 1 && i == seq.length - 1) {
                sb.append(v[i]+ "/"+w[i]);
            }
        }

        System.out.println("Sequence: " + sb.toString());
        return val[row - 1][col - 1];
    }

    private static int[] printKnapsackWithoutRepetition(int[][] knapsack, int[] v, int[] w) {
        int[] sequence = new int[w.length];
        int nIndex = knapsack.length - 1;
        int wIndex = knapsack[0].length - 1;
        int val = knapsack[nIndex][wIndex];
        while (wIndex > 0 && nIndex > 0 && val > 0) {
            // if the element is not in the sequence
            if (val == knapsack[nIndex - 1][wIndex]) {
                nIndex--;
            } else {
                sequence[nIndex - 1] = 1;
                val -= v[nIndex - 1];
                wIndex -= w[nIndex - 1];
            }
        }

        return sequence;
    }

    private static String printKnapsackWithRepetition(int[] knapsack, int[] v, int[] w){
        List<String> sequence = new ArrayList<>();
        int nIndex = w.length;
        int wIndex = knapsack.length;
        int val = knapsack[wIndex-1];
        while(nIndex > 0 && wIndex > 0 && val > 0){
            if(val-v[nIndex-1] == knapsack[wIndex - 1 - w[nIndex-1]]){
                wIndex-=w[nIndex-1];
                val-=v[nIndex-1];
                sequence.add(v[nIndex-1]+"/"+w[nIndex-1]);
            }else{
                nIndex--;
            }
        }
        StringJoiner sj = new StringJoiner(",");

        Collections.reverse(sequence);
        sequence.forEach(s->{
            sj.add(s);
        });
        return sj.toString();
    }

    private static void display2DArr(int[][] a, int[] w, int[] v) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        int capacity = 10;
        int[] v = {30, 14, 16, 9};
        int[] w = {6, 3, 4, 2};

        System.out.println(knapsackRepetition(capacity, v, w));

        // Expected
        // capacity = 10
        // Value per unit weight = 5, 4.67, 4, 4.5
        // 30 + 2 * 9 = 48
        // sequence: 30/6, 9/2, 9/2

        System.out.println();
        System.out.println(knapsackWithoutRepetition(capacity, v, w));
        // expected
        // 30 + 16 = 46
        // sequence used: 30/6, 16/4
    }
}
