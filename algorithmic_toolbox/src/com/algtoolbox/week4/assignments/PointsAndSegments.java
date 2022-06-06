package com.algtoolbox.week4.assignments;

import java.util.Arrays;
import java.util.Scanner;

/**
 * finds number of segments that pass b y a point in O(n log n) time\
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 05.06.2022
 */
public class PointsAndSegments {
    /**
     * calculates the number of segments that pass by each point in O(n logn) time
     * count = number of starts - number of ends
     *
     * @param starts array of start points of the segments
     * @param ends array of end points of the segments
     * @param points array of points
     * @return array that contains number of segments that coincide with each point
     */
    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int N = points.length;
        int segLen = starts.length;

        int[] count = new int[N];

        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0; i < N; i++) {
            int stIndex = 0;
            while (stIndex < segLen) {
                if(points[i] < starts[stIndex]){
                    break;
                }
                stIndex++;
            }

            int endIndex = 0;
            while(endIndex<segLen){
                if(points[i] <= ends[endIndex]){
                    break;
                }
                endIndex++;
            }
            count[i] = stIndex - endIndex;
        }

        return count;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}
