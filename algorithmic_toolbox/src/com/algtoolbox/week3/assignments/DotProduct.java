package com.algtoolbox.week3.assignments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/23/2022
 * <p>
 * Problem Description
 * Task: Given two sequences 𝑎1, 𝑎2, . . . , 𝑎𝑛 (𝑎𝑖 is the profit per click of the 𝑖-th ad) and 𝑏1, 𝑏2, . . . , 𝑏𝑛 (𝑏𝑖 is
 * the average number of clicks per day of the 𝑖-th slot), we need to partition them into 𝑛 pairs (𝑎𝑖, 𝑏𝑗)
 * such that the sum of their products is maximized.
 * Input Format: The first line contains an integer 𝑛, the second one contains a sequence of integers
 * 𝑎1, 𝑎2, . . . , 𝑎𝑛, the third one contains a sequence of integers 𝑏1, 𝑏2, . . . , 𝑏𝑛.
 * Constraints: 1 ≤ 𝑛 ≤ 103; −105 ≤ 𝑎𝑖, 𝑏𝑖 ≤ 105 for all 1 ≤ 𝑖 ≤ 𝑛.
 * Output Format. Output the maximum value of
 * Σ︀𝑛
 * 𝑖=1
 * 𝑎𝑖𝑐𝑖, where 𝑐1, 𝑐2, . . . , 𝑐𝑛 is a permutation of
 * 𝑏1, 𝑏2, . . . , 𝑏𝑛.
 */
public class DotProduct {
    /**
     * Calculates the max. advertisement revenue in O(nlogn) time
     *
     * @param a profit per click for i-th ad.
     * @param b average number of clicks per day of the i-th slot.
     * @return the max. sum of their products
     */
    private static long maxDotProduct2(int[] a, int[] b) {
        long res = 0;

        int n = a.length;

        a = Arrays.stream(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        b = Arrays.stream(b)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < n; i++) {
            res += (long)a[i] * b[i];
        }

        return res;
    }

    private static long maxDotProduct3(int[] a, int[] b) {
        long res = 0;

        int n = a.length;
        int i = 0;

        int iMaxA = -1;
        int iMaxB = -1;

        while (i < n) {
            iMaxA = maxArrayIndex(a);
            iMaxB = maxArrayIndex(b);
            res += a[iMaxA] * b[iMaxB];
            a[iMaxA] = Integer.MIN_VALUE;
            b[iMaxB] = Integer.MIN_VALUE;
            i++;
        }

        return res;
    }

    private static long maxDotProduct(int[] a, int[] b) {
        long res = 0;

        int n = a.length;
        int i = 0;

        int iMaxA = -1;
        int iMaxB = -1;

        while (i < n) {
            iMaxA = maxArrayIndex(a);
            iMaxB = maxArrayIndex(b);
            res += (long)a[iMaxA] * b[iMaxB];
            a = removeByIndex(a, iMaxA);
            b = removeByIndex(b, iMaxB);
            i++;
        }

        return res;
    }

    private static int maxArrayIndex(int[] a) {
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int indexMax = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    private static int[] removeByIndex(int[] src, int i) {
        int[] dest = new int[src.length - 1];


        System.arraycopy(src, 0, dest, 0, i);
        //System.out.println(Arrays.toString(dest));


        System.arraycopy(src, i + 1, dest, i, src.length - i - 1);
        //System.out.println(Arrays.toString(dest));


        return dest;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(maxDotProduct2(a, b));
    }
}
