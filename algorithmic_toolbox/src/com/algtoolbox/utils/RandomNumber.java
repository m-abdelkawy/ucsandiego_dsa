package com.algtoolbox.utils;

import java.util.Random;

public class RandomNumber {
    public static int generateRandomIntBetween(int lo, int hi) {
        Random random = new Random();
        return random.nextInt(hi - lo) + lo;
    }

//    public static long generateRandomLongBetween(long lo, long hi) {
//        Random random = new Random();
//        return random.nextLong(hi - lo) + lo;
//    }
}
