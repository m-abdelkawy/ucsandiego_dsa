package com.algtoolbox.week4.assignments;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream stream) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static int binarySearch(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        return binarySearchRecursive(a, lo, hi, x);
    }

    private static int binarySearchRecursive(int[] a, int lo, int hi, int x) {
        // base case, element does not exist in the array
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (a[mid] == x)
            return mid;

        if (x < a[mid]) {
            // search the left side of the array
            return binarySearchRecursive(a, 0, mid - 1, x);
        } else {
            // search the right side of the array
            return binarySearchRecursive(a, mid + 1, hi, x);
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        // do the search
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
}
