package com.algtoolbox.week6.part2PlacingParentheses;

public class Parenthesizing {
    private static long evaluate(long leftOperand, long rightOperand, String operator) {
        long result = 0;
        switch (operator) {
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            default:
                break;
        }
        return result;
    }

    private static long getMaxValue(String expression) {
        int n = (expression.length() + 1) / 2;
        long[][] minArr = new long[n][n];
        long[][] maxArr = new long[n][n];
        // set the diagonal elements as the single digits
        for (int i = 0; i < n; i++) {
            minArr[i][i] = expression.charAt(2 * i) - '0';
            maxArr[i][i] = expression.charAt(2 * i) - '0';
        }

        for (int s = 0; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                minMax(minArr, maxArr, i, j, expression);
            }
        }
        return maxArr[0][n - 1];
    }

    private static void minMax(long[][] minArr, long[][] maxArr, int i, int j, String expression) {
        if (i == j) {
            return;
        }

        long minVal = Long.MAX_VALUE;
        long maxVal = Long.MIN_VALUE;


        for (int k = i; k < j; k++) {
            String operator = expression.substring(2 * k + 1, 2 * k + 2);
            long a = evaluate(minArr[i][k], minArr[k + 1][j], operator);
            long b = evaluate(maxArr[i][k], maxArr[k + 1][j], operator);
            long c = evaluate(minArr[i][k], maxArr[k + 1][j], operator);
            long d = evaluate(maxArr[i][k], minArr[k + 1][j], operator);

            minVal = Math.min(minVal, Math.min(a, Math.min(b, Math.min(c, d))));
            maxVal = Math.max(maxVal, Math.max(a, Math.max(b, Math.max(c, d))));
        }

        minArr[i][j] = minVal;
        maxArr[i][j] = maxVal;
    }

    public static void main(String[] args) {
        String exp = "5-8+7*4-8+9";
        System.out.println(getMaxValue(exp));
    }
}
