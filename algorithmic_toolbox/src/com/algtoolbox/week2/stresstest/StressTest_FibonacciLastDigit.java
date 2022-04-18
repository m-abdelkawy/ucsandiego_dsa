package com.algtoolbox.week2.stresstest;

import com.algtoolbox.utils.RandomNumber;
import com.algtoolbox.week2.assignments.FibonacciLastDigit;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StressTest_FibonacciLastDigit {
    private static void stressTest(int indexRange) {
        LocalDateTime startTime = LocalDateTime.now();

        while (true) {
            int n = RandomNumber.generateRandomIntBetween(0, indexRange);
            int fibLastDigitNaive = FibonacciLastDigit.getFibonacciLastDigit_Naive(n);
            int fibLastDigit = FibonacciLastDigit.getFibonacciLastDigit(n);

            System.out.println(String.format("fibLastDigitNaive[%d]: %d", n, fibLastDigitNaive));
            System.out.println(String.format("fibLastDigit[%d]: %d", n, fibLastDigit));

            if (fibLastDigitNaive == fibLastDigit) {
                System.out.println("OK!");
            } else {
                System.out.println(String.format("Wrong Answer %d, %d", fibLastDigitNaive, fibLastDigit));
                break;
            }

            if (ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) == 5)
                break;
        }
    }

    public static void main(String[] args) {
        stressTest(40);
    }
}
