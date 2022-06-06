package com.algtoolbox.week4.assignments;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearchWithDuplicates {
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
        return binarySearchIterative(a, lo, hi, x);
    }

    private static int binarySearchIterative(int[] a, int lo, int hi, int x){
        int firstOccurence = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(a[mid] == x){
                firstOccurence = mid;
            }
            if(x <= a[mid]){
                hi = mid -1;
            }else{
                lo = mid + 1;
            }
        }
        return firstOccurence;
    }

    public static void main(String[] args) {
        BinarySearch.FastScanner scanner = new BinarySearch.FastScanner(System.in);
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
