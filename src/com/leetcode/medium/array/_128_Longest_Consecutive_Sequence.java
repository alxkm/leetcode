package com.leetcode.medium.array;

import java.util.HashSet;
import java.util.Set;

public class _128_Longest_Consecutive_Sequence {
    //https://leetcode.com/problems/longest-consecutive-sequence/
    //todo todo todo

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n: nums) set.add(n);
        Set<Integer> used = new HashSet<>();
        int counter = 1;
        for (int n: nums) {
            if (used.contains(n)) continue;
            int max = 1;
            int start = n;
            while (true) {
                if (set.contains(++start)) {
                    used.add(start);
                    max++;
                } else break;
            }
            counter = Math.max(counter, max);
        }
        return counter;
    }
}
