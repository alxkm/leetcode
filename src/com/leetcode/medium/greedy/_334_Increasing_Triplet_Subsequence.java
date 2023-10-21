package com.leetcode.medium.greedy;

import java.util.HashSet;
import java.util.Set;

public class _334_Increasing_Triplet_Subsequence {
    //https://leetcode.com/problems/increasing-triplet-subsequence/
    //334. Increasing Triplet Subsequence

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int m0 = Integer.MAX_VALUE, m1 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (m0 >= n) {
                m0 = n;
            } else if (m1 >= n) {
                m1 = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for (int n: nums) uniq.add(n);
        if (uniq.size() <= 2) return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!set.add(nums[i])) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                //if (!set.add(nums[j])) continue;
                if (nums[i] >= nums[j]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    //if (nums[j] >= nums[k]) continue;
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
