package com.algtoolbox.week2.stresstest;

import com.algtoolbox.utils.RandomNumber;
import com.algtoolbox.week2.assignments.GCD;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StressTest_GCD {

    private static void stressTest(int numRange){
        LocalDateTime startTime = LocalDateTime.now();

        while(true){
            int a = RandomNumber.generateRandomIntBetween(1, numRange);
            int b = RandomNumber.generateRandomIntBetween(1, numRange);

            int gcdNaive = GCD.gcd_naive(a, b);
            int gcd = GCD.gcd(a, b);

            System.out.println(String.format("Numbers: (%d, %d)", a, b));
            System.out.println(String.format("GCD Naive: %d,\tGCD: %d", gcdNaive, gcd));

            if(gcdNaive == gcd){
                System.out.println("OK!");
            }
            else{
                System.out.println(String.format("Wrong Answer: %d, %d", gcdNaive, gcd));
                break;
            }

            if(ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) == 5){
                break;
            }
        }
    }

    public static void main(String[] args) {
        stressTest(999999);
    }
}
