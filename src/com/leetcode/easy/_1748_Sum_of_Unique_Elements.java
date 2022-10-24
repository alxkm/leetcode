package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _1748_Sum_of_Unique_Elements {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = map.get(nums[i]);
            if (n != null) {
                map.put(nums[i], ++n);
            } else {
                map.put(nums[i], 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) sum += entry.getKey();
        }

        return sum;
    }
}
