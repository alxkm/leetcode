package com.leetcode.easy.hash;

import java.util.HashSet;
import java.util.Set;

public class _217_Contains_Duplicate {
    //https://leetcode.com/problems/contains-duplicate/
    //217. Contains Duplicate

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) return true;
            else set.add(n);
        }
        return false;
    }
}
