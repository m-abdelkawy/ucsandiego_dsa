package com.algtoolbox.week4.practice;

import com.algtoolbox.utils.RandomNumber;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class StressTest_Karatsuba {
    static void stressTest(int sizeRange, int valueRange){
        Karatsuba karatsuba = new Karatsuba();
        LocalDateTime startTime = LocalDateTime.now();
        while(true){
            long x = RandomNumber.generateRandomIntBetween(2, sizeRange);
            long y = RandomNumber.generateRandomIntBetween(2, sizeRange);

            long resKaratsuba = karatsuba.multiply(x, y);
            long resNaive = x * y;

            System.out.println("resNaive: " + resNaive +", " + "resKaratsuba: " + resKaratsuba);

            if(resNaive == resKaratsuba)
                System.out.println("OK!");
            else{
                System.out.println("Wrong Answer: " + resNaive + ", " + resKaratsuba);
                break;
            }

            if(ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) ==10){
                break;
            }
        }
        System.out.println("Testing Time: " + Duration.between(startTime,LocalDateTime.now()).getSeconds() + " seconds");
    }

    public static void main(String[] args) {
        StressTest_Karatsuba.stressTest(10000, 100000);
    }
}
