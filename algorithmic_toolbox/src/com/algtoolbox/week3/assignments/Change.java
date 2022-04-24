package com.algtoolbox.week3.assignments;

import java.util.Scanner;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0 - 04/22/2022
 *
 * Money change problem
 * Task: The goal in this problem is to find the minimum number of coins needed to change the input value
 * (an integer) into coins with denominations 1, 5, and 10.
 * Input Format: The input consists of a single integer 𝑚.
 * Constraints: 1 ≤ 𝑚 ≤ 103.
 * Output Format: Output the minimum number of coins with denominations 1, 5, 10 that changes 𝑚.
 *
 * Greedy Algorithm design approach
 * Safe move: count how many coins of 10 the sum m has.
 * Repeat for the remaining amount of money with 5 and so on.
 */
public class Change {
    /**
     * Calculates the minimum number of coins with denominations 1, 5, 10 that changes m with run time O(1)
     * @param m amount of money
     * @return the minimum number of coins with denominations 1, 5, 10 that changes m
     */
    public static int getChange(int m){
        int nCoins = 0;

        if(m>=10){
            nCoins += m/10;
            m%=10;
        }
        if(m>=5){
            nCoins+=m/5;
            m%= 5;
        }
        if(m>=1){
            nCoins += m;
            m%=1;
        }

        return nCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
