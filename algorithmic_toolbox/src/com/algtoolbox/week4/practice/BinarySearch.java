package com.algtoolbox.week4.practice;

public class BinarySearch {

    private int binarySearchRecursive(int[] arr, int lo, int hi, int key) {
        if (lo > hi) {
            return lo - 1;
        }
        int mid = (hi + lo) / 2;
        if (arr[mid] == key) {
            return mid;
        }

        if (key < arr[mid]) {
            return binarySearchRecursive(arr, lo, mid-1, key);
        } else {
            return binarySearchRecursive(arr, mid + 1, hi, key);
        }
    }

    private int binarySearchIterative(int[] arr, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo-1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 10, 12, 15, 18, 20, 20, 50, 60};

        BinarySearch bs = new BinarySearch();

        System.out.println(bs.binarySearchRecursive(arr, 0, arr.length - 1, 70));
        System.out.println(bs.binarySearchRecursive(arr, 0, arr.length - 1, 50));
        System.out.println(bs.binarySearchRecursive(arr, 0, arr.length - 1, 21));
        System.out.println(bs.binarySearchRecursive(arr, 0, arr.length - 1, 40));
        System.out.println(bs.binarySearchRecursive(arr, 0, arr.length - 1, 1));

        System.out.println(bs.binarySearchIterative(arr, 0, arr.length - 1, 70));
        System.out.println(bs.binarySearchIterative(arr, 0, arr.length - 1, 50));
        System.out.println(bs.binarySearchIterative(arr, 0, arr.length - 1, 21));
        System.out.println(bs.binarySearchIterative(arr, 0, arr.length - 1, 40));
        System.out.println(bs.binarySearchIterative(arr, 0, arr.length - 1, 1));
    }
}
