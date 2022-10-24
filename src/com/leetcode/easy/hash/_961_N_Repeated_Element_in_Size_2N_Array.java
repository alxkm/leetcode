package com.leetcode.easy.hash;

import java.util.HashSet;
import java.util.Set;

public class _961_N_Repeated_Element_in_Size_2N_Array {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) return nums[i];
            s.add(nums[i]);
        }
        return 0;
    }
}
