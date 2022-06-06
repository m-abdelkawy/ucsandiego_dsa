package com.algtoolbox.week4.assignments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Closest {
    private static Point[] points;


    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point that) {
            return this.x == that.x ? Long.signum(this.y - that.y) : Long.signum(this.x - that.x);
        }

        public static double distance(Point p1, Point p2) {
            return Math.sqrt(Math.pow(p2.y - p1.y, 2) + Math.pow(p2.x - p1.x, 2));
        }

        public static double distance(int x1, int y1, int x2, int y2) {
            return Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        }
    }

    static double minimalDistance(int[] x, int[] y) {
        int N = x.length;
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        Arrays.sort(points);

        return minimalDistance(points, 0, x.length - 1);
    }

    static double minimalDistance(Point[] points, int lo, int hi) {

        if (hi - lo == 1) {
            return Point.distance(points[lo], points[hi]);
        }
        if (hi == lo) {
            return Double.POSITIVE_INFINITY;
        }

        int mid = lo + (hi - lo) / 2;

        double distLeft = minimalDistance(points, lo, mid);
        double distRight = minimalDistance(points, mid + 1, hi);

        double dist = Math.min(distLeft, distRight);

        double midX = (double) (points[mid].x + points[mid + 1].x) / 2;

        List<Point> strip = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(points[i].x - midX) < dist)
                //strip[i-lo] = points[i];
                strip.add(points[i]);
        }

        double minDistStrip = Double.POSITIVE_INFINITY;
        Point[] stripArr = new Point[strip.size()];
        stripArr = strip.toArray(stripArr);
        Arrays.sort(stripArr, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.y == p2.y) {
                    if (p1.x == p2.x) return 0;
                    else if (p1.x < p2.x) return -1;
                    else return 1;
                } else if (p1.y < p2.y) return -1;
                else return 1;
            }
        });
        for (int i = 0; i < stripArr.length - 1; i++) {
            double ptDist = Point.distance(stripArr[i], stripArr[i + 1]);
            minDistStrip = Math.min(minDistStrip, ptDist);
        }

        return Math.min(dist, minDistStrip);
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

}
