package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _1394_Find_Lucky_Integer_in_an_Array {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for (var entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                max = Math.max(max, entry.getKey());
            }
        }
        return max;
    }
}
