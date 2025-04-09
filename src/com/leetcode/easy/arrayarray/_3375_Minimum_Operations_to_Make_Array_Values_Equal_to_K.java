package com.leetcode.easy.arrayarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K {
    //3375. Minimum Operations to Make Array Values Equal to K
    //https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/

    public int minOperations(int[] nums, int k) {
        for (int n : nums) if (n < k) return -1;
        Arrays.sort(nums);
        int count = 0;
        while (!isOk(nums, k)) {
            int i = nums.length - 1;
            int prev = nums[i];
            i--;
            while (i >= 0 && nums[i] == prev) {
                i--;
            }
            if (i == -1) {
                i = 0;
                nums[i] = k;
            }
            for (int j = i; j < nums.length; j++) {
                nums[j] = nums[i];
            }
            count++;
        }

        return count;
    }

    private boolean isOk(int[] nums, int k) {
        for (int n : nums) if (n != k) return false;
        return true;
    }

    public int minOperations1(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            } else if (x > k) {
                st.add(x);
            }
        }
        return st.size();
    }
}
