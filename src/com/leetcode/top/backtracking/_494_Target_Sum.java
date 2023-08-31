package com.leetcode.top.backtracking;

public class _494_Target_Sum {
    //https://leetcode.com/problems/target-sum/

    public int findTargetSumWays(int[] nums, int target) {
        return f(0, nums, target, 0);
    }

    private int f(int sum, int[] nums, int target, int i) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int a = f(sum + nums[i], nums, target, i + 1);
        int b = f(sum - nums[i], nums, target, i + 1);

        return a + b;
    }
}
