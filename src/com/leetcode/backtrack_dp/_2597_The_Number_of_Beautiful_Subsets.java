package com.leetcode.backtrack_dp;

import java.util.HashMap;
import java.util.Map;

public class _2597_The_Number_of_Beautiful_Subsets {
    //2597. The Number of Beautiful Subsets
    //https://leetcode.com/problems/the-number-of-beautiful-subsets/description/

    public int beautifulSubsets(int[] nums, int k) {
        return f(0, nums, k, new HashMap<>()) - 1;
    }

    int f(int i, int[] nums, int k, Map<Integer, Integer> map) {
        if (i == nums.length) return 1;
        int result = f(i + 1, nums, k, map);
        if ((map.getOrDefault(nums[i] - k, 0) == 0) && (map.getOrDefault(nums[i] + k, 0) == 0)) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            result += f(i + 1, nums, k, map);
            map.put(nums[i], map.get(nums[i]) - 1);
        }
        return result;
    }
}
