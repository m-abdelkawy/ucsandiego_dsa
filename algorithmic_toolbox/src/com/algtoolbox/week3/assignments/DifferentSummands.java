package com.algtoolbox.week3.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/24/2022
 * <p>
 * Problem Description
 * Task. The goal of this problem is to represent a given positive integer 𝑛 as a sum of as many pairwise
 * distinct positive integers as possible. That is, to find the maximum 𝑘 such that 𝑛 can be written as
 * 𝑎1 + 𝑎2 + · · · + 𝑎𝑘 where 𝑎1, . . . , 𝑎𝑘 are positive integers and 𝑎𝑖 ̸= 𝑎𝑗 for all 1 ≤ 𝑖 < 𝑗 ≤ 𝑘.
 * Input Format. The input consists of a single integer 𝑛.
 * Constraints. 1 ≤ 𝑛 ≤ 109.
 * Output Format. In the first line, output the maximum number 𝑘 such that 𝑛 can be represented as a sum
 * of 𝑘 pairwise distinct positive integers. In the second line, output 𝑘 pairwise distinct positive integers
 * that sum up to 𝑛 (if there are many such representations, output any of them).
 * <p>
 * Greedy Algorithm Approach
 * consider sum starts with 1
 * and the minimum difference between consecutive numbers is 1
 * repeat for the remaining (the subproblem)
 */
public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (n - i > i) {
                summands.add(i);
                n -= i;
            } else {
                summands.add(n);
                break;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        summands.forEach(summand -> {
            System.out.print(summand + " ");
        });
    }
}
