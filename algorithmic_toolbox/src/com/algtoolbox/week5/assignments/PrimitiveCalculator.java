package com.algtoolbox.week5.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    public static int[] dp_sequence(int n) {
        int[] minOperations = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int min1 = minOperations[i - 1] + 1;
            int min2 = Integer.MAX_VALUE, min3=Integer.MAX_VALUE;
            if (i % 3 == 0) {
                min3 = minOperations[i / 3] + 1;
            }
            if (i % 2 == 0) {
                min2 = minOperations[i / 2] + 1;
            }
            minOperations[i] = Math.min(Math.min(min2, min3), min1);
        }
        return minOperations;
    }

    public static List<Integer> dp_sequence2(int n) {
        int[] minOperations = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int min1 = minOperations[i - 1] + 1;
            int min2 = Integer.MAX_VALUE, min3=Integer.MAX_VALUE;
            if (i % 3 == 0) {
                min3 = minOperations[i / 3] + 1;
            }
            if (i % 2 == 0) {
                min2 = minOperations[i / 2] + 1;
            }
            minOperations[i] = Math.min(Math.min(min2, min3), min1);
        }
        // Backtracking to get the sequence
        List<Integer> sequence = new ArrayList<>();
        sequence.add(n);
        for (int i = n, j=n-1; i >= 1 && j >= 1; j--) {
            if(minOperations[i] - minOperations[j] == 1 && (i-j == 1 || j*2==i || j*3 ==i)){
                sequence.add(j);
                i = j;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[] sequence = dp_sequence(n);
        List<Integer> sequence = dp_sequence2(n);
        System.out.println(sequence.size() - 1);
        for (Integer num: sequence) {
            System.out.print(num + " ");
        }
    }
}
