package com.algtoolbox.week4.assignments;

import java.util.Scanner;

public class Inversions {
    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        int mid, inv_count = 0;

        // base case
        if(left >= right)
            return 0;

        mid = left + (right - left) / 2;

        inv_count += getNumberOfInversions(a, b, left, mid);
        inv_count += getNumberOfInversions(a, b, mid + 1, right);

        inv_count += merge(a, b, left, mid, right);

        return inv_count;
    }

    private static int merge(int[] a, int[] aux, int lo, int mid, int hi) {
        int inv_count = 0;
        int i = lo;
        int j = mid +1;
        for (int k = lo; k <= hi; k++) {
            if(j > hi){
                aux[k] = a[i++];
            }else if (i > mid){
                aux[k] = a[j++];
            }
            else if(a[i] <= a[j]){
                aux[k]=a[i++];
            }
            else if(a[j] < a[i]){
                // inversion occurs
                aux[k] = a[j++];
                inv_count += ((mid + 1) - i);
            }
        }

        System.arraycopy(aux, lo, a, lo, hi - lo + 1);

        return inv_count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
    }
}