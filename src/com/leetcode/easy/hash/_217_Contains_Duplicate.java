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
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int j = i - 1;
            while (j >= 0 && current < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            if (j >= 0 && nums[j] == current) {
                return true;
            }
            nums[j + 1] = current;
        }
        return false;
    }

    public static void main(String[] args) {
        var sol = new _217_Contains_Duplicate();
        System.out.println(sol.containsDuplicate1(new int[]{1, 2, 3, 1}));
    }
}
