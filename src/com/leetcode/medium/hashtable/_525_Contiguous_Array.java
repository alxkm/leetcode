package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _525_Contiguous_Array {
    //https://leetcode.com/problems/contiguous-array/
    //TOP

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            Integer prev = map.get(count);
            if (prev != null) {
                max = Math.max(max, i - prev);
            } else {
                map.put(count, i);
            }
        }

        return max;
    }
}
