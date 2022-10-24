package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _13_Roman_to_Integer {
    /*
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    * */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int[] sum = new int[20];
        char prev = s.charAt(0);
        sum[0] = map.get(prev);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            Integer num = map.get(s.charAt(i));

            if (cur == 'V' && prev == 'I') {
                sum[i - 1] = 4;
                prev = s.charAt(i);
                continue;
            } else if (cur == 'X' && (prev == 'I')) {
                sum[i - 1] = 9;
                prev = s.charAt(i);
                continue;
            } else if (cur == 'L' && prev == 'X') {
                sum[i - 1] = 40;
                prev = s.charAt(i);
                continue;
            } else if (cur == 'C' && prev == 'X') {
                sum[i - 1] = 90;
                prev = s.charAt(i);
                continue;
            } else if (cur == 'D' && prev == 'C') {
                sum[i - 1] = 400;
                prev = s.charAt(i);
                continue;
            } else if (cur == 'M' && prev == 'C') {
                sum[i - 1] = 900;
                prev = s.charAt(i);
                continue;
            }
            prev = s.charAt(i);
            sum[i] = num;
        }
        return Arrays.stream(sum).sum();
    }

    public static void main(String[] args) {
        //int[] array = {5,4,-1,7,8};
        //System.out.println(maxSubArray(array));

        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(romanToInt("XVIII"));
    }
}
