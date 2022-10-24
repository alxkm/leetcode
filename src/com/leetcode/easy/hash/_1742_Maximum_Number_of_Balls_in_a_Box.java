package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _1742_Maximum_Number_of_Balls_in_a_Box {
    static public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            if (i < 10) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(i));
                int sum = 0;

                for (Character ch : sb.toString().toCharArray()) {
                    sum += (int)ch - 48;
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (var entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }

    public int countBalls1(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int value = 0;
            if (i < 10) {
                value = map.getOrDefault(i, 0) + 1;
                map.put(i, value);
            } else {
                int sum = 0;
                var arr = String.valueOf(i).toCharArray();
                for (char ch : arr) {
                    sum += (int)ch - 48;
                }
                value = map.getOrDefault(sum, 0) + 1;
                map.put(sum, value);
            }
            max = Math.max(max, value);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(countBalls(1, 10));
    }
}
