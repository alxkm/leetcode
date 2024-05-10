package com.leetcode.dif;

import java.util.Arrays;

public class MaxFrequencyExample {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int tmp = k;
            int m = 1;
            for (int j = i + 1; j < nums.length; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                if (abs <= tmp) {
                    tmp -= abs;
                }
                if (tmp >= 0) m++;
                if (tmp <= 0) break;
            }
            max = Math.max(max, m);
        }
        return max;
    }
    public static void main(String[] args) {
//        Integer a1 = 1, a2 = a1;
//        System.out.println(a1 == a2);

        MaxFrequencyExample sol = new MaxFrequencyExample();
        System.out.println(sol.maxFrequency(new int[] {1,4,8,13}, 5));
    }
}
