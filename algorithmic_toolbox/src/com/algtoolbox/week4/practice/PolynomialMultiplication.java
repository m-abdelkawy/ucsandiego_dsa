package com.algtoolbox.week4.practice;

import java.util.Arrays;

public class PolynomialMultiplication {

    /**
     * calculate the product of two polynomials in O(n2)
     *
     * @param a the first polynomial coefficients
     * @param b the second polynomial coefficients
     * @param n the number of terms or (degree - 1)
     * @return the product of two polynomials in O(n2)
     */
    private int[] multPolyNaive(int[] a, int[] b, int n) {
        int[] product = new int[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                product[i + j] += a[i] * b[j];
            }
        }
        return product;
    }

    private int[] multPolyDivideAndConquerNaive(int[] A, int[] B, int n, int a, int b) {
        int[] res = new int[2 * n - 1];
        if (n == 1) {
            res[0] = A[a] * B[b];
            return res;
        }

        // calculate AlBl
        int[] AlBl = new int[n - 1];
        AlBl = multPolyDivideAndConquerNaive(A, B, n / 2, a, b);
        popLeft(res, AlBl);

        // calculate ArBr
        int[] ArBr = new int[n - 1];
        ArBr = multPolyDivideAndConquerNaive(A, B, n / 2, a + (n / 2), b + (n / 2));
        popRight(res, ArBr);

        // calculate AlBr
        int[] AlBr = new int[n - 1];
        AlBr = multPolyDivideAndConquerNaive(A, B, n / 2, a, b + (n / 2));

        // calculate ArBl
        int[] ArBl = new int[n - 1];
        ArBl = multPolyDivideAndConquerNaive(A, B, n / 2, a + (n / 2), b);

        int[] sumMid = new int[n-1];
        sumMid = sumArr(AlBr, ArBl);

        // embed Array
        midPart(res, sumMid, n / 2, n + (n / 2) - 1);
        return res;
    }

    private void midPart(int[] res, int[] embedded, int start, int end) {
        for (int i = start; i < end; i++) {
            res[i] += embedded[i - start];
        }
    }

    private int[] sumArr(int[] l, int[] r) {
        int[] sum = new int[r.length];
        for (int i = 0; i < l.length; i++) {
            sum[i] = l[i] + r[i];
        }
        return sum;
    }

    private void popRight(int[] res, int[] right) {
        for (int i = 0; i < right.length; i++) {
            res[res.length - 1 - i] = right[right.length - 1 - i];
        }
    }

    private void popLeft(int[] res, int[] left) {
        for (int i = 0; i < left.length; i++) {
            res[i] = left[i];
        }
    }

    public static void main(String[] args) {
        PolynomialMultiplication pm = new PolynomialMultiplication();
        int[] a = {0,3, 2, 5};
        int[] b = {0,5, 1, 2};
        System.out.println(Arrays.toString(pm.multPolyNaive(a, b, 4)));
        System.out.println(Arrays.toString(pm.multPolyDivideAndConquerNaive(a, b, 4, 0, 0)));
    }
}
