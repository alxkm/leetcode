package com.leetcode.top.top175.dp;

import java.util.HashSet;
import java.util.Set;

public class _416_Partition_Equal_Subset_Sum {
    //https://leetcode.com/problems/partition-equal-subset-sum/
    //FOREIGN_SOLUTION
    //TOP

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextDp = new HashSet<>();
            for (int n: dp) {
                nextDp.add(nums[i] + n);
                nextDp.add(n);
            }
            dp = nextDp;
        }

        return dp.contains(target);
    }
}
