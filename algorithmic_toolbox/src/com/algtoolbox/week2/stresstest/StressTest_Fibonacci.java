package com.algtoolbox.week2.stresstest;

import com.algtoolbox.utils.RandomNumber;
import com.algtoolbox.week2.assignments.Fibonacci;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StressTest_Fibonacci {

    static void stressTest(int indexRange) {
        LocalDateTime startTime = LocalDateTime.now();
        while (true) {
            int n = RandomNumber.generateRandomIntBetween(0, indexRange);

            long fibNaive = Fibonacci.calc_fib_naive(n);
            long fibFast = Fibonacci.calc_fib(n);

            System.out.println(String.format("FibNaive[%d]: %d", n, fibNaive));
            System.out.println(String.format("FibFast[%d]: %d", n, fibFast));
            if (fibNaive == fibFast) System.out.println("OK!");
            else {
                System.out.println(String.format("Wrong Answer %d, %d", fibNaive, fibFast));
                break;
            }
            if (ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) == 5) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        stressTest(40);
    }
}
