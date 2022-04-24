package com.algtoolbox.week3.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author Mohammed Abdelkawy
 * @version 1.1 - 04/23/2022
 * <p>
 * Problem Description
 * Task: Given a set of 𝑛 segments {[𝑎0, 𝑏0], [𝑎1, 𝑏1], . . . , [𝑎𝑛−1, 𝑏𝑛−1]} with integer coordinates on a line, find
 * the minimum number 𝑚 of points such that each segment contains at least one point. That is, find a
 * set of integers 𝑋 of the minimum size such that for any segment [𝑎𝑖, 𝑏𝑖] there is a point 𝑥 ∈ 𝑋 such
 * that 𝑎𝑖 ≤ 𝑥 ≤ 𝑏𝑖.
 * Input Format: The first line of the input contains the number 𝑛 of segments. Each of the following 𝑛 lines
 * contains two integers 𝑎𝑖 and 𝑏𝑖 (separated by a space) defining the coordinates of endpoints of the 𝑖-th
 * segment.
 * Constraints: 1 ≤ 𝑛 ≤ 100; 0 ≤ 𝑎𝑖 ≤ 𝑏𝑖 ≤ 109 for all 0 ≤ 𝑖 < 𝑛.
 * Output Format: Output the minimum number 𝑚 of points on the first line and the integer coordinates
 * of 𝑚 points (separated by spaces) on the second line. You can output the points in any order. If there
 * are many such sets of points, you can output any set. (It is not difficult to see that there always exist
 * a set of points of the minimum size such that all the coordinates of the points are integers.)
 * <p>
 * Greedy Algorithm Approach
 * Safe Move: take the smallest end to be the point of intersection with as many as possible number of segments
 * remove segments that pass by that point
 * repeat for a smaller-size problem
 */
public class CoveringSegments2 {

    private static class Segment {
        private int start, end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    private static int[] optimalPoints(Segment[] segments) {
        List<Integer> lstPt = new ArrayList<>();
        int n = segments.length;
        int[] points = new int[segments.length * 2];
        for (int i = 0; i < n; i++) {
            points[2 * i] = segments[i].getStart();
            points[2 * i + 1] = segments[i].getEnd();
        }

        while (points.length > 0) {
            int indexMinEnd = getMinEndPoint(points);
            lstPt.add(points[indexMinEnd]);
            points = removeSegmentsByPoint(points, indexMinEnd);
        }
        return lstPt.stream()
                .mapToInt(x->x.intValue())
                .toArray();
    }

    private static int[] removeSegmentsByPoint(int[] points, int indexPt) {
        int pt = points[indexPt];
        int n = points.length/2;
        List<Integer> proxyArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(points[2*i] <= pt && points[2*i+1]>=pt){
                continue;
            }
            proxyArray.add(points[2*i]);
            proxyArray.add(points[2*i+1]);
        }
        return proxyArray.stream()
                .mapToInt(x->x.intValue())
                .toArray();
    }

    private static int getMinEndPoint(int[] points) {
        int n = points.length/2;
        int minEndPt = Integer.MAX_VALUE;
        int indexMinEndPt = -1;
        for (int i = 0; i < n; i++) {
            if (points[2 * i+1] < minEndPt) {
                minEndPt = points[2 * i+1];
                indexMinEndPt = 2 * i+1;
            }
        }
        return indexMinEndPt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
