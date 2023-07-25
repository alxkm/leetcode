package com.leetcode.top.top175;

import java.util.Arrays;

public class _698_Partition_to_K_Equal_Sum_Subsets {
    //https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

    private int[] nums;
    private boolean[] used;

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum % k != 0) return false;
        this.nums = nums;
        this.used = new boolean[nums.length];
        Arrays.sort(nums);
        reverse(nums);
        return f(k, 0, sum / k, 0);
    }

    private boolean f(int k, int i, int sum, int s) {
        if (k == 0) return true;
        if (s == sum) return f(k - 1, 0, sum, 0);

        for (int j = i; j < nums.length; j++) {
            if (used[j] || s + nums[j] > sum) continue;

            if (j - 1 >= 0 && nums[j] == nums[j - 1] && !used[j - 1]) continue;

            used[j] = true;
            if (f(k, j + 1, sum, s + nums[j])) return true;
            used[j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        var solution = new _698_Partition_to_K_Equal_Sum_Subsets();
        int[] a = {4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(solution.canPartitionKSubsets(a, k));
    }
}
