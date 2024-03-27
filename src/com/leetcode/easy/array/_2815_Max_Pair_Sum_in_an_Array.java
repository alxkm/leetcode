package com.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2815_Max_Pair_Sum_in_an_Array {
    //2815. Max Pair Sum in an Array
    //https://leetcode.com/problems/max-pair-sum-in-an-array/

    public int maxSum(int[] nums) {
        Map<Integer, Integer> mapOfNums = new HashMap<>();

        for (int num : nums) {
            char[] chars = Integer.valueOf(num).toString().toCharArray();
            Arrays.sort(chars);

            if (!mapOfNums.containsKey(num)) {
                mapOfNums.put(num, chars[chars.length - 1] - '0');
            }
        }

        int sum = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (mapOfNums.get(nums[i]) == mapOfNums.get(nums[j])) {
                    sum = Math.max(sum, nums[i] + nums[j]);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        var sol = new _2815_Max_Pair_Sum_in_an_Array();
        System.out.println(sol.maxSum(new int[]{1, 2, 3, 4}));
    }
}
