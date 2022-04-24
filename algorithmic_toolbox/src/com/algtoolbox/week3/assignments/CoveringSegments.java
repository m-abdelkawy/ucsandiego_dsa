package com.algtoolbox.week3.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/23/2022
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
public class CoveringSegments {
    /**
     * Calculates the minimum number of points that cut segments in O(n^2) time
     * @param segments array of segments
     * @return array of minimum number of point coordinates that cut the segments provided
     */
    private static int[] optimalPoints(Segment[] segments) {
        List<Integer> points = new ArrayList<>();

        while(segments.length > 0){
            int iMinEnd = getMinEndPoint(segments);
            points.add(segments[iMinEnd].getEnd());

            segments = removeSegmentsByPoint(segments, segments[iMinEnd].getEnd());
        }

        return points.stream()
                .mapToInt(x->x.intValue()).toArray();
    }

    /**
     * removes all segments cut by point in O(n) time
     * @param segments array of segments
     * @param point coordinate of point
     * @return array of remaining segments after removing segments that pass by the point
     */
    private static Segment[] removeSegmentsByPoint(Segment[] segments, int point) {
        List<Segment> proxySegments = new ArrayList<>();

        for (Segment segment: segments) {
            if(point >= segment.getStart() && point <= segment.getEnd()){
                continue;
            }
            proxySegments.add(segment);
        }
        return proxySegments.toArray(new Segment[proxySegments.size()]);
    }

    /**
     * gets the index of the segment with the minimum end point coordinate in O(n) time
     * @param segments array of segments
     * @return the index of the segment with the smallest end coordinate
     */
    private static int getMinEndPoint(Segment[] segments) {
        int n = segments.length;
        int minEnd = Integer.MAX_VALUE;
        int indexMinEnd = -1;
        for (int i = 0; i < n; i++) {
            if (segments[i].getEnd() < minEnd) {
                minEnd = segments[i].getEnd();
                indexMinEnd = i;
            }
        }
        return indexMinEnd;
    }

    /**
     * Segment class
     */
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

        int[] points = optimalPoints(segments);

        // number of points
        System.out.println(points.length);

        //points coordinates
        //System.out.println(Arrays.toString(points));

        for (int point: points) {
            System.out.print(String.format("%s ", point));
        }
    }
}
