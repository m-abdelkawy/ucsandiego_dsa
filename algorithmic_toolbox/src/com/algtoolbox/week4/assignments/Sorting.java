package com.algtoolbox.week4.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {
    private static Random random = new Random();

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

    private static void randomizedQuickSort(int[] a, int l, int r) {
        // base case (1 element left)
        if (l >= r)
            return;

        // randomize the pivot
        int k = random.nextInt(r-l+1)+l;
        exchange(a, l, k);

        int[] m1m2 = partition3(a, l, r);

        randomizedQuickSort(a, l, m1m2[0] - 1);
        randomizedQuickSort(a, m1m2[1] + 1, r);
    }

    private static int[] partition3(int[] a, int l, int r) {
        int[] m1m2 = new int[2];

        int lt = l, gt = r;
        int pivot = a[lt];

        int i = lt;

        while (i <= gt) {
            if (a[i] < pivot) {
                exchange(a, i++, lt++);
            } else if (a[i] == pivot) {
                i++;
            } else if (a[i] > pivot) {
                exchange(a, i, gt--);
            }
        }
        m1m2[0] = lt;
        m1m2[1] = gt;
        return m1m2;
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
