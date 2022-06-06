package com.algtoolbox.week4.quickSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort3 {
    public static void sort(Comparable[] a) {
        List<Comparable> lstA = Arrays.asList(a);
        Collections.shuffle(lstA);
        a = lstA.toArray(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        // base case
        if(lo >= hi)
            return;
        int[] m1m2 = partition3(a, lo, hi);

        sort(a, lo, m1m2[0]-1);
        sort(a, m1m2[1]+1, hi);
    }

    private static int[] partition3(Comparable[] a, int lo, int hi){
        int[] m1m2 = new int[2];

        int lt = lo, gt = hi;
        Comparable pivot = a[lo];
        int i = lo;

        while(i<=gt){
            int cmp = a[i].compareTo(pivot);
            if(cmp < 0){
                exchange(a, i++, lt++);
            }
            else if(cmp > 0){
                exchange(a, i, gt--);
            }
            else{ // cmp == 0
                i++;
            }
        }

        m1m2[0] = lt;
        m1m2[1]=gt;
        return m1m2;
    }

    private static void exchange(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {5, 4, 2, 1, 3, 6, 9, 7, 7};
        // 1, 2, 3, 4, 5, 6, 7, 7, 9
        QuickSort3.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
