package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _2441_Largest_Positive_Integer_That_Exists_With_Its_Negative {
    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int n : nums) {
            if (n > 0) {
                map.put(n, n);
            } else {
                map1.put(n, n);
            }
        }
        int max = -1;
        for (int n : nums) {
            if (n > 0) {
                var a = map.get(n);
                var b = map1.get(-n);

                if (a != null && b != null) {
                    max = Math.max(max , a);
                }
            }
        }
        return max;
    }
}
