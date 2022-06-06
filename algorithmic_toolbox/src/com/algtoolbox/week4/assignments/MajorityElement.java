package com.algtoolbox.week4.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem 3
 * Description:
 * Task. The goal in this code problem is to check whether an input sequence contains a majority element.
 * Input Format. The first line contains an integer 𝑛, the next one contains a sequence of 𝑛 non-negative
 * integers 𝑎0, 𝑎1, . . . , 𝑎𝑛−1.
 * Constraints. 1 ≤ 𝑛 ≤ 105; 0 ≤ 𝑎𝑖 ≤ 109 for all 0 ≤ 𝑖 < 𝑛.
 * Output Format. Output 1 if the sequence contains an element that appears strictly more than 𝑛/2 times,
 * and 0 otherwise.
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 05.06.2022
 */
public class MajorityElement {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static int getMajorityElement(int[] a, int left, int right) {
        int[] aux = new int[a.length];
        // sort using merge sort
        //sort(a, aux, left, right);
        Arrays.sort(a);
        // traverse the sorted array
        int count = 1;
        int element = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                count++;
                if (count > a.length / 2)
                    return element;
            } else {
                count = 1;
                element = a[i + 1];
            }
        }
        return -1;
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        // base case (1 element)
        if (lo >= hi)
            return;

        int mid = lo + (hi - lo) / 2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = a[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[i] <= aux[j]) // = to keep the algorithm balanced
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

//        int[] a = {2, 3, 4,4,4,4,4,4,4,4,4,4, 9, 2, 2};
//        System.out.println(getMajorityElement(a, 0, a.length-1));
    }
}
