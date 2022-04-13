package com.algtoolbox.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Calculates the maximum pairwise product in O(n2) time
 * @author Mohammed Abdelkawy
 * @version 1.0
 */
public class MaxPairwiseProductNaive {
    static long getMaxPairwiseProduct(long[] numbers){
        long max_product = 0;
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                max_product = Math.max(max_product, numbers[i] * numbers[j]);
            }
        }
        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    //scanner
    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
