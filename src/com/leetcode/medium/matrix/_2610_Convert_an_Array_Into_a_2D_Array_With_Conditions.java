package com.leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2610_Convert_an_Array_Into_a_2D_Array_With_Conditions {
    //https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.get(nums[i]));
        }
        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            List<Integer> l = new ArrayList<>();
            for (var entry: map.entrySet()) {
                if (entry.getValue() != 0) {
                    l.add(entry.getKey());
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            ll.add(l);
        }
        return ll;
    }
}
