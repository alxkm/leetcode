package com.leetcode.medium.math;

import java.util.HashMap;
import java.util.Map;

public class _2364_Count_Number_of_Bad_Pairs {
    //https://leetcode.com/problems/count-number-of-bad-pairs/description/
    //2364. Count Number of Bad Pairs

    public long countBadPairs(int[] nums) {
        long counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            counter += map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return ((long)((long)nums.length * (long)(nums.length - 1)) / 2) - counter;
    }
}
