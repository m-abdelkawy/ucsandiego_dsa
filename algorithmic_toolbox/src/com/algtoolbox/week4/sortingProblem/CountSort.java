package com.algtoolbox.week4.sortingProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {
    /**
     * sorts an array of integer in time O(n + m)
     * where n is the size of the input array and m is the size of the count array
     * if (m grows no faster than n), i.e, m = O(n), then the running time is O(n), linear
     * @param a the input array to sort
     */
    public static void sort(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            if(a[i] < min){
                min = a[i];
            }
            if(a[i] > max){
                max = a[i];
            }
        }

        int countLen = max - min + 1;
        int[] count = new int[countLen];
        for (int i = 0; i < N; i++) {
            count[a[i] - min]++;
        }

        int pos = 0;
        for (int i = 0; i < countLen; i++) {
            for (int j = 0; j < count[i]; j++) {
                a[pos++] = i + min;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {5, 3, 4, 1, 2};
        CountSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
