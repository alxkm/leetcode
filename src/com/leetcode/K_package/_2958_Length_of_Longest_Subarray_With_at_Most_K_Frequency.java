package com.leetcode.K_package;

import java.util.HashMap;
import java.util.Map;

public class _2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency {
    //2958. Length of Longest Subarray With at Most K Frequency
    //https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
