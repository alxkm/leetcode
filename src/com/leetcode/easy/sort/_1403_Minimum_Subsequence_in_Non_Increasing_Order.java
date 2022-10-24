package com.leetcode.easy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1403_Minimum_Subsequence_in_Non_Increasing_Order {
    static public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> l = new ArrayList<>();
        int subSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            subSum += nums[i];
            sum -= nums[i];
            l.add(nums[i]);
            if (subSum > sum) break;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = {4,3,10,9,8};
        System.out.println(minSubsequence(a));
    }
}
