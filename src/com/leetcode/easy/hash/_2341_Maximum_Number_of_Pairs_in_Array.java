package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _2341_Maximum_Number_of_Pairs_in_Array {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer a = map.get(nums[i]);
            if (a != null) {
                map.put(nums[i], ++a);
            } else {
                map.put(nums[i], 1);
            }


        }

        int pairs = 0;
        int single = 0;

        for (int v : map.values()) {
            pairs += v / 2;
            single += v % 2;
        }
        int[] a = {pairs, single};
        return a;
    }
}
