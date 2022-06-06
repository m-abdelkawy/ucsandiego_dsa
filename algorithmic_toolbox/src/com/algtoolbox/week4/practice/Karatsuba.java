package com.algtoolbox.week4.practice;

public class Karatsuba {

    public long multiply(long x, long y) {
        // base case
        if(x< 10 && y < 10)
            return x * y;

        // calculate length of numbers
        int lenX = numLength(x);
        int lenY = numLength(y);

        // get max length
        int maxLen = Math.max(lenX, lenY);

        // to make the input even
        int halfMaxLen = maxLen / 2 + maxLen % 2;

        // ten to the power of max Length
        long maxLenTen = (long) Math.pow(10, halfMaxLen);

        // calculate halves of the input numbers
        long xl = x / maxLenTen;
        long xr = x % maxLenTen;

        long yl = y / maxLenTen;
        long yr = y % maxLenTen;

        // calculate the three multiplications
        long resLeft = multiply(xl, yl);
        long resMiddle = multiply(xl + xr, yl + yr);
        long resRight = multiply(xr, yr);

        long res = resLeft * (long) Math.pow(10, halfMaxLen * 2)
                + (resMiddle - resLeft - resRight) * (long) Math.pow(10, halfMaxLen)
                + resRight;

        return res;
    }

    private int numLength(long n) {
        int len = 0;
        while (n > 0) {
            len++;
            n /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Karatsuba karatsuba = new Karatsuba();
        System.out.println(karatsuba.multiply(1234,5678));
        System.out.println(1234*5678);
    }
}
