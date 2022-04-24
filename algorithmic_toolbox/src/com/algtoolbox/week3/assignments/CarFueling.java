package com.algtoolbox.week3.assignments;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/23/2022
 *
 * Input Format: The first line contains an integer 𝑑. The second line contains an integer 𝑚. The third line
 * specifies an integer 𝑛. Finally, the last line contains integers stop1, stop2, . . . , stop𝑛.
 * Output Format: Assuming that the distance between the cities is 𝑑 miles, a car can travel at most 𝑚 miles
 * on a full tank, and there are gas stations at distances stop1, stop2, . . . , stop𝑛 along the way, output the
 * minimum number of refills needed. Assume that the car starts with a full tank. If it is not possible to
 * reach the destination, output −1.
 * Constraints: 1 ≤ 𝑑 ≤ 10^5. 1 ≤ 𝑚 ≤ 400. 1 ≤ 𝑛 ≤ 300. 0 < stop1 < stop2 < · · · < stop𝑛 < 𝑑.
 *
 * Greedy Algorithm design approach
 * Safe move: take the first stop to refill to be the farthest one from the lastRefill
 * make the lastRefill = the current one and reduce to a smaller problem with lastRefill as the start
 */
public class CarFueling {

    /**
     * computes the minimum number of refills for a car to move from a to b in O(n) time
     * @param dist total distance from source to destination
     * @param tank the distance the car can reach with fulL tank
     * @param stops array of stops
     * @return the minimum number of refills for a car to move from a to b
     */
    static int computeMinRefills(int dist, int tank, int[] stops){
        int numRefills = 0;
        int currentRefill=0;
        int lastRefill = 0;

        int[] allStops=new int[stops.length+2];

        System.arraycopy(stops, 0, allStops, 1, stops.length);

        allStops[0]=0;
        allStops[allStops.length-1] = dist;
        int n = stops.length;

        while(currentRefill <= n){
            lastRefill = currentRefill;
            while(currentRefill<=n && allStops[currentRefill+1]-allStops[lastRefill] <=tank){
                currentRefill++;
            }

            if(currentRefill == lastRefill)
                return -1;

            if(currentRefill <= n)
                numRefills++;
        }

        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank= scanner.nextInt();
        int nStops = scanner.nextInt();
        int[] stops = new int[nStops];
        for (int i = 0; i < nStops; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist,tank, stops));
    }
}
