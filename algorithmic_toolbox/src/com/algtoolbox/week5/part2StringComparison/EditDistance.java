package com.algtoolbox.week5.part2StringComparison;

import java.util.Arrays;

public class EditDistance {
    public static int editDistance(String str1, String str2) {
        int row = str1.length() + 1;
        int col = str2.length() + 1;

        int[][] distance = new int[row][col];

        for (int i = 0; i < row; i++) {
            distance[i][0] = i;
        }

        for (int j = 0; j < col; j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int insertion = distance[i][j - 1] + 1;
                int deletion = distance[i - 1][j] + 1;
                int mismatch = distance[i - 1][j - 1] + 1;
                int match = distance[i - 1][j - 1];
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    distance[i][j] = match;
                } else {
                    distance[i][j] = Math.min(Math.min(insertion, deletion), mismatch);
                }
            }
        }
        display2DArr(distance, str1, str2);
        return distance[row - 1][col - 1];
    }

    public static int[][] editDistance2(String str1, String str2) {
        int row = str1.length() + 1;
        int col = str2.length() + 1;

        int[][] distance = new int[row][col];

        for (int i = 0; i < row; i++) {
            distance[i][0] = i;
        }

        for (int j = 0; j < col; j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int insertion = distance[i][j - 1] + 1;
                int deletion = distance[i - 1][j] + 1;
                int mismatch = distance[i - 1][j - 1] + 1;
                int match = distance[i - 1][j - 1];
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    distance[i][j] = match;
                } else {
                    distance[i][j] = Math.min(Math.min(insertion, deletion), mismatch);
                }
            }
        }
        display2DArr(distance, str1, str2);
        return distance;
    }

    private static void display2DArr(int[][] a, String str1, String str2) {
        char[] chars1Arr = str1.toCharArray();
        char[] chars2Arr = str2.toCharArray();
        char[] chars1 = new char[chars1Arr.length + 1];
        chars1[0] = '0';
        for (int i = 1; i < chars1.length; i++) {
            chars1[i] = chars1Arr[i - 1];
        }
        char[] chars2 = new char[chars2Arr.length + 1];
        chars2[0] = '0';
        for (int i = 1; i < chars2.length; i++) {
            chars2[i] = chars2Arr[i - 1];
        }

        System.out.println("  " + Arrays.toString(chars2));
        for (int i = 0; i < a.length; i++) {
            System.out.println(chars1[i] + " " + Arrays.toString(a[i]));
        }
    }

    public static String[] outputAlignment(int[][] distance, String str1, String str2) {
        int i = str1.length(), j = str2.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (i > 0 && j > 0) {
            if (distance[i][j] == distance[i - 1][j] + 1) {// deletion
                sb1.append(str1.charAt(--i));
                sb2.append("-");
            } else if (distance[i][j] == distance[i][j - 1] + 1) {// insertion
                sb1.append("-");
                sb2.append(str2.charAt(--j));
            }
            //else if (distance[i][j] == distance[i - 1][j - 1]) {// mismatch(replacement)
            else {
                sb1.append(str1.charAt(--i));
                sb2.append(str2.charAt(--j));
            }
        }
        return new String[]{sb1.reverse().toString(), sb2.reverse().toString()};
    }

    public static String[] outputAlignment2(int[][] distance, String str1, String str2) {
        int i = str1.length(), j = str2.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (i > 0 && j > 0) {
            if (distance[i][j] == distance[i - 1][j - 1] + 1) {// deletion
                sb1.append(str1.charAt(--i));
                sb2.append(str2.charAt(--j));
            } else if (distance[i][j] == distance[i - 1][j] + 1) {// deletion
                sb1.append(str1.charAt(--i));
                sb2.append("-");
            } else if (distance[i][j] == distance[i][j - 1] + 1) {// insertion
                sb1.append("-");
                sb2.append(str2.charAt(--j));
            }
            //else if (distance[i][j] == distance[i - 1][j - 1]) {// mismatch(replacement)
            else {
                sb1.append(str1.charAt(--i));
                sb2.append(str2.charAt(--j));
            }
        }

        while (i > 0) {
            sb1.append(str1.charAt(--i));
            sb2.append("-");
        }
        while (j > 0) {
            sb1.append("-");
            sb2.append(str2.charAt(--j));
        }
        return new String[]{sb1.reverse().toString(), sb2.reverse().toString()};
    }

    public static void main(String[] args) {
        // minimum number of operations to convert str1 to str2
        String str1 = "editing";
        String str2 = "distance";
        //System.out.println(editDistance(str1, str2));

        int[][] distance = editDistance2(str1, str2);
//        String[] alignment = outputAlignment(distance, str1, str2);
        String[] alignment = outputAlignment2(distance, str1, str2);

        for (int i = 0; i < alignment.length; i++) {
            System.out.println(alignment[i]);
        }
    }
}
