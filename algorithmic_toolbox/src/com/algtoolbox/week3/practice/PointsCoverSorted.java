package com.algtoolbox.week3.practice;

import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/20/2022
 *
 * Greedy algorithm design approach
 * safe move: choose the left most point to coincide with the left of the segment
 * reduce the problem to a similar subproblem of smaller size
 *
 * Running time is O(n) provided that the coordinates are sorted from left to right
 */
public class PointsCoverSorted {
    /**
     * Calculates the minimum number of segments of certain length that covers a span of points
     * @param coordinates Coordinates of points
     * @param segLength Length of the segment
     * @return the minimum number of segments covering the points
     */
    public static int minSegments(double[] coordinates, int segLength){
        int res = 0;

        int i = 0;
        int n = coordinates.length;
        while(i < n){
            double segLeft = coordinates[i];
            double segRight = segLeft + segLength;
            while(i<n && coordinates[i] <= segRight){
                i++;
            }
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int segmentLength = scanner.nextInt();
        int nPoints = scanner.nextInt();
        double[] points = new double[nPoints];
        for (int i = 0; i < nPoints; i++) {
            points[i] = scanner.nextDouble();
        }
        System.out.println(minSegments(points, segmentLength));
    }
}
