package com.algtoolbox.week4.quickSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {
    public static void sort(Comparable[] a) {
        List<Comparable> lstA = Arrays.asList(a);
        Collections.shuffle(lstA);
        a = lstA.toArray(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;

//        int m = partition1(a, lo, hi);
        int m = partition2(a, lo, hi);

        sort(a, lo, m - 1);
        sort(a, m + 1, hi);
    }

    /**
     * Partitions the array into three partitions [ lt pivot, pivot,  gt pivot ]
     * UCSanDiego implementation
     *
     * @param a  the array to sort
     * @param lo start index
     * @param hi end index
     * @return the index of the pivot after placement in its final position
     */
    private static int partition1(Comparable[] a, int lo, int hi) {
        int j = lo;
        Comparable pivot = a[lo];
        for (int i = j + 1; i <= hi; i++) {
            if (lessOrEqual(a[i], pivot))
                exchange(a, i, ++j);
        }
        exchange(a, lo, j);
        return j;
    }

    /**
     * Partitions the array into three partitions [ lt pivot, pivot,  gt pivot ]
     * Princeton implementation
     *
     * @param a  the array to sort
     * @param lo start index
     * @param hi end index
     * @return the index of the pivot after placement in its final position
     */
    private static int partition2(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], pivot))
                if (i == hi) break;
            while (less(pivot, a[--j]))
                if (j == lo) break;

            if(i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
    }

    private static boolean lessOrEqual(Comparable u, Comparable v) {
        return u.compareTo(v) < 0 || u.compareTo(v) == 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {5, 4, 2, 1, 3, 6, 9, 7, 7};
        // 1, 2, 3, 4, 5, 6, 7, 7, 9
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
