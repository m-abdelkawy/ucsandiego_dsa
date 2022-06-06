package com.algtoolbox.week4.practice;

import java.util.Arrays;

public class SelectionSort {
    private static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                exchange(a, i, minIndex);
            }
        }
    }

    private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {5,7,8,3,2,4,1,4,7};
        System.out.println("Before Sorting: ");
        System.out.println(Arrays.asList(a));
        SelectionSort.sort(a);
        System.out.println("After Sorting: ");
        System.out.println(Arrays.asList(a));
    }
}
