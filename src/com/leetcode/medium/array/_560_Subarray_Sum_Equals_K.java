package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

public class _560_Subarray_Sum_Equals_K {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCounterMap = new HashMap<>();
        int s = 0;
        int result = 0;
        sumCounterMap.put(0, 1);
        for (int num : nums) {
            s += num;
            result += sumCounterMap.getOrDefault(s - k, 0);
            sumCounterMap.put(s, sumCounterMap.getOrDefault(s, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        System.out.println(subarraySum(a, 2));
    }
}
