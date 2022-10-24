package com.leetcode.easy.hash;

import java.util.HashSet;
import java.util.Set;

public class _2395_Find_Subarrays_With_Equal_Sum {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i - 1] + nums[i];
            if (s.contains(sum)) return true;
            else s.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
