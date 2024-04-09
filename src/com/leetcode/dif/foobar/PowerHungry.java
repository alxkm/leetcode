package com.leetcode.dif.foobar;

public class PowerHungry {
    public static String solution(int[] xs) {
        if (xs.length == 1) return Integer.valueOf(xs[0]).toString();
        int negCount = 0;
        int zeroCount = 0;
        int posCount = 0;
        for (int n : xs) {
            if (n > 0) posCount++;
            else if (n < 0) negCount++;
            else zeroCount++;
        }
        if (posCount + negCount == 0) return "0";
        if (posCount == 0 && zeroCount > 0 && negCount == 1) return "0";

        java.math.BigDecimal sum = new java.math.BigDecimal("1");
        if (posCount > 0) {
            for (int n: xs) {
                if (n > 0) {
                    sum = sum.multiply(new java.math.BigDecimal(n));
                }
            }
        }

        if (negCount > 0) {
            if (negCount % 2 > 0) {
                negCount--;
            }
            java.util.Arrays.sort(xs);
            for (int i = 0; i < negCount; i++) {
                sum = sum.multiply(new java.math.BigDecimal(xs[i]));
            }
        }

        return sum.toString();
    }


    public static String solution1(int[] xs) {
        if (xs.length == 1) return Integer.valueOf(xs[0]).toString();
        int negCount = 0;
        int zeroCount = 0;
        long pos = 1L;
        long sum = 0L;
        int posCount = 0;
        for (int n : xs) {
            if (n < 0) negCount++;
            if (n > 0) {
                posCount++;
                pos = pos * n;
                sum = pos;
            }
            if (n == 0) zeroCount++;
        }

        if (posCount + negCount == 0) return Long.toString(sum);
        if (posCount == 0 && zeroCount != 0 && negCount == 1) return "0";
        long neg = 1L;
        if (negCount > 1) {
            if (negCount % 2 > 0) negCount--;
            java.util.Arrays.sort(xs);
            for (int i = 0; i < negCount; i++) {
                neg *= xs[i];
            }
            if (sum == 0) {
                return Long.toString(neg);
            }
            sum *= neg;

            return Long.toString(sum);
        }
        return Long.toString(sum);
    }
    public static void main(String[] args) {
        System.out.println(PowerHungry.solution(new int[]{-2, -3, 4, -5}));
        //System.out.println(PowerHungry.solution(new int[]{696, 254, 707, 730, 252, 144, 18, -678, 921, 681, -665, 421, -501, 204, 742, -609, 672, -72, 339, -555, -736, 230, -450, 375, 941, 50, 897, -192, -912, -915, 609, 100, -933, 458, -893, 932, -590, -209, 107, 473, -311, 73, 68, -229, 480, 41, -235, 558, -615, -289, -643}));
    }
}
