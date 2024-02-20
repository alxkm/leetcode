package com.leetcode.easy.top.array;

import java.util.HashSet;
import java.util.Set;

public class _2154_Keep_Multiplying_Found_Values_by_Two {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> m = new HashSet<>();
        for (int num : nums) m.add(num);
        while (m.contains(original)) {
            original *= 2;
        }
        return original;
    }
}
