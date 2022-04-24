package com.algtoolbox.week3.assignments;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/24/2022
 * <p>
 * Problem Description
 * Task. Compose the largest number out of a set of integers.
 * Input Format. The first line of the input contains an integer 𝑛. The second line contains integers
 * 𝑎1, 𝑎2, . . . , 𝑎𝑛.
 * Constraints. 1 ≤ 𝑛 ≤ 100; 1 ≤ 𝑎𝑖 ≤ 103 for all 1 ≤ 𝑖 ≤ 𝑛.
 * Output Format. Output the largest number that can be composed out of 𝑎1, 𝑎2, . . . , 𝑎𝑛.
 * <p>
 * Greedy Algorithm Approach
 * consider the largest left digit of the number to be forming the largest number
 * if it's more than one digit then compare the following digits
 * remove the number chosen from the input array
 * repeat for the smaller-sized problem
 */
public class LargestNumber {

    private static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            long o1o2 = Long.parseLong(o1 + o2);
            long o2o1 = Long.parseLong(o2 + o1);
            if (o1o2 > o2o1) {
                return -1;
            } else if (o1o2 < o2o1) {
                return 1;
            }
            return 0;
        }
    };

    private static Comparator<String> comparator2 = (o1, o2) -> {
        long o1o2 = Long.parseLong(o1 + o2);
        long o2o1 = Long.parseLong(o2 + o1);
        if (o1o2 > o2o1) {
            return -1;
        } else if (o1o2 < o2o1) {
            return 1;
        }
        return 0;
    };

    private static String largestNumber(String[] a) {
        a = Arrays.stream(a).sorted(comparator).collect(Collectors.toList()).toArray(new String[a.length]);

        return String.join("", a);
    }

    private static String largestNumber2(String[] a) {
        StringBuilder sb = new StringBuilder();
        while (a.length > 0) {
            int indexMax = getIndexMax(a);
            sb.append(a[indexMax]);
            a = removeByIndex(a, indexMax);
        }
        return sb.toString();
    }

    private static String[] removeByIndex(String[] a, int index) {
        int n = a.length;
        List<String> proxyArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != index)
                proxyArr.add(a[i]);
        }
        return proxyArr.toArray(new String[proxyArr.size()]);
    }

    private static int getIndexMax(String[] a) {
        int n = a.length;
        String max = "";
        int indexMax = -1;
        for (int i = 0; i < n; i++) {
            long cur = Long.parseLong(a[i] + max);
            long prev = Long.parseLong(max + a[i]);
            if (cur >= prev) {
                max = a[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        //System.out.println(largestNumber(a));
        System.out.println(largestNumber2(a));
    }
}
