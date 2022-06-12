package com.algtoolbox.week5.assignments;

import java.util.Scanner;

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
                    distance[i][j] = Math.min(mismatch, Math.min(insertion, deletion));
                }
            }
        }

        return distance[row - 1][col - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(editDistance(str1, str2));

    }
}
