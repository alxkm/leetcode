package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _1_Two_Sum {
    //https://leetcode.com/problems/two-sum/
    //1. Two Sum

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                result[0] = i;
                result[1] = index;
                return result;
            }
        }
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer n = map.get(target - nums[i]);
            if (n != null && i != n) {
                return new int[]{i, n};
            }
        }
        return new int[0];
    }

}
