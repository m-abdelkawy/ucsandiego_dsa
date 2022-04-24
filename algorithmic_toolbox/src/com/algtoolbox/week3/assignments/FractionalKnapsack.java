package com.algtoolbox.week3.assignments;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/22/2022
 *
 * Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
 * Input Format:- The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack.
 * The next 𝑛 lines define the values and weights of the items. The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the
 * value and the weight of 𝑖-th item, respectively.
 * Constraints. 1 ≤ 𝑛 ≤ 10^3, 0 ≤ 𝑊 ≤ 2 · 10^6; 0 ≤ 𝑣𝑖 ≤ 2 · 10^6,
 * 0 < 𝑤𝑖 ≤ 2 · 10^6 for all 1 ≤ 𝑖 ≤ 𝑛. All the
 * numbers are integers.
 * Output Format:- Output the maximal value of fractions of items that fit into the knapsack. The absolute
 * value of the difference between the answer of your program and the optimal value should be at most
 * 10−3. To ensure this, output your answer with at least four digits after the decimal point (otherwise
 * your answer, while being computed correctly, can turn out to be wrong because of rounding issues).
 */
public class FractionalKnapsack {
    //private static DecimalFormat df = new DecimalFormat("0.0000");

    /**
     * Calculates the maximum value of items that can fir into a knapsack in time O(n^2).
     * @param capacity capacity of the knap sack
     * @param values array of values of items
     * @param weights array of weights of items
     * @return the maximum value of items that can fir into a knapsack
     */
    private static double getOptimalValue(int capacity, int[] values, int[] weights){
        double value = 0;

        int n = values.length;

        while(capacity > 0 && Arrays.stream(weights).anyMatch(w->w>0)){
            // 01. choose the item with the maximum value per unit weight (v/w)
            int indexMaxValuePerUnitWeight = 0;
            double maxValuePerUnitWeight = 0;
            for (int i = 0; i < n; i++) {
                if(weights[i] > 0 && (double)values[i]/weights[i] > maxValuePerUnitWeight){
                    maxValuePerUnitWeight = (double)values[i]/weights[i];
                    indexMaxValuePerUnitWeight = i;
                }
            }

            // 02. put as much as possible of the item with max value per unit weight in the knapsack
            int amountTaken = Math.min(capacity, weights[indexMaxValuePerUnitWeight]);
            double valueTaken = maxValuePerUnitWeight * amountTaken;
            capacity -= amountTaken;

            weights[indexMaxValuePerUnitWeight] -= amountTaken;
            //values[indexMaxValuePerUnitWeight] -= valueTaken;

            value+=valueTaken;
        }

        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
