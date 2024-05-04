package com.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2831_Find_the_Longest_Equal_Subarray {
    //2831. Find the Longest Equal Subarray
    //https://leetcode.com/problems/find-the-longest-equal-subarray/description/

    public int longestEqualSubarray(List<Integer> nums, int k) {
        int maxFrequency = 0, s = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            map.put(val, map.getOrDefault(val, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(val));
            int extraElementCount = (i - s + 1) - maxFrequency;

            if (extraElementCount > k) {
                int num = nums.get(s);
                map.put(num, map.get(num) - 1);
                s++;
            }
        }
        return maxFrequency;
    }
}
