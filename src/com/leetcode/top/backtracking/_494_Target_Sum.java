package com.leetcode.top.backtracking;

public class _494_Target_Sum {
    //https://leetcode.com/problems/target-sum/
    //https://leetcode.com/problems/target-sum/?envType=daily-question&envId=2024-12-26
    //494. Target Sum

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

    class Solution {

        public int findTargetSumWays(int[] nums, int target) {
            return f(0, 0, nums, target);
        }

        int f(int i, int s, int[] ar, int t) {
            if (i == ar.length) return (s == t) ? 1 : 0;

            return f(i + 1, s + ar[i], ar, t) + f(i + 1, s - ar[i], ar, t);
        }
    }
}
