package com.leetcode.medium.sort;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _2191_Sort_the_Jumbled_Numbers {
    //2191. Sort the Jumbled Numbers
    //https://leetcode.com/problems/sort-the-jumbled-numbers/?envType=daily-question&envId=2024-07-24

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] ar = new int[nums.length][3];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int base = 1;
            int x1 = 0;
            if (n == 0) {
                x1 = mapping[n];
            }
            while (n > 0) {
                int newDigit = mapping[n % 10];
                n /= 10;
                x1 += newDigit * base;
                base *= 10;
            }
            ar[i][0] = nums[i];
            ar[i][1] = x1;
            ar[i][2] = i;
        }
        Arrays.sort(ar, (x, y) -> {
            if (x[1] == y[1]) {
                return x[2] - y[2];
            }
            return x[1] - y[1];
        });
        int[] array = new int[ar.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = ar[i][0];
        }
        return array;
    }

    public static void main(String[] args) {
        var sol = new _2191_Sort_the_Jumbled_Numbers();
        System.out.println(Arrays.toString(sol.sortJumbled(ArrayUtil.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), ArrayUtil.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))));
        System.out.println(Arrays.toString(sol.sortJumbled(ArrayUtil.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), ArrayUtil.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))));
        System.out.println(Arrays.toString(sol.sortJumbled(ArrayUtil.of(8, 9, 4, 0, 2, 1, 3, 5, 7, 6), ArrayUtil.of(991, 338, 38))));
    }
}
