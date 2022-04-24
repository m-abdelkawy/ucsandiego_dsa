package com.algtoolbox.week3.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/19/12022
 */
public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops){
        int numRefills = 0;
        int currentRefill = 0;
        int lastRefill = 0;
        int[] allStops = new int[stops.length+2];
        System.arraycopy(stops, 0, allStops, 1, stops.length);

        allStops[0] = 0;
        allStops[allStops.length-1] = dist;
        int n = allStops.length-2;

        while(currentRefill <= n){
            lastRefill = currentRefill;
            while(currentRefill<=n && allStops[currentRefill + 1] - allStops[lastRefill] <= tank && lastRefill != n+1){
                currentRefill++;
            }
            if(currentRefill == lastRefill){
                return -1;
            }
            if(currentRefill <= n){
                numRefills++;
            }
        }

        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
