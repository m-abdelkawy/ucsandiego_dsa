package com.algtoolbox.week2.stresstest;

import com.algtoolbox.utils.RandomNumber;
import com.algtoolbox.week2.assignments.LCM;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StressTest_LCM {
    private static void stressTest(int numRange){
        LocalDateTime startTime = LocalDateTime.now();

        while(true){
            int a = RandomNumber.generateRandomIntBetween(0, numRange);
            int b = RandomNumber.generateRandomIntBetween(0, numRange);

            long lcmNaive = LCM.lcm_naive2(a, b);
            long lcm = LCM.lcm(a, b);

            System.out.println(String.format("Numbers: (%d, %d)", a, b));
            System.out.println(String.format("LCM Naivd: %d,\tLCM: %d", lcmNaive, lcm));

            if(lcmNaive == lcm){
                System.out.println("OK!");
            }else{
                System.out.println(String.format("Wrong Answer (%d, %d)", lcmNaive, lcm));
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
