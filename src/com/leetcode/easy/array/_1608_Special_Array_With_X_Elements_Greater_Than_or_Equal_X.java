package com.leetcode.easy.array;

import java.util.Arrays;

public class _1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X {
    //https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[n - i - 1] < i && i <= nums[n - i]) return i;
        }
        if (nums[0] >= n) return n;
        return -1;
    }
}
