package com.algtoolbox.week1;

import com.algtoolbox.utils.RandomNumber;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class StressTest_MaxPairwiseProduct {
    static void stressTest(int sizeRange, int valueRange){
        LocalDateTime startTime = LocalDateTime.now();
        while(true){
            int n = RandomNumber.generateRandomIntBetween(2, sizeRange);
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = RandomNumber.generateRandomIntBetween(0, valueRange);
            }
            System.out.println(Arrays.toString(arr));
            long resNaive = MaxPairwiseProductNaive.getMaxPairwiseProduct(arr);
            long resFast = MaxPairwiseProductFast.getMaxPairwiseProduct(arr);

            if(resNaive == resFast)
                System.out.println("OK!");
            else{
                System.out.println("Wrong Answer: " + resNaive + ", " + resFast);
            }

            if(ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) ==10){
                break;
            }
        }
        System.out.println("Testing Time: " + Duration.between(startTime,LocalDateTime.now()).getSeconds() + " seconds");
    }
    public static void main(String[] args) {

        StressTest_MaxPairwiseProduct.stressTest(10, 100000);
    }
}
